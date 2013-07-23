package controller;

import dao.LoadCurveDAO;
import java.util.List;
import model.LoadCurve;
import model.Mensuration;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Wagner Santos
 */
public class LoadCurveCtrl {

    private LoadCurve loadCurve;
    private LoadCurveDAO loadCurveDAO;

    public LoadCurveCtrl() {
        this.loadCurveDAO = new LoadCurveDAO();
        this.loadCurve = new LoadCurve();
    }

    public List<Mensuration> getAllMensuration() {
        return loadCurveDAO.getAllMensuration();
    }

    public List<Mensuration> getMensurationByDay(int day, int mounth, int year) {
        return loadCurveDAO.getMensurationByDay(day, mounth, year);
    }

    public Mensuration getLastMensuration() {
        return loadCurveDAO.getLastMensuration();
    }

    public ChartPanel createLoadCurveGraphPanel() {
        return loadCurve.createLoadCurveGraphPanel();
    }

    public ChartPanel createMontlyLoadCurveGraphPanel() {
        return loadCurve.createMontlyLoadCurvePanel();
    }

    public Mensuration getMaxMensuration() {
        return this.loadCurve.maxMensuration;
    }

    public LoadCurve getLoadCurve() {
        return this.loadCurve;
    }

    public int getState() {
        return this.loadCurve.state;
    }

    public Mensuration getMinMensuration() {
        return this.loadCurve.minMensuration;
    }

    public void setMaxMensuration(Mensuration maxMensuration) {
        this.loadCurve.maxMensuration = maxMensuration;
    }

    public void setMinMensuration(Mensuration minMensuration) {
        this.loadCurve.minMensuration = minMensuration;
    }

    public void setState(int state) {
        this.loadCurve.state = state;
    }

    public void setSize(int x, int y) {
        this.loadCurve.chartPanel.setSize(x, y);
    }
}
