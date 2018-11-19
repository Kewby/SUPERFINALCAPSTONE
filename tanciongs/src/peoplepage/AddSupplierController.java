/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.SupplierModel;
import models.EmployeeModel;

/**
 *
 * @author
 */
public class AddSupplierController {
        
    public void clear (AddSupplier as) {
        as.getTxtSupplierName().setText("");
        as.getTxtEmail().setText("");
        as.getTxtContactNo().setText("");
        as.getTxtAddress().setText("");
        as.getTxtContactPerson().setText("");
    }
    
    public void add (AddSupplier as) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        SupplierModel sm = new SupplierModel();
        sm.setSupplier_name(as.getTxtSupplierName().getText().trim());
        sm.setSupplier_address(as.getTxtAddress().getText().trim());
        sm.setSupplier_email(as.getTxtEmail().getText().trim());
        sm.setSupplier_contactnumber(as.getTxtContactNo().getText().trim());
        sm.setSupplier_contactperson(as.getTxtContactPerson().getText().trim());
        
        
        
        if (sm.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            as.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
