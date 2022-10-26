
package com.carrentalsystem.common;


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
        LoginPage loginPage = new LoginPage();
        String sql="SELECT * FROM user WHERE UserID='"+logins.getID()+"';";
        try {
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("Password").equals(logins.getPassword())){
                    switch(rs.getInt("UserRolle")){
                        case 1:
                           /* AdminInterface adminInterface = new AdminInterface();
                            adminInterface.setUserID(logins.getID());
                            loginPage.dispose();
                            adminInterface.show();*/
                            break;
                        case 2:
                            /*SellerInterface sellerInterface = new SellerInterface();
                            sellerInterface.Load(logins.getID());
                            sellerInterface.setUserID(logins.getID());
                            loginPage.dispose();
                            sellerInterface.show();*/
                            
                            break;
                        case 3:
                           /* cashierInterface cashierinterface = new cashierInterface();
                            loginPage.dispose();
                            cashierinterface.show();*/
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
