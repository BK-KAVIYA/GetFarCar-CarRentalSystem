package com.carrentalsystem.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Connect database and return connection using singleton pattern

/**
 *
 * @author KA VI YA
 */
public class DBConnector {
    
    //Restric cleation object in onother class make constructor private 
    private DBConnector() {}
    
    //create object type private static
   private static DBConnector dbConnector = new DBConnector();
   
   //Return object
   public static DBConnector getObject(){  
       return dbConnector;
   }
    
   public static Connection getConnection(){
       Connection conn=null;
       String url="jdbc:mysql://localhost:3306/getfarcars";
       String username="root";
       String Password="";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,Password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

       return conn;
   }
}
