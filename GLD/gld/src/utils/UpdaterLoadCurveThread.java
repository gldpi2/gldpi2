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
    private JLabel maxPotencyValue;
    private JLabel maxPotencyTime;
    private JLabel minPotencyValue;
    private JLabel minPotencyTime;

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
            JLabel maxPotencyValue, JLabel maxPotencyTime,
            JLabel minPotencyValue, JLabel minPotencyTime) {
        this.loadCurve = loadCurve;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.maxPotencyValue = maxPotencyValue;
        this.maxPotencyTime = maxPotencyTime;
        this.minPotencyValue = minPotencyValue;
        this.minPotencyTime = minPotencyTime;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {
        Mensuration lastMensuration = null;

        List<Mensuration> mensuration = this.loadCurveCtrl.getMensurationByDay(19, 6, 2013);

        final Day today = new Day();

        boolean inserted = false;
        double averagePotency = 0;

        int i = 0;
        if (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double currentPotency = m.getPotency();

                if (averagePotency == 0) {
                    averagePotency = m.getPotency();
                }

                if (m.getMinute() % 15 == 0) {
                    if (!inserted) {
                        final Minute m0 = new Minute(m.getMinute(), new Hour(m.getHour(), today));
                        final Minute m1 = new Minute(m.getMinute() + 15, new Hour(m.getHour(), today));

                        averagePotency = (averagePotency + currentPotency) / 2;

                        loadCurve.offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);

                        inserted = true;
                        averagePotency = 0;
                    }

                    if (averagePotency == 0) {
                        averagePotency = m.getPotency();
                    } else {
                        averagePotency += currentPotency;
                    }

                } else {
                    inserted = false;
                    averagePotency += currentPotency;
                }

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    loadCurveCtrl.setMaxMensuration(m);
                }

                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    loadCurveCtrl.setMinMensuration(m);
                }

                lastMensuration = m;
            }

            updateMaxPotency(loadCurveCtrl.getMaxMensuration());
            updateMinPotency(loadCurveCtrl.getMinMensuration());
        }

        inserted = false;
        averagePotency = 0;
        while (true) {
            Mensuration m = this.loadCurveCtrl.getLastMensuration();

            if (lastMensuration == null) {
                lastMensuration = m;
            }

            if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                double currentPotency = m.getPotency();

                if (m.getMinute() % 15 == 0) {
                    if (!inserted) {
                        final Minute m0 = new Minute(m.getMinute(), new Hour(m.getHour(), today));
                        final Minute m1 = new Minute(m.getMinute() + 15, new Hour(m.getHour(), today));

                        averagePotency = (averagePotency + currentPotency) / 2;

                        loadCurve.offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), averagePotency);

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

                updateJLabel(flowValue, m.getFlow(), lastMensuration.getFlow());
                updateJLabel(tensionValue, m.getTension(), lastMensuration.getTension());
                updateJLabel(potencyvalue, m.getPotency(), currentPotency);

                lastMensuration = m;
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdaterLoadCurveThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        if (jLabel != null) {
            jLabel.setText(String.format("%.3f", current));
            if (last > current) {
                jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
            } else {
                jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
            }
            jLabel.revalidate();
            jLabel.repaint();
        }
    }

    private void updateMaxPotency(Mensuration m) {
        if (this.maxPotencyValue != null) {
            loadCurveCtrl.setMaxMensuration(m);
            this.maxPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMaxMensuration().getPotency()));
            this.maxPotencyValue.revalidate();
            this.maxPotencyValue.repaint();

            this.maxPotencyTime.setText(m.getTime());
            this.maxPotencyTime.revalidate();
            this.maxPotencyTime.repaint();
        }
    }

    private void updateMinPotency(Mensuration m) {
        if (this.maxPotencyValue != null) {
            loadCurveCtrl.setMinMensuration(m);
            this.minPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMinMensuration().getPotency()));
            this.minPotencyValue.revalidate();
            this.minPotencyValue.repaint();

            this.minPotencyTime.setText(m.getTime());
            this.minPotencyTime.revalidate();
            this.minPotencyTime.repaint();
        }
    }
}
