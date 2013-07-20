package utils;

import controller.LoadCurveCtrl;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.LoadCurve;
import model.Mensuration;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.SimpleTimePeriod;

/**
 *
 * @author wagner
 */
public class UpdaterLoadCurveThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private LoadCurveCtrl loadCurveCtrl = new LoadCurveCtrl();
    private LoadCurve loadCurve;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel powerFactorValue;
    private JLabel frequencyValue;
    private JLabel maxPotencyValue;
    private JLabel maxPotencyTime;
    private JLabel maxPotencyDate;
    private JLabel minPotencyValue;
    private JLabel minPotencyTime;
    private JLabel minPotencyDate;
    private JLabel sourceLabel;
    private JLabel meterLabel;
    private JLabel statusLabel;

    /**
     * Método construtor da classe UpdaterLoadCurveThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public UpdaterLoadCurveThread(LoadCurve loadCurve) {
        this.loadCurve = loadCurve;
    }

    public UpdaterLoadCurveThread(LoadCurve loadCurve,
            JLabel flowValue, JLabel tensionValue, JLabel potencyValue,
            JLabel powerFactorValue, JLabel frequencyValue,
            JLabel maxPotencyValue, JLabel maxPotencyTime, JLabel maxPotencyDate,
            JLabel minPotencyValue, JLabel minPotencyTime, JLabel minPotencyDate,
            JLabel sourceLabel,
            JLabel meterLabel, JLabel statusLabel) {
        this.loadCurve = loadCurve;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.powerFactorValue = powerFactorValue;
        this.frequencyValue = frequencyValue;
        this.maxPotencyValue = maxPotencyValue;
        this.maxPotencyTime = maxPotencyTime;
        this.maxPotencyDate = maxPotencyDate;
        this.minPotencyValue = minPotencyValue;
        this.minPotencyTime = minPotencyTime;
        this.minPotencyDate = minPotencyDate;
        this.sourceLabel = sourceLabel;
        this.meterLabel = meterLabel;
        this.statusLabel = statusLabel;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {
        Mensuration lastMensuration = null;

        List<Mensuration> mensuration = this.loadCurveCtrl.getMensurationByDay(17, 7, 2013);

        final Day today = new Day();

        boolean inserted = false;
        int lastMinuteInserted = -1;
        double averagePotency = 0;

        int i = 0;
        if (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double currentPotency = m.getPotency();

                //REMOVER!!!! INICIO
                if (lastMensuration == null) {
                    lastMensuration = m;
                }
                updateMaxPotency(m);
                updateMinPotency(m);
                this.updateSourceAvailable(m);
                this.updateStatusLabel(m);
                //REMOVER!!!! FIM

                if (averagePotency == 0) {
                    averagePotency = m.getPotency();
                }

                if (m.getMinute() % 15 == 0) {
                    if (!inserted || lastMinuteInserted != m.getMinute()) {
                        final Minute m0 = new Minute(m.getMinute(), new Hour(m.getHour(), today));
                        final Minute m1 = new Minute(m.getMinute() + 10, new Hour(m.getHour(), today));

                        averagePotency = (averagePotency + currentPotency) / 2;

                        if (m.getHour() >= 18 && m.getHour() < 21) {
                            loadCurve.peakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);
                        } else {
                            loadCurve.offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);
                        }

                        lastMinuteInserted = m.getMinute();
                        inserted = true;
                        averagePotency = 0;
                    }

                    if (averagePotency == 0) {
                        averagePotency = m.getPotency();
                    } else {
                        averagePotency = (currentPotency + averagePotency) / 2;
                    }

                } else {
                    inserted = false;
                    averagePotency = (currentPotency + averagePotency) / 2;
                }

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    loadCurveCtrl.setMaxMensuration(m);
                }

                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    loadCurveCtrl.setMinMensuration(m);
                }

                updateAllLabels(m, lastMensuration);

                lastMensuration = m;

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UpdaterLoadCurveThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            updateMaxPotency(loadCurveCtrl.getMaxMensuration());
            updateMinPotency(loadCurveCtrl.getMinMensuration());
        }

        while (true) {
            Mensuration m = this.loadCurveCtrl.getLastMensuration();

            if (lastMensuration == null) {
                lastMensuration = m;
            }

            if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                double currentPotency = m.getPotency();

                this.updateSourceAvailable(m);
                this.updateStatusLabel(m);

                if (m.getMinute() % 15 == 0 || lastMinuteInserted != m.getMinute()) {
                    if (!inserted) {
                        final Minute m0 = new Minute(m.getMinute(), new Hour(m.getHour(), today));
                        final Minute m1 = new Minute(m.getMinute() + 10, new Hour(m.getHour(), today));

                        averagePotency = (averagePotency + currentPotency) / 2;

                        if (m.getHour() >= 18 && m.getHour() < 21) {
                            loadCurve.peakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);
                        } else {
                            loadCurve.offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);
                        }

                        inserted = true;
                        averagePotency = 0;
                    }
                    averagePotency += currentPotency;
                } else {
                    inserted = false;
                    averagePotency += currentPotency;
                }

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    updateMaxPotency(m);
                }

                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    updateMinPotency(m);
                }

                updateAllLabels(m, lastMensuration);

                lastMensuration = m;
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdaterLoadCurveThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateAllLabels(Mensuration currentMensuration, Mensuration lastMensuration) {
        updateJLabel(flowValue, currentMensuration.getFlow(), lastMensuration.getFlow());
        updateJLabel(tensionValue, currentMensuration.getTension(), lastMensuration.getTension());
        updateJLabel(potencyvalue, currentMensuration.getPotency(), lastMensuration.getPotency());
        updateJLabel(powerFactorValue, currentMensuration.getPowerFactor(), lastMensuration.getPowerFactor());
        updateJLabel(frequencyValue, currentMensuration.getFrequency(), lastMensuration.getFrequency());
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        if (jLabel != null) {
            jLabel.setText(String.format("%.3f", current));
            if (last > current) {
                jLabel.setIcon(new ImageIcon("src/icons/arrow_down_small.png"));
            } else {
                jLabel.setIcon(new ImageIcon("src/icons/arrow_up_small.png"));
            }
            jLabel.revalidate();
            jLabel.repaint();
        }
    }

    private void updateMaxPotency(Mensuration m) {
        if (this.maxPotencyValue != null) {
            loadCurveCtrl.setMaxMensuration(m);
            this.maxPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMaxMensuration().getPotency()) + " kW");
            this.maxPotencyValue.revalidate();
            this.maxPotencyValue.repaint();

            this.maxPotencyTime.setText(m.getTime());
            this.maxPotencyTime.revalidate();
            this.maxPotencyTime.repaint();

            this.maxPotencyDate.setText(m.getDate());
            this.maxPotencyDate.revalidate();
            this.maxPotencyDate.repaint();
        }
    }

    private void updateMinPotency(Mensuration m) {
        if (this.minPotencyValue != null) {
            loadCurveCtrl.setMinMensuration(m);
            this.minPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMinMensuration().getPotency()) + " kW");
            this.minPotencyValue.revalidate();
            this.minPotencyValue.repaint();

            this.minPotencyTime.setText(m.getTime());
            this.minPotencyTime.revalidate();
            this.minPotencyTime.repaint();

            this.minPotencyDate.setText(m.getDate());
            this.minPotencyDate.revalidate();
            this.minPotencyDate.repaint();
        }
    }

    private void updateSourceAvailable(Mensuration current) {
        if (this.sourceLabel != null) {
            if (current.getEnergyAvailable() == 1) {
                this.sourceLabel.setText("Disponível");
            } else {
                this.sourceLabel.setText("Indisponível");
            }
        }
    }

    private void updateStatusLabel(Mensuration current) {
        if (this.statusLabel != null) {
            double tension = current.getBateryTension();
            if (tension > 13.5) {
                this.statusLabel.setText("Carregada - ( 100 % )");
                this.statusLabel.setIcon(new ImageIcon("src/icons/full.png"));
            } else if (tension < 0.5) {
                this.statusLabel.setText("Descarregada - ( 0 % )");
                this.statusLabel.setIcon(new ImageIcon("src/icons/died.png"));
            } else if (current.getFlowAeroGenerator() > 0.0 && current.getFlowPanel() > 0.0) {
                this.statusLabel.setText("Carregando - ( " + String.format("%.2f", current.getTension() / 14) + " % )");
                this.statusLabel.setIcon(new ImageIcon("src/icons/charging.png"));
            } else {
                this.statusLabel.setText("Não Carregando");
                this.statusLabel.setIcon(new ImageIcon("src/icons/not_charging.png"));
            }
        }
    }
}
