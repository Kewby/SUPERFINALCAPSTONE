/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

//import function.Temp;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ProductModel;

/**
 *
 * @author Allysha, Kirby
 */
public class ProductPageController {
     
     public void deleteProduct(String prodId) {
         ProductModel pm = new ProductModel();
         
         pm.setProduct_code(prodId);
         
         if (pm.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
     }
      
}
    
    
    

