/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import _tests.GraphPanel;
import _tests.GraphPanelDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensuration;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author wagner
 */
public class UpdaterGraphThread implements Runnable {

    private GraphPanelDAO graphPanelDao = new GraphPanelDAO();
    private XYSeries series;

    public UpdaterGraphThread(XYSeries series) {
        this.series = series;
    }

    @Override
    public void run() {

        int i = 0;
        int lastId = 0;

        try {
            List<Mensuration> mensuration = this.graphPanelDao.getMensuration();

            for (Mensuration m : mensuration) {
                int time = new Integer(m.getTimestamp().substring(8, 14));

                System.out.println(time + " " + m.getFlow() + " " + m.getTension());
                series.addOrUpdate(time, m.getFlow() * m.getTension());
                lastId = m.getIdMensuration();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {
                Mensuration m = this.graphPanelDao.getLastMensuration();
                if (!(lastId == m.getIdMensuration())) {
                    int time = new Integer(m.getTimestamp().substring(8, 14));

                    System.out.println(time + " " + m.getFlow() + " " + m.getTension());

                    series.addOrUpdate(time, m.getFlow() * m.getTension());
                    lastId = m.getIdMensuration();
                }

            } catch (SQLException ex) {
                Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(Integer.parseInt(SystemProperties.properties.getProperty("REFRESH_TIME")));
            } catch (InterruptedException e) {
            }
        }
    }
}
