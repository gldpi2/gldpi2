package view;

import controller.ConsumptionMonthCtrl;
import controller.ContractCtrl;
import controller.GuidelineRateCtrl;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import model.ConsumptionMonth;
import model.GuidelineRate;
import model.Login;

/**
 *
 * @author itallorossi
 */
public class ContractStudy extends javax.swing.JPanel {

    private NewMainMenu newMenu;
    private Login loggedUser;
    private List<ConsumptionMonth> allConsumptionMonths;
    private Map<Integer, String> months = new HashMap<>();
    private double futureExtraDemand;
    private double maxPeak, maxOffPeak;
    private double medianPeak, medianOffPeak;
    private double avgPeak, avgOffPeak;
    private double contractedBiggest, demandBiggest, averageBiggest;
    private List<GuidelineRate> gdLine;
    private double costAvgBlue, costMaxBlue, costMedBlue, cost;
    private double costMaxCtrGreen, costMaxGreen, costMaxMedGreen;
    private boolean changed = false;

    /**
     * Creates new form ContractStudy
     */
    public ContractStudy(int y, Login user) {
        initComponents();
        setSize(1024, y);
        loggedUser = user;
        fillMonthsMap();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabela.setDefaultRenderer(Double.class, centerRenderer);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setResizingAllowed(false);
        tabela.disable();

        ConsumptionMonthCtrl csCtrl = new ConsumptionMonthCtrl();

        comboYears.removeAllItems();
        comboYears.addItem("Selecione...");
        for (int i = 0; i < csCtrl.getYears().size(); i++) {
            comboYears.addItem(csCtrl.getYears().get(i));
        }

        GuidelineRateCtrl gdCtrl = new GuidelineRateCtrl();
        try {
            gdLine = gdCtrl.readGuidelineRate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        label.setVisible(false);
        extraDemand.setVisible(false);
    }

    private void generateContractStudy() {
        fillCurrentContract();
        calculateAverage();
        getMaxValue();
        calculateMedian();

        peakBlueAvg.setText("" + String.format("%.2f", avgPeak));
        offPeakBlueAvg.setText("" + String.format("%.2f", avgOffPeak));
        peakBlueMax.setText("" + String.format("%.2f", maxPeak));
        offPeakBlueMax.setText("" + String.format("%.2f", maxOffPeak));
        peakGreenMax.setText("" + String.format("%.2f", demandBiggest));
        peakGreenMaxAvg.setText("" + String.format("%.2f", averageBiggest));
        peakBlueMed.setText("" + String.format("%.2f", medianPeak));
        offPeakBlueMed.setText("" + String.format("%.2f", medianOffPeak));

        horoSazonalAzul();

        costBlueAvg.setText("" + String.format("%.2f", costAvgBlue));
        costBlueMax.setText("" + String.format("%.2f", costMaxBlue));
        costBlueMed.setText("" + String.format("%.2f", costMedBlue));
        currentCost.setText("" + String.format("%.2f", cost));

        horoSazonalVerde();

        costGreenContract.setText("" + String.format("%.2f", costMaxCtrGreen));
        costGreenMax.setText("" + String.format("%.2f", costMaxGreen));
        costGreenMaxAvg.setText("" + String.format("%.2f", costMaxMedGreen));
    }

    private void horoSazonalAzul() {
        for (int i = 0; i < 12; i++) {
            if (allConsumptionMonths.get(i).getPeakDemand() > avgPeak) {
                costAvgBlue += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(0).getPeakDemand());
            } else {
                costAvgBlue += avgPeak * Double.parseDouble(gdLine.get(0).getPeakDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > avgOffPeak) {
                costAvgBlue += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            } else {
                costAvgBlue += avgOffPeak * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            }

            costAvgBlue += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(0).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(0).getConsumptionDryPeak());

            if (allConsumptionMonths.get(i).getPeakDemand() > maxPeak) {
                costMaxBlue += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(0).getPeakDemand());
            } else {
                costMaxBlue += maxPeak * Double.parseDouble(gdLine.get(0).getPeakDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > maxOffPeak) {
                costMaxBlue += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            } else {
                costMaxBlue += maxOffPeak * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            }

            costMaxBlue += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(0).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(0).getConsumptionDryPeak());

            if (allConsumptionMonths.get(i).getPeakDemand() > medianPeak) {
                costMedBlue += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(0).getPeakDemand());
            } else {
                costMedBlue += medianPeak * Double.parseDouble(gdLine.get(0).getPeakDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > medianOffPeak) {
                costMedBlue += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            } else {
                costMedBlue += medianOffPeak * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            }

            costMedBlue += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(0).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(0).getConsumptionDryPeak());

