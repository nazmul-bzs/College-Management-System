/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import com.jfoenix.controls.JFXButton;
import database.Database;
import database.model.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class StudentProfileViewController implements Initializable {
    
    Database database;
    private Student student = new Student();

    @FXML
    private Button backButton;
    @FXML
    private JFXButton jfxBackButton;
    @FXML
    private Label stdIdLabel;
    @FXML
    private Label fnameLabel;
    @FXML
    private Label lNameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label bDateLabel;
    @FXML
    private Button editButton;
    @FXML
    private JFXButton jfxEditButton;

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
    private void jfxBackButtonAction(ActionEvent event) {
        try {
            database.showStudentPage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void backButtonAction(ActionEvent event) {
        try {
            database.showStudentPage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setDatabase(Database database) {
        this.database = database;
    }
    
    private void loadStudentProfile() {
        List<List<String>> studentInfo = student.searchById(Student.LoggedInStudentId);
        stdIdLabel.setText(studentInfo.get(0).get(0));
        fnameLabel.setText(studentInfo.get(0).get(1));
        lNameLabel.setText(studentInfo.get(0).get(2));
        sexLabel.setText(studentInfo.get(0).get(3));
        bDateLabel.setText(studentInfo.get(0).get(4));
        //System.out.println(studentInfo.get(0).get(4));
    }

    @FXML
    private void jfxEditButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileEdit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void editButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileEdit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
