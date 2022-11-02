/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcars.managecars;

/**
 *
 * @author ASUS
 */
public class ManageCar {
    private String carID;
    private String cname;
    private String ctype;
    private String cstatus;
    private int cprice;
    private int cseats;
    private String cnoplate;
    private String cfuel;

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public int getCprice() {
        return cprice;
    }

    public void setCprice(int cprice) {
        this.cprice = cprice;
    }

    public int getCseats() {
        return cseats;
    }

    public void setCseats(int cseats) {
        this.cseats = cseats;
    }

    public String getCnoplate() {
        return cnoplate;
    }

    public void setCnoplate(String cnoplate) {
        this.cnoplate = cnoplate;
    }

    public String getCfuel() {
        return cfuel;
    }

    public void setCfuel(String cfuel) {
        this.cfuel = cfuel;
    }
    
    
}
