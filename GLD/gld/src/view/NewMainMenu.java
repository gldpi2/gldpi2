/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Login;
import utils.UpdaterCostThread;
import utils.UpdaterLoadCurveThread;
import static view.MainWindow.desktop;

/**
 *
 * @author gld-pi2
 */
public class NewMainMenu extends javax.swing.JPanel {

    int i = 0, state = 0;
    private CostChart costChart;
    private LoadCurveChart loadCurveChart;
    private Thread updaterThread;
    
    private MainMenu pg;

  
    private javax.swing.JLabel FlowValue;
    private javax.swing.JLabel PotencyValue;
    private javax.swing.JLabel TensionValue;
    private javax.swing.JLabel maxPotencyValue;
    private javax.swing.JLabel minPotencyValue;
    private javax.swing.JLabel maxPotencyTime;
    private javax.swing.JLabel minPotencyTime;
    
    /**
     * Creates new form NewMainMenu
     */
    public NewMainMenu(Login user) {
        initComponents();
        setSize(1024, 678);

        this.init();
    }

     public void init() {
        //teoricamente era pra rodar gráfico de custo.
        panelCostm.removeAll();
        costChart = new CostChart(panelCostm.getWidth(), panelCostm.getHeight());
        costChart.criaGrafico();

        costChart.criaGrafico();
        Thread th = new Thread(new UpdaterCostThread(costChart.series, 
                                                    this.FlowValue, this.TensionValue, this.PotencyValue));
        th.setDaemon(true);
        th.start();
        
        desktop.add(costChart);
        panelCostm.add(costChart);
        panelCostm.revalidate();
        panelCostm.repaint();
          
        //rodar grafico de consumo
        panelConsumptionm.removeAll();
        loadCurveChart = new LoadCurveChart(panelConsumptionm.getWidth(), panelConsumptionm.getHeight());
        loadCurveChart.startGraph();
        
        updaterThread = new Thread(new UpdaterLoadCurveThread(loadCurveChart.getSeries(),
                                                              this.FlowValue, this.TensionValue, this.PotencyValue, 
                                                              this.maxPotencyValue, this.maxPotencyTime,
                                                              this.minPotencyValue, this.minPotencyTime));
        updaterThread.setDaemon(true);
        updaterThread.start();

        desktop.add(loadCurveChart);
        panelConsumptionm.add(loadCurveChart);
        panelConsumptionm.revalidate();
        panelConsumptionm.repaint();
        
        
        state = 1;        
 }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCostm = new javax.swing.JPanel();
        panelConsumptionm = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GLD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 24))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.jpg"))); // NOI18N

        panelCostm.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfico de Custo"));
        panelCostm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelCostmComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelCostmLayout = new javax.swing.GroupLayout(panelCostm);
        panelCostm.setLayout(panelCostmLayout);
        panelCostmLayout.setHorizontalGroup(
            panelCostmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCostmLayout.setVerticalGroup(
            panelCostmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelConsumptionm.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafico de Carga"));
        panelConsumptionm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelConsumptionmComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelConsumptionmLayout = new javax.swing.GroupLayout(panelConsumptionm);
        panelConsumptionm.setLayout(panelConsumptionmLayout);
        panelConsumptionmLayout.setHorizontalGroup(
            panelConsumptionmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelConsumptionmLayout.setVerticalGroup(
            panelConsumptionmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jLabel2.setText("©WM ENERGIA, 2013");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCostm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelConsumptionm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelConsumptionm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCostm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelCostmComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCostmComponentResized
         if (state == 1) {
            costChart.changeSize(panelCostm.getWidth(), panelCostm.getHeight());
        }
    }//GEN-LAST:event_panelCostmComponentResized

    private void panelConsumptionmComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelConsumptionmComponentResized
        if (state == 1) {
            loadCurveChart.changeSize(panelConsumptionm.getWidth(), panelConsumptionm.getHeight());
        }
    }//GEN-LAST:event_panelConsumptionmComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelConsumptionm;
    private javax.swing.JPanel panelCostm;
    // End of variables declaration//GEN-END:variables
}
