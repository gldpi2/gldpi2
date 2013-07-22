package view;

import controller.CostEstimationOnHistoryCtrl;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Login;
import org.jfree.data.time.Day;
import utils.DatabaseInterface;

/**
 *
 * @author itallorossi
 */
public class CostEstimationOnHistoryWindow extends javax.swing.JPanel {

    private int state;
    private int month;
    private int year;
    private CostEstimationOnHistoryChart estimationChart;
    private NewMainMenu newMenu;
    private Login userLogged;
    private Day today = new Day();
    private DatabaseInterface dbInterface = new DatabaseInterface();
    /*
     * 0 - data minima selecionavel / 1 - data maxima selecionavel
     */
    private Date[] dates = new Date[2];

    public CostEstimationOnHistoryWindow(int y, Login user) {
        initComponents();
        month = today.getMonth() - 1;
        year = today.getYear() - 2013;
        userLogged = user;
        setSize(1024, y);
        init();
    }

    private void init() {
        desktop.removeAll();

        Date date = new Date();

        estimationChart = new CostEstimationOnHistoryChart(desktop.getWidth(), desktop.getHeight());
        int last_day = CostEstimationOnHistoryCtrl.INTERVAL_LAST_DAY;
        estimationChart.startGraph(CostEstimationOnHistoryCtrl.INTERVAL_LAST_DAY,0);

        initialVisibleComponents();
        setMaxAndMinDates();
        desktop.add(estimationChart);
        state = 1;

        DecimalFormat fmt = new DecimalFormat("0.00");
        countLabel2.setText(fmt.format(estimationChart.getFinalCost()));
    }

