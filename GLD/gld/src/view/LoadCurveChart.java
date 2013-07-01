package view;

import controller.LoadCurveCtrl;
import model.LoadCurve;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author itallorossi
 */
public class LoadCurveChart extends javax.swing.JPanel {

    public LoadCurveCtrl loadCurveCtrl = new LoadCurveCtrl();

    /**
     * Creates new form CharPanel
     */
    public LoadCurveChart(int x, int y) {
        initComponents();
        setSize(x, y);
    }

    public void startGraph() {
        ChartPanel panel = loadCurveCtrl.createLoadCurveGraphPanel();
        panel.setSize(this.getWidth(), this.getHeight());
        panel.setVisible(true);
        this.removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
        loadCurveCtrl.setState(1);
    }

    public TimeSeries getSeries() {
        return this.loadCurveCtrl.getSeries();
    }

    public void changeSize(int x, int y) {
        if (loadCurveCtrl.getState() != 0) {
            loadCurveCtrl.setSize(x, y);
            this.setSize(x, y);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
