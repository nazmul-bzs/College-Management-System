/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author Nazmul
 */
public class Admin {
    public static String LoggedInAdminId;
    public void insertData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into ADMIN (AD_ID,ROOMNO,START_DATE,END_DATE,ROLE) values(?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
            pst.setInt(2, Integer.parseInt(list.get(1)));
            pst.setString(3, list.get(2));
            pst.setString(4, list.get(3));
            pst.setString(5, list.get(4));
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
        String sql = "SELECT * FROM ADMIN";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("AD_ID"));
                row.add(rs.getString("ROOMNO"));
                row.add(rs.getString("START_DATE"));
                row.add(rs.getString("END_DATE"));
                 row.add(rs.getString("ROLE"));
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
    
    public static List<String> getAnAdmin() {
        String sql = "SELECT * FROM ADMIN WHERE AD_ID = ?";
        List<String> row = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(0, Admin.LoggedInAdminId);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                
                row.add(rs.getString("AD_ID"));
                row.add(rs.getString("ROOMNO"));
                row.add(rs.getString("START_DATE"));
                row.add(rs.getString("END_DATE"));
                row.add(rs.getString("ROLE"));
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
