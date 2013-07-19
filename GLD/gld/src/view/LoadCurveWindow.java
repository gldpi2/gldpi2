package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Login;
import org.jfree.data.time.Day;
import utils.DatabaseInterface;
import utils.UpdaterLoadCurveThread;

/**
 *
 * @author itallorossi
 */
public class LoadCurveWindow extends javax.swing.JPanel {

    private int state;
    private int month;
    private int year;
    private LoadCurveChart loadChart;
    private NewMainMenu newMenu;
    private Login userLogged;
    private Day today = new Day();
    private DatabaseInterface dbInterface = new DatabaseInterface();
    /*
     * 0 - data minima selecionavel / 1 - data maxima selecionavel
     */
    private Date[] dates = new Date[2];
    private Thread updaterThread;

    public LoadCurveWindow(int y, Login user) {
        initComponents();
        month = today.getMonth() - 1;
        year = today.getYear() - 2013;
        userLogged = user;
        setSize(1024, y);
        init();
    }

    private void init() {
        desktop.removeAll();
        loadChart = new LoadCurveChart(desktop.getWidth(), desktop.getHeight());

        updaterThread = new Thread(new UpdaterLoadCurveThread(loadChart.getLoadCurve(),
                this.flowLabel, this.tensionLabel, this.potencyLabel,
                this.powerFactorLabel, this.frequencyLabel,
                this.maxValue, this.maxTime, this.maxDate,
                this.minValue, this.minTime, this.minDate,
                this.sourceLabel));
        updaterThread.setDaemon(true);
        updaterThread.start();

        initialVisibleComponents();
        setMaxAndMinDates();
        loadChart.startGraph(true);

        desktop.add(loadChart);
        state = 1;
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
                Calendar cal = Calendar.getInstance();
                Date data = dateChooserFrom.getDate();

                if (data != null && dateChooserTo.isVisible()) {
                    cal.setTime(data);
                    cal.add(Calendar.DATE, 1);
                    Date newData = cal.getTime();
                    dateChooserTo.setMinSelectableDate(newData);
                    dateChooserTo.setCalendar(null);
                }
            }
        });
    }

    private void setMaxAndMinDates() {
        dbInterface.connect();
        dates = dbInterface.getMaxAndMinDates();
        dbInterface.disconnect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToMainMenu = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        desktop = new javax.swing.JPanel();
        panelInformations = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        maxTime = new javax.swing.JLabel();
        maxValue = new javax.swing.JLabel();
        maxDate = new javax.swing.JLabel();
        minValue = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        minDate = new javax.swing.JLabel();
        minTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gráfico de Curva de Carga", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 24))); // NOI18N
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
            .add(0, 1050, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 423, Short.MAX_VALUE)
        );

        panelInformations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Sistema Híbrido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans Caption", 0, 14))); // NOI18N
        panelInformations.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel6.setText("Máximo:");
        jLabel6.setToolTipText("");

        maxTime.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        maxTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxTime.setText("-");

        maxValue.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        maxValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxValue.setText("-");

        maxDate.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        maxDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxDate.setText("-");

        minValue.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        minValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minValue.setText("-");

        jLabel8.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel8.setText("Mínimo:");
        jLabel8.setToolTipText("");

        minDate.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        minDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minDate.setText("-");

        minTime.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        minTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minTime.setText("-");

        jLabel9.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel9.setText("Status da Bateria:");
        jLabel9.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N
        jLabel10.setText("Meta:");

        org.jdesktop.layout.GroupLayout panelInformationsLayout = new org.jdesktop.layout.GroupLayout(panelInformations);
        panelInformations.setLayout(panelInformationsLayout);
        panelInformationsLayout.setHorizontalGroup(
            panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelInformationsLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(panelInformationsLayout.createSequentialGroup()
                            .add(jLabel8)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(minDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(minTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(minValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(panelInformationsLayout.createSequentialGroup()
                            .add(jLabel6)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(maxDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(maxTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(maxValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jLabel9)
                    .add(jLabel10))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInformationsLayout.setVerticalGroup(
            panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelInformationsLayout.createSequentialGroup()
                .add(jLabel9)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel10)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(maxDate)
                    .add(maxTime)
                    .add(maxValue))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelInformationsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(minValue)
                    .add(minTime)
                    .add(minDate))
                .addContainerGap())
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .add(dateChooserTo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(separador)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(panelCommands, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelInformations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelRealTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(backToMainMenu))
            .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelInformations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelRealTime, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelCommands, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
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

            updaterThread.stop();
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
        int selectedMonth = monthChooser.getSelectedIndex() + 1;
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
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JPanel desktop;
    private javax.swing.JLabel flowLabel;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel maxDate;
    private javax.swing.JLabel maxTime;
    private javax.swing.JLabel maxValue;
    private javax.swing.JLabel minDate;
    private javax.swing.JLabel minTime;
    private javax.swing.JLabel minValue;
    private javax.swing.JComboBox monthChooser;
    private javax.swing.JPanel panelCommands;
    private javax.swing.JPanel panelInformations;
    private javax.swing.JPanel panelRealTime;
    private javax.swing.JLabel potencyLabel;
    private javax.swing.JLabel powerFactorLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JLabel tensionLabel;
    private javax.swing.JLabel toLabel;
    private javax.swing.JComboBox yearChooser;
    // End of variables declaration//GEN-END:variables
}
