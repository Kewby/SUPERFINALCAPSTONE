/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.SupplierModel;


/**
 *
 * @author kirbp
 */
public class UpdateSupplierController {
    
    public void clear(UpdateSupplier usc){
        usc.getTxtSupplierName().setText("");
        usc.getTxtAddress().setText("");
        usc.getTxtEmail().setText("");
        usc.getTxtContactNumber().setText("");
        usc.getTxtContactPerson().setText("");
    }
    
    public void update(UpdateSupplier us){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");

        SupplierModel sm = new SupplierModel();
        
        sm.setSupplier_name(us.getTxtSupplierName().getText().trim());
        sm.setSupplier_address(us.getTxtAddress().getText().trim());
        sm.setSupplier_email(us.getTxtEmail().getText().trim());
        sm.setSupplier_contactnumber(us.getTxtContactNumber().getText().trim());
        sm.setSupplier_contactperson(us.getTxtContactPerson().getText().trim());        
        
        sm.setSupplier_id(us.getSupplierId());
        
        if (sm.update() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            us.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
        
        
    }
    
}