    private void initialVisibleComponents() {
        fromLabel.setVisible(false);
        dateChooserFrom.setVisible(false);
        toLabel.setVisible(false);
        dateChooserTo.setVisible(false);
        yearChooser.setVisible(false);
        monthChooser.setVisible(false);
        yearChooser.setSelectedIndex(year);
        monthChooser.setSelectedIndex(month);

        dateChooserFrom.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Calendar calendar = Calendar.getInstance();
                Date date = dateChooserFrom.getDate();

                if (date != null && dateChooserTo.isVisible()) {
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, 1);
                    Date newData = calendar.getTime();
                    dateChooserTo.setMinSelectableDate(newData);
                    dateChooserTo.setCalendar(null);
                }
            }
        });

        dateChooserFrom.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    if (e.getNewValue() != null) {
                        //System.out.println(e.getPropertyName() + ": " + (Date) e.getNewValue());
                        Calendar calendario = Calendar.getInstance();
                        //if(calendario.getTime())
                        if (dateChooserFrom.getDate().compareTo(Calendar.getInstance().getTime()) < 0) {
                            JOptionPane.showMessageDialog(null, "Datas anteriores não podem ser escolhidas para estimativas!");
                            return;
                        }

                        Calendar today  = Calendar.getInstance();
                        Calendar target = Calendar.getInstance();
                        target.setTime(dateChooserFrom.getDate());
                        
                        long milsecs1 = today.getTimeInMillis();
                        long milsecs2 = target.getTimeInMillis();
                        long diff = milsecs2 - milsecs1;
                        
                        long ddays = diff / (24 * 60 * 60 * 1000);

                        estimationChart.startGraph(CostEstimationOnHistoryCtrl.INTERVAL_LAST_DAY, (int)ddays );
                    }
                }
            }
        });
    }

    private void setMaxAndMinDates() {
        dbInterface.connect();
        //dates = dbInterface.getMaxAndMinDates();
        dbInterface.disconnect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToMainMenu = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        desktop = new javax.swing.JPanel();
        panelRealTime = new javax.swing.JPanel();
        powerFactorLabel = new javax.swing.JLabel();
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
        commandsCombo = new javax.swing.JComboBox();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        dateChooserTo = new com.toedter.calendar.JDateChooser();
        yearChooser = new javax.swing.JComboBox();
        monthChooser = new javax.swing.JComboBox();
        panelInformations3 = new javax.swing.JPanel();
        money2 = new javax.swing.JLabel();
        valueKw2 = new javax.swing.JLabel();
        countLabel2 = new javax.swing.JLabel();
        valueCount2 = new javax.swing.JLabel();
        kwLabel2 = new javax.swing.JLabel();
        kWValue3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estimativa de Custo baseado no Histórico", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 24))); // NOI18N
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
            .add(0, 998, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        panelRealTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Rede Elétrica - Tempo Real", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N
        panelRealTime.setMinimumSize(new java.awt.Dimension(275, 154));

        powerFactorLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        powerFactorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_up_small.png"))); // NOI18N
        powerFactorLabel.setText("Atualizando...");

        sourceLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        sourceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightning.png"))); // NOI18N
        sourceLabel.setText("Atualizando...");

        jLabel3.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel3.setText("Disponibilidade");

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
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(panelRealTimeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(sourceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(powerFactorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(10, 10, 10))
                    .add(panelRealTimeLayout.createSequentialGroup()
                        .add(jLabel3)
                        .add(0, 0, Short.MAX_VALUE)))
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
                    .add(powerFactorLabel)
                    .add(tensionLabel)
                    .add(frequencyLabel))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelCommands.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comandos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N

        commandsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Diário", "Mensal", "Período" }));
        commandsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandsComboActionPerformed(evt);
            }
        });

        fromLabel.setText("De:");

        toLabel.setText("Até:");

        yearChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016"}));

        monthChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        monthChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthChooserItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelCommandsLayout = new org.jdesktop.layout.GroupLayout(panelCommands);
        panelCommands.setLayout(panelCommandsLayout);
        panelCommandsLayout.setHorizontalGroup(
            panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelCommandsLayout.createSequentialGroup()
                .add(panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelCommandsLayout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(fromLabel)
                            .add(toLabel))
                        .add(6, 6, 6)
                        .add(panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dateChooserTo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .add(dateChooserFrom, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, monthChooser, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, yearChooser, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, commandsCombo, 0, 159, Short.MAX_VALUE)))
                .add(3, 3, 3))
        );
        panelCommandsLayout.setVerticalGroup(
            panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelCommandsLayout.createSequentialGroup()
                .add(commandsCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(yearChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(monthChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelCommandsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelCommandsLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(fromLabel)
                        .add(24, 24, 24)
                        .add(toLabel))
                    .add(panelCommandsLayout.createSequentialGroup()
                        .add(dateChooserFrom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(dateChooserTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, 0))
        );

        panelInformations3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N

        money2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        money2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money-coin.png"))); // NOI18N
        money2.setText("R$");

        valueKw2.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        valueKw2.setText("Valor do kW");

        countLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        countLabel2.setText("Atualizando...");

        valueCount2.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        valueCount2.setText("Valor da Conta");

        kwLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        kwLabel2.setText("Atualizando...");

        kWValue3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        kWValue3.setText("R$");

        org.jdesktop.layout.GroupLayout panelInformations3Layout = new org.jdesktop.layout.GroupLayout(panelInformations3);
        panelInformations3.setLayout(panelInformations3Layout);
        panelInformations3Layout.setHorizontalGroup(
            panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelInformations3Layout.createSequentialGroup()
                .addContainerGap()
                .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(valueCount2)
                        .add(61, 61, 61))
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(money2)
                        .add(2, 2, 2)
                        .add(countLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(30, 30, 30)))
                .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(kWValue3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(kwLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(138, 138, 138))
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(valueKw2)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelInformations3Layout.setVerticalGroup(
            panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelInformations3Layout.createSequentialGroup()
                .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(valueCount2)
                            .add(valueKw2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(kwLabel2)
                            .add(kWValue3)))
                    .add(panelInformations3Layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(panelInformations3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(countLabel2)
                            .add(money2))))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .add(panelCommands, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelInformations3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 352, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelRealTime, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(desktop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(51, 51, 51)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(separador)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(118, 118, 118)
                        .add(backToMainMenu))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelRealTime, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelCommands, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelInformations3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(0, 462, Short.MAX_VALUE)
                        .add(separador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(backToMainMenu))
                    .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (state == 1) {
            estimationChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_formComponentResized

    private void desktopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopComponentResized
        if (state == 1) {
            estimationChart.changeSize(desktop.getWidth(), desktop.getHeight());
        }
    }//GEN-LAST:event_desktopComponentResized

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
            newMenu = new NewMainMenu(userLogged);
            MainWindow.desktop.add(newMenu);
            MainWindow.desktop.revalidate();
            MainWindow.desktop.repaint();

            // XXX
            //updaterThread.stop();
        }
    }//GEN-LAST:event_backToMainMenuActionPerformed

    private void commandsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandsComboActionPerformed
        String selected = commandsCombo.getSelectedItem().toString();
        dateChooserFrom.setMinSelectableDate(dates[0]);
        dateChooserFrom.setMaxSelectableDate(dates[1]);
        dateChooserTo.setMaxSelectableDate(dates[1]);

        switch (selected) {
            case "Diário":
                dateChooserFrom.setVisible(true);
                dateChooserFrom.setCalendar(null);
                dateChooserTo.updateUI();
                dateChooserTo.setVisible(false);
                toLabel.setVisible(false);
                fromLabel.setVisible(false);
                yearChooser.setVisible(false);
                monthChooser.setVisible(false);
                break;
            case "Mensal":
                initialVisibleComponents();
                yearChooser.setVisible(true);
                monthChooser.setVisible(true);
                break;
            case "Período":
                dateChooserFrom.setVisible(true);
                dateChooserFrom.setCalendar(null);
                dateChooserFrom.updateUI();
                dateChooserTo.setVisible(true);
                dateChooserTo.setCalendar(null);
                dateChooserTo.updateUI();
                toLabel.setVisible(true);
                fromLabel.setVisible(true);
                yearChooser.setVisible(false);
                monthChooser.setVisible(false);
                break;
            default:
                initialVisibleComponents();
                break;
        }
    }//GEN-LAST:event_commandsComboActionPerformed

    private void monthChooserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthChooserItemStateChanged
        String selected = commandsCombo.getSelectedItem().toString();
        int selectedMonth = monthChooser.getSelectedIndex();
        int selectedYear = Integer.parseInt(yearChooser.getSelectedItem().toString());

        if (selected.equals("Mensal")) {
            if (selectedYear >= dates[0].getYear() || selectedYear <= dates[1].getYear()) {
                if (selectedMonth <= dates[0].getMonth() || selectedMonth >= dates[1].getMonth()) {
                    System.out.println("\n\nTESTE!!!\n\n");
                }
            }
        }
    }//GEN-LAST:event_monthChooserItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainMenu;
    private javax.swing.JComboBox commandsCombo;
    private javax.swing.JLabel countLabel2;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JPanel desktop;
    private javax.swing.JLabel flowLabel;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel kWValue3;
    private javax.swing.JLabel kwLabel2;
    private javax.swing.JLabel money2;
    private javax.swing.JComboBox monthChooser;
    private javax.swing.JPanel panelCommands;
    private javax.swing.JPanel panelInformations3;
    private javax.swing.JPanel panelRealTime;
    private javax.swing.JLabel potencyLabel;
    private javax.swing.JLabel powerFactorLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JLabel tensionLabel;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel valueCount2;
    private javax.swing.JLabel valueKw2;
    private javax.swing.JComboBox yearChooser;
    // End of variables declaration//GEN-END:variables
}
