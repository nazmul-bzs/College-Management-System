/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import database.model.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class StudentProfileEditController implements Initializable {
    
    private Student student = new Student();
    private Database database;

    @FXML
    private JFXDatePicker editBdate;
    @FXML
    private JFXTextField editFname;
    @FXML
    private JFXTextField editLname;
    @FXML
    private JFXTextField editSex;
    @FXML
    private Button stdEditButton;
    @FXML
    private JFXButton stdEditjfxButton;
    @FXML
    private JFXTextField editId;
    @FXML
    private Button stdEditBackButton;
    @FXML
    private JFXButton stdEditjfxBackButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadStudentProfile();
    }    

    @FXML
    private void stdEditjfxButtonAction(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>(4);
        list.add(0, editFname.getText());
        list.add(1, editLname.getText());
        list.add(2, editSex.getText());
        list.add(3, editBdate.getValue().toString());
        student.updateStudentData(list, Integer.parseInt(Student.LoggedInStudentId));
        try {
            database.showStudentProfileView();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void stdEditButtonAction(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>(4);
        list.add(0, editFname.getText());
        list.add(1, editLname.getText());
        list.add(2, editSex.getText());
        list.add(3, editBdate.getValue().toString());
        student.updateStudentData(list, Integer.parseInt(Student.LoggedInStudentId));
        try {
            database.showStudentProfileView();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setDatabase(Database database) {
        this.database = database;
    }
    
    private void loadStudentProfile() {
        System.out.println(Student.LoggedInStudentId);
        List<List<String>> studentInfo = student.searchById(Student.LoggedInStudentId);
        editId.setText(studentInfo.get(0).get(0));
        editFname.setText(studentInfo.get(0).get(1));
        editLname.setText(studentInfo.get(0).get(2));
        editSex.setText(studentInfo.get(0).get(3));
        editBdate.setValue(LocalDate.parse(studentInfo.get(0).get(4), DateTimeFormatter.ISO_DATE));
    }

    @FXML
    private void stdEditjfxBackButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileView();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void stdEditBackButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileView();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
