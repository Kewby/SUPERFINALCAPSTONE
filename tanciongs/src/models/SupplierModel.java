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

/**
 *
 * @author 
 */
public class SupplierModel extends MyModel {
    
    private int supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_email;
    private String supplier_contactnumber;
    private String supplier_contactperson;
    private int deleteStatus;

    
    public int delete () {
        Statement st;
        int ret = 0;
        this.initialize();
        String str = "UPDATE `supplier` SET deleteStatus = 1 WHERE supplier_id = '"+this.supplier_id+"'";
        System.out.println("Supplier ID:" + str);
        
        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ret;
    }
    
    public int update(){
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
         String str = "UPDATE `supplier` SET `supplier_name`= '"+this.supplier_name+"', "
                + " `supplier_address` = '"+this.supplier_address+"', "
                + " `supplier_email` = '"+this.supplier_email+"', "
                + " `supplier_contactnumber` = '"+this.supplier_contactnumber+"', "
                + " `supplier_contactperson` = '"+this.supplier_contactperson+"',"
                + " `deleteStatus` = '"+this.deleteStatus+"' "
                + "WHERE `supplier_id` = '"+this.supplier_id+"'";
         
         System.out.println(str);
        
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public ResultSet viewAll () {
        Statement st;
//        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT supplier_id as 'Supplier ID', supplier_name as 'Company Name', supplier_address as 'Address', supplier_email as 'Email', supplier_contactnumber as 'Contact No', supplier_contactperson as 'Contact Person' FROM supplier where deleteStatus=0"; //all not admin user
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            return rs;
//            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet login () {
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT * FROM `employee` where username = '"+this.username+"' and password = '"+this.password+"' limit 1";
        
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int add () {
        Statement st;
        int ret = 0;
        this.initialize();
        String str = "INSERT into `supplier` (`supplier_id`, `supplier_name`,`supplier_address`, `supplier_email`,`supplier_contactnumber`,`supplier_contactperson`, `deleteStatus`) VALUES(null, '"+this.supplier_name+"', '"+this.supplier_address+"', '"+this.supplier_email+"','"+this.supplier_contactnumber+"', '"+this.supplier_contactperson+"', 0)";

        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
        }
        
        return ret;
    }
    
    //DELIVERY FORM
    public ResultSet getSupplier(){ //DELIVERY FORM
        Statement st;
        ResultSet ret = null;
        this.initialize();
        
        String str = "SELECT supplier_name FROM supplier";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
   
    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return supplier_address;
    }
    
    public void setSupplier_address(String supplier_address){
        this.supplier_address = supplier_address;
    }
    
    public String getSupplier_email(){
        return supplier_email;
    }
    
    public void setSupplier_email(String supplier_email){
        this.supplier_email = supplier_email;    
    }
    
    public String getSupplier_contactnumber() {
        return supplier_contactnumber;
    }

    public void setSupplier_contactnumber(String supplier_contactnumber) {
        this.supplier_contactnumber = supplier_contactnumber;
    }
    
    public String getSupplier_contactperson() {
        return supplier_contactperson;
    }

    public void setSupplier_contactperson(String supplier_contactperson) {
        this.supplier_contactperson = supplier_contactperson;
    }
    
    public int getDeletestatus (){
        return deleteStatus;
    }
    
    public void setDeletestatus(int deleteStatus){
        this.deleteStatus = deleteStatus;
    }

    
}
