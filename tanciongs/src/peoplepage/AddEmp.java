/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import peoplepage.PeoplePage;

/**
 *
 * @author Kirby
 */
public class AddEmp extends javax.swing.JFrame {
    /**
     * Creates new form AddEmp
     */
    AddEmpController aec = new AddEmpController();
    
    private String name;
    private AddEmp(){
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public AddEmp(String name) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        setName(name);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirm = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        background_addEmployee = new javax.swing.JLabel();
        AddEmpAdd = new javax.swing.JButton();
        AddEmpClear = new javax.swing.JButton();
        AddEmpCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New User");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(null);

        txtFname.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtFname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtFname);
        txtFname.setBounds(280, 160, 280, 40);

        txtLname.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtLname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtLname);
        txtLname.setBounds(280, 210, 280, 40);

        txtUsername.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtUsername);
        txtUsername.setBounds(279, 270, 280, 40);

        txtPassword.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword);
        txtPassword.setBounds(280, 330, 280, 40);

        txtConfirm.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmActionPerformed(evt);
            }
        });
        jPanel2.add(txtConfirm);
        txtConfirm.setBounds(279, 380, 280, 40);

        txtEmail.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail);
        txtEmail.setBounds(279, 440, 280, 40);

        txtContactNo.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtContactNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNoActionPerformed(evt);
            }
        });
        jPanel2.add(txtContactNo);
        txtContactNo.setBounds(279, 490, 280, 40);

        txtAddress.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtAddress);
        txtAddress.setBounds(279, 550, 280, 40);

        background_addEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FORMADJUSTED-02.png"))); // NOI18N
        jPanel2.add(background_addEmployee);
        background_addEmployee.setBounds(0, 0, 600, 700);

        AddEmpAdd.setText("ADD");
        AddEmpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpAddActionPerformed(evt);
            }
        });
        jPanel2.add(AddEmpAdd);
        AddEmpAdd.setBounds(280, 620, 70, 40);

        AddEmpClear.setText("CLEAR");
        AddEmpClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpClearActionPerformed(evt);
            }
        });
        jPanel2.add(AddEmpClear);
        AddEmpClear.setBounds(360, 620, 90, 40);

        AddEmpCancel.setText("CANCEL");
        AddEmpCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpCancelActionPerformed(evt);
            }
        });
        jPanel2.add(AddEmpCancel);
        AddEmpCancel.setBounds(460, 623, 110, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddEmpClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpClearActionPerformed
        aec.clear(this);
        txtConfirm.setText("");
    }//GEN-LAST:event_AddEmpClearActionPerformed

    private void AddEmpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpAddActionPerformed
        if(txtFname.getText().trim().equals("") || txtLname.getText().trim().equals("") 
                || txtUsername.getText().trim().equals("") || txtPassword.getText().trim().equals("") 
                || txtConfirm.getText().trim().equals("") || txtEmail.getText().trim().equals("")
                || txtContactNo.getText().trim().equals("") || txtAddress.getText().trim().equals("")
                ) {
            JOptionPane.showMessageDialog(null, "Failed! Please fill up!");
        } 
        
        else if (!txtPassword.getText().equals(txtConfirm.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords don't match!");
        }
        
        
        else {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to add this?", "Confirm Adding",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                aec.add(this);
                this.dispose();
                PeoplePage peop = new PeoplePage(this.getName());
                peop.getLblUser().setText("Welcome, "+this.getName());
                peop.setVisible(true);
                peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_AddEmpAddActionPerformed

    private void AddEmpCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpCancelActionPerformed
        this.dispose();
        PeoplePage peop = new PeoplePage(this.getName());
        peop.getLblUser().setText("Welcome "+this.getName());
        peop.setVisible(true);
        peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_AddEmpCancelActionPerformed

    private void txtConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void txtContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNoActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmp().setVisible(true);
            }
        });
    }
    
     

    
    
    
    
    //Getters
    public JTextField getTxtFname() {
        return txtFname;
    }

    public JTextField getTxtLname() {
        return txtLname;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }
    
    public JPasswordField getTxtConfirm() {
        return txtConfirm;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }
    
    public JTextField getTxtEmail(){
        return txtEmail;
    }
    
    public JTextField getTxtContactNo(){
        return txtContactNo;
    }
    
    public JTextField getTxtAddress(){
        return txtAddress;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEmpAdd;
    private javax.swing.JButton AddEmpCancel;
    private javax.swing.JButton AddEmpClear;
    private javax.swing.JLabel background_addEmployee;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    
}
