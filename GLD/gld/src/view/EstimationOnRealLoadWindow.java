package view;

import model.Login;
import utils.EstimationOnRealLoadThread;

/**
 *
 * @author Wagner Santos
 */
public class EstimationOnRealLoadWindow extends javax.swing.JPanel {

    int i = 0, state = 0;
    private EstimationOnRealLoadChart estimationLoadChart;
    private Thread updaterThread;
    MainMenu mainm;
    NewMainMenu newMainm;
    Login user;

    /**
     * Creates new form PatternWindow
     */
    public EstimationOnRealLoadWindow(int y, Login user) {
        initComponents();
        setSize(1024, y);
        this.init();
    }

    private void init() {
        desktop.removeAll();
        estimationLoadChart = new EstimationOnRealLoadChart(desktop.getWidth(), desktop.getHeight());
        estimationLoadChart.startGraph();

        updaterThread = new Thread(new EstimationOnRealLoadThread(estimationLoadChart.series, estimationLoadChart.estimate,
                this.FlowValue, this.TensionValue, this.PotencyValue,
                this.estimateNumberLabel, this.maxPotencyValue, this.maxPotencyTime,
                this.minPotencyValue, this.minPotencyTime));
        updaterThread.setDaemon(true);
        updaterThread.start();

        desktop.add(estimationLoadChart);
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

        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        matricula = new javax.swing.JLabel();
        maxPotencyLabel = new javax.swing.JLabel();
        maxPotencyValue = new javax.swing.JLabel();
        maxPotencyTime = new javax.swing.JLabel();
        minPotencyLabel = new javax.swing.JLabel();
        minPotencyValue = new javax.swing.JLabel();
        minPotencyTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        estimateLabel = new javax.swing.JLabel();
        estimateNumberLabel = new javax.swing.JLabel();
        estimateSlider = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();
        desktop = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        FlowLabel = new javax.swing.JLabel();
        FlowValue = new javax.swing.JLabel();
        PotencyLabel = new javax.swing.JLabel();
        PotencyValue = new javax.swing.JLabel();
        TensioLabel = new javax.swing.JLabel();
        TensionValue = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estimativa de Carga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 24))); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/house_go.png"))); // NOI18N
        jButton2.setText("Voltar ao Menu Principal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        jLabel2.setText("Usuário:");

        matricula.setText("user");

        maxPotencyLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        maxPotencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxPotencyLabel.setText("Demanda Máxima");

        maxPotencyValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxPotencyValue.setText("Atualizando...");

        maxPotencyTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxPotencyTime.setText("Atualizando...");

        minPotencyLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        minPotencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minPotencyLabel.setText("Demanda Mínima");

        minPotencyValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minPotencyValue.setText("Atualizando...");

        minPotencyTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minPotencyTime.setText("Atualizando...");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(matricula)
                .add(87, 87, 87)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(maxPotencyTime, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(maxPotencyValue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(maxPotencyLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(minPotencyTime, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(minPotencyValue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(minPotencyLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(minPotencyLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(minPotencyValue)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(minPotencyTime))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(matricula)
                            .add(maxPotencyLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(maxPotencyValue)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(maxPotencyTime)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comandos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        estimateLabel.setText("Número de Projeções:");

        estimateNumberLabel.setText("1");

        estimateSlider.setMajorTickSpacing(1);
        estimateSlider.setMaximum(10);
        estimateSlider.setMinimum(1);
        estimateSlider.setMinorTickSpacing(1);
        estimateSlider.setPaintTicks(true);
        estimateSlider.setSnapToTicks(true);
        estimateSlider.setToolTipText("");
        estimateSlider.setValue(1);
        estimateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                estimateSliderMouseDragged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(estimateLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(estimateNumberLabel)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(estimateSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(estimateLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(estimateNumberLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(estimateSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktop.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título Gráfico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
        desktop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                desktopComponentResized(evt);
            }
        });

        org.jdesktop.layout.GroupLayout desktopLayout = new org.jdesktop.layout.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 394, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 656, Short.MAX_VALUE)
        );

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tempo Real", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        FlowLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        FlowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FlowLabel.setText("Corrente");

        FlowValue.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        FlowValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FlowValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up.png"))); // NOI18N
        FlowValue.setText("-");

        PotencyLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        PotencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PotencyLabel.setText("Potência");

        PotencyValue.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        PotencyValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PotencyValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up.png"))); // NOI18N
        PotencyValue.setText("-");

        TensioLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        TensioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TensioLabel.setText("Tensão");

        TensionValue.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        TensionValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TensionValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up.png"))); // NOI18N
        TensionValue.setText("-");

        org.jdesktop.layout.GroupLayout infoPanelLayout = new org.jdesktop.layout.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(FlowValue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(PotencyLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PotencyValue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(infoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(TensioLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(TensionValue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(FlowLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(PotencyLabel)
                .add(18, 18, 18)
                .add(PotencyValue)
                .add(18, 18, 18)
                .add(TensioLabel)
                .add(18, 18, 18)
                .add(TensionValue)
                .add(18, 18, 18)
                .add(FlowLabel)
                .add(18, 18, 18)
                .add(FlowValue)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(infoPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(infoPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2)
                .add(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (state == 1) {
            estimationLoadChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_formComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updaterThread.stop();
        MainWindow.desktop.removeAll();
        newMainm = new NewMainMenu(user);
        MainWindow.desktop.add(newMainm);
        MainWindow.desktop.revalidate();
        MainWindow.desktop.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void desktopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopComponentResized
        if (state == 1) {
            estimationLoadChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_desktopComponentResized

    private void estimateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estimateSliderMouseDragged
        estimateNumberLabel.setText("" + estimateSlider.getValue());
    }//GEN-LAST:event_estimateSliderMouseDragged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FlowLabel;
    private javax.swing.JLabel FlowValue;
    private javax.swing.JLabel PotencyLabel;
    private javax.swing.JLabel PotencyValue;
    private javax.swing.JLabel TensioLabel;
    private javax.swing.JLabel TensionValue;
    private javax.swing.JPanel desktop;
    private javax.swing.JLabel estimateLabel;
    private javax.swing.JLabel estimateNumberLabel;
    private javax.swing.JSlider estimateSlider;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel matricula;
    private javax.swing.JLabel maxPotencyLabel;
    private javax.swing.JLabel maxPotencyTime;
    private javax.swing.JLabel maxPotencyValue;
    private javax.swing.JLabel minPotencyLabel;
    private javax.swing.JLabel minPotencyTime;
    private javax.swing.JLabel minPotencyValue;
    // End of variables declaration//GEN-END:variables
}
