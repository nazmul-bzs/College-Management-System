/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import database.controller.StudentRegController;
import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.scene.control.Alert;
/**
 *
 * @author Nazmul
 */
public class Student {
    public static String LoggedInStudentId;
    public void insertStudentData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into STUDENT (STDID, FIRSTNAME, LASTNAME,SEX, BDATE) values(?,?,?,?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
            pst.setString(2, list.get(1));
            pst.setString(3, list.get(2));
            pst.setString(4, list.get(3));
            try {
                
                pst.setDate(5, new Date((new SimpleDateFormat("yyyy-mm-dd")).parse(list.get(4)).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch (SQLIntegrityConstraintViolationException e){
            showStudentIntegretyAlert();
        }
        catch(SQLException e){
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
    }
    
    public void showStudentIntegretyAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("This student id is already in database");
        alert.show();
    }
    
    
    public List<List<String>> getAllStudents()
    {
        String sql = "SELECT * FROM STUDENT";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }
    
    public List<List<String>> searchById(String StdId) {
        String sql = "SELECT * FROM STUDENT WHERE STDID = " + StdId;
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }
    
    
    public List<List<String>> searchByfName(String Fname) {
        String sql = "SELECT * FROM STUDENT WHERE FIRSTNAME = ?";
        System.out.println(sql);
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Fname);
            ResultSet rs = pst.executeQuery();
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
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }
    
    
     public List<List<String>> dueStdList(String month) {
        String sql = "Select s.stdid, s.firstname, s.lastname " +
                       "from student s, fe[e_receipt f " +
                        "where s.Stdid = f.std_id and Lower(f.paid_status) = Lower('DUE') " +
                        "and f.Month = ?";
        System.out.println(sql);
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, month);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(rs.getInt("STDID")));
                row.add(rs.getString("FIRSTNAME"));
                row.add(rs.getString("LASTNAME"));
                row.add(null);
                //row.add(String.valueOf(rs.getDate("BDATE")));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }
     
     public void updateStudentData(ArrayList<String> list, int stdid) {
         try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "UPDATE STUDENT SET FIRSTNAME = ?, LASTNAME = ?, SEX = ?, BDATE = ? WHERE STDID = " + stdid;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, list.get(0));
            pst.setString(2, list.get(1));
            pst.setString(3, list.get(2));
            try {
                
                pst.setDate(4, new Date((new SimpleDateFormat("yyyy-mm-dd")).parse(list.get(3)).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
     }
    
}
