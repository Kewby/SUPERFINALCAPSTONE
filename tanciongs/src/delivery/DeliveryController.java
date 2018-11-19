/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.BranchModel;
import models.DeliveryModel;
import models.EmployeeModel;
import models.SupplierModel;
import productpage.ProductPageController;
import delivery.DeliveryPage;
import models.StockModel;


/**
 *
 * @author Allysha
 */
public class DeliveryController {
    
    public void clear(DeliveryForm df) { //clear the jtextfields from the delivery form
        df.getTxtProductCode().setText("");
        df.getTxtUnitPrice().setText("");
        df.getTxtNumberUnits().setText("");
        df.getTxtUnitMeasure().setText("");
        df.getcomboSupplier().setSelectedIndex(0);
        df.getTxtEmployee().setText("");
    }
    
    public void addForm(DeliveryForm df) { //submits to the query to the database: delivery table
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        
        DeliveryModel dm = new DeliveryModel();
        
        dm.setProduct_code(dm.determineProduct(df.getTxtProductCode().getText()));
        System.out.println("Product ID: "+dm.getProduct_code());
        
        dm.setDelivery_unitprice(Float.parseFloat(df.getTxtUnitPrice().getText().trim()));
        dm.setDelivery_numberofunits(Integer.parseInt(df.getTxtNumberUnits().getText().trim()));
        dm.setDelivery_unitofmeasure(df.getTxtUnitMeasure().getText().trim());
        
        dm.setSupplier_name(dm.determineSupplier(df.getcomboSupplier().getSelectedItem().toString()));
        System.out.println("Supplier ID: "+dm.getSupplier_name());
        
        //dm.setEmployee_id(dm.determineEmployee(df.getcomboEmployee().getSelectedItem().toString()));
        dm.setUsername(dm.determineEmployee(df.getTxtEmployee().getText().trim()));
        System.out.println("Employee ID: "+dm.getUsername());
        
        dm.setBranch_id(Integer.parseInt(dm.determineBranch(df.getName())));
        
        
        if (dm.addForm() >= 1) {
            JOptionPane.showMessageDialog(null, "Delivery Accepted!");
            df.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
          
    }
    
    public void updateStock(DeliveryForm df){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        
        DeliveryModel dm = new DeliveryModel();
        StockModel sm = new StockModel();
        
        int product = dm.determineProduct(df.getTxtProductCode().getText());
        int itemsdelivered = Integer.parseInt(df.getTxtNumberUnits().getText().trim());
        int stock = sm.determineStockID(product);
        
        System.out.println("SELECTED Product:"+product);
        System.out.println("Items Delivered:"+itemsdelivered);
        System.out.println("StockID is:"+stock);
        
        
       if (dm.updateStock(product, itemsdelivered, stock)>= 1) {
            JOptionPane.showMessageDialog(null, "Stock updated!");
            df.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
        
    public void addStock(DeliveryForm df){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        
        DeliveryModel dm = new DeliveryModel();
        StockModel stm = new StockModel();
        
        int product = dm.determineProduct(df.getTxtProductCode().getText());
        int itemsdelivered = Integer.parseInt(df.getTxtNumberUnits().getText().trim());
        int branch = Integer.parseInt(dm.determineBranch(df.getName()));
        int prodStock = stm.determineProdStock(dm.determineProduct(df.getTxtProductCode().getText()));
        
        System.out.println("ADD SELECTED Product:"+product);
        System.out.println("ADD Items Delivered:"+itemsdelivered);
        System.out.println("ADD Branch ID:"+branch);        
        System.out.println("ADD ProdStock:"+prodStock);        
        
       if (dm.addStock(product, itemsdelivered, branch)>= 1) {
            JOptionPane.showMessageDialog(null, "Stock Added!");
            df.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
    
    public ResultSet getSupplier(){
        SupplierModel sm = new SupplierModel();
        return sm.getSupplier();
    }
   
    
    
}
