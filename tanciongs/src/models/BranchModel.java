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
 * @author Allysha
 */
public class BranchModel extends MyModel {
    
    private int branch_id;
    private String branch_name;
    
    //Delivery Form
    public ResultSet getBranch(){
        Statement st;
        ResultSet ret = null;
        this.initialize();
        
        String str = "SELECT branch_name FROM branch";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int getBranch_id(){
        return branch_id;
    }
    
    public void setBranch_id(int branch_id){
        this.branch_id = branch_id;
    }
    
    public String getBranch_name(){
        return branch_name;
    }
    
    public void setBranch_name(String branch_name){
        this.branch_name = branch_name;
    }
}
