/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import model.GuidelineRate;

/**
 *
 * @author gld-pi2
 */
public class GuidelineRateFrameInfo extends javax.swing.JFrame {

    /**
     * Creates new form GuidelineRateFrameInfo
     */
    public GuidelineRateFrameInfo() {
        initComponents();
        setLocationRelativeTo(null);
        initVisibleComponents();
    }

    public void initVisibleComponents() {
        guidelineRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (GuidelineRateWindow.guidelineEdit.getGuidelineRate().equals("Horo-Sazonal Azul")) {
            guidelineRateLabel.setText(GuidelineRateWindow.guidelineEdit.getGuidelineRate());
            categoryDataLabel.setText(GuidelineRateWindow.guidelineEdit.getCategory());
            peakDemandDataLabel.setText(GuidelineRateWindow.guidelineEdit.getPeakDemand());
            offPeakDemandDataLabel.setText(GuidelineRateWindow.guidelineEdit.getOffPeakDemand());
            consumptionDryPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionDryPeak());
            consumptionDryOffPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionDryOffPeak());
            consumptionHumidPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionHumidPeak());
            consumptionHumidOffPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionHumidOffPeak());
            transpassedPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getTranspassedPeak());
            transpassedOffPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getTranspassedOffPeak());
            normalDemandDataLabel.setVisible(false);
            normalDemandShowLabel.setVisible(false);
            transpassedDemandDataLabel.setVisible(false);
            transpassedDemandShowLabel.setVisible(false);
        } else if (GuidelineRateWindow.guidelineEdit.getGuidelineRate().equals("Horo-Sazonal Verde")) {
            guidelineRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            guidelineRateLabel.setText(GuidelineRateWindow.guidelineEdit.getGuidelineRate());
            categoryDataLabel.setText(GuidelineRateWindow.guidelineEdit.getCategory());
            peakDemandDataLabel.setVisible(false);
            peakDemandShowLabel.setVisible(false);
            offPeakDemandDataLabel.setVisible(false);
            offPeakDemandShowLabel.setVisible(false);
            consumptionDryPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionDryPeak());
            consumptionDryOffPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionDryOffPeak());
            consumptionHumidPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionHumidPeak());
            consumptionHumidOffPeakDataLabel.setText(GuidelineRateWindow.guidelineEdit.getConsumptionHumidOffPeak());
            transpassedPeakDataLabel.setVisible(false);
            transpassedPeakShowLabel.setVisible(false);
            transpassedOffPeakDataLabel.setVisible(false);
            transpassedOffPeakShowLabel.setVisible(false);
            normalDemandDataLabel.setText(GuidelineRateWindow.guidelineEdit.getNormalDemand());
            transpassedDemandDataLabel.setText(GuidelineRateWindow.guidelineEdit.getTranspassedDemand());
        }
    }

    GuidelineRateFrameInfo(GuidelineRate guidelineEdit) {
        guidelineEdit = new GuidelineRate();
        guidelineRateLabel.setText(guidelineEdit.getGuidelineRate());//To change body of generated methods, choose Tools | Templates.
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
        guidelineRateLabel = new javax.swing.JLabel();
        categoryShowLabel = new javax.swing.JLabel();
        peakDemandShowLabel = new javax.swing.JLabel();
        offPeakDemandShowLabel = new javax.swing.JLabel();
        consumptionDryPeakShowLabel = new javax.swing.JLabel();
        consumptionDryOffPeakShowLabel = new javax.swing.JLabel();
        consumptionHumidPeakShowLabel = new javax.swing.JLabel();
        consumptionHumidOffPeakShowLabel = new javax.swing.JLabel();
        transpassedPeakShowLabel = new javax.swing.JLabel();
        transpassedOffPeakShowLabel = new javax.swing.JLabel();
        normalDemandShowLabel = new javax.swing.JLabel();
        transpassedDemandShowLabel = new javax.swing.JLabel();
        categoryDataLabel = new javax.swing.JLabel();
        peakDemandDataLabel = new javax.swing.JLabel();
        offPeakDemandDataLabel = new javax.swing.JLabel();
        consumptionDryPeakDataLabel = new javax.swing.JLabel();
        consumptionDryOffPeakDataLabel = new javax.swing.JLabel();
        consumptionHumidPeakDataLabel = new javax.swing.JLabel();
        consumptionHumidOffPeakDataLabel = new javax.swing.JLabel();
        transpassedPeakDataLabel = new javax.swing.JLabel();
        transpassedOffPeakDataLabel = new javax.swing.JLabel();
        normalDemandDataLabel = new javax.swing.JLabel();
        transpassedDemandDataLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes Enquadramento Tarifário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 18))); // NOI18N

        guidelineRateLabel.setText("Atualizando...");

        categoryShowLabel.setText("Categoria:");

        peakDemandShowLabel.setText("Demanda em Ponta:");

        offPeakDemandShowLabel.setText("Demanda Fora de Ponta:");

        consumptionDryPeakShowLabel.setText("Consumo em Ponta Seca:");

        consumptionDryOffPeakShowLabel.setText("Consumo Fora de Ponta Seca:");

        consumptionHumidPeakShowLabel.setText("Consumo em Ponta Úmida:");

        consumptionHumidOffPeakShowLabel.setText("Consumo Fora de Ponta Úmida:");

        transpassedPeakShowLabel.setText("Demanda Ultrapassada na Ponta:");

        transpassedOffPeakShowLabel.setText("Demanda Ultrapassada Fora de Ponta:");

        normalDemandShowLabel.setText("Demanda Normal:");

        transpassedDemandShowLabel.setText("Demanda Ultrapassada:");

        categoryDataLabel.setText("Atualizando...");

        peakDemandDataLabel.setText("Atualizando...");

        offPeakDemandDataLabel.setText("Atualizando...");

        consumptionDryPeakDataLabel.setText("Atualizando...");

        consumptionDryOffPeakDataLabel.setText("Atualizando...");

        consumptionHumidPeakDataLabel.setText("Atualizando...");

        consumptionHumidOffPeakDataLabel.setText("Atualizando...");

        transpassedPeakDataLabel.setText("Atualizando...");

        transpassedOffPeakDataLabel.setText("Atualizando...");

        normalDemandDataLabel.setText("Atualizando...");

        transpassedDemandDataLabel.setText("Atualizando...");

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(guidelineRateLabel)
                                .addGap(212, 212, 212))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(closeButton)
                                .addGap(222, 222, 222))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(categoryShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoryDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(transpassedDemandShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transpassedDemandDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(peakDemandShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(peakDemandDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(offPeakDemandShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(offPeakDemandDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(consumptionDryPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consumptionDryPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(consumptionDryOffPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consumptionDryOffPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(consumptionHumidPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consumptionHumidPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(consumptionHumidOffPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consumptionHumidOffPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(transpassedPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transpassedPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(transpassedOffPeakShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(transpassedOffPeakDataLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(normalDemandShowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(normalDemandDataLabel)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guidelineRateLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryShowLabel)
                    .addComponent(categoryDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peakDemandShowLabel)
                    .addComponent(peakDemandDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offPeakDemandShowLabel)
                    .addComponent(offPeakDemandDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumptionDryPeakShowLabel)
                    .addComponent(consumptionDryPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumptionDryOffPeakShowLabel)
                    .addComponent(consumptionDryOffPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumptionHumidPeakShowLabel)
                    .addComponent(consumptionHumidPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumptionHumidOffPeakShowLabel)
                    .addComponent(consumptionHumidOffPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transpassedPeakShowLabel)
                    .addComponent(transpassedPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transpassedOffPeakShowLabel)
                    .addComponent(transpassedOffPeakDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalDemandShowLabel)
                    .addComponent(normalDemandDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transpassedDemandShowLabel)
                    .addComponent(transpassedDemandDataLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(closeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setLocationRelativeTo(guidelineRateLabel);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryDataLabel;
    private javax.swing.JLabel categoryShowLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel consumptionDryOffPeakDataLabel;
    private javax.swing.JLabel consumptionDryOffPeakShowLabel;
    private javax.swing.JLabel consumptionDryPeakDataLabel;
    private javax.swing.JLabel consumptionDryPeakShowLabel;
    private javax.swing.JLabel consumptionHumidOffPeakDataLabel;
    private javax.swing.JLabel consumptionHumidOffPeakShowLabel;
    private javax.swing.JLabel consumptionHumidPeakDataLabel;
    private javax.swing.JLabel consumptionHumidPeakShowLabel;
    private javax.swing.JLabel guidelineRateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel normalDemandDataLabel;
    private javax.swing.JLabel normalDemandShowLabel;
    private javax.swing.JLabel offPeakDemandDataLabel;
    private javax.swing.JLabel offPeakDemandShowLabel;
    private javax.swing.JLabel peakDemandDataLabel;
    private javax.swing.JLabel peakDemandShowLabel;
    private javax.swing.JLabel transpassedDemandDataLabel;
    private javax.swing.JLabel transpassedDemandShowLabel;
    private javax.swing.JLabel transpassedOffPeakDataLabel;
    private javax.swing.JLabel transpassedOffPeakShowLabel;
    private javax.swing.JLabel transpassedPeakDataLabel;
    private javax.swing.JLabel transpassedPeakShowLabel;
    // End of variables declaration//GEN-END:variables
}
