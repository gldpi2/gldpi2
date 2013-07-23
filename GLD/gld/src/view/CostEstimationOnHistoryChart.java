package view;

import controller.CostEstimationOnHistoryCtrl;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Fernando
 */
public class CostEstimationOnHistoryChart extends javax.swing.JPanel {

    public CostEstimationOnHistoryCtrl costEstimationOnHistoryCtrl = new CostEstimationOnHistoryCtrl();

    /**
     * Creates new form CharPanel
     */
    public CostEstimationOnHistoryChart(int x, int y) {
        initComponents();
        setSize(x, y);
    }

    public void startGraph(int interval, int offset) {
        ChartPanel panel = null;        
        panel = costEstimationOnHistoryCtrl.createCostEstimationOnHistoryGraphPanel(interval, offset);
        panel.setSize(this.getWidth(), this.getHeight());
        panel.setVisible(true);
        this.removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
        costEstimationOnHistoryCtrl.setState(1);
    }

    public TimeSeries getSeries() {
        return costEstimationOnHistoryCtrl.getAllSeries();
    }
    
    public TimeSeries limitSeries(){
        return costEstimationOnHistoryCtrl.limitSeries();
    }

    public void changeSize(int x, int y) {
        if (costEstimationOnHistoryCtrl.getState() != 0) {
            costEstimationOnHistoryCtrl.setSize(x, y);
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

    double getFinalCost() {
        return costEstimationOnHistoryCtrl.getFinalCost();
    }
}
