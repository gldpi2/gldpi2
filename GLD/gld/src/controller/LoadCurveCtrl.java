package controller;

import dao.LoadCurveDAO;
import java.util.List;
import model.LoadCurve;
import model.Mensuration;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Wagner Santos
 */

public class LoadCurveCtrl {
    
    private LoadCurve loadCurve;
    private LoadCurveDAO loadCurveDAO;
    
    public LoadCurveCtrl(){
        this.loadCurveDAO = new LoadCurveDAO();
        this.loadCurve = new LoadCurve();
    }
    
    public List<Mensuration> getAllMensuration(){
        return loadCurveDAO.getAllMensuration();
    }
    
    public Mensuration getLastMensuration(){
        return loadCurveDAO.getLastMensuration();
    }

    public ChartPanel createLoadCurveGraphPanel() {
        return loadCurve.createLoadCurveGraphPanel();
    }

    public void setState(int state) {
        this.loadCurve.state = state;
    }

    public void setSize(int x, int y) {
        this.loadCurve.chartPanel.setSize(x, y);
    }
    
    public Mensuration getMaxMensuration(){
        return this.loadCurve.maxMensuration;
    }

    public TimeSeries getSeries() {
        return this.loadCurve.series;
    }

    public int getState() {
        return this.loadCurve.state;
    }
    
    public void setMaxMensuration(Mensuration maxMensuration){
        this.loadCurve.maxMensuration = maxMensuration;
    }
    
}
