/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.CategoryModel;
import models.ProductModel;

/**
 *
 * @author
 */
public class UpdateProductController {

    public void clear(UpdateProduct updc) {
        updc.getTxtItemCode().setText("");
        updc.getTxtProductName().setText("");
        updc.getcomboCategory().setSelectedIndex(0);
        updc.getcomboProductType().setSelectedIndex(0);
        updc.getTxtStandardCost().setText("");
        updc.getTxtMarkupCost().setText("");
        updc.getTxtItemCode().requestFocus();
    }

    public void update(UpdateProduct updc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        int productType  = 0;
        ProductModel pm = new ProductModel();
        
        pm.setProduct_code(updc.getTxtItemCode().getText().trim());
        pm.setProduct_name(updc.getTxtProductName().getText().trim());
        pm.setProduct_category(pm.determineCategory(updc.getcomboProductType().getSelectedItem().toString()));
        System.out.print("Category ID: "+pm.getProduct_category());
        
        productType = (updc.getcomboProductType().getSelectedItem().toString().compareToIgnoreCase("AGRICULTURE")==0)?1:0;
        pm.setProduct_type(productType);
        
        pm.setStandard_cost(Float.parseFloat(updc.getTxtStandardCost().getText().trim()));
        pm.setMarkup_cost(Float.parseFloat(updc.getTxtMarkupCost().getText().trim()));
        pm.setBranch_id(Integer.parseInt(pm.determineBranch(updc.getName()))); //determines which branch the product will be added

        if (pm.update() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            updc.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
    
    public ResultSet getCategories() {
        CategoryModel cm = new CategoryModel();
        return cm.getCategory();
    }
}
