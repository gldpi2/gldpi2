package view;

import model.Login;

/**
 *
 * @author itallorossi
 */
public class NewPatternWindow extends javax.swing.JPanel {

    private int state;
    private LoadCurveChart loadChart;

    public NewPatternWindow(int y, Login user) {
        initComponents();
        setSize(1024, y);
        init();
    }

    private void init() {
        desktop.removeAll();
        loadChart = new LoadCurveChart(desktop.getWidth(), desktop.getHeight());
        loadChart.startGraph();

        desktop.add(loadChart);
        state = 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToMainMenu = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        desktop = new javax.swing.JPanel();
        panelInformations = new javax.swing.JPanel();
        panelRealTime = new javax.swing.JPanel();
        potencyFactorLabel = new javax.swing.JLabel();
        sourceLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        potencyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tensionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        flowLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        frequencyLabel = new javax.swing.JLabel();
        panelCommands = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NewPatternWindow", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 24))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        backToMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/house_go.png"))); // NOI18N
        backToMainMenu.setText("Voltar ao Menu Principal");
        backToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuActionPerformed(evt);
            }
        });

        desktop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                desktopComponentResized(evt);
            }
        });

        org.jdesktop.layout.GroupLayout desktopLayout = new org.jdesktop.layout.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 475, Short.MAX_VALUE)
        );

        panelInformations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N

        org.jdesktop.layout.GroupLayout panelInformationsLayout = new org.jdesktop.layout.GroupLayout(panelInformations);
        panelInformations.setLayout(panelInformationsLayout);
        panelInformationsLayout.setHorizontalGroup(
            panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 371, Short.MAX_VALUE)
        );
        panelInformationsLayout.setVerticalGroup(
            panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        panelRealTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tempo Real", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N
        panelRealTime.setMinimumSize(new java.awt.Dimension(275, 154));

        potencyFactorLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        potencyFactorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up_small.png"))); // NOI18N
        potencyFactorLabel.setText("Atualizando...");

        sourceLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        sourceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightning.png"))); // NOI18N
        sourceLabel.setText("Atualizando...");

        jLabel3.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel3.setText("Fonte");

        jLabel4.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel4.setText("Fator de Potência");

        potencyLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        potencyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up_small.png"))); // NOI18N
        potencyLabel.setText("Atualizando...");

        jLabel2.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel2.setText("Potência");

        jLabel5.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel5.setText("Tensão");

        tensionLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        tensionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_down_small.png"))); // NOI18N
        tensionLabel.setText("Atualizando...");

        jLabel1.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel1.setText("Corrente");

        flowLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        flowLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_down_small.png"))); // NOI18N
        flowLabel.setText("Atualizando...");

        jLabel7.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel7.setText("Frequência");

        frequencyLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        frequencyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_down_small.png"))); // NOI18N
        frequencyLabel.setText("Atualizando...");

        org.jdesktop.layout.GroupLayout panelRealTimeLayout = new org.jdesktop.layout.GroupLayout(panelRealTime);
        panelRealTime.setLayout(panelRealTimeLayout);
        panelRealTimeLayout.setHorizontalGroup(
            panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelRealTimeLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(sourceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(10, 10, 10))
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(82, 82, 82))
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(potencyFactorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(10, 10, 10)))
                .add(20, 20, 20)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(52, 52, 52))
                    .add(potencyLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(62, 62, 62))
                    .add(tensionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(5, 5, 5)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(frequencyLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(36, 36, 36))
                    .add(flowLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(52, 52, 52)))
                .add(5, 5, 5))
        );
        panelRealTimeLayout.setVerticalGroup(
            panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelRealTimeLayout.createSequentialGroup()
                .add(0, 0, 0)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sourceLabel)
                    .add(potencyLabel)
                    .add(flowLabel))
                .add(18, 18, 18)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(potencyFactorLabel)
                    .add(tensionLabel)
                    .add(frequencyLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCommands.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comandos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N

        org.jdesktop.layout.GroupLayout panelCommandsLayout = new org.jdesktop.layout.GroupLayout(panelCommands);
        panelCommands.setLayout(panelCommandsLayout);
        panelCommandsLayout.setHorizontalGroup(
            panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 207, Short.MAX_VALUE)
        );
        panelCommandsLayout.setVerticalGroup(
            panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(separador)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(backToMainMenu))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(panelCommands, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelInformations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelRealTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panelInformations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelCommands, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(separador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backToMainMenu))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (state == 1) {
            loadChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_formComponentResized

    private void desktopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopComponentResized
        if (state == 1) {
            loadChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_desktopComponentResized

    private void backToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuActionPerformed
        frequencyLabel.setText("10.000");
        flowLabel.setText("15.000");
        potencyLabel.setText("8.000");
        tensionLabel.setText("25.000");
        potencyFactorLabel.setText("110.000");
        sourceLabel.setText("CEB");
    }//GEN-LAST:event_backToMainMenuActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainMenu;
    private javax.swing.JPanel desktop;
    private javax.swing.JLabel flowLabel;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel panelCommands;
    private javax.swing.JPanel panelInformations;
    private javax.swing.JPanel panelRealTime;
    private javax.swing.JLabel potencyFactorLabel;
    private javax.swing.JLabel potencyLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JLabel tensionLabel;
    // End of variables declaration//GEN-END:variables
}
