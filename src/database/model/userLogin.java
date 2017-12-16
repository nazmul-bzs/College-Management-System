/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.sql.*;

/**
 *
 * @author Nazmul
 */
public class userLogin {
    private String userType = null;
    public userLogin(String userType) {
        this.userType = userType;
    }
    
    public boolean validateLogin(String username, String password) {
        boolean success = false;
        
        String sqlStaff = "SELECT * FROM STAFF WHERE STFNO = ? AND PASSWORD = ?";
        String sqlStudent = "SELECT * FROM STUDENT WHERE STDID = ? AND PASSWORD = ?";
        try {
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst;
            if(userType.equalsIgnoreCase("STAFF")) pst = con.prepareStatement(sqlStaff);
            else pst = con.prepareStatement(sqlStudent);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                success = true;
            }
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
