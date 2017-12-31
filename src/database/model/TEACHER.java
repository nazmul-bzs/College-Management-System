/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
/**
 *
 * @author Nazmul
 */
public class  TEACHER{
    public void insertTeacherData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into TEACHER (T_ID,DESIGNATION,SUBJECT,DIVISION,ROOMNO) values(?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
            pst.setString(2, list.get(1));
            pst.setString(3, list.get(2));
            pst.setString(4, list.get(3));
            pst.setInt(5, Integer.parseInt(list.get(4)));
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
        String sql = "SELECT * FROM TEACHER";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("T_ID"));
                row.add(rs.getString("DESIGNATION"));
                row.add(rs.getString("SUBJECT"));
                row.add(rs.getString("DIVISION"));
                row.add(rs.getString("ROOMNO"));
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
