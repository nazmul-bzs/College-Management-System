/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import database.Database;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class StudentHomePageController implements Initializable {
    
    Database database;

    @FXML
    private Button stdProfileButton;
    @FXML
    private Button stdCourseButton;
    @FXML
    private Button stdTeacherButton;
    @FXML
    private JFXButton stdProfilejfxButton;
    @FXML
    private JFXButton stdCoursejfxButton;
    @FXML
    private JFXButton stdTeacherjfxButton;
    @FXML
    private JFXButton stdLogOutjfxButton;
    @FXML
    private Button stdLogOutButton;

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
    private void stdProfileButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileView();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void stdProfilejfxButtonAction(ActionEvent event) {
        try {
            database.showStudentProfileView();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @FXML
    private void stdCourseButtonAction(ActionEvent event) {
    }


    @FXML
    private void stdCoursejfxButtonAction(ActionEvent event) {
    }

    @FXML
    private void stdTeacherButtonAction(ActionEvent event) {
    }
    
    @FXML
    private void stdTeacherjfxButtonAction(ActionEvent event) {
    }

    @FXML
    private void stdLogOutjfxButtonAction(ActionEvent event) {
        try {
           database.showLoginPage();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void stdLogOutButtonAction(ActionEvent event) {
        try {
           database.showLoginPage();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    
}
