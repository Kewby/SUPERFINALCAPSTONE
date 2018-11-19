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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Allysha
 */
public class EmployeeModel extends MyModel {
    
    public int employee_id;
    private String employee_firstname;
    private String employee_lastname;
    private String username;
    private String password;
    private String employee_email;
    private String employee_contactnumber;
    private String employee_address;
    private int branch_id;
    private int isAdmin;
    private int deleteStatus;
    
    public ResultSet login () { //checks from the database if the username and password inputted from the login is found
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
    
    public ResultSet viewAll () { //displays only all the employees from cebu branch. Admin/s from cebu are not shown
        Statement st;
        this.initialize(); //initialize db
        
        String str = "SELECT employee_id AS 'Employee ID Number', employee_firstname AS 'First Name', employee_lastname AS 'Last Name', username AS 'Username', employee_email AS 'E-mail', employee_contactnumber AS 'Contact Number', employee_address AS 'Address', "
                + "(CASE WHEN isAdmin = '0' THEN 'Cashier' ELSE 'Admin' END) AS Role FROM employee WHERE branch_id=1 AND isAdmin=0 AND deleteStatus=0";
        //branch_id = 1 is cebu, branch_id = 2 is leyte
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
         
            return rs;
            
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet viewLeyte (String id) {
        Statement st;
        this.initialize(); //initialize db
        
        String str = "SELECT employee_id AS 'Employee ID Number',employee_firstname AS 'First Name', employee_lastname AS 'Last Name', username AS 'Username', employee_email AS 'E-mail', employee_contactnumber AS 'Contact Number', employee_address AS 'Address', "
                + "(CASE WHEN isAdmin = '0' THEN 'Cashier' ELSE 'Admin' END) AS Role FROM employee WHERE branch_id="+id+" AND isAdmin=0 AND deleteStatus=0"; //all not admin emp 
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            return rs;
            
        } catch (SQLException ex) {}
        return null;
    }
    
    public int add () {
        Statement st;
        int ret = 0;
        this.initialize();
        String str = "INSERT into `employee` (`employee_id`, `employee_firstname`, `employee_lastname`, `username`, `password`, `employee_email`, `employee_contactnumber`, `employee_address`, `branch_id`, `isAdmin`, `deleteStatus`) values (null, '"+this.employee_firstname+"', '"+this.employee_lastname+"', '"+this.username+"','"+this.password+"', '"+this.employee_email+"', '"+this.employee_contactnumber+"', '"+this.employee_address+"', '"+this.branch_id+"', '"+this.isAdmin+"', 0)";
        System.out.println(str); 
        
        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
        }
        
        return ret;
    }
    
    public int delete() {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "UPDATE employee SET deleteStatus = 1 WHERE employee_id = '"+this.employee_id+"'";
        
        System.out.println(str);
        try {
            st = conn.createStatement();
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
        
         String str = "UPDATE `employee` SET `employee_firstname`= '"+this.employee_firstname+"', "
                + " `employee_lastname` = '"+this.employee_lastname+"', "
                + " `username` = '"+this.username+"', "
                + " `password` = '"+this.password+"', "
                + " `employee_email` = '"+this.employee_email+"', "
                + " `employee_contactnumber` = '"+this.employee_contactnumber+"', "
                + " `employee_address` = '"+this.employee_address+"', "
                + " `isAdmin` = '"+this.isAdmin+"', "
                + " `deleteStatus` = '"+this.deleteStatus+"' "
                 + "WHERE `employee_id` = '"+this.employee_id+"'";
         
         System.out.println(str);
        
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public String determineBranch (String username) {
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize(); //initialize db
        
        String str = "select `branch_id` from employee where "
                + "username = '"
                +username+"' limit 1";
        
        try {
            
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }
    

    public int determineRole (String role) { //displays the category name instead of the category id
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "SELECT `role_id` FROM role WHERE role_name = '"
                +role+"' limit 1";
        
        System.out.println("Role is:"+role);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("Success");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    
//    public ResultSet getEmployee(){  //DELIVERY FORM
//        Statement st;
//        ResultSet ret = null;
//        this.initialize();
//        
//        String str = "SELECT username FROM `employee`";
//       
//        
//        try {
//            st = conn.createStatement();
//            ret = st.executeQuery(str);
//        } catch (SQLException ex) {}
//        return ret;
//    }
    
    public int determineEmployee (String employee){ //choose who received the deliveries. add delivery form DROPDOWN
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT branch_id FROM `employee` WHERE branch_id = '"+employee+"' AND WHERE limit 1";
       // String str = "SELECT branch_id FROM `employee` WHERE branch_id = 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK: deletermine employee ");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    
    

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
   
    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmployee_email(){
        return employee_email;
    }
    
    public void setEmployee_email(String employee_email){
        this.employee_email = employee_email;    
    }
    
    public String getEmployee_contactnumber() {
        return employee_contactnumber;
    }

    public void setEmployee_contactnumber(String employee_contactnumber) {
        this.employee_contactnumber = employee_contactnumber;
    }
    
    public String getEmployee_address(){
        return employee_address;
    }
    
    public void setEmployee_address(String employee_address){
        this.employee_address = employee_address;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public int getBranch_id () {
        return branch_id;
    }
    
    public void setBranch_id(int branch_id){
        this.branch_id = branch_id;
    }

    public void isAdmin(int role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet determineEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
