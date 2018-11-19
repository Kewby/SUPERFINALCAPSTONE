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
 * @author Kirby
 */
public class StockModel extends MyModel {
    private int stock_id;
    private int stock_onhand;
    private int product_id;
    private int branch_id;
    private int deleteStatus;


public ResultSet viewStock(){
    Statement st;
    ResultSet ret = null;
    this.initialize();
    
    String str = "SELECT stock_id, (SELECT product.product_code FROM `product` WHERE stock.product_id = product.product_id) AS 'Product Code', (SELECT product.product_name FROM `product` WHERE stock.product_id = product.product_id) AS 'Product Name', stock_onhand, branch_id "
            + "FROM `stock`";
    try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
}

public ResultSet viewStock2(String id){
    Statement st;
    ResultSet ret = null;
    this.initialize();
    
    String str = "SELECT stock_id, (SELECT product.product_code FROM `product` WHERE stock.product_id = product.product_id) AS 'Product Code', (SELECT product.product_name FROM `product` WHERE stock.product_id = product.product_id) AS 'Product Name', stock_onhand, branch_id "
            + "FROM `stock`" 
            + "WHERE branch_id="+id+"" ;
    System.out.println("Success");

    try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            System.out.println("OK: viewStock2");
            
            return rs;
            
        } catch (SQLException ex) {}
        return ret;
}

public String determineBranch (String username) { //determines which branch is the username from, cebu or leyte branch
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT branch_id FROM `employee` where username = '"
                +username+"' limit 1";
        System.out.println("OK: stock determinebranch");
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }

    public int determineStockID (int productID) { 
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `stock_id` FROM `stock` WHERE product_id = '"
                +productID+"' limit 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK:  determinestockID");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int determineProdStock (int productID){ //receiver will input the product code on the add delivery form. INPUT PRODUCT CODE, DB WILL READ AS PRODUCT ID
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `product_id` FROM `stock` WHERE product_id = '"
                +productID+"' limit 1";
        
        //System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK: STOCK determineprodstock");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    

//Getters and Setters
    public int getStock_id(){
        return stock_id;
    }
    
    public void setStock_id(int stock_id){
        this.stock_id = stock_id;
    }
    
    public int getStock_onhand(){
        return stock_onhand;
    }
    
    public int setStock_onhand(int stock_onhand){
        return this.stock_onhand = stock_onhand;
    }
    
    public int getProduct_id(){
        return product_id;
    }
    
    public void setProduct_id(int product_id){
        this.product_id = product_id;
    }
    
    public int getProduct_code(){
        return product_id;
    }
    
    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int stock_id) {
        this.branch_id = stock_id;
    }


}