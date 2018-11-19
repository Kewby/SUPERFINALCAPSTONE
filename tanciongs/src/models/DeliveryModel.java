/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Allysha
 */
public class DeliveryModel extends MyModel{ 
    private int delivery_id;    
    private int product_id;
    private float delivery_unitprice;
    private int delivery_numberofunits;
    private String delivery_unitofmeasure;
    private float delivery_totalcostamount;
    private int supplier_id;
    private int branch_id;
    private int employee_id;
    private int deleteStatus;
    private int stock_id;
    
   
    public ResultSet showDelivery () { //Views all the deliveries, both cebu/leyte
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT DATE_FORMAT(delivery_datetime, '%y-%m-%d') AS 'Date Delivery' ,"
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' ,"
                + "delivery_unitprice AS 'Unit Price' ,"
                + "delivery_numberofunits AS 'No of Units' ,"
                + "delivery_unitofmeasure AS 'Unit of Measure' ,"
                + "delivery_totalcostamount AS 'Total Purchase',"
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Supplier' ,"
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' ,"
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Employee' FROM `delivery` WHERE branch_id=1 AND isAdmin=0 AND deleteStatus=0 ORDER BY delivery_datetime DESC";
                
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
            return rs;
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet showDelivery2 (String id) { //current display in the delivery table, because of branch_id
        Statement st;
        ResultSet rs = null;
        this.initialize(); //initialize db
        
        String str = "SELECT DATE_FORMAT(delivery_datetime, '%y-%m-%d') AS 'Date Delivery' ,"
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' ,"
                + "delivery_unitprice AS 'Unit Price' ,"
                + "delivery_numberofunits AS 'No of Units' ,"
                + "delivery_unitofmeasure AS 'Unit of Measure' ,"
                + "delivery_totalcostamount AS 'Total Purchase',"
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Supplier' ,"
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' ,"
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Employee' FROM `delivery` WHERE branch_id="+id+" AND deleteStatus=0 ORDER BY delivery_datetime DESC";
                
        try {
            st = conn.createStatement();
            rs = st.executeQuery(str);
            System.out.println("OK: showdelivery2");
            
            return rs;
            
        } catch (SQLException ex) {}
        return rs;
    }
    
    public ResultSet currentDelivery () { //DISPLAYS CURRENT DATE DELIVERIES
        Statement st;
        int ret = 0;
        ResultSet rs = null;
        this.initialize();
        
        String str = "SELECT delivery_datetime AS 'Date Delivery' , "
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' , "
                + "delivery_unitprice AS 'Unit Price' , "
                + "delivery_numberofunits AS 'Number of Units' , "
                + "delivery_unitofmeasure AS 'Unit of Measure' , "
                + "delivery_totalcostamount AS 'Total Cost' ,  "
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Suppler' , "
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' , "
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Received by' "
                + "FROM `delivery` WHERE DATE_FORMAT(delivery_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') AND deleteStatus = 0";
      
      
      try {
            st = conn.createStatement();
            rs = st.executeQuery(str);
            System.out.println(rs);
            
            return rs;
            
        } catch (SQLException ex) {}
        return rs;

    }
    
     public ResultSet currentDelivery2 (String id) { //current display in the CURRENT DATE delivery table, because of branch_id
        Statement st;
        ResultSet rs = null;
        this.initialize(); //initialize db
        
       String str = "SELECT delivery_datetime AS 'Date Delivery' , "
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' , "
                + "delivery_unitprice AS 'Unit Price' , "
                + "delivery_numberofunits AS 'Number of Units' , "
                + "delivery_unitofmeasure AS 'Unit of Measure' , "
                + "delivery_totalcostamount AS 'Total Cost' ,  "
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Suppler' , "
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' , "
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Received by' "
                + "FROM `delivery` WHERE DATE_FORMAT(delivery_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') AND WHERE branch_id="+id+" AND deleteStatus = 0";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(str);
            System.out.println("OK: currentDelivery2");
            
            return rs;
            
        } catch (SQLException ex) {}
        return rs;
    }
    
    
    public String determineBranch (String username){ //determines which branch is the username from, cebu or leyte branch. COMBOBRANCH
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize();
        
        String str = "SELECT branch_id FROM `employee` WHERE username = '"
                +username+"' limit 1";
        System.out.println("OK delivery determinebranch");
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK delivery determinebranch");
         //   ret = Integer.parseInt(rs.getString(1));
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int addForm(){ //ADD DELIVERY FORM: query to add the deliveries to the database
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `delivery` (`delivery_id`, `delivery_datetime`, `product_id`, `delivery_unitprice`, `delivery_numberofunits`, `delivery_unitofmeasure`, `supplier_id`, `branch_id`, `employee_id`, `deleteStatus`) VALUES (NULL, CURRENT_TIMESTAMP , '"
                +this.product_id+"', '"+this.delivery_unitprice+"', '"
                +this.delivery_numberofunits+"', '"+this.delivery_unitofmeasure+"', '"
                +this.supplier_id+"', '"+this.branch_id+"', '"
                +this.employee_id+"' ,0)";
                
        System.out.println(str);
        try{
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            System.out.println(branch_id);
            System.out.println("OK: add delivery");
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int determineSupplier (String supplier) { //ADD DELIVERY FORM: shows a dropdown on the form to choose the supplier.
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `supplier_id` FROM supplier WHERE supplier_name = '"
                +supplier+"' limit 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK: delivery determinesupplier");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    
//    public int determineEmployee (String employee){ //choose who received the deliveries. add delivery form DROPDOWN
//        Statement st;
//        ResultSet rs = null;
//        int ret = 0;
//        this.initialize();
//        
//        String str = "SELECT branch_id FROM `employee` WHERE branch_id = '"+employee+"' AND WHERE limit 1";
//       // String str = "SELECT branch_id FROM `employee` WHERE branch_id = 1";
//        System.out.println(str);
//        
//        try {
//            st = conn.createStatement();     
//            rs = st.executeQuery(str);
//            
//            //retrive the value from the first return row.
//            rs.next();
//            System.out.println("OK: deletermine employee ");
//            ret = Integer.parseInt(rs.getString(1));
//        } catch (SQLException ex) {}
//        return ret;
//    }
    
//    public int determineEmployee (String employee){ //ADD DELIVERY FORM: choose who received the deliveries.
//        Statement st;
//        ResultSet rs = null;
//        int ret = 0;
//        this.initialize();
//        
//      //  String str = "SELECT branch_id FROM `employee` WHERE branch_id = '"+employee+"' AND WHERE limit 1";
//        //String str = "SELECT username, (SELECT branch.branch_id FROM `branch` WHERE employee.branch_id = branch.branch_id) FROM employee WHERE branch_id ="+id+" ";
//        String str = "SELECT `employee_id` FROM employee WHERE username = '"
//                +employee+"' AND WHERE limit 1";
//        System.out.println(str);
//        
//        try {
//            st = conn.createStatement();     
//            rs = st.executeQuery(str);
//            
//            //retrive the value from the first return row.
//            rs.next();
//            System.out.println("OK: determineemployee");
//            ret = Integer.parseInt(rs.getString(1));
//        } catch (SQLException ex) {}
//        return ret;
//    }
    
    public int determineProduct (String product){ //receiver will input the product code on the add delivery form. INPUT PRODUCT CODE, DB WILL READ AS PRODUCT ID
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT product_id FROM `product` WHERE product_code = '"
                +product+"' limit 1";
        
        //System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK: DELIVERY determineproduct");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int determineEmployee (String username) { //DELIVERIES WILL BE RECEIVED BY THE SAID USERNAME. INPUT USERNAME, DB WILL READ AS EMPLOYEE ID.
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        //LACKING: IF USERNAME IS NOT FOUND FROM ASSIGNED BRANCH, IT WILL NOT CONTINUE
        String str = "SELECT employee_id FROM `employee` WHERE username = '"
                +username+"' limit 1";
        System.out.println(str);
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(str);
            
            rs.next();
            System.out.println("OK: DELIVERY determine employee");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    
     public int updateStock (int product, int itemsdelivered, int stock){ //receiver will input the product code on the add delivery form. INPUT PRODUCT CODE, DB WILL READ AS PRODUCT ID
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "UPDATE `stock` JOIN `delivery` SET stock_onhand = stock.stock_onhand + '"+itemsdelivered+"' WHERE DATE_FORMAT(delivery_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') AND stock.product_id = '"+product+"' AND stock.stock_id = '"+stock+"'";
        
        System.out.println("The itemsdelivered is:" + itemsdelivered);
        System.out.println("Product ID is:" + product);
        System.out.println("Values:" + str);
        
        try {
            st = conn.createStatement();     
            ret = st.executeUpdate(str);
            System.out.println("OK: update stock");
        } catch (SQLException ex){
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
     
    public int addStock(int product, int itemsdelivered, int branch){ //If the product doesn't have a registered stock, it will add.
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `stock` (`stock_id`, `stock_onhand`, `product_id`, `branch_id`, `deleteStatus`) VALUES (NULL, '"+itemsdelivered+"','"+product+"', '"+branch+"', 0)";
                
        System.out.println(str);
        try{
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            System.out.println("NEW STOCK ADDED");
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    
    //Getters and Setters
    public int getStock_id(){
        return product_id;
    }
    
    public void setStock_id(int product_id){
        this.product_id = product_id;
    }
    
    public int getDelivery_id(){
        return delivery_id;
    }
    
    public void setDelivery_id(int delivery_id){
        this.delivery_id = delivery_id;
    }
    
    public int getProduct_code(){
        return product_id;
    }
    
    public void setProduct_code(int product_id){
        this.product_id = product_id;
    }
    
    public int getUsername(){
        return employee_id;
    }
    
    public void setUsername(int employee_id){
        this.employee_id = employee_id;
    }
    
    public float getDelivery_unitprice(){
        return delivery_unitprice;
    }
    
    public void setDelivery_unitprice(float delivery_unitprice){
        this.delivery_unitprice = delivery_unitprice;
    }
    
    public int getDelivery_numberofunits(){
        return delivery_numberofunits;
    }
    
    public void setDelivery_numberofunits(int delivery_numberofunits){
        this.delivery_numberofunits = delivery_numberofunits;
    }
    
    public String getDelivery_unitofmeasure(){
        return delivery_unitofmeasure;
    }
    
    public void setDelivery_unitofmeasure(String delivery_unitofmeasure){
        this.delivery_unitofmeasure = delivery_unitofmeasure;
    }
    
    public int getSupplier_name(){
        return supplier_id;
    }
    
    public void setSupplier_name(int supplier_id){
        this.supplier_id = supplier_id;
    }
    
    public int getBranch_id(){
        return branch_id;
    }
    
    public void setBranch_id(int product_id){
        this.branch_id = product_id;
    }
    
    public float getDelivery_totalcostamount(){
        return delivery_totalcostamount;
    }
    
    public void setDelivery_totalcostamount(float delivery_totalcostamount){
        this.delivery_totalcostamount = delivery_totalcostamount;
    }

   

    
    
}
