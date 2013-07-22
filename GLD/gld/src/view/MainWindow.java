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
    public static CostWindow NewCostWindow;
    public static LoadEstimationOnHistoryWindow eohWindow;
    public static old__EstimationOnRealCostWindow eorCostWindow;
    public static EstimationOnRealLoadWindow eorLoadWindow;
    public static UserWindow userWindow;
    public static EstimationCurveMenu estimationCurveMenu;
    public static EstimationCostMenu estimationCostMenu;
    public static NewPatternWindow pattern;
    private PowerGridMonitor powerGridMonitor;
    private Thread monitorThread;
    private int state = 0;
    private MainMenu mainMenu;
    public static NewMainMenu newMainMenu;
    private GuidelineRateWindow guideLineWindow;
    private CostEstimationOnHistoryWindow loadWindowEst;
    private ContractWindow contractWindow;
    private ContractStudy contractStudy;

    public MainWindow(Login usuario) {
        initComponents();
        initPowerGridMonitor();
        setSize(1024, 720);
        setLocationRelativeTo(null);
        user = usuario;

        if (user.getPermission().equals("2")) {
            menuRegistros.setVisible(false);
            separadorArquivo.setVisible(false);
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
        mainMenu = new MainMenu(user);
        desktop.add(mainMenu);
        desktop.revalidate();
        desktop.repaint();

        state = 1;
    }

    private void initNewMenu() {
        desktop.removeAll();
        newMainMenu = new NewMainMenu(user);
        desktop.add(newMainMenu);
        desktop.revalidate();
        desktop.repaint();

        state = 1;
    }

    private void initPowerGridMonitor() {
        if (powerGridMonitor == null) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.INFO, "Inicializando PowerGridMonitorThread");
            powerGridMonitor = new PowerGridMonitor();
            monitorThread = new Thread(powerGridMonitor);
            monitorThread.start();
        }
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
        menuRegistros = new javax.swing.JMenu();
        menuRegistrosUsuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        separadorArquivo = new javax.swing.JPopupMenu.Separator();
        menuVoltarMenuPrincipal = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        raizMonitoramento = new javax.swing.JMenu();
        menuConsumo = new javax.swing.JMenuItem();
        menuCustos = new javax.swing.JMenuItem();
        raizEstimativas = new javax.swing.JMenu();
        menuEstimativaCusto = new javax.swing.JMenuItem();
        menuEstudoContratual = new javax.swing.JMenuItem();
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

        desktop.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                desktopComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                desktopComponentRemoved(evt);
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
            .add(0, 658, Short.MAX_VALUE)
        );

        raizArquivo.setText("Arquivo");

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

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        jMenuItem1.setText("Contrato");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRegistros.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money_exclamation.png"))); // NOI18N
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

        menuConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_bar.png"))); // NOI18N
        menuConsumo.setText("Perfil do Consumidor");
        menuConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsumoActionPerformed(evt);
            }
        });
        raizMonitoramento.add(menuConsumo);

        menuCustos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart_curve.png"))); // NOI18N
        menuCustos.setText("Custo");
        menuCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustosActionPerformed(evt);
            }
        });
        raizMonitoramento.add(menuCustos);

        barraMenu.add(raizMonitoramento);

        raizEstimativas.setText("Previsões");

        menuEstimativaCusto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money-coin.png"))); // NOI18N
        menuEstimativaCusto.setText("Custo");
        menuEstimativaCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstimativaCustoActionPerformed(evt);
            }
        });
        raizEstimativas.add(menuEstimativaCusto);

        menuEstudoContratual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report_magnify.png"))); // NOI18N
        menuEstudoContratual.setText("Estudo Contratual");
        menuEstudoContratual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstudoContratualActionPerformed(evt);
            }
        });
        raizEstimativas.add(menuEstudoContratual);

        barraMenu.add(raizEstimativas);

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
        NewCostWindow = new CostWindow(desktop.getHeight(), user);
        desktop.add(NewCostWindow);
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

    private void menuVoltarMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarMenuPrincipalActionPerformed
        initNewMenu();
    }//GEN-LAST:event_menuVoltarMenuPrincipalActionPerformed

    private void menuEstudoContratualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstudoContratualActionPerformed
        desktop.removeAll();
        contractStudy = new ContractStudy(desktop.getHeight(), user);
        desktop.add(contractStudy);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuEstudoContratualActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desktop.removeAll();
        guideLineWindow = new GuidelineRateWindow(desktop.getHeight(), user);
        desktop.add(guideLineWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuEstimativaCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstimativaCustoActionPerformed
        desktop.removeAll();
        loadWindowEst = new CostEstimationOnHistoryWindow(desktop.getHeight(), user);
        desktop.add(loadWindowEst);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuEstimativaCustoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        desktop.removeAll();
        contractWindow = new ContractWindow(desktop.getHeight(), user);
        desktop.add(contractWindow);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void desktopComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_desktopComponentRemoved
        if (newMainMenu != null) {
            newMainMenu.updateLoadCurve.stopExecution();
            newMainMenu.updaterLoadCurveThread.stop();
            newMainMenu.updaterCostCurve.stop();
            newMainMenu = null;
        }

        if (loadWindow != null) {
            loadWindow.updater.stopExecution();
            loadWindow.updaterThread.stop();
            loadWindow = null;
        }
    }//GEN-LAST:event_desktopComponentRemoved

    private void desktopComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_desktopComponentAdded
    }//GEN-LAST:event_desktopComponentAdded

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
    private javax.swing.JMenuItem menuCustos;
    private javax.swing.JMenuItem menuEstimativaCusto;
    private javax.swing.JMenuItem menuEstudoContratual;
    private javax.swing.JMenu menuRegistros;
    private javax.swing.JMenuItem menuRegistrosUsuario;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenuItem menuVoltarMenuPrincipal;
    private javax.swing.JMenu raizAjuda;
    private javax.swing.JMenu raizArquivo;
    private javax.swing.JMenu raizEstimativas;
    private javax.swing.JMenu raizMonitoramento;
    private javax.swing.JPopupMenu.Separator separadorArquivo;
    // End of variables declaration//GEN-END:variables
}
