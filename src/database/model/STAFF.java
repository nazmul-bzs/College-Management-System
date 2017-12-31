/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class STAFF {
    public void insertData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into STAFF (STFNO,FIRSTNAME,LASTNAME,SEX,BDATE,JOINDATE,JOB_DESC,CURRENTADRESS,PERMENANTADRESS,STFCONTACTNO,M_SAL,STATUS,PASSWORD) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
            pst.setString(2, list.get(1));
            pst.setString(3, list.get(2));
            pst.setString(4, list.get(3));
            pst.setString(5, list.get(4));
            pst.setString(6, list.get(5));
            pst.setString(7, list.get(6));
            pst.setString(8, list.get(7));
            pst.setString(9, list.get(8));
            pst.setInt(10,Integer.parseInt(list.get(9)));
            pst.setString(11, list.get(10));
            pst.setString(12, list.get(11));
            pst.setString(13, list.get(12));
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch (SQLException e)
        {
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
    }
    
    public List<List<String>> getAllUsers()
    {
        String sql = "SELECT * FROM STAFF";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("STFNO"));
                row.add(rs.getString("FIRSTNAME"));
                row.add(rs.getString("LASTNAME"));
                row.add(rs.getString("SEX"));
                row.add(rs.getString("BDATE"));
                row.add(rs.getString("JOINDATE"));
                row.add(rs.getString("JOB_DESC"));
                row.add(rs.getString("CURRENTADRESS"));
                row.add(rs.getString("PERMENANTADRESS"));
                row.add(rs.getString("STFCONTACTNO"));
                row.add(rs.getString("M_SAL"));
                row.add(rs.getString("STATUS"));
                row.add(rs.getString("PASSWORD"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return resultList;
    }
    
    
    public static List<String> getAStaff()
    {
        String sql = "SELECT * FROM STAFF WHERE STFNO = ?";
        List<String> row = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(0, Admin.LoggedInAdminId);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                row.add(rs.getString("STFNO"));
                row.add(rs.getString("FIRSTNAME"));
                row.add(rs.getString("LASTNAME"));
                row.add(rs.getString("SEX"));
                row.add(rs.getString("BDATE"));
                row.add(rs.getString("JOINDATE"));
                row.add(rs.getString("JOB_DESC"));
                row.add(rs.getString("CURRENTADRESS"));
                row.add(rs.getString("PERMENANTADRESS"));
                row.add(rs.getString("STFCONTACTNO"));
                row.add(rs.getString("M_SAL"));
                row.add(rs.getString("STATUS"));
                row.add(rs.getString("PASSWORD"));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return row;
    }
}

