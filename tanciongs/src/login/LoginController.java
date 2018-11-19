/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import adminpage.AdminPage;
import cashierpage.CashierPage;
import cashierpage.ChangeFund;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import models.SalesModel;

/**
 *
 * @author Allysha
 */
public class LoginController {
    
    public void login (Login l) {
        EmployeeModel em = new EmployeeModel(); //links the employeemodel
        SalesModel sm = new SalesModel();
        em.setUsername(l.getInputUsername().getText().trim()); //assigns the setter to the jtextfield from the login
        em.setPassword(l.getInputPassword().getText().trim()); //assigns the setter to the jtextfield from the login
        
        ResultSet rs = em.login(); //calls from the employeemodel
        
        try {
            if (rs.next()) { //displays the username of the admin from cebu/leyte
                if (rs.getString("isAdmin").equals("1")) {
                    
                    AdminPage ap = new AdminPage(rs.getString("username"),rs.getInt("employee_id")); //if isAdmin = 1, directs to the adminpage
                    
                    
                    ap.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                   if (JOptionPane.showConfirmDialog(ap, 
            "Are you sure to close this window?", "(This would be the same as Logging out.)", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                ap.logout();
            System.exit(0);
        }
            }
        });
                    ap.getLblUser().setText("Welcome "+rs.getString("username")); //lblUser is from the adminpage. It can only login using the username from the employee table(database)
                    ap.setVisible(true);
  
                } else {
                    if(sm.checkDate() >= 1){
                        CashierPage cp = new CashierPage(rs.getString("username"),rs.getInt("employee_id"),rs.getInt("isAdmin"));
                        cp.getLblUser().setText("Welcome "+rs.getString("username"));
                        cp.setVisible(true);
                        cp.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        
                    }else{
                    //displays the username of the cashier from cebu/leyte
                    ChangeFund cf = new ChangeFund(rs.getString("username"),rs.getInt("employee_id"),rs.getInt("isAdmin")); //if isAdmin = 0, directs to the changefund 
                    cf.getLblUser().setText("Welcome "+rs.getString("username")); //lblUser is from the changefund. It can only login using the username from the employee table(database)
                    cf.setVisible(true);
                    //cf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    }
                }
                
                l.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "User or Password doesn't exist!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
