/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Login;
import utils.PowerGridMonitor;

/**
 *
 * @author itallorossi
 */
public class MainWindow extends javax.swing.JFrame {

    public static Login user;
    public static LoadCurveWindow loadWindow;
    public static CostWindow costWindow;
    public static LoadEstimationOnHistoryWindow eohWindow;
    public static EstimationOnRealCostWindow eorCostWindow;
    public static EstimationOnRealLoadWindow eorLoadWindow;
    public static UserWindow userWindow;
    public static EstimationCurveMenu estimationCurveMenu;
    public static EstimationCostMenu estimationCostMenu;
    public static NewPatternWindow pattern;
    PowerGridMonitor powerGridMonitor;
    Thread monitorThread;
    int state = 0;
    private MainMenu pg;
    private NewMainMenu pg2;
    private GuidelineRateWindow1 guideLineWindow;

    /**
     * Creates new form JanelaPrincipal
     */
    public MainWindow(Login usuario) {
        initComponents();
        initPowerGridMonitor();
        setSize(1024, 720);
        setLocationRelativeTo(null);
        user = usuario;

        this.raizHibrido.setVisible(false);

        if (Integer.parseInt(user.getTipo()) == 2) {
            menuRegistros.setVisible(false);
        }

        //this.init();

        //descomentar caso queira chamar essa main menu
        this.initNewMenu();

    }

    public MainWindow() {
        initComponents();
    }

    private void init() {
        desktop.removeAll();
        pg = new MainMenu(user);
        desktop.add(pg);
        desktop.revalidate();
        desktop.repaint();

        state = 1;
    }

    private void initNewMenu() {
        desktop.removeAll();
        pg2 = new NewMainMenu(user);
        desktop.add(pg2);
        desktop.revalidate();
        desktop.repaint();

        state = 1;
    }

