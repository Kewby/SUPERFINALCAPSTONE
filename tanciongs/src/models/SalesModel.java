/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allysha
 */
public class SalesModel extends MyModel {
    
    private int sales_id; 
    private int employee_id;
    private float changefund;
    private float total_sales;
    
    static int transaction_id;
    private float transaction_grandtotal;
    private float transaction_tender;
    private float transaction_change;
    
    private int transactionItem_id;
    private int product_id;
    private int transactionItem_qty;
    private float transactionItem_unitprice;
    private float transactionItem_subtotal;
    
    public int checkDate(){ //calculates the total sales for the day
      Statement st;
      int ret = 0;
      ResultSet rs = null;
      this.initialize();
        
       String str = "SELECT COUNT(*) AS total FROM `sales` WHERE DATE_FORMAT(sales_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') ";
      System.out.println(str);
      try{
           st = conn.createStatement();     
           rs = st.executeQuery(str);
           while(rs.next()){
               ret = rs.getInt("total");
           }
      }catch(SQLException ex){
          
      }
      
      System.out.println(ret);
      return ret;
    }
    
    public int checkDateAndFund(int id){ //checks if the changefund was inputted for the day
      Statement st;
      int ret = 0;
      ResultSet rs = null;
      this.initialize();
        
       String str = "SELECT COUNT(*) AS total FROM `sales` WHERE DATE_FORMAT(sales_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d')"
               + "AND changefund=0 AND employee_id='"+id+"'";
      System.out.println(str);
      try{
           st = conn.createStatement();     
           rs = st.executeQuery(str);
           while(rs.next()){
               ret = rs.getInt("total");
           }
      }catch(SQLException ex){
          
      }
      
      System.out.println(ret);
      return ret;
    }
    public int addChangefund(){ //asks for the start of the  day
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `sales` (`sales_id`, `sales_datetime`,`employee_id` ,`changefund`) VALUES (NULL, CURRENT_TIMESTAMP,'"+this.employee_id+"',  '"+this.changefund+"')";      
        //WHERE sales.employee_id = employee.employee_id
        
        System.out.println(str);
        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int cartName(String product){ //determine the name of the inputted product code. Displays the name of the product
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT product_name FROM `product` WHERE product_code = '"
                +product+"' limit 1";
        
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
    
    
    public int addToCart (){ //inserts all the data from the table to the transactionitem table
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `transactionitem` (`transactionItem_id` , `transaction_id` , `product_id` , `transactionItem_qty`, `transactionItem_unitprice`, `transactionItem_subtotal`) VALUES ( NULL, '"+this.transaction_id+"', '"+this.product_id+"', '"+this.transactionItem_qty+"', '"+this.transactionItem_unitprice+"', '"+this.transactionItem_subtotal+"')";
        System.out.println(str);
        try{
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
 
    
    public int addTotalSales(int id,float totalSales){ //adds the total sales of the employee for the day every time the employee will log out
         Statement st;
        ResultSet rs = null;
        int ret = 0,count;
        this.initialize();
        count = checkDateAndFund(id);
        if(count==0){
            String str = "INSERT INTO `sales` (`sales_id`, `sales_datetime`,`employee_id` ,`total_sales`) VALUES (NULL, CURRENT_TIMESTAMP,'"+id+"',  '"+totalSales+"')";
             try{
                st = conn.createStatement();
                ret = st.executeUpdate(str);
            } catch (SQLException ex){
                Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            String str = "UPDATE `sales` SET `total_sales` = '"+totalSales+"' WHERE employee_id='"+id+"'AND "
                    + "DATE_FORMAT(sales_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d')";
            
            try{
                st = conn.createStatement();
                ret = st.executeUpdate(str);
            } catch (SQLException ex){
                Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
        return ret;
    }
    public int addTransaction(){ //adds the data from the receive payment to the transaction table
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `transaction` (`transaction_id`, transaction_datetime`, `employee_id`, `transaction_grandtotal`, `transaction_tender`, `transaction_change`) VALUES (NULL, CURRENT_TIMESTAMP, '"+this.employee_id+"', '"+this.transaction_grandtotal+"', '"+this.transaction_tender+"', '"+transaction_change+"')";
        
        System.out.println(str);
        try{
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex){
            Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int getSales_id(){
        return sales_id;
    }
    
    public void setSales_id(int sales_id){
        this.sales_id = sales_id;
    }
    
    public int getEmployee_id(){
        return employee_id;
    }
    
    public void setEmployee_id(int employee_id){
        this.employee_id = employee_id;
    }
    
    public float getChangefund(){
        return changefund;
    }
    
    
    public void setChangefund(float changefund){
        this.changefund = changefund;
    }
    
    public float getTotal_sales(){
        return total_sales;
    }
    
    public void setTotal_sales(float total_sales){
        this.total_sales = total_sales;
    }
    
    /*
    static int getTransaction_id(){
        return transaction_id;
    }
    
    static void setTransaction_id(int transaction_id){
        this.transaction_id = transaction_id;
    }
    */
    
    public float getTransaction_total(){
        return transaction_grandtotal;
    }
    
    public void setTransaction_total(float transaction_grandtotal){
        this.transaction_grandtotal = transaction_grandtotal;
    }
    
    public float getTransaction_tender(){
        return transaction_tender;
    }
    
    public void setTransaction_tender(float transaction_tender){
        this.transaction_tender = transaction_tender;
    }
    
    public float getTransaction_change(){
        return transaction_change;
    }
    
    public void setTransaction_change(float transaction_change){
        this.transaction_change = transaction_change;
    }
    
    
    public int getTransactionItem_id(){
       return transactionItem_id;
    }
    
    public void setTransactionItem_id(int transactionItem_id){
        this.transactionItem_qty = transactionItem_id;
    }
    
    public int getProduct_code(){
        return product_id;
    }
    
    public void setProduct_code(int product_id){
        this.product_id = product_id;
    }
    
    public int getTransactionItem_qty(){
        return transactionItem_qty;
    }
    
    public void setTransactionItem_qty(int transactionItem_qty){
        this.transactionItem_qty = transactionItem_qty;
    }
    
    public float getTransactionItem_unitprice(){
        return transactionItem_unitprice;
    }
    
    public void setTransactionItem_unitprice(float transactionItem_unitprice){
        this.transactionItem_unitprice = transactionItem_unitprice;
    }
    
    public float getTransactionItem_subtotal(){
        return transactionItem_subtotal;
    }
    
    public void setTransactionItem_subtotal(float transactionItem_subtotal){
        this.transactionItem_subtotal = transactionItem_subtotal;
    }
    

    
}
