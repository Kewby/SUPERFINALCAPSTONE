/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import models.SupplierModel;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Allysha
 */
public class PeoplePageController {
    
    public void deleteEmp(int empID){
        EmployeeModel em = new EmployeeModel();
         
        em.setEmployee_id(empID);
         
        if (em.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
    }
    
    public void deleteSupplier(int supplierID){
        SupplierModel sm = new SupplierModel();
         
        sm.setSupplier_id(supplierID);
         
        if (sm.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
    }
}
