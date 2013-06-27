/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UserDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author artur
 */
public class UserWindow extends javax.swing.JPanel {

    /**
     * Creates new form Usuário
     */
    public UserWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwrod2Label = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        cell_oiLabel = new javax.swing.JLabel();
        cell_vivoLabel = new javax.swing.JLabel();
        cell_timLabel = new javax.swing.JLabel();
        cell_claroLabel = new javax.swing.JLabel();
        cell_oiBox = new javax.swing.JCheckBox();
        cell_vivoBox = new javax.swing.JCheckBox();
        cell_timBox = new javax.swing.JCheckBox();
        cell_claroBox = new javax.swing.JCheckBox();
        profileCombo = new javax.swing.JComboBox();
        profileLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        password2Field = new javax.swing.JPasswordField();
        cell_oiField = new javax.swing.JFormattedTextField();
        cell_vivoField = new javax.swing.JFormattedTextField();
        cell_timField = new javax.swing.JFormattedTextField();
        cell_claroField = new javax.swing.JFormattedTextField();
        warningLabel = new javax.swing.JLabel();
        registerField = new javax.swing.JFormattedTextField();
        hint = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jLabel1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar Usuário");

        nameLabel.setText("*Nome:");
        nameLabel.setName(""); // NOI18N

        registerLabel.setText("*Matrícula:");

        passwordLabel.setText("*Senha:");

        passwrod2Label.setText("*Confirme Senha:");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        createButton.setText("Cadastrar");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("Endereço Eletrônico:");

        cell_oiLabel.setText("Telefone (OI):");

        cell_vivoLabel.setText("Telefone (VIVO):");

        cell_timLabel.setText("Telefone (TIM):");

        cell_claroLabel.setText("Telefone (CLARO):");

