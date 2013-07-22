/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Login;

/**
 *
 * @author itallorossi
 */
public class ContractStudy extends javax.swing.JPanel {

    private NewMainMenu newMenu;
    private Login loggedUser;

    /**
     * Creates new form ContractStudy
     */
    public ContractStudy(int y, Login user) {
        initComponents();
        setSize(1024, y);
        loggedUser = user;
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

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSeparator1)
            .add(jPanel4Layout.createSequentialGroup()
                .add(0, 847, Short.MAX_VALUE)
                .add(backToMainMenu))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
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
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
