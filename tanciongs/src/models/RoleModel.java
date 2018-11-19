/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kirbp
 */
public class RoleModel extends MyModel{
    
    private int role_id;
    private String role_name;
    
     public ResultSet getRole() {
        Statement st;
        ResultSet ret = null;
        this.initialize();
        
        String str = "SELECT role_name FROM `role`";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
     
    public int getRole_id(){
        return role_id;
    }
    
    public void setRole_id(int role_id){
        this.role_id = role_id;
    }
    
    public String getRole_name(){
        return role_name;
    }
    
    public void setCategory_name(String role_name){
        this.role_name = role_name;
    }
}
