/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import cashierpage.CashierPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Allysha, Kirby
 */
public class ProductModel extends MyModel{
    private int product_id;
    private String product_code;
    private String product_name;
    private int product_type;
    private int category_id; 
    private float standard_cost;
    private float markup_cost;
    private float list_price;
    private int branch_id;
    private int deleteStatus;
    JFrame frame = new JFrame();
    
    
    public ResultSet viewAll () { //displays all the data from database. Mixes the cebu products and leyte products
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT product_code AS 'Product Code', product_name AS 'Product Name', (SELECT category.category_name FROM category WHERE product.category_id = category.category_id) AS 'Product Category', "
                + "(CASE WHEN product_type = 'true' THEN 'Non-Agricultural' ELSE 'Agricultural' END) AS 'Product Type', `standard_cost` AS 'Standard Cost', `markup_cost` AS 'Markup Cost', `list_price` AS 'List Price' FROM `product` where deleteStatus = 0";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public ResultSet viewAll2 (String id) { //this is what displays on the current productpage table. Because of the branch_id. It only displays cebu products if it is logged in from cebu admin
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
    
        String str = "SELECT product_code AS 'Product Code', product_name AS 'Product Name', (SELECT category.category_name FROM `category` WHERE product.category_id = category.category_id) AS 'Product Category', "
                + "(CASE WHEN product_type = 'true' THEN 'Non-Agricultural' ELSE 'Agricultural' END) AS 'Product Type', `standard_cost` AS 'Standard Cost', `markup_cost` AS 'Markup Cost', list_price AS 'List Price' FROM `product` WHERE branch_id="+id+" AND deleteStatus = 0"; 
        //the query determines the products from which branch the admin is logged in
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            System.out.println("OK: viewall2");
            
            return rs;
            
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int add () { //admins can only add products into the database from the addproduct form. if cebu is logged in, the products will  automatically be added to the cebu products. admins cannot add products to a different branch, unless logged in as leyte admin
       Statement st;
       int ret = 0;
       this.initialize(); //initialize db
        
       String str = "INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `product_type`, `category_id`, `standard_cost`, `markup_cost`, `branch_id`, `deleteStatus`) VALUES (NULL, '"
                +this.product_code+"', '"+this.product_name+"', '"
                +this.product_type+"', '"+this.category_id+"', '"
                +this.standard_cost+"', '"+this.markup_cost+"','"+this.branch_id+"', 0)";
       //query does not need the list_price because once data is inserted into standard_cost and markup_code, the list_price automatically computes it in the database
      
        System.out.println(str);
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            System.out.println(branch_id);
            System.out.println("OK: addproduct");
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int update(){ //admins can only update products. the product code cannot be changed
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "UPDATE `product` SET `product_name` = '"+this.product_name+"',"
                + " `product_type` = '"+this.product_type+"',"
                + " `category_id` = '"+this.category_id+"',"
                + " `standard_cost` = '"+this.standard_cost+"',"
                + "`markup_cost` = '"+this.markup_cost+"' WHERE `product_code` = '"+this.product_code+"'"; 
         
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int delete () { //the product is only deleted from the system, but it still exist in the database. this is only a soft delete, not a permanent delete
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db delete product
        
        String str = "UPDATE product SET deleteStatus = 1 WHERE product_code = '"+this.product_code+"'"; 
        //only changes the deleteStatus of a product
        
        System.out.println(str);
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ret;
    }
    
    public String determineBranch (String username) { //determines which branch is the username from, cebu or leyte branch
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT branch_id FROM `employee` where username = '"
                +username+"' limit 1";
        System.out.println("OK: product determinebranch");
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int determineCategory (String category) { //displays the category name instead of the category id
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "SELECT `category_id` FROM category WHERE category_name = '"
                +category+"' limit 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("HELLO");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
 
    public ResultSet search(long id){ //cashier page input product code search bar
        Statement st;
        ResultSet ret = null;
        this.initialize();
        
        String str = "SELECT * FROM `product` WHERE product_code ="+id+" LIMIT 1";
        
        try{
        
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            if(rs.isBeforeFirst()){
                rs.next();
            }

            else if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(frame,"The Product Code does not exist.");
                
//                CashierPage cp =  new CashierPage();
//                cp.inputProductCode.setText("");
            }
            
            return rs;
           
        }catch(SQLException ex){
           
            return ret;
            
        }
    }
    
    //Getters and Setters
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
     public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    public int getProduct_type(){
        return product_type;
    }
    
    public void setProduct_type(int product_type){
        this.product_type = product_type;
    }
    
    public int getProduct_category() {
        return category_id;
    }

    public void setProduct_category(int category_id) {
        this.category_id = category_id;
    }
    
    public float getStandard_cost() {
        return standard_cost;
    }

    public void setStandard_cost(float standard_cost) {
        this.standard_cost = standard_cost;
    }
    
    public float getMarkup_cost() {
        return markup_cost;
    }

    public void setMarkup_cost(float markup_cost) {
        this.markup_cost = markup_cost;
    }
    
    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int product_id) {
        this.branch_id = product_id;
    }

    
}
