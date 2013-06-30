package utils;

import _tests.GraphPanel;
import _tests.GraphPanelDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
import model.Mensuration;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author wagner
 */
public class UpdaterLoadCurveThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private GraphPanelDAO graphPanelDao = new GraphPanelDAO();
    private TimeSeries series;
    private JLabel FlowValue;
    private JLabel TensionValue;
    private JLabel Potencyvalue;

    /**
     * Método construtor da classe UpdaterLoadCurveThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public UpdaterLoadCurveThread(TimeSeries series, JLabel FlowValue, JLabel TensionValue, JLabel PotencyValue) {
        this.series = series;
        this.FlowValue = FlowValue;
        this.TensionValue = TensionValue;
        this.Potencyvalue = PotencyValue;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {

        int i = 0;
        Mensuration lastMensuration = null;
        Mensuration maxPotency;

        try {
            List<Mensuration> mensuration = this.graphPanelDao.getMensuration();

            for (Mensuration m : mensuration) {
                series.addOrUpdate(m.getMillisecond(), m.getPotency());

                lastMensuration = m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {
                Mensuration m = this.graphPanelDao.getLastMensuration();
                if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                    series.addOrUpdate(m.getMillisecond(), m.getPotency());

                    updateJLabel(FlowValue, m.getFlow(), lastMensuration.getFlow());
                    updateJLabel(TensionValue, m.getTension(), lastMensuration.getTension());
                    updateJLabel(Potencyvalue, m.getPotency(), lastMensuration.getPotency());

                    lastMensuration = m;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        jLabel.setText("" + current);
        if (last > current) {
            jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
        } else {
            jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
        }
        jLabel.revalidate();
        jLabel.repaint();
    }
}
