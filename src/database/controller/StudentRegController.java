/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import database.Database;
import database.model.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class StudentRegController implements Initializable {
    
    private Database database;
    private Student student;

    @FXML
    private TextField stdidField;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField dbirthField;
    @FXML
    private Button resetButton;
    @FXML
    private Button submitButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setDatabase(Database database) {
        this.database = database;
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
    }

    @FXML
    private void submitButtonAction(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>(5);
        list.add(0, stdidField.getText());
        list.add(1, fnameField.getText());
        list.add(2, lnameField.getText());
        list.add(3, sexField.getText());
        list.add(4, dbirthField.getText());
        new Student().insertData(list);
//        Thread t=new  Thread(new Runnable() {
//            @Override
//            public void run() {
//                
//                insertData(list);
//                }
//        }).start();
        
    }
    
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
        }catch (SQLException e)
        {
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
    }
    
    public void showIntegretyAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("This student id is already in database");
        alert.show();
    }
    
}
