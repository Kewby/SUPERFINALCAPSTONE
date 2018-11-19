/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allysha
 */
//public class MyModel {
//    
//    Connection conn = null;
//    String username = "tanciongsdb";
//    String password = "Hg5fMoKQ9_3~";
//    
//    public void initialize () {
//        
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("ERROR");
//        }
//        
//        try {
//            conn  = (Connection) DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host/tanciongsdb", 
//                    username, password);
//        } catch (SQLException ex) {
//            Logger.getLogger(MyModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//} 


public class MyModel {
    
    Connection conn = null; 
    String username = "root";
    String password = "";
    
    public void initialize () {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR");
        }
        
        try {
            conn  = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtanciongs", 
                    username, password);
        } catch (SQLException ex) {
            Logger.getLogger(MyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}