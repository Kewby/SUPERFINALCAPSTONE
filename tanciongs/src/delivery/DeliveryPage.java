/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import adminpage.AdminPage;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.DeliveryModel;
import javax.swing.JOptionPane;
import login.Login;
import javax.swing.RowFilter;

/**
 *
 * @author Allysha, Kirby
 */
public class DeliveryPage extends javax.swing.JFrame {

    /**
     * Creates new form DeliveryPage
     */
    
    public DeliveryPage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public DeliveryPage(String name){
        initComponents();
        this.setLocationRelativeTo(null);
        setName(name);   
        
        DeliveryModel dm = new DeliveryModel(); //links to delivery model
        ResultSet rs = dm.showDelivery();       //calls the query...
        ResultSet rs2 = dm.currentDelivery();
        
        String val = dm.determineBranch(name); 
            if(val.compareTo("1")==0){
                all_branch.setSelectedIndex(0);
                rs = dm.showDelivery2("1");
            }else{
                all_branch.setSelectedIndex(1);
                rs = dm.showDelivery2("2");
            }
        tblDelivery.setModel(DbUtils.resultSetToTableModel(rs));
        tblCurrent.setModel(DbUtils.resultSetToTableModel(rs2));
        
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
        lblUser = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        current_tab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCurrent = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        current_branch = new javax.swing.JComboBox<>();
        totalCurrent = new javax.swing.JLabel();
        searchCurrent = new javax.swing.JTextField();
        background_current = new javax.swing.JLabel();
        tab_currentDeliveries = new javax.swing.JButton();
        tab_all = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        all_tab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        totalPurchase = new javax.swing.JLabel();
        searchDelivery = new javax.swing.JTextField();
        all_branch = new javax.swing.JComboBox<>();
        background_allDeliveries = new javax.swing.JLabel();
        addDelivery = new javax.swing.JButton();
        tab_current2 = new javax.swing.JButton();
        tab_all2 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(241, 242, 242));

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUser.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(988, Short.MAX_VALUE)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -20, 1370, 50);

        current_tab.setLayout(null);

        jScrollPane2.setBorder(null);

        tblCurrent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCurrent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCurrent.setRowHeight(30);
        jScrollPane2.setViewportView(tblCurrent);

        current_tab.add(jScrollPane2);
        jScrollPane2.setBounds(40, 300, 1290, 360);

        jPanel2.setBackground(new java.awt.Color(244, 158, 9));
        jPanel2.setLayout(null);
        current_tab.add(jPanel2);
        jPanel2.setBounds(30, 290, 1310, 380);

        current_branch.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        current_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cebu Branch", "Leyte Branch" }));
        current_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_branchActionPerformed(evt);
            }
        });
        current_tab.add(current_branch);
        current_branch.setBounds(1060, 230, 280, 40);

        totalCurrent.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        totalCurrent.setText("0.00");
        current_tab.add(totalCurrent);
        totalCurrent.setBounds(1060, 180, 280, 40);

        searchCurrent.setBackground(new java.awt.Color(241, 242, 242));
        searchCurrent.setBorder(null);
        current_tab.add(searchCurrent);
        searchCurrent.setBounds(80, 200, 350, 14);

        background_current.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DELIVERYADJUSTEDCURRENT.png"))); // NOI18N
        current_tab.add(background_current);
        background_current.setBounds(0, 0, 1370, 710);

        tab_currentDeliveries.setText("jButton1");
        tab_currentDeliveries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_currentDeliveriesActionPerformed(evt);
            }
        });
        current_tab.add(tab_currentDeliveries);
        tab_currentDeliveries.setBounds(40, 240, 370, 50);

        tab_all.setText("jButton1");
        tab_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_allActionPerformed(evt);
            }
        });
        current_tab.add(tab_all);
        tab_all.setBounds(420, 240, 390, 50);

        btnLogout.setText("jButton1");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        current_tab.add(btnLogout);
        btnLogout.setBounds(1270, 10, 70, 70);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        current_tab.add(btnBack);
        btnBack.setBounds(10, 20, 140, 50);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        current_tab.add(jButton1);
        jButton1.setBounds(450, 190, 100, 50);

        jTabbedPane1.addTab("CURRENT DATE DELIVERIES", current_tab);

        all_tab.setLayout(null);

        jScrollPane1.setBorder(null);

        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDelivery);

        all_tab.add(jScrollPane1);
        jScrollPane1.setBounds(40, 301, 1290, 360);

        jPanel3.setBackground(new java.awt.Color(244, 158, 9));
        jPanel3.setLayout(null);
        all_tab.add(jPanel3);
        jPanel3.setBounds(30, 290, 1310, 380);

        totalPurchase.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalPurchase.setText("0.00");
        all_tab.add(totalPurchase);
        totalPurchase.setBounds(1060, 190, 280, 29);

        searchDelivery.setBackground(new java.awt.Color(241, 242, 242));
        searchDelivery.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        searchDelivery.setBorder(null);
        searchDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDeliveryActionPerformed(evt);
            }
        });
        searchDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDeliveryKeyReleased(evt);
            }
        });
        all_tab.add(searchDelivery);
        searchDelivery.setBounds(80, 200, 350, 20);

        all_branch.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        all_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cebu Branch", "Leyte Branch" }));
        all_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all_branchActionPerformed(evt);
            }
        });
        all_tab.add(all_branch);
        all_branch.setBounds(1060, 230, 280, 40);

        background_allDeliveries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DELIVERYADJUSTEDSHOWALL.png"))); // NOI18N
        background_allDeliveries.setText("jLabel2");
        all_tab.add(background_allDeliveries);
        background_allDeliveries.setBounds(0, 0, 1370, 710);

        addDelivery.setText("ADD DELIVERY");
        addDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliveryActionPerformed(evt);
            }
        });
        all_tab.add(addDelivery);
        addDelivery.setBounds(450, 180, 110, 60);

        tab_current2.setText("jButton1");
        tab_current2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_current2ActionPerformed(evt);
            }
        });
        all_tab.add(tab_current2);
        tab_current2.setBounds(40, 243, 370, 50);

        tab_all2.setText("jButton2");
        tab_all2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_all2ActionPerformed(evt);
            }
        });
        all_tab.add(tab_all2);
        tab_all2.setBounds(420, 240, 400, 50);

        btnBack1.setText("BACK");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        all_tab.add(btnBack1);
        btnBack1.setBounds(10, 20, 140, 50);

        jTabbedPane1.addTab("ALL DELIVERIES", all_tab);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1370, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeliveryActionPerformed
        DeliveryForm df = new DeliveryForm (this.getName());
        df.setVisible(true);
    }//GEN-LAST:event_addDeliveryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminPage ap = new AdminPage (this.getName());
        ap.getLblUser().setText("Welcome "+this.getName());
        ap.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void all_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all_branchActionPerformed
       DeliveryModel dm = new DeliveryModel();
       ResultSet rs = null;
    
       //SHOW ALL DELIVERIES
        if(all_branch.getSelectedItem().toString().compareTo("Cebu Branch")==0){
            rs = dm.showDelivery2("1");
        }else{
            rs = dm.showDelivery2("2");
        }
        tblDelivery.setModel(DbUtils.resultSetToTableModel(rs)); 
      
        DefaultTableModel model = (DefaultTableModel) tblDelivery.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblDelivery.setRowSorter(tr);
        try {
           tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchDelivery.getText()));
 
        float total =  0;
        for (int i = 0; i < tblDelivery.getRowCount(); i++ ) {
            total = total + Float.parseFloat(tblDelivery.getValueAt(i, 5).toString());
        }
        
        totalPurchase.setText(Float.toString(total));
        
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_all_branchActionPerformed

    private void searchDeliveryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDeliveryKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblDelivery.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblDelivery.setRowSorter(tr);
        try {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchDelivery.getText()));
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_searchDeliveryKeyReleased

    private void current_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_branchActionPerformed
       DeliveryModel dm = new DeliveryModel();
       ResultSet rs2 = null;
   
       //SHOW ONLY CURRENT DATE DELIVERIES
        if(current_branch.getSelectedItem().toString().compareTo("Cebu Branch")==0){
            rs2 = dm.currentDelivery2("1");
        }else{
            rs2 = dm.currentDelivery2("2");
        }
        tblCurrent.setModel(DbUtils.resultSetToTableModel(rs2)); 

        DefaultTableModel model = (DefaultTableModel) tblCurrent.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblCurrent.setRowSorter(tr);
        try {
           tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchCurrent.getText()));
        
           
        float current = 0;
        for (int i = 0; i < tblCurrent.getRowCount(); i++ ) {
            current = current + Float.parseFloat(tblCurrent.getValueAt(i, 5).toString());
        }
        totalCurrent.setText(Float.toString(current));

        
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_current_branchActionPerformed

    private void searchDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDeliveryActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Login l = new Login();
        l.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tab_currentDeliveriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_currentDeliveriesActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_tab_currentDeliveriesActionPerformed

    private void tab_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_allActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_tab_allActionPerformed

    private void tab_current2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_current2ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_tab_current2ActionPerformed

    private void tab_all2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_all2ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_tab_all2ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        AdminPage ap = new AdminPage (this.getName());
        ap.getLblUser().setText("Welcome "+this.getName());
        ap.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DeliveryForm df = new DeliveryForm (this.getName());
        df.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryPage().setVisible(true);
            }
        });
    }

    
    public JTable getTblDelivery(){  
        return tblDelivery;
    }
    
    public JTable getTblCurrent(){
        return tblCurrent;
    }
    
    public JLabel getLblUser() {
        return lblUser;
    }
    
    public JLabel getTotalPurchase(){
        return totalPurchase;
    }
    
    public JLabel getTotalCurrent(){
        return totalCurrent;
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDelivery;
    private javax.swing.JComboBox<String> all_branch;
    private javax.swing.JPanel all_tab;
    private javax.swing.JLabel background_allDeliveries;
    private javax.swing.JLabel background_current;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> current_branch;
    private javax.swing.JPanel current_tab;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField searchCurrent;
    private javax.swing.JTextField searchDelivery;
    private javax.swing.JButton tab_all;
    private javax.swing.JButton tab_all2;
    private javax.swing.JButton tab_current2;
    private javax.swing.JButton tab_currentDeliveries;
    private javax.swing.JTable tblCurrent;
    private javax.swing.JTable tblDelivery;
    private javax.swing.JLabel totalCurrent;
    private javax.swing.JLabel totalPurchase;
    // End of variables declaration//GEN-END:variables
}
