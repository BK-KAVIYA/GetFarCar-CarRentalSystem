/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getfarcars.managecars;

import com.getfarcar.common.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ManageCarDAO {
    public void Add(ManageCar managecar);
    public ManageCar Search(String carID);
    public ManageCar Searchtype(String ctype);
    public void Update(ManageCar managecar);
    public void Delete(ManageCar managecar);
    public List<ManageCar> ManageCarlist();
    public List<ManageCar> SearchCarlist(String CID);
    public List<ManageCar> CarTypelist ();
}
