
package com.getfarcar.common;

import GetFarCars.Com.Admin.AdminUserManage;
import GetFarCars.Com.Admin.DriverDashboard;
import com.carrentalsystem.system.DBConnector;
import com.carrentalsystem.system.LoginPageGetFarCars;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginImp implements LoginDAO{

    PreparedStatement pst;
    DBConnector obj=DBConnector.getObject();
    Connection conn=obj.getConnection();
    
    @Override
    public void userLogin(Login logins) {
        LoginPageGetFarCars loginPage = new LoginPageGetFarCars();
        String sql="SELECT * FROM user WHERE user_id='"+logins.getID()+"';";
        try {
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("Password").equals(logins.getPassword())){
                    switch(rs.getInt("Role")){
                        case 1:
                            DriverDashboard admindashboard = new DriverDashboard();
                            admindashboard.setUser(logins.getID());
                            loginPage.dispose();
                            admindashboard.show();
                            break;
                        case 2:
                            /*SellerInterface sellerInterface = new SellerInterface();
                            sellerInterface.Load(logins.getID());
                            sellerInterface.setUserID(logins.getID());
                            loginPage.dispose();
                            sellerInterface.show();*/
                            
                            break;
                        default :
                            JOptionPane.showMessageDialog(loginPage,"user cann't Identified!!");
                    
                    }
                }
                }

        }catch (SQLException ex) {
            Logger.getLogger(LoginImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
