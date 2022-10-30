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
    public void Update(CarMaintanance carmaintanance,String CarMaintananceTable) {
        
        try {
  
                String sql="Update "+CarMaintananceTable+" set  M_ID=?,Reason=?,Parts=?,Cost=?,Car_ID=?,Invoice_no=?;";
                pst=conn.prepareStatement(sql);
                pst.setString(1,carmaintanance.getM_ID());
                pst.setString(2,carmaintanance.getReason());
                pst.setString(3,carmaintanance.getParts());
                pst.setInt(4,carmaintanance.getCost());
                pst.setString(5,carmaintanance.getCar_id());
                pst.setInt(6,carmaintanance.getInvoice_id());
               

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data recode is Updated!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Data Insertion Error!!");
                Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);++++++++++++++++++++++
            }
    }

    @Override
    public void Delete(CarMaintanance carmaintanance,String CarMaintananceTable) {
         try {
            String sql="Delete from "+CarMaintananceTable+" where M_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,carmaintanance.getM_ID());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Recode Deleted!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Recode Deletion Error!!");
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);++++++++++++++++++
        }
    }

    @Override
    public CarMaintanance Serch(String M_ID) {
        String TableName=null;
        CarMaintanance carmaintanance = new CarMaintanance();
        char res=M_ID.charAt(0);
        switch(res){
            case 'A':
               TableName="admin";
                break;
            case 'C':
               TableName="customer";
                break;

        }
        
        String sql="select * from "+TableName+" where M_ID=?;";

            
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
                carmaintanance.setInvoice_id(rs.getInt("invoice_id"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return carmaintanance;
    }

    @Override
    public List<CarMaintanance> list(String tableName) {
        List<CarMaintanance> list =new ArrayList<CarMaintanance>();
         try {
            
            String sql="Select * from "+tableName+";";
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                CarMaintanance carmaintanance = new CarMaintanance();
                String M_ID = null;
                carmaintanance.setM_ID(M_ID);
                carmaintanance.setReason(rs.getString("reason"));
                carmaintanance.setParts(rs.getString("parts"));
                carmaintanance.setCost(rs.getInt("cost"));
                carmaintanance.setCar_id(rs.getString("car_id"));
                carmaintanance.setInvoice_id(rs.getInt("invoice_id"));
                
                list.add(carmaintanance);
            
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
    }

    @Override
    public List<CarMaintanance> CarMaintanancelist() {
        List<CarMaintanance> list =new ArrayList<CarMaintanance>();
            
            
        try {
            String sql="Select * from carmaintanancerolle;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                CarMaintanance carmaintanance = new CarMaintanance();
                carmaintanance.setCarMaintananceRolle(rs.getInt("CarMaintananceRolleID"));   ------------------------------------++++++++
                carmaintanance.setUserType(rs.getString("UserType"));              ------------------------------------+++++++++++++***
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
            pst.setString(1,carmaintanance.getM_ID());
                pst.setString(2,carmaintanance.getReason());
                pst.setString(3,carmaintanance.getParts());
                pst.setInt(4,carmaintanance.getCost());
                pst.setString(5,carmaintanance.getCar_id());
                pst.setInt(6,carmaintanance.getInvoice_id());
            
            pst.executeUpdate();
            /*
            String sql1="Insert into user Values(?,?,?)";
            pst1=conn.prepareStatement(sql1);
            pst1.setString(1, user.getID());
            pst1.setString(2, user.getPassword());
            pst1.setInt(3, userType);
            pst1.executeUpdate();*/
            
            JOptionPane.showMessageDialog(null,"New Maintanance is added!!");        
        } catch (SQLException ex) {
            Logger.getLogger(CarMaintananceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Add(CarMaintanance car_maintanance, String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(CarMaintanance car_maintanance, String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(CarMaintanance car_maintanance, String tablename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarMaintanance Serch(String car_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarMaintanance> list(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarMaintanance> CarMaintanancelist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
