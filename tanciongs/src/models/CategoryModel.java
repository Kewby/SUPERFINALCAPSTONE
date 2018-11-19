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
 * @author Client
 */
public class CategoryModel extends MyModel {
    
    private int category_id;
    private String category_name;
    private String description;
    
    public ResultSet getCategory() {
        Statement st;
        ResultSet ret = null;
        this.initialize();
        
        String str = "SELECT category_name FROM `category`";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }   
    
    public int getCategory_id(){
        return category_id;
    }
    
    public void setCategory_id(int category_id){
        this.category_id = category_id;
    }
    
    public String getCategory_name(){
        return category_name;
    }
    
    public void setCategory_name(String category_name){
        this.category_name = category_name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription (String description){
        this.description = description;
    }
    
}
