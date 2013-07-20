package view;

import javax.swing.JOptionPane;
import model.Login;
import utils.UpdaterCostThread;
import utils.UpdaterLoadCurveThread;
import static view.MainWindow.desktop;

/**
 *
 * @author greg
 */
public class MainMenu extends javax.swing.JPanel {

    int i = 0, state = 0;
    private CostChart costChart;
    private LoadCurveChart loadCurveChart;
    private Thread loadCurveUpdaterThread;
    private MainMenu pg;
    private javax.swing.JLabel FlowValue;
    private javax.swing.JLabel PotencyValue;
    private javax.swing.JLabel TensionValue;
    private javax.swing.JLabel maxPotencyValue;
    private javax.swing.JLabel minPotencyValue;
    private javax.swing.JLabel maxPotencyTime;
    private javax.swing.JLabel minPotencyTime;
    private javax.swing.JLabel maxCostValue;
    private javax.swing.JLabel minCostValue;

    /**
     * Creates new form MainMenu
     */
    public MainMenu(Login user) {
        initComponents();
        setSize(1024, 678);
    }

    public void init() {
        //teoricamente era pra rodar gráfico de custo.
        panelCost.removeAll();
        costChart = new CostChart(panelCost.getWidth(), panelCost.getHeight());
        costChart.criaGrafico();

        costChart.criaGrafico();
        Thread costUpdaterCostThread = new Thread(new UpdaterCostThread(costChart.getSeries(), costChart.limitSeries()));
        costUpdaterCostThread.setDaemon(true);
        costUpdaterCostThread.start();

        desktop.add(costChart);
        panelCost.add(costChart);
        panelCost.revalidate();
        panelCost.repaint();

        //rodar grafico de consumo
        panelConsumption.removeAll();
        loadCurveChart = new LoadCurveChart(panelConsumption.getWidth(), panelConsumption.getHeight());
        loadCurveChart.startGraph(false);

        loadCurveUpdaterThread = new Thread(new UpdaterLoadCurveThread(loadCurveChart.getLoadCurve()));
        loadCurveUpdaterThread.setDaemon(true);
        loadCurveUpdaterThread.start();

        desktop.add(loadCurveChart);
        panelConsumption.add(loadCurveChart);
        panelConsumption.revalidate();
        panelConsumption.repaint();

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
        jPanel2 = new javax.swing.JPanel();
        matricula = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelCost = new javax.swing.JPanel();
        panelConsumption = new javax.swing.JPanel();
        panelCadastros = new javax.swing.JPanel();
        buttonUser = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonCostm = new javax.swing.JButton();
        buttonConsumptionm = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttonCoste = new javax.swing.JButton();
        buttonConsumptione = new javax.swing.JButton();
        buttonStudy = new javax.swing.JButton();
        panelHibrido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Principal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 24))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 14))); // NOI18N

        matricula.setText("user");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        jLabel2.setText("Usuário:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matricula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45))
        );

        panelCost.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfico de Custo"));
        panelCost.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelCostComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelCostLayout = new javax.swing.GroupLayout(panelCost);
        panelCost.setLayout(panelCostLayout);
        panelCostLayout.setHorizontalGroup(
            panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCostLayout.setVerticalGroup(
            panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelConsumption.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfico de Consumo"));
        panelConsumption.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelConsumptionComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelConsumptionLayout = new javax.swing.GroupLayout(panelConsumption);
        panelConsumption.setLayout(panelConsumptionLayout);
        panelConsumptionLayout.setHorizontalGroup(
            panelConsumptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        panelConsumptionLayout.setVerticalGroup(
            panelConsumptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCadastros.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastros"));
        panelCadastros.setToolTipText("");
        panelCadastros.setLayout(new java.awt.GridBagLayout());

        buttonUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        buttonUser.setText("Usuário");
        buttonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserActionPerformed(evt);
            }
        });
        panelCadastros.add(buttonUser, new java.awt.GridBagConstraints());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoramento"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        buttonCostm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_curve.png"))); // NOI18N
        buttonCostm.setText("Custo");
        buttonCostm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCostmActionPerformed(evt);
            }
        });
        jPanel4.add(buttonCostm, new java.awt.GridBagConstraints());

        buttonConsumptionm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_line.png"))); // NOI18N
        buttonConsumptionm.setText("Consumo");
        buttonConsumptionm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsumptionmActionPerformed(evt);
            }
        });
        jPanel4.add(buttonConsumptionm, new java.awt.GridBagConstraints());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Estimativas"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        buttonCoste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money-coin.png"))); // NOI18N
        buttonCoste.setText("Custo");
        buttonCoste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCosteActionPerformed(evt);
            }
        });
        jPanel5.add(buttonCoste, new java.awt.GridBagConstraints());

        buttonConsumptione.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightning.png"))); // NOI18N
        buttonConsumptione.setText("Consumo");
        buttonConsumptione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsumptioneActionPerformed(evt);
            }
        });
        jPanel5.add(buttonConsumptione, new java.awt.GridBagConstraints());

        buttonStudy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report_magnify.png"))); // NOI18N
        buttonStudy.setText("Estudo Contratual");
        buttonStudy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudyActionPerformed(evt);
            }
        });
        jPanel5.add(buttonStudy, new java.awt.GridBagConstraints());

        panelHibrido.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema Híbrido"));

        jLabel3.setText("Em desenvolvimento...");

        javax.swing.GroupLayout panelHibridoLayout = new javax.swing.GroupLayout(panelHibrido);
        panelHibrido.setLayout(panelHibridoLayout);
        panelHibridoLayout.setHorizontalGroup(
            panelHibridoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHibridoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHibridoLayout.setVerticalGroup(
            panelHibridoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHibridoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addComponent(panelCadastros, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addComponent(panelHibrido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelConsumption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCadastros, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelHibrido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelConsumption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserActionPerformed
        MainWindow.desktop.removeAll();
        MainWindow.userWindow = new UserWindow(desktop.getHeight());
        MainWindow.desktop.add(MainWindow.userWindow);
        MainWindow.desktop.revalidate();
        MainWindow.desktop.repaint();
    }//GEN-LAST:event_buttonUserActionPerformed

    private void buttonCostmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCostmActionPerformed
        MainWindow.desktop.removeAll();
        MainWindow.NewCostWindow = new CostWindow(MainWindow.desktop.getHeight(), MainWindow.user);
        MainWindow.desktop.add(MainWindow.NewCostWindow);
        MainWindow.desktop.revalidate();
        MainWindow.desktop.repaint();
    }//GEN-LAST:event_buttonCostmActionPerformed

    private void buttonConsumptionmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsumptionmActionPerformed
        MainWindow.desktop.removeAll();
        MainWindow.loadWindow = new LoadCurveWindow(desktop.getHeight(), MainWindow.user);
        MainWindow.desktop.add(MainWindow.loadWindow);
        MainWindow.desktop.revalidate();
        MainWindow.desktop.repaint();
    }//GEN-LAST:event_buttonConsumptionmActionPerformed

    private void panelCostComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCostComponentResized
        if (state == 1) {
            costChart.changeSize(panelCost.getWidth(), panelCost.getHeight());
        }
    }//GEN-LAST:event_panelCostComponentResized

    private void panelConsumptionComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelConsumptionComponentResized
        if (state == 1) {
            loadCurveChart.changeSize(panelCost.getWidth(), panelCost.getHeight());
        }
    }//GEN-LAST:event_panelConsumptionComponentResized

    private void buttonCosteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCosteActionPerformed
        JOptionPane.showMessageDialog(panelCost, "Em desenvolvimento!", "Em Breve", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_buttonCosteActionPerformed

    private void buttonConsumptioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsumptioneActionPerformed
        //MainWindow.desktop.removeAll();
        //MainWindow.estimationCurveMenu = new EstimationCurveMenu(MainWindow.user);
        //MainWindow.desktop.add(MainWindow.estimationCurveMenu);
        //MainWindow.desktop.revalidate();
        //MainWindow.desktop.repaint();
        JOptionPane.showMessageDialog(panelCost, "Em desenvolvimento!", "Em Breve", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_buttonConsumptioneActionPerformed

    private void buttonStudyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudyActionPerformed
        JOptionPane.showMessageDialog(panelCost, "Em desenvolvimento!", "Em Breve", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_buttonStudyActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConsumptione;
    private javax.swing.JButton buttonConsumptionm;
    private javax.swing.JButton buttonCoste;
    private javax.swing.JButton buttonCostm;
    private javax.swing.JButton buttonStudy;
    private javax.swing.JButton buttonUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel matricula;
    private javax.swing.JPanel panelCadastros;
    private javax.swing.JPanel panelConsumption;
    private javax.swing.JPanel panelCost;
    private javax.swing.JPanel panelHibrido;
    // End of variables declaration//GEN-END:variables
}
