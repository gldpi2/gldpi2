/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.GuidelineRate;

/**
 *
 * @author gld-pi2
 */
public class GuidelineRateWindowInfo extends javax.swing.JPanel {

    /**
     * Creates new form GuidelineRateWindowInfo
     */
    public GuidelineRateWindowInfo() {
        initComponents();
   //     setLocationRelativeTo(null);
    }

    GuidelineRateWindowInfo(GuidelineRate guidelineEdit) {
         //To change body of generated methods, choose Tools | Templates.
        
    }
    
    public void initialVisibleComponents(){
        categoryDataLabel.setVisible(false);
        categoryShowLabel.setVisible(false);
        consumptionDryPeakDataLabel.setVisible(false);
        consumptionDryPeakShowLabel.setVisible(false);
        consumptionHumidOffPeakDataLabel.setVisible(false);
        consumptionHumidOffPeakShowLabel.setVisible(false);
        consumptionHumidPeakDataLabel.setVisible(false);
        consumptionHumidPeakShowLabel.setVisible(false);
        consumptionOffPeakDemandDataLabel.setVisible(false);
        consumptionOffPeakDemandShowLabel.setVisible(false);
        guidelineRateLabel.setVisible(false);
        normalDemandDataLabel.setVisible(false);
        normalDemandShowLabel.setVisible(false);
        offPeakDemandDataLabel.setVisible(false);
        offPeakDemandShowLabel.setVisible(false);
        peakDemandDataLabel.setVisible(false);
        peakDemandShowLabel.setVisible(false);
        transpassedDemandDataLabel.setVisible(false);
        transpassedDemandShowLabel.setVisible(false);
        transpassedOffPeakDataLabel.setVisible(false);
        transpassedOffPeakShowLabel.setVisible(false);
        transpassedPeakDataLabel.setVisible(false);
        transpassedPeakShowLabel.setVisible(false);
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
        consumptionOffPeakDemandShowLabel = new javax.swing.JLabel();
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
        consumptionOffPeakDemandDataLabel = new javax.swing.JLabel();
        consumptionHumidPeakDataLabel = new javax.swing.JLabel();
        consumptionHumidOffPeakDataLabel = new javax.swing.JLabel();
        transpassedPeakDataLabel = new javax.swing.JLabel();
        transpassedOffPeakDataLabel = new javax.swing.JLabel();
        normalDemandDataLabel = new javax.swing.JLabel();
        transpassedDemandDataLabel = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes Enquadramento Tarifário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 18))); // NOI18N

        guidelineRateLabel.setText("Atualizando...");

        categoryShowLabel.setText("Categoria:");

        peakDemandShowLabel.setText("Demanda em Ponta:");

        offPeakDemandShowLabel.setText("Demanda Fora de Ponta:");

        consumptionDryPeakShowLabel.setText("Consumo em Ponta Seca:");

        consumptionOffPeakDemandShowLabel.setText("Consumo Fora de Ponta Seca:");

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

        consumptionOffPeakDemandDataLabel.setText("Atualizando...");

        consumptionHumidPeakDataLabel.setText("Atualizando...");

        consumptionHumidOffPeakDataLabel.setText("Atualizando...");

        transpassedPeakDataLabel.setText("Atualizando...");

        transpassedOffPeakDataLabel.setText("Atualizando...");

        normalDemandDataLabel.setText("Atualizando...");

        transpassedDemandDataLabel.setText("Atualizando...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guidelineRateLabel)
                .addGap(212, 212, 212))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(consumptionOffPeakDemandShowLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consumptionOffPeakDemandDataLabel))
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
                .addContainerGap())
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
                    .addComponent(consumptionOffPeakDemandShowLabel)
                    .addComponent(consumptionOffPeakDemandDataLabel))
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
                .addContainerGap(96, Short.MAX_VALUE))
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryDataLabel;
    private javax.swing.JLabel categoryShowLabel;
    private javax.swing.JLabel consumptionDryPeakDataLabel;
    private javax.swing.JLabel consumptionDryPeakShowLabel;
    private javax.swing.JLabel consumptionHumidOffPeakDataLabel;
    private javax.swing.JLabel consumptionHumidOffPeakShowLabel;
    private javax.swing.JLabel consumptionHumidPeakDataLabel;
    private javax.swing.JLabel consumptionHumidPeakShowLabel;
    private javax.swing.JLabel consumptionOffPeakDemandDataLabel;
    private javax.swing.JLabel consumptionOffPeakDemandShowLabel;
    private javax.swing.JLabel guidelineRateLabel;
    private javax.swing.JPanel jPanel1;
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