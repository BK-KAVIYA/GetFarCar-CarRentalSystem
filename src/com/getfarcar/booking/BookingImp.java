/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcar.booking;

import com.carrentalsystem.system.DBConnector;
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
 * @author MSI
 */
public class BookingImp implements BookingDAO{
    PreparedStatement pst;
    PreparedStatement pst1;
    
    DBConnector obj=DBConnector.getObject();
    java.sql.Connection conn=DBConnector.getConnection();

    @Override
    public void Add(Booking booking) {
         try {

            String sql="Insert into booking Values(?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,booking.getBid());
            pst.setString(2,booking.getStartdate());
            pst.setString(3,booking.getEnddate());
            pst.setString(4,booking.getStatus());
            pst.setString(5,booking.getDeposit());
            pst.setString(6,booking.getCustomerid());
            pst.setString(7,booking.getCarid());
            pst.setString(8,booking.getDriverid());
            pst.setString(9,booking.getAdminid());
           
            
            pst.executeUpdate();
            
            
            

            
            JOptionPane.showMessageDialog(null,"New Booking is added!!");
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void Update(Booking booking){


try {
  
             String sql="Update booking set  Start_Date=?,End_Date=?,Status=?,Deposite=?,Cus_ID=?,Car_ID=?,Dri_ID=?,Admin_ID=? where B_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,booking.getStartdate());
            pst.setString(2,booking.getEnddate());
            pst.setString(3,booking.getStatus());
            pst.setString(4,booking.getDeposit());
            pst.setString(5,booking.getCustomerid());
            pst.setString(6,booking.getCarid());
            pst.setString(7,booking.getDriverid());
            pst.setString(8,booking.getAdminid());
            pst.setString(9,booking.getBid());
           


                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Booking is Updated!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Booking Update Error!!");
                Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
            }





}
    
    
    
    @Override
    public Booking Search(String BID) {
        Booking booking = new Booking();
        
        try{
            String sql="select * from booking where B_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,BID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){   
                booking.setBid(BID);
                booking.setStartdate(rs.getString("Start_Date"));
                booking.setEnddate(rs.getString("End_Date"));
                booking.setStatus(rs.getString("Status"));
                booking.setDeposit(rs.getString("Deposite"));
                booking.setCustomerid(rs.getString("Cus_ID"));
                booking.setCarid(rs.getString("Car_ID"));
                booking.setDriverid(rs.getString("Dri_ID"));
                booking.setAdminid (rs.getString("Admin_ID"));
            }
           
        }catch (SQLException ex) {
            Logger.getLogger(BookingImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
 
      return booking;
        }
    
    public void Delete(Booking booking) {
         try {
            String sql="Delete from booking where B_ID=?;";
            pst=conn.prepareStatement(sql);
            pst.setString(1,booking.getBid());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Recode Deleted!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Recode Deletion Error!!");
            Logger.getLogger(BookingImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public List<Booking> ManageBookingList(){
        
    List<Booking> list= new ArrayList<Booking>();
        try {
            String sql="SELECT * FROM booking;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs=pst.executeQuery();
            
            
            while(rs.next()){
                
                
                    Booking booking = new Booking();
                    
                    booking.setBid(rs.getString("B_ID"));
                    booking.setStartdate(rs.getString("Start_Date"));
                    booking.setEnddate(rs.getString("End_Date"));
                    booking.setEnddate(rs.getString("End_Date"));
                    booking.setStatus(rs.getString("Status"));
                    booking.setDeposit(rs.getString("Deposite"));
                    booking.setCustomerid(rs.getString("Cus_ID"));
                    booking.setCarid(rs.getString("Car_ID"));
                    booking.setDriverid(rs.getString("Dri_ID"));
                    
                    
                    list.add(booking);
               
            }  
        
        } catch (SQLException ex) {
            Logger.getLogger(BookingImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    
    }
    
    
    @Override
    public List<Booking>SearchBookingList(String BookingID){
        List<Booking> list=new ArrayList<Booking>();
        try {
               
            

            String sql="SELECT * FROM booking WHERE B_ID='"+BookingID+"';";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs=pst.executeQuery();
            
            while(rs.next()){
                
                Booking booking = new Booking();
                booking.setBid(rs.getString("B_ID"));
                booking.setStartdate(rs.getString("Start_Date"));
                booking.setEnddate(rs.getString("End_Date"));
                booking.setStatus(rs.getString("Status"));
                booking.setDeposit(rs.getString("Deposite"));
                booking.setCustomerid(rs.getString("Cus_ID"));
                booking.setCarid(rs.getString("Car_ID"));
                booking.setDriverid(rs.getString("Dri_ID"));
                booking.setAdminid (rs.getString("Admin_ID"));
                
                list.add(booking);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return list;
    
    
    
    
    
    
    }
    
    
    @Override
   public List<Booking>SearchCustomerList(String CustomerID){
        List<Booking> list=new ArrayList<Booking>();
        try {
               
            

            String sql="SELECT * FROM booking WHERE Cus_ID='"+CustomerID+"';";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs=pst.executeQuery();
            
            while(rs.next()){
                
                Booking booking1 = new Booking();
                booking1.setBid(rs.getString("B_ID"));
                booking1.setStartdate(rs.getString("Start_Date"));
                booking1.setEnddate(rs.getString("End_Date"));
                booking1.setStatus(rs.getString("Status"));
                booking1.setDeposit(rs.getString("Deposite"));
                booking1.setCustomerid(rs.getString("Cus_ID"));
                booking1.setCarid(rs.getString("Car_ID"));
                booking1.setDriverid(rs.getString("Dri_ID"));
                booking1.setAdminid (rs.getString("Admin_ID"));
                
                list.add(booking1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return list;
    
    
    
    
    
    
    } 
    
    
    
    
    
    
    

}