        cell_oiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_oiBoxActionPerformed(evt);
            }
        });

        cell_vivoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_vivoBoxActionPerformed(evt);
            }
        });

        cell_timBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_timBoxActionPerformed(evt);
            }
        });

        cell_claroBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_claroBoxActionPerformed(evt);
            }
        });

        profileCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Técnico" }));
        profileCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileComboActionPerformed(evt);
            }
        });

        profileLabel.setText("Perfil:");

        try {
            cell_oiField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cell_oiField.setEnabled(false);

        try {
            cell_vivoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cell_vivoField.setEnabled(false);

        try {
            cell_timField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cell_timField.setEnabled(false);
        cell_timField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell_timFieldActionPerformed(evt);
            }
        });

        try {
            cell_claroField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cell_claroField.setEnabled(false);

        warningLabel.setText("Os campos assinalados com asterisco (*) são de preencimento obrigatório");

        try {
            registerField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/information.png"))); // NOI18N
        hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintActionPerformed(evt);
            }
        });

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/information.png"))); // NOI18N
        jToggleButton1.setActionCommand("");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameLabel)
                                            .addComponent(registerLabel)
                                            .addComponent(passwordLabel)
                                            .addComponent(passwrod2Label)
                                            .addComponent(emailLabel))
                                        .addGap(37, 37, 37))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cell_oiLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cell_oiBox))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cell_vivoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cell_vivoBox))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cell_timLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cell_timBox))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(profileLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cell_claroLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cell_claroBox)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registerField)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(passwordField)
                                    .addComponent(password2Field)
                                    .addComponent(emailField)
                                    .addComponent(cell_oiField)
                                    .addComponent(cell_vivoField)
                                    .addComponent(cell_timField)
                                    .addComponent(cell_claroField)
                                    .addComponent(profileCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(registerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerLabel))
                    .addComponent(hint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwrod2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cell_oiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cell_oiLabel))
                    .addComponent(cell_oiBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cell_vivoBox)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cell_vivoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cell_vivoLabel)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cell_timField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cell_timLabel)
                    .addComponent(cell_timBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cell_claroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cell_claroLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(profileCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profileLabel)))
                    .addComponent(cell_claroBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        int profile = 0;
        if (profileCombo.getSelectedItem().equals("Administrador")) {
            profile = 1;
        }
        if (profileCombo.getSelectedItem().equals("Técnico")) {
            profile = 2;
        }
        if (Verifications()) {
            String cell_oi = (cell_oiField.getText().equals("(  )    -    ")) ? null : cell_oiField.getText();
            String cell_vivo = (cell_vivoField.getText().equals("(  )    -    ")) ? null : cell_vivoField.getText();
            String cell_tim = (cell_timField.getText().equals("(  )    -    ")) ? null : cell_timField.getText();
            String cell_claro = (cell_claroField.getText().equals("(  )    -    ")) ? null : cell_claroField.getText();
            String email = (emailField.getText().equals("")) ? null : emailField.getText();
            User user = new User(nameField.getText(), registerField.getText(),
                    passwordField.getText().toString(), email,
                    cell_oi, cell_vivo, cell_tim, cell_claro, profile);
            
            UserDAO dao = new UserDAO();
            
            dao.createUser(user);

//        System.out.println("User = " + user);
//        System.out.println("User.name = " + user.getName());
//        System.out.println("User.register = " + user.getRegister());
//        System.out.println("User.password = " + user.getPassword());
//        System.out.println("User.email = " + user.getEmail());
//        System.out.println("User.cell_oi = " + user.getCell_oi());
//        System.out.println("User.cell_vivo =" + user.getCell_vivo());
//        System.out.println("User.cell_tim = " + user.getCell_tim());
//        System.out.println("User.cell_claro = " + user.getCell_claro());
//        System.out.println("User.profile = " + user.getProfile());
        }
    }//GEN-LAST:event_createButtonActionPerformed
    
    private void profileComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileComboActionPerformed
    
    private void cell_oiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_oiBoxActionPerformed
        if (cell_oiBox.isSelected()) {
            cell_oiField.setEnabled(true);
        } else {
            cell_oiField.setEnabled(false);
            cell_oiField.setText("");
        }
    }//GEN-LAST:event_cell_oiBoxActionPerformed
    
    private void cell_vivoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_vivoBoxActionPerformed
        if (cell_vivoBox.isSelected()) {
            cell_vivoField.setEnabled(true);
        } else {
            cell_vivoField.setEnabled(false);
            cell_vivoField.setText("");
        }
    }//GEN-LAST:event_cell_vivoBoxActionPerformed
    
    private void cell_timBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_timBoxActionPerformed
        if (cell_timBox.isSelected()) {
            cell_timField.setEnabled(true);
        } else {
            cell_timField.setEnabled(false);
            cell_timField.setText("");
        }
    }//GEN-LAST:event_cell_timBoxActionPerformed
    
    private void cell_claroBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_claroBoxActionPerformed
        if (cell_claroBox.isSelected()) {
            cell_claroField.setEnabled(true);
        } else {
            cell_claroField.setEnabled(false);
            cell_claroField.setText("");
        }
    }//GEN-LAST:event_cell_claroBoxActionPerformed
    
    private void cell_timFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell_timFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cell_timFieldActionPerformed
    
    private void hintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "O campo matrícula deve ser preenchido "
                + "no formato 99/99999999!\nCaso sua matrícula não possua os 9 digítos "
                + "complete os espaços \nrestantes com zeros(\"0\").", "Dica de "
                + "Preenchimento!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_hintActionPerformed
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "O campo senha deve conter de "
                + "6 a 10 caracteres alfanuméricos", "Dica de "
                + "Preenchimento!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox cell_claroBox;
    private javax.swing.JFormattedTextField cell_claroField;
    private javax.swing.JLabel cell_claroLabel;
    private javax.swing.JCheckBox cell_oiBox;
    private javax.swing.JFormattedTextField cell_oiField;
    private javax.swing.JLabel cell_oiLabel;
    private javax.swing.JCheckBox cell_timBox;
    private javax.swing.JFormattedTextField cell_timField;
    private javax.swing.JLabel cell_timLabel;
    private javax.swing.JCheckBox cell_vivoBox;
    private javax.swing.JFormattedTextField cell_vivoField;
    private javax.swing.JLabel cell_vivoLabel;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JToggleButton hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField password2Field;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwrod2Label;
    private javax.swing.JComboBox profileCombo;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JFormattedTextField registerField;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables

    public boolean checkPassword() {
        String sen = passwordField.getText();
        String senC = password2Field.getText();
        
        if ((sen.equals(senC) && senC.equals(sen)) && (!sen.equals("") || !senC.equals(""))) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkEmail(String email) {
        
        if (email.equals("")) {
            return true;
        }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        
        Matcher m = p.matcher(email);
        
        boolean matchFound = m.matches();
        
        if (matchFound) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkCellNumbers() {
        if (cell_oiBox.isSelected() && cell_oiField.getText().equals("(  )    -    ")) {
            return false;
        }
        if (cell_vivoBox.isSelected() && cell_vivoField.getText().equals("(  )    -    ")) {
            return false;
        }
        if (cell_timBox.isSelected() && cell_timField.getText().equals("(  )    -    ")) {
            return false;
        }
        if (cell_claroBox.isSelected() && cell_claroField.getText().equals("(  )    -    ")) {
            return false;
        }
        return true;
    }
    
    public boolean Verifications() {
        if (nameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo nome é obrigatório!",
                    "Erro: Nome",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (registerField.getText().equals("  /       ")) {
            JOptionPane.showMessageDialog(null, "O campo matrícula é obrigatório!",
                    "Erro: Matrícula",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (passwordField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo senha é obrigatório!",
                    "Erro: Senha",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password2Field.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Confirme a senha digitada!",
                    "Erro: Senha2",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!checkPassword()) {
            JOptionPane.showMessageDialog(null, "A senhas digitadas "
                    + "não conferem!", "Erro: Senha", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
            password2Field.setText("");
            return false;
        }
        if (passwordField.getText().length() < 6 || passwordField.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "O campo senha deve conter "
                    + "de 6 a 10 caracteres", "Erro: Senha", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
            password2Field.setText("");
            return false;
        }
        if (!checkEmail(emailField.getText())) {
            JOptionPane.showMessageDialog(null, "Email inválido!\n"
                    + "O email deve estar no formato:\n"
                    + "email@dominio.[com, org, net...]", "Erro: Email",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!checkCellNumbers()) {
            JOptionPane.showMessageDialog(null, "Número telefônico inválido!",
                    "Erro: Telefone",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
        final JFrame frame = new JFrame();
        frame.add(new UserWindow());
        frame.setLocation(300, 200);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}