            if (allConsumptionMonths.get(i).getPeakDemand() > Double.parseDouble(currentPeakDemand.getText())) {
                cost += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(0).getPeakDemand());
            } else {
                cost += Double.parseDouble(currentPeakDemand.getText()) * Double.parseDouble(gdLine.get(0).getPeakDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > Double.parseDouble(currentOffPeakDemand.getText())) {
                cost += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            } else {
                cost += Double.parseDouble(currentOffPeakDemand.getText()) * Double.parseDouble(gdLine.get(0).getOffPeakDemand());
            }

            cost += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(0).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(0).getConsumptionDryPeak());

        }
    }

    private void horoSazonalVerde() {
        for (int i = 0; i < 12; i++) {
            if (allConsumptionMonths.get(i).getPeakDemand() > contractedBiggest) {
                costMaxCtrGreen += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxCtrGreen += contractedBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > contractedBiggest) {
                costMaxCtrGreen += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxCtrGreen += contractedBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            costMaxCtrGreen += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(1).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(1).getConsumptionDryPeak());

            if (allConsumptionMonths.get(i).getPeakDemand() > demandBiggest) {
                costMaxGreen += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxGreen += demandBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > demandBiggest) {
                costMaxGreen += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxGreen += demandBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            costMaxGreen += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(1).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(1).getConsumptionDryPeak());

            if (allConsumptionMonths.get(i).getPeakDemand() > averageBiggest) {
                costMaxMedGreen += allConsumptionMonths.get(i).getPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxMedGreen += averageBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            if (allConsumptionMonths.get(i).getOffPeakDemand() > averageBiggest) {
                costMaxMedGreen += allConsumptionMonths.get(i).getOffPeakDemand() * Double.parseDouble(gdLine.get(1).getNormalDemand());
            } else {
                costMaxMedGreen += averageBiggest * Double.parseDouble(gdLine.get(1).getNormalDemand());
            }

            costMaxMedGreen += (allConsumptionMonths.get(i).getOffPeakConsumption() * Double.parseDouble(gdLine.get(1).getConsumptionDryOffPeak())) + (allConsumptionMonths.get(i).getPeakConsumption()) * Double.parseDouble(gdLine.get(1).getConsumptionDryPeak());

        }
    }

    private void calculateAverage() {
        double sumPeak = 0.0, sumOffPeak = 0.0;

        for (int i = 0; i < 12; i++) {
            sumPeak += allConsumptionMonths.get(i).getPeakDemand();
            sumOffPeak += allConsumptionMonths.get(i).getOffPeakDemand();
        }

        avgPeak = sumPeak / 12.0;
        avgOffPeak = sumOffPeak / 12.0;

        if (avgPeak > avgOffPeak) {
            averageBiggest = avgPeak;
        } else {
            averageBiggest = avgOffPeak;
        }
    }

    private void calculateMedian() {
        Vector<Double> peaks = new Vector<>();
        Vector<Double> offPeaks = new Vector<>();

        for (int i = 0; i < 12; i++) {
            peaks.add(allConsumptionMonths.get(i).getPeakDemand());
            offPeaks.add(allConsumptionMonths.get(i).getOffPeakDemand());
        }

        Collections.sort(peaks);
        Collections.sort(offPeaks);

        medianPeak = (peaks.get(5) + peaks.get(6)) / 2.0;
        medianOffPeak = (offPeaks.get(5) + offPeaks.get(6)) / 2.0;
    }

    private void getMaxValue() {
        maxPeak = -999999.0;
        maxOffPeak = -999999.0;

        for (int i = 0; i < 12; i++) {
            if (allConsumptionMonths.get(i).getPeakDemand() > maxPeak) {
                maxPeak = allConsumptionMonths.get(i).getPeakDemand();
            }
            if (allConsumptionMonths.get(i).getOffPeakDemand() > maxOffPeak) {
                maxOffPeak = allConsumptionMonths.get(i).getOffPeakDemand();
            }
        }

        if (maxPeak > maxOffPeak) {
            demandBiggest = maxPeak;
        } else {
            demandBiggest = maxOffPeak;
        }
    }

    private void fillTable(int year) {
        ConsumptionMonthCtrl csCtrl = new ConsumptionMonthCtrl();
        allConsumptionMonths = csCtrl.getAllConsumptions(year);

        for (int i = 0; i < 12; i++) {
            tabela.getModel().setValueAt(months.get(allConsumptionMonths.get(i).getMonth()) + "/" + year, i, 0);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getPeakDemand(), i, 1);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getOffPeakDemand(), i, 2);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getPeakConsumption(), i, 3);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getOffPeakConsumption(), i, 4);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getPeakExtra(), i, 5);
            tabela.getModel().setValueAt(allConsumptionMonths.get(i).getOffPeakExtra(), i, 6);

            switch (allConsumptionMonths.get(i).getDryOrHumid()) {
                case -1:
                    tabela.getModel().setValueAt("Não se aplica", i, 7);
                    break;
                case 0:
                    tabela.getModel().setValueAt("Seco", i, 7);
                    break;
                case 1:
                    tabela.getModel().setValueAt("Úmido", i, 7);
                    break;
            }
        }
    }

    private boolean isValidNumber(String value) {
        if (value.isEmpty()) {
            return true;
        } else {
            try {
                double d = Double.parseDouble(value);
                futureExtraDemand = d;
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    private void fillCurrentContract() {
        ContractCtrl cont = new ContractCtrl();
        GuidelineRateCtrl gdCtrl = new GuidelineRateCtrl();

        currentPeakDemand.setText(cont.getCurrentContract().getPeakDemand());
        currentOffPeakDemand.setText(cont.getCurrentContract().getOffPeakDemand());
        currentGuideline.setText(gdCtrl.getGuideline(cont.getCurrentContract().getIdRate()).getGuidelineRate());

        if (Integer.parseInt(cont.getCurrentContract().getPeakDemand()) > Integer.parseInt(cont.getCurrentContract().getOffPeakDemand())) {
            contractedBiggest = Integer.parseInt(cont.getCurrentContract().getPeakDemand());
        } else {
            contractedBiggest = Integer.parseInt(cont.getCurrentContract().getOffPeakDemand());
        }

        peakGreenContract.setText("" + contractedBiggest);
    }

    private void fillMonthsMap() {
        months.put(1, "Janeiro");
        months.put(2, "Fevereiro");
        months.put(3, "Março");
        months.put(4, "Abril");
        months.put(5, "Maio");
        months.put(6, "Junho");
        months.put(7, "Julho");
        months.put(8, "Agosto");
        months.put(9, "Setembro");
        months.put(10, "Outubro");
        months.put(11, "Novembro");
        months.put(12, "Dezembro");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        backToMainMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboYears = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        label = new javax.swing.JLabel();
        extraDemand = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        currentGuideline = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentPeakDemand = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        currentOffPeakDemand = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        currentCost = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        peakBlueMax = new javax.swing.JLabel();
        offPeakBlueMax = new javax.swing.JLabel();
        costBlueMax = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        peakBlueAvg = new javax.swing.JLabel();
        offPeakBlueAvg = new javax.swing.JLabel();
        costBlueAvg = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        peakBlueMed = new javax.swing.JLabel();
        offPeakBlueMed = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        costBlueMed = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        peakGreenContract = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        costGreenContract = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        peakGreenMax = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        costGreenMax = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        peakGreenMaxAvg = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        costGreenMaxAvg = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setSize(new java.awt.Dimension(1024, 720));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estudo Contratual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 24))); // NOI18N

        backToMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/house_go.png"))); // NOI18N
        backToMainMenu.setText("Voltar ao Menu Principal");
        backToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuActionPerformed(evt);
            }
        });

        jLabel1.setText("Ano:");

        comboYears.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "2012", "2013", "2014" }));

        tabela.setFont(new java.awt.Font("PT Sans Caption", 0, 13)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mês/Ano", "Demanda Ponta", "Demanda Fora", "Consumo Ponta", "Consumo Fora", "Ultrapassado Ponta", "Ultrapassado Fora", "Tipo Mês"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        label.setText("Expansão Prevista para Demanda:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report_edit.png"))); // NOI18N
        jButton1.setText("Gerar Estudo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato Atual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel3.setText("Enquadramento Tarifário:");

        currentGuideline.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        currentGuideline.setText("Atualizando...");

        jLabel5.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel5.setText("Demanda Ponta:");

        currentPeakDemand.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        currentPeakDemand.setText("Atualizando...");

        jLabel4.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel4.setText("Demanda Fora de Ponta:");

        currentOffPeakDemand.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        currentOffPeakDemand.setText("Atualizando...");

        jLabel6.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel6.setText("Custo Anual:");

        currentCost.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        currentCost.setText("Atualizando...");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(currentOffPeakDemand)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 62, Short.MAX_VALUE)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(currentCost))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(currentGuideline))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(currentPeakDemand)))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(currentGuideline))
                .add(12, 12, 12)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(currentPeakDemand))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(currentCost)
                        .add(jLabel6))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(currentOffPeakDemand)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horo-sazonal Azul", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel8.setText("Demanda Ponta (Máxima):");

        jLabel9.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel9.setText("Demanda Fora de Ponta (Máxima):");

        jLabel10.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel10.setText("Custo Anual para Máximo:");

        peakBlueMax.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakBlueMax.setText("Atualizando...");

        offPeakBlueMax.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        offPeakBlueMax.setText("Atualizando...");

        costBlueMax.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costBlueMax.setText("Atualizando...");

        jLabel14.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel14.setText("Demanda Ponta (Média):");

        jLabel15.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel15.setText("Demanda Fora de Ponta (Média):");

        jLabel16.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel16.setText("Custo Anual para Média:");

        peakBlueAvg.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakBlueAvg.setText("Atualizando...");

        offPeakBlueAvg.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        offPeakBlueAvg.setText("Atualizando...");

        costBlueAvg.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costBlueAvg.setText("Atualizando...");

        jLabel20.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel20.setText("Demanda Ponta (Mediana):");

        peakBlueMed.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakBlueMed.setText("Atualizando...");

        offPeakBlueMed.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        offPeakBlueMed.setText("Atualizando...");

        jLabel23.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel23.setText("Demanda Fora de Ponta (Mediana):");

        jLabel24.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel24.setText("Custo Anual para Mediana:");

        costBlueMed.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costBlueMed.setText("Atualizando...");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakBlueMax))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(offPeakBlueMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(costBlueMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(48, 48, 48)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(costBlueAvg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel15)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(offPeakBlueAvg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel14)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakBlueAvg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(46, 46, 46)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel24)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(costBlueMed))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel23)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(offPeakBlueMed))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel20)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakBlueMed)))
                .add(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(peakBlueMax))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel9)
                            .add(offPeakBlueMax))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel10)
                            .add(costBlueMax)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel20)
                            .add(peakBlueMed))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel23)
                            .add(offPeakBlueMed))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel24)
                            .add(costBlueMed)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel14)
                            .add(peakBlueAvg))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel15)
                            .add(offPeakBlueAvg))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel16)
                            .add(costBlueAvg))))
                .add(0, 6, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horo-sazonal Verde", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14), new java.awt.Color(51, 153, 0))); // NOI18N

        peakGreenContract.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakGreenContract.setText("Atualizando...");

        jLabel27.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel27.setText("Demanda (Maior Contratada):");

        jLabel30.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel30.setText("Custo Anual para Contratada:");

        costGreenContract.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costGreenContract.setText("Atualizando...");

        jLabel32.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel32.setText("Demanda (Máxima):");

        peakGreenMax.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakGreenMax.setText("Atualizando...");

        jLabel36.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel36.setText("Custo Anual para Máxima:");

        costGreenMax.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costGreenMax.setText("Atualizando...");

        jLabel38.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel38.setText("Demanda (Maior Média):");

        peakGreenMaxAvg.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        peakGreenMaxAvg.setText("Atualizando...");

        jLabel42.setFont(new java.awt.Font("PT Sans Caption", 1, 12)); // NOI18N
        jLabel42.setText("Custo Anual para Maior Média:");

        costGreenMaxAvg.setFont(new java.awt.Font("PT Sans Caption", 0, 12)); // NOI18N
        costGreenMaxAvg.setText("Atualizando...");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel27)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakGreenContract, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel30)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(costGreenContract, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(80, 80, 80)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel36)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(costGreenMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel32)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakGreenMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(80, 80, 80)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(costGreenMaxAvg))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel38)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(peakGreenMaxAvg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel38)
                            .add(peakGreenMaxAvg))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel42)
                            .add(costGreenMaxAvg)))
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel27)
                                .add(peakGreenContract))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel30)
                                .add(costGreenContract)))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel32)
                                .add(peakGreenMax))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel36)
                                .add(costGreenMax)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jSeparator1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 574, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboYears, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(label)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(extraDemand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton1))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(backToMainMenu))
                .add(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(comboYears, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(label)
                    .add(extraDemand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(backToMainMenu))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (comboYears.getSelectedItem().toString().equals("Selecione...")) {
            JOptionPane.showMessageDialog(null,
                    "Por favor selecione o ano que deseja gerar o relatório!",
                    "Selecione um Ano",
                    JOptionPane.ERROR_MESSAGE,
                    new ImageIcon("src/icons/exclamation.png"));
        } else {
            if (isValidNumber(extraDemand.getText()) == false) {
                JOptionPane.showMessageDialog(null,
                        "Valor inválido para demanda extra!",
                        "Demanda Extra",
                        JOptionPane.ERROR_MESSAGE,
                        new ImageIcon("src/icons/exclamation.png"));
            } else {
                if (extraDemand.getText().isEmpty()) {
                    futureExtraDemand = 0.0;
                }
                fillTable(Integer.parseInt(comboYears.getSelectedItem().toString()));
                if (changed == false) {
                    generateContractStudy();
                    changed = true;
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuActionPerformed
        int i;

        Object[] options = {"Sim", "Não"};
        i = JOptionPane.showOptionDialog(null,
                "Deseja realmente Voltar ao Menu Principal?",
                "Voltar ao Menu Principal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/icons/house_go.png"),
                options,
                options[1]);

        if (i == JOptionPane.YES_OPTION) {
            MainWindow.desktop.removeAll();
            newMenu = new NewMainMenu(loggedUser);
            MainWindow.desktop.add(newMenu);
            MainWindow.desktop.revalidate();
            MainWindow.desktop.repaint();
        }
    }//GEN-LAST:event_backToMainMenuActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainMenu;
    private javax.swing.JComboBox comboYears;
    private javax.swing.JLabel costBlueAvg;
    private javax.swing.JLabel costBlueMax;
    private javax.swing.JLabel costBlueMed;
    private javax.swing.JLabel costGreenContract;
    private javax.swing.JLabel costGreenMax;
    private javax.swing.JLabel costGreenMaxAvg;
    private javax.swing.JLabel currentCost;
    private javax.swing.JLabel currentGuideline;
    private javax.swing.JLabel currentOffPeakDemand;
    private javax.swing.JLabel currentPeakDemand;
    private javax.swing.JTextField extraDemand;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel offPeakBlueAvg;
    private javax.swing.JLabel offPeakBlueMax;
    private javax.swing.JLabel offPeakBlueMed;
    private javax.swing.JLabel peakBlueAvg;
    private javax.swing.JLabel peakBlueMax;
    private javax.swing.JLabel peakBlueMed;
    private javax.swing.JLabel peakGreenContract;
    private javax.swing.JLabel peakGreenMax;
    private javax.swing.JLabel peakGreenMaxAvg;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
