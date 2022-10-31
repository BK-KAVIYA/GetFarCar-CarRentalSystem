/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcars.managecars;

import com.carrentalsystem.system.DBConnector;
import com.getfarcar.common.User;
import com.getfarcar.common.UserImp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ManageCarImp implements ManageCarDAO{
    PreparedStatement pst;
    PreparedStatement pst1;
    DBConnector obj=DBConnector.getObject();
    java.sql.Connection conn=obj.getConnection();

    @Override
    public void Add(ManageCar managecar) {

       try {

            String sql="Insert into car Values(?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,managecar.getCarID());
            pst.setString(2,managecar.getCname());
            pst.setString(3,managecar.getCtype());
            pst.setString(4,managecar.getCstatus());
            pst.setInt(5,managecar.getCprice());
            pst.setInt(6,managecar.getCseats());
            pst.setString(7,managecar.getCnoplate());
            pst.setString(8,managecar.getCfuel());
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"New Car is added!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ManageCar Search(String carID) {
        ManageCar managecar = new ManageCar();
            
        try {
            String sql="select * from car where Car_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,carID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                managecar.setCarID(carID);
                managecar.setCname(rs.getString("Cname"));
                managecar.setCtype(rs.getString("Car_type"));
                managecar.setCstatus(rs.getString("Status"));
                managecar.setCprice(rs.getInt("Price"));
                managecar.setCseats(rs.getInt("No_of_seat"));
                managecar.setCnoplate(rs.getString("Number_Plate"));
                managecar.setCfuel(rs.getString("Fuel_Type"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return managecar;
    }

    @Override
    public void Update(ManageCar managecar) {
        try {
  
                String sql="Update car set  Cname=?,Car_type=?,Status=?,Price=?,No_of_seat=?,Number_Plate=?,Fuel_Type=? where Car_ID=?;";
                pst=conn.prepareStatement(sql);

                pst.setString(1,managecar.getCname());
                pst.setString(2,managecar.getCtype());
                pst.setString(3,managecar.getCstatus());
                pst.setInt(4,managecar.getCprice());
                pst.setInt(5,managecar.getCseats());
                pst.setString(6,managecar.getCnoplate());
                pst.setString(7,managecar.getCfuel());
                pst.setString(8,managecar.getCarID());


                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data recode is Updated!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Data Insertion Error!!");
                Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void Delete(ManageCar managecar) {
        try {
            String sql="Delete from car where Car_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,managecar.getCarID());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Recode Deleted!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Recode Deletion Error!!");
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ManageCar> ManageCarlist() {
        List<ManageCar> list =new ArrayList<ManageCar>();
            
            
        try {
            String sql="Select * from car;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                ManageCar managecar = new ManageCar();
                managecar.setCarID(rs.getString("Car_ID"));
                managecar.setCname(rs.getString("Cname"));
                managecar.setCtype(rs.getString("car_type")); 
                managecar.setCstatus(rs.getString("Status"));
                managecar.setCprice(rs.getInt("Price"));
                managecar.setCseats(rs.getInt("No_of_seat"));
                managecar.setCnoplate(rs.getString("Number_Plate")); 
                managecar.setCfuel(rs.getString("Fuel_Type")); 
                list.add(managecar);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list;
    }

    @Override
    public List<ManageCar> SearchCarlist(String CID) {
        List<ManageCar> list =new ArrayList<ManageCar>();
            
            
        try {
            String sql="Select * from car where Car_ID='"+CID+"';";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                ManageCar managecar = new ManageCar();
                managecar.setCarID(rs.getString("Car_ID"));
                managecar.setCname(rs.getString("Cname"));
                managecar.setCtype(rs.getString("car_type")); 
                managecar.setCstatus(rs.getString("Status"));
                managecar.setCprice(rs.getInt("Price"));
                managecar.setCseats(rs.getInt("No_of_seat"));
                managecar.setCnoplate(rs.getString("Number_Plate")); 
                managecar.setCfuel(rs.getString("Fuel_Type")); 
                list.add(managecar);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list;
    }

    @Override
    public List<ManageCar> CarTypelist() {
        List<ManageCar> list =new ArrayList<ManageCar>();
        
        try {
            String sql="Select * from car;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                ManageCar managecar = new ManageCar();
                managecar.setCarID(rs.getString("Car_ID"));
                managecar.setCtype(rs.getString("car_type")); 
                managecar.setCstatus(rs.getString("Status")); 
                list.add(managecar);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return list;

}

    @Override
    public ManageCar Searchtype(String ctype) {
        ManageCar managecar = new ManageCar();
            
        try {
            String sql="select * from car where Car_type=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,ctype);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                managecar.setCarID(rs.getString("Car_ID"));
                managecar.setCname(rs.getString("Cname"));
                managecar.setCtype(rs.getString("Car_type"));
                managecar.setCstatus(rs.getString("Status"));
                managecar.setCprice(rs.getInt("Price"));
                managecar.setCseats(rs.getInt("No_of_seat"));
                managecar.setCnoplate(rs.getString("Number_Plate"));
                managecar.setCfuel(rs.getString("Fuel_Type"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return managecar;
    }
}


