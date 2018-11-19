/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import cashierpage.ReceivePaymentController.TransItem;
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
public class TransactionModel extends MyModel {
    
    
    JFrame frame = new JFrame();
    
    
    ///////PRINT RECEIPT CODE HERE:
    public int addToTransaction(float tender, float change, int id, float total){ //inputs the data from the receive payment form to the transaction table
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `transaction`(`transaction_datetime`,"
                + "`transaction_tender`,"
                + "`transaction_change`,"
                + "`employee_id`,"
                + "`transaction_grandtotal`)VALUES(CURRENT_TIMESTAMP,'"+tender+"','"+change+"',"
                + "'"+id+"','"+total+"')";
         try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            if(ret>0){
                JOptionPane.showMessageDialog(frame,"Purchase Succeeded."); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    ///////PRINT RECEIPT CODE HERE:
    
    public int getLastRowId(){ 
         Statement st;
        int ret  = 0;
        this.initialize();
        
        String str = "SELECT * FROM `transaction`";
        try{
         st = conn.createStatement();
         ResultSet rs = st.executeQuery(str);
         rs.last();
         ret = rs.getInt("transaction_id");
         System.out.println("This is transaction id");
        }catch(Exception e){
            
        }
        return ret;
    }
       public float computeTotalSales(int id){ //computes the total sales of the employee
        Statement st;
        ResultSet rs = null;
        float ret = 0;
        this.initialize();
        
        String str = "SELECT `transaction_grandtotal` FROM `transaction` WHERE employee_id= '"+id+"'"
                + " AND DATE_FORMAT(transaction_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') ";
         try{
         st = conn.createStatement();
             rs = st.executeQuery(str);
         while(rs.next()){
             ret += rs.getFloat("transaction_grandtotal");
         }
        
        }catch(Exception e){
            
        }
        
        return ret;
    }
    public void addItem(TransItem trans){ //inputs the data from the table to the transactionitem table after purchasing
        Statement st;
        int ret  = 0;
        this.initialize();
        
        String str = "INSERT INTO `transactionitem`(`transaction_id`,`product_id`,"
                + "`transactionItem_qty`,`transactionItem_unitprice`)"
                + "VALUES('"+trans.getTransId()+"','"+trans.getProdId()+"','"+trans.getTransQty()+"',"
                + "'"+trans.getuPrice()+"')";
        
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
