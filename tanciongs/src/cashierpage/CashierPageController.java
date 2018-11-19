/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashierpage;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import models.SalesModel;

/**
 *
 * @author Allysha
 */
public class CashierPageController {
    
    public void addChangefund (ChangeFund cf){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyd-MM-dd");
        SalesModel salesm = new SalesModel();
        
        salesm.setChangefund(Float.parseFloat(cf.getTxtChangefund().getText().trim()));
        salesm.setEmployee_id(cf.getId());
       
        if (salesm.addChangefund() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added Start of the Day!");
            cf.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }

    
    

    
    
    
    
               

}

