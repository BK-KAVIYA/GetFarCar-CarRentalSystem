
package com.getfarcars.maintanance;

import com.getfarcar.common.*;

/**
 *
 * @author sanjeewa
 */
public class CarMaintanance {
    
    private String M_ID;
    private String reason;
    private String parts;
    private int cost;
    private String car_id;
    private int invoice_id;

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String M_ID) {
        this.M_ID = M_ID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }
    
     public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }


     
    
}
