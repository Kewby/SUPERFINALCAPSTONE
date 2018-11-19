/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import models.RoleModel;
/**
 *
 * @author Client
 */
public class UpdateEmpController {
    public void clear(UpdateEmp uec){
        uec.getTxtFirstname().setText("");
        uec.getTxtLastname().setText("");
        uec.getTxtUsername().setText("");
        uec.getTxtPassword().setText("");
        uec.getTxtConfirm().setText("");
        uec.getTxtEmail().setText("");
        uec.getTxtContactNumber().setText("");
        uec.getTxtAddress().setText("");
        uec.getComboRole().setSelectedIndex(0);
    }
    
    public void update(UpdateEmp ue){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
                
        EmployeeModel em = new EmployeeModel();
        
        em.setEmployee_firstname(ue.getTxtFirstname().getText().trim());
        em.setEmployee_lastname(ue.getTxtLastname().getText().trim());
        em.setUsername(ue.getTxtUsername().getText().trim());
        em.setPassword(ue.getTxtPassword().getText().trim());
        em.setEmployee_email(ue.getTxtEmail().getText().trim());
        em.setEmployee_contactnumber(ue.getTxtContactNumber().getText().trim());
        em.setEmployee_address(ue.getTxtAddress().getText().trim());
        
        //role = (uec.getComboRole().getSelectedItem().toString().compareToIgnoreCase("CASHIER")==0)?1:0;
        //em.isAdmin(role);
        
        em.setEmployee_id(ue.getEmpId());
        
        em.setIsAdmin(em.determineRole(ue.getComboRole().getSelectedItem().toString()));
        
        if (em.update() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            ue.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
        
        
    }
    
    public ResultSet getRole() {
        RoleModel rm = new RoleModel();
        return rm.getRole();
    }
    
}
