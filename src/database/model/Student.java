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
}
