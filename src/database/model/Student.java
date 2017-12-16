/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import database.controller.StudentRegController;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
/**
 *
 * @author Nazmul
 */
public class Student {
    public void insertData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into STUDENT (STDID, FIRSTNAME, LASTNAME,SEX) values(?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
            pst.setString(2, list.get(1));
            pst.setString(3, list.get(2));
            pst.setString(4, list.get(3));
           // pst.setString(4, list.get(4));
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch(SQLIntegrityConstraintViolationException e) {
            new StudentRegController().showIntegretyAlert();
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
    }
    public List<List<String>> getAllUsers()
    {
        String sql = "SELECT * FROM STUDENT";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(rs.getInt("STDID")));
                row.add(rs.getString("FIRSTNAME"));
                row.add(rs.getString("LASTNAME"));
                row.add(rs.getString("SEX"));
                row.add(String.valueOf(rs.getDate("BDATE")));
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
}
