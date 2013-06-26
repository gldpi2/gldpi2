package utils;

import _tests.GraphPanel;
import _tests.GraphPanelDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensuration;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author wagner
 */
public class UpdaterGraphThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private GraphPanelDAO graphPanelDao = new GraphPanelDAO();
    private TimeSeries series;

    /**
     * Método construtor da classe UpdaterGraphThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public UpdaterGraphThread(TimeSeries series) {
        this.series = series;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterGraphThread.
     */
    @Override
    public void run() {

        int i = 0;
        int lastId = 0;

        try {
            List<Mensuration> mensuration = this.graphPanelDao.getMensuration();

            for (Mensuration m : mensuration) {
                int time = new Integer(m.getTimestamp().substring(8, 14));

                //System.out.println(time + " " + m.getFlow() + " " + m.getTension());
                series.addOrUpdate(m.getMillisecond(), m.getFlow() * m.getTension());
                lastId = m.getIdMensuration();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {
                Mensuration m = this.graphPanelDao.getLastMensuration();
                if (!(lastId == m.getIdMensuration())) {
                    series.addOrUpdate(m.getMillisecond(), m.getFlow() * m.getTension());
                    lastId = m.getIdMensuration();
                }

            } catch (SQLException ex) {
                Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException e) {
            }
        }
    }
}
