package view;

import controller.LoginCtrl;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.DatabaseInterface;

/**
 *
 * @author itallorossi
 */
public class LoginWindow extends javax.swing.JFrame {

    public LoginWindow() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonEntrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registerField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        buttonEntrar = new javax.swing.JButton();
        changeDatabaseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktopLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bem-Vindo ao GLD!", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        jLabel1.setText("Matrícula");

        registerField.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        registerField.setText("090038070");

        jLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        jLabel2.setText("Senha");

        passwordField.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        passwordField.setText("senha1234");

        buttonEntrar.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        buttonEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/door_in.png"))); // NOI18N
        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        changeDatabaseButton.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        changeDatabaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_connect.png"))); // NOI18N
        changeDatabaseButton.setText("Base de Dados");
        changeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDatabaseButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout desktopLoginLayout = new org.jdesktop.layout.GroupLayout(desktopLogin);
        desktopLogin.setLayout(desktopLoginLayout);
        desktopLoginLayout.setHorizontalGroup(
            desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopLoginLayout.createSequentialGroup()
                .addContainerGap()
                .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(desktopLoginLayout.createSequentialGroup()
                        .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .add(18, 18, 18)
                        .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(passwordField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .add(registerField))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, desktopLoginLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(changeDatabaseButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonEntrar)))
                .addContainerGap())
        );
        desktopLoginLayout.setVerticalGroup(
            desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopLoginLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(registerField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(desktopLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonEntrar)
                    .add(changeDatabaseButton))
                .add(0, 0, 0))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopLogin, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopLogin, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        LoginCtrl loginCtrl = new LoginCtrl();
        loginCtrl.setLogin(registerField.getText(), passwordField.getText());

        DatabaseInterface dbInterface = new DatabaseInterface();

        dbInterface.connect();

        if (dbInterface.isConnected() == false) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados!\nFavor entrar com um host válido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (loginCtrl.verifyLogin(registerField.getText(), passwordField.getText()) == 1) {
                MainWindow main = new MainWindow(loginCtrl.getLogin());
                this.setVisible(false);
                main.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Problema ao efetuar login!\nSenha e/ou Matrícula incorretos!\nVerifque se o banco de dados está configurado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }

        dbInterface.disconnect();
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }//GEN-LAST:event_formWindowClosing

    private void changeDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDatabaseButtonActionPerformed
        Object[] options = {"Sim", "Não"};

        try {
            String host = (String) JOptionPane.showInputDialog(null,
                    "Entre com o HOST do banco de dados: ",
                    "HOST",
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon("src/icons/database_connect.png"),
                    null,
                    null);

            Properties dbProperties = new Properties();
            FileWriter writer;

            if (!host.equals("")) {
                try {
                    dbProperties.load(new FileInputStream("src/utils/PropertiesFile.properties"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dbProperties.setProperty("HOST", host);

                try {
                    writer = new FileWriter("src/utils/PropertiesFile.properties");
                    dbProperties.store(writer, null);
                    writer.flush();
                    writer.close();
                    JOptionPane.showMessageDialog(null,
                            "O sistema será fechado para que as configurações sejam aplicadas!\nReinicie o sistema para começar a usar!",
                            "Banco de Dados Configurado",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("src/icons/cross.png"));
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException e) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.WARNING, "Usuário cancelou a seleção!");
        }
    }//GEN-LAST:event_changeDatabaseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JButton changeDatabaseButton;
    private javax.swing.JPanel desktopLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField registerField;
    // End of variables declaration//GEN-END:variables
}
