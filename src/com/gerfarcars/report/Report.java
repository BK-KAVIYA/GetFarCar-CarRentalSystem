
package com.gerfarcars.report;


public class Report {
    private String InvoiceNo;
    private String CustomerID;
    private String CustomerName;
    private String VehicaleID;
    private String VehicaleType;
    private String BookingID;
    private String StartDate;
    private String EndDate;   
    private String Date;
    private String Time;
    private int Amount;
    private int Tcars;
    private int Acars;

    public int getTcars() {
        return Tcars;
    }

    public void setTcars(int Tcars) {
        this.Tcars = Tcars;
    }

    public int getAcars() {
        return Acars;
    }

    public void setAcars(int Acars) {
        this.Acars = Acars;
    }
    

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }
    
    
     public String getVehicaleType() {
        return VehicaleType;
    }

    public void setVehicaleType(String VehicaleType) {
        this.VehicaleType = VehicaleType;
    }
    
    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getVehicaleID() {
        return VehicaleID;
    }

    public void setVehicaleID(String VehicaleID) {
        this.VehicaleID = VehicaleID;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

 
}
