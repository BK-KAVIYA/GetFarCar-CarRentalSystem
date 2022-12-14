/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerfarcars.report;

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
 * @author KA VI YA
 */
public class ReportImp implements ReportDAO{

    
    PreparedStatement pst;
    PreparedStatement pst1;
    DBConnector obj=DBConnector.getObject();
    java.sql.Connection conn=obj.getConnection();
    
    private int Tamount;
    private double presentage;
    private double totalCars;
    private double availableCar;
    private double precentage;
    private double retprecentage;

    public int getPrecentage() {
        return (int) precentage;
    }

    public void setPrecentage(double precentage) {
        this.precentage = precentage;
    }
    

    public double getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(double totalCars) {
        this.totalCars = totalCars;
    }

    public double getAvailableCar() {
        return availableCar;
    }

    public void setAvailableCar(double availableCar) {
        this.availableCar = availableCar;
    }

    
    
    public double getPresentage() {
        return presentage;
    }

    public void setPresentage(double presentage) {
        this.presentage = presentage;
    }
    
    
    public int getTamount() {
        return Tamount;
    }

    public void setTamount(int Tamount) {
        this.Tamount = Tamount;
    }
    
    public List<Report> ReportList() {
        List<Report> list =new ArrayList<Report>();
            
        try {
            String sql="Select * from checkout;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                Report report = new Report();
                report.setInvoiceNo(rs.getString("Check_ID"));
                report.setCustomerID(rs.getString("Cus_ID"));
                report.setBookingID(rs.getString("B_ID"));
                report.setDate(rs.getString("Date"));
                report.setAmount(rs.getInt("Amount"));
                Tamount=Tamount+rs.getInt("Amount");
                
            
            String sql1="Select * from customer where ID='"+rs.getString("Cus_ID")+"';";
            pst1=conn.prepareStatement(sql1);
            ResultSet rs1;
            rs1 = pst1.executeQuery();
            
            while(rs1.next()){               
                report.setCustomerName(rs1.getString("Fname"));                      
            }
            
            String sql2="Select * FROM car WHERE Car_ID=(SELECT Car_ID from booking where B_ID='"+rs.getString("B_ID")+"');";
            pst1=conn.prepareStatement(sql2);
            ResultSet rs3;
            rs3 = pst1.executeQuery();
            
            while(rs3.next()){               
                report.setVehicaleType(rs3.getString("Car_type"));                      
            }
             
            list.add(report);
            }
  
            setTamount(Tamount);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list;
    }

    @Override
    public List<Report> AdminReportList() {
        
        List<Report> list1 =new ArrayList<Report>();
            
        try {
            String sql="SELECT * FROM booking;";
         pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                Report report1 = new Report();
                report1.setBookingID(rs.getString("B_ID"));
                report1.setCustomerID(rs.getString("Cus_ID"));
                report1.setVehicaleID(rs.getString("Car_ID"));
                report1.setStartDate(rs.getString("Start_Date"));
                report1.setEndDate(rs.getString("End_Date"));
                
                String sql1="Select * from customer where ID='"+rs.getString("Cus_ID")+"';";
                pst1=conn.prepareStatement(sql1);
                ResultSet rs1;
                rs1 = pst1.executeQuery();
            
                while(rs1.next()){               
                    report1.setCustomerName(rs1.getString("Fname"));                      
                }
                
                String sql2="Select * FROM car WHERE Car_ID=(SELECT Car_ID from booking where B_ID='"+rs.getString("B_ID")+"');";
                pst1=conn.prepareStatement(sql2);
                ResultSet rs3;
                rs3 = pst1.executeQuery();

                while(rs3.next()){               
                    report1.setVehicaleType(rs3.getString("Car_type"));                      
                }
               
                
                 list1.add(report1);
            }
  
          //  setTamount(Tamount);
     
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
         return list1;
    }

    @Override
    public List<Report> AdminCarAvailability() {
        List<Report> list2 =new ArrayList<Report>();
            
        try {
            String sql="SELECT * FROM caravailability;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                Report report2 = new Report();
                report2.setVehicaleID(rs.getString("Car_ID"));
                report2.setTcars(rs.getInt("Number_Of_Cars"));
                report2.setAcars(rs.getInt("Available_Cars"));
                
                totalCars=totalCars+rs.getInt("Number_Of_Cars");
                availableCar=availableCar+rs.getInt("Available_Cars");
                             
                
                String sql2="Select * FROM car WHERE Car_ID=(SELECT Car_ID from caravailability where Car_ID='"+rs.getString("Car_ID")+"');";
                pst1=conn.prepareStatement(sql2);
                ResultSet rs3;
                rs3 = pst1.executeQuery();

                while(rs3.next()){               
                    report2.setVehicaleType(rs3.getString("Car_type"));                      
                }
                
                list2.add(report2);                
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
         return list2;
            
    }


    public void Add(Report report) {
        try {

            String sql="Insert into checkout Values(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,4);
            pst.setDouble(2,report.getAmount());
            pst.setString(3,report.getDate());
            pst.setString(4,report.getCustomerID());
            pst.setString(5,report.getAdminID());
            pst.setString(6,report.getBookingID());
     
            pst.executeUpdate();
            
 
            JOptionPane.showMessageDialog(null,"New Checkout is added!!");
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(UserImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Report> InvoiceList(String CID) {
        List<Report> list =new ArrayList<Report>();
        try {
            String sql1="Select * from customer where ID='"+CID+"';";
            pst1=conn.prepareStatement(sql1);
            ResultSet rs1;
            rs1 = pst1.executeQuery();
            
            while(rs1.next()){
                Report report = new Report();
                report.setCustomerName(rs1.getString("Fname")+" "+rs1.getString("Lname"));
                report.setAddress1(rs1.getString("Line1")+", "+rs1.getString("Line2"));
                report.setAddress2(rs1.getString("City"));
                System.out.println(report.getCustomerName());
                list.add(report);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
   public double get_Precentage(){
     try {
            String sql="SELECT * FROM caravailability;";
            pst=conn.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                Report report2 = new Report();
                report2.setVehicaleID(rs.getString("Car_ID"));
                report2.setTcars(rs.getInt("Number_Of_Cars"));
                report2.setAcars(rs.getInt("Available_Cars"));
                
                totalCars=totalCars+rs.getInt("Number_Of_Cars");
                availableCar=availableCar+rs.getInt("Available_Cars");
                
                setAvailableCar(availableCar);
                setTotalCars(totalCars); 
                
            }
                } catch (SQLException ex) {
                    Logger.getLogger(ReportImp.class.getName()).log(Level.SEVERE, null, ex);
                }
               retprecentage=(getAvailableCar()/getTotalCars())*100;
   return retprecentage;
   }
    
}