    private void initPowerGridMonitor() {
        Logger.getLogger(MainWindow.class.getName()).log(Level.INFO, "Inicializando PowerGridMonitorThread");

        powerGridMonitor = new PowerGridMonitor();

        monitorThread = new Thread(powerGridMonitor);

        monitorThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        raizArquivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuRegistros = new javax.swing.JMenu();
        menuRegistrosUsuario = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        separadorArquivo = new javax.swing.JPopupMenu.Separator();
        menuVoltarMenuPrincipal = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        raizMonitoramento = new javax.swing.JMenu();
        menuCustos = new javax.swing.JMenuItem();
        menuConsumo = new javax.swing.JMenuItem();
        raizEstimativas = new javax.swing.JMenu();
        menuEstimativasCusto = new javax.swing.JMenu();
        menuCustoTempoReal = new javax.swing.JMenuItem();
        menuCustoHistorico = new javax.swing.JMenuItem();
        menuEstimativasConsumo = new javax.swing.JMenu();
        menuConsumoTempoReal = new javax.swing.JMenuItem();
        menuConsumoHistorico = new javax.swing.JMenuItem();
        menuEstudoContratual = new javax.swing.JMenuItem();
        raizHibrido = new javax.swing.JMenu();
        raizAjuda = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento da Energia Elétrica pelo Lado da Demanda Associado a um Sistema Híbrido de Abastecimento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        org.jdesktop.layout.GroupLayout desktopLayout = new org.jdesktop.layout.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 800, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 638, Short.MAX_VALUE)
        );

        raizArquivo.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.META_MASK));
        jMenuItem1.setText("New Pattern");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        raizArquivo.add(jMenuItem1);

        menuRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application_form.png"))); // NOI18N
        menuRegistros.setText("Registros");

        menuRegistrosUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        menuRegistrosUsuario.setText("Usuários");
        menuRegistrosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrosUsuarioActionPerformed(evt);
            }
        });
        menuRegistros.add(menuRegistrosUsuario);

        jMenuItem2.setText("Enquadramento Tarifário");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuRegistros.add(jMenuItem2);

        raizArquivo.add(menuRegistros);
        raizArquivo.add(separadorArquivo);

        menuVoltarMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/house_go.png"))); // NOI18N
        menuVoltarMenuPrincipal.setText("Voltar ao Menu Principal");
        menuVoltarMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoltarMenuPrincipalActionPerformed(evt);
            }
        });
        raizArquivo.add(menuVoltarMenuPrincipal);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        raizArquivo.add(menuSair);

        barraMenu.add(raizArquivo);

        raizMonitoramento.setText("Monitoramento");

        menuCustos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_curve.png"))); // NOI18N
        menuCustos.setText("Custo");
        menuCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustosActionPerformed(evt);
            }
        });
        raizMonitoramento.add(menuCustos);

        menuConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_line.png"))); // NOI18N
        menuConsumo.setText("Consumo");
        menuConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsumoActionPerformed(evt);
            }
        });
        raizMonitoramento.add(menuConsumo);

        barraMenu.add(raizMonitoramento);

        raizEstimativas.setText("Estimativas");

        menuEstimativasCusto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money-coin.png"))); // NOI18N
        menuEstimativasCusto.setText("Custo");

        menuCustoTempoReal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock.png"))); // NOI18N
        menuCustoTempoReal.setText("Tempo Real");
        menuCustoTempoReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustoTempoRealActionPerformed(evt);
            }
        });
        menuEstimativasCusto.add(menuCustoTempoReal);

        menuCustoHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuCustoHistorico.setText("Por Histórico");
        menuCustoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustoHistoricoActionPerformed(evt);
            }
        });
        menuEstimativasCusto.add(menuCustoHistorico);

        raizEstimativas.add(menuEstimativasCusto);

        menuEstimativasConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lightning.png"))); // NOI18N
        menuEstimativasConsumo.setText("Consumo");

        menuConsumoTempoReal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock.png"))); // NOI18N
        menuConsumoTempoReal.setText("Tempo Real");
        menuConsumoTempoReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsumoTempoRealActionPerformed(evt);
            }
        });
        menuEstimativasConsumo.add(menuConsumoTempoReal);

        menuConsumoHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuConsumoHistorico.setText("Por Histórico");
        menuConsumoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsumoHistoricoActionPerformed(evt);
            }
        });
        menuEstimativasConsumo.add(menuConsumoHistorico);

        raizEstimativas.add(menuEstimativasConsumo);

        menuEstudoContratual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report_magnify.png"))); // NOI18N
        menuEstudoContratual.setText("Estudo Contratual");
        menuEstudoContratual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstudoContratualActionPerformed(evt);
            }
        });
        raizEstimativas.add(menuEstudoContratual);

        barraMenu.add(raizEstimativas);

        raizHibrido.setText("Sistema Hibrído");
        barraMenu.add(raizHibrido);

        raizAjuda.setText("Ajuda");

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/information.png"))); // NOI18N
        menuSobre.setText("Sobre...");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        raizAjuda.add(menuSobre);

        barraMenu.add(raizAjuda);

        setJMenuBar(barraMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, desktop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int i;

        Object[] options = {"Sim", "Não"};
        i = JOptionPane.showOptionDialog(null,
                "Deseja realmente fechar o sistema?",
                "Sair do Sistema",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/icons/cross.png"),
                options,
                options[1]);

        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuCustosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCustosActionPerformed
        desktop.removeAll();
        costWindow = new CostWindow(desktop.getHeight(), user);
        desktop.add(costWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuCustosActionPerformed

    private void menuConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsumoActionPerformed
        desktop.removeAll();
        loadWindow = new LoadCurveWindow(desktop.getHeight(), user);
        desktop.add(loadWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuConsumoActionPerformed

    private void menuRegistrosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrosUsuarioActionPerformed
        desktop.removeAll();
        userWindow = new UserWindow(desktop.getHeight());
        desktop.add(userWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuRegistrosUsuarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closePowerGridMonitorThread();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int i;

        Object[] options = {"Sim", "Não"};
        i = JOptionPane.showOptionDialog(null,
                "Deseja realmente finalizar a aplicação?",
                "Sair do Sistema",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/icons/cross.png"),
                options,
                options[1]);

        if (i == JOptionPane.YES_OPTION) {
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        AboutWindow about = new AboutWindow();
        about.setVisible(true);
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuCustoTempoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCustoTempoRealActionPerformed
        desktop.removeAll();
        eorCostWindow = new EstimationOnRealCostWindow(MainWindow.desktop.getHeight(), MainWindow.user);
        desktop.add(eorCostWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuCustoTempoRealActionPerformed

    private void menuConsumoTempoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsumoTempoRealActionPerformed
        desktop.removeAll();
        eorLoadWindow = new EstimationOnRealLoadWindow(MainWindow.desktop.getHeight(), MainWindow.user);
        desktop.add(eorLoadWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuConsumoTempoRealActionPerformed

    private void menuVoltarMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarMenuPrincipalActionPerformed
        initNewMenu();
    }//GEN-LAST:event_menuVoltarMenuPrincipalActionPerformed

    private void menuCustoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCustoHistoricoActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento!", "Em Breve", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_menuCustoHistoricoActionPerformed

    private void menuConsumoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsumoHistoricoActionPerformed
        desktop.removeAll();
        eohWindow = new LoadEstimationOnHistoryWindow(MainWindow.desktop.getHeight(), MainWindow.user);
        desktop.add(MainWindow.eohWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuConsumoHistoricoActionPerformed

    private void menuEstudoContratualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstudoContratualActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento!", "Em Breve", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_menuEstudoContratualActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        desktop.removeAll();
        pattern = new NewPatternWindow(desktop.getHeight(), user);
        desktop.add(pattern);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desktop.removeAll();
        guideLineWindow = new GuidelineRateWindow1(desktop.getHeight());
        desktop.add(guideLineWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void closePowerGridMonitorThread() {
        Logger.getLogger(MainWindow.class.getName()).log(Level.INFO, "PowerGridMonitorThread parada.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    public static javax.swing.JPanel desktop;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuConsumo;
    private javax.swing.JMenuItem menuConsumoHistorico;
    private javax.swing.JMenuItem menuConsumoTempoReal;
    private javax.swing.JMenuItem menuCustoHistorico;
    private javax.swing.JMenuItem menuCustoTempoReal;
    private javax.swing.JMenuItem menuCustos;
    private javax.swing.JMenu menuEstimativasConsumo;
    private javax.swing.JMenu menuEstimativasCusto;
    private javax.swing.JMenuItem menuEstudoContratual;
    private javax.swing.JMenu menuRegistros;
    private javax.swing.JMenuItem menuRegistrosUsuario;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenuItem menuVoltarMenuPrincipal;
    private javax.swing.JMenu raizAjuda;
    private javax.swing.JMenu raizArquivo;
    private javax.swing.JMenu raizEstimativas;
    private javax.swing.JMenu raizHibrido;
    private javax.swing.JMenu raizMonitoramento;
    private javax.swing.JPopupMenu.Separator separadorArquivo;
    // End of variables declaration//GEN-END:variables
}
