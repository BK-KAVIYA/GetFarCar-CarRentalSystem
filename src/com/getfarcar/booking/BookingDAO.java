/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcar.booking;

import java.util.List;



/**
 *
 * @author MSI
 */
public interface BookingDAO {
    public void Add(Booking booking);
    public void Update(Booking booking);   
    public Booking Search(String BID);
     public void Delete(Booking booking);
     public List<Booking>ManageBookingList();
     public List<Booking>SearchBookingList(String BookingID);
     public List<Booking>SearchCustomerList(String CustomerID);
}
