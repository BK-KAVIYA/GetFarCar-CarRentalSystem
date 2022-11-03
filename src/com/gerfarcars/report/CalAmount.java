
package com.gerfarcars.report;

//import java.sql.Date;
import com.carrentalsystem.system.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
//import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KA VI YA
 */



public class CalAmount {
    private String CustomerID;
    private String CarID;
    private String StartDate;
    private String EndDate;
    private int DayCount;
    private int Price;
    private Double FixedCost= 750.00;
    private Double TotalCost;
    
    PreparedStatement pst1;
    DBConnector obj=DBConnector.getObject();
    Connection conn=obj.getConnection();

    public String getStartDate() {
        return EndDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return StartDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }
       
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String CarID) {
        this.CarID = CarID;
    }
    
    
    public double calAmount(){
        
        String edate=getEndDate();
        String sdate=getStartDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(sdate, formatter);
        LocalDate date2 = LocalDate.parse(edate, formatter);
        Period period = Period.between(date2, date1);
        DayCount=((period.getYears()*365)+(period.getMonths()*30)+(period.getDays()));
        
        try {
            String sql1="Select * from car where Car_ID='"+getCarID()+"';";
            pst1=conn.prepareStatement(sql1);
            ResultSet rs1;
            rs1 = pst1.executeQuery();
            
            while(rs1.next()){
                Price=rs1.getInt("Price");     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        TotalCost=(DayCount*Price)+FixedCost;
        
        return TotalCost;
        
    
    }
    
}
