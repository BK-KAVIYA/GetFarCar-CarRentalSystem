/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcars.maintanance;

import com.getfarcar.common.*;
import com.carrentalsystem.system.DBConnector;
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
 * @author sanjeewa
 */
public class CarMaintananceImp implements MaintananceDAO{
    
    PreparedStatement pst;
    PreparedStatement pst1;
    DBConnector obj=DBConnector.getObject();
    java.sql.Connection conn=obj.getConnection();



    @Override
    public void Update(CarMaintanance carmaintanance) {
        
        try {
  
                String sql="Update maintance set Reason=?,Parts=?,Cost=?,Car_ID=?,Invoice_no=? where M_ID=?;";
                pst=conn.prepareStatement(sql);
                
                pst.setString(1,carmaintanance.getReason());
                pst.setString(2,carmaintanance.getParts());
                pst.setInt(3,carmaintanance.getCost());
                pst.setString(4,carmaintanance.getCar_id());
                pst.setInt(5,carmaintanance.getInvoice_id());
                pst.setString(6,carmaintanance.getM_ID());
               

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data recode is Updated!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Data Insertion Error!!");
                Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void Delete(CarMaintanance carmaintanance) {
         try {
            String sql="Delete from maintance where M_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,carmaintanance.getM_ID());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Recode Deleted!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Recode Deletion Error!!");
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CarMaintanance Serch(String M_ID) {

        CarMaintanance carmaintanance = new CarMaintanance();       
        String sql="select * from maintance where M_ID=?;";

            
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,M_ID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                
                carmaintanance.setM_ID(M_ID);
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("Invoice_no"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return carmaintanance;
    }

    @Override
    public List<CarMaintanance> list() {
        List<CarMaintanance> list =new ArrayList<CarMaintanance>();
         try {
            
            String sql="Select * from maintance;";
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                CarMaintanance carmaintanance = new CarMaintanance();
                //String M_ID = null;
                carmaintanance.setM_ID(rs.getString("M_ID"));
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("Invoice_no"));
                
                list.add(carmaintanance);
            
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
    }

   
    public List<CarMaintanance> CarMaintanancelist(String MID) {
        List<CarMaintanance> list =new ArrayList<CarMaintanance>();
            
            
        try {
            String sql="Select * from maintance WHERE M_ID='"+MID+"';";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                CarMaintanance carmaintanance = new CarMaintanance();
                
                carmaintanance.setM_ID(rs.getString("M_ID"));
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("Invoice_no"));
                


                list.add(carmaintanance);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list;
    }

    @Override
    public void Add(CarMaintanance carmaintanance) {
        try {

            String sql="Insert into maintance Values(?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1,carmaintanance.getM_ID());
                pst.setString(2,carmaintanance.getReason());
                pst.setString(3,carmaintanance.getParts());
                pst.setInt(4,carmaintanance.getCost());
                pst.setString(5,carmaintanance.getCar_id());
                pst.setInt(6,carmaintanance.getInvoice_id());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"New Maintanance is added!!");        
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CarMaintanance> CarMaintanancelist() {
         List<CarMaintanance> list =new ArrayList<CarMaintanance>();
            
            
        try {
            String sql="Select * from maintance;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                CarMaintanance carmaintanance = new CarMaintanance();
                
                carmaintanance.setM_ID(rs.getString("M_ID"));
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("Invoice_no"));
                
                list.add(carmaintanance);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list;
    }
    
   public CarMaintanance Serch_cid(String Car_ID) {

        CarMaintanance carmaintanance = new CarMaintanance();       
        String sql="select * from maintance where Car_ID=?;";

            
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,Car_ID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                
                carmaintanance.setM_ID(rs.getString("M_ID"));
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("Invoice_no"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return carmaintanance;
    }
    
    






    
}
