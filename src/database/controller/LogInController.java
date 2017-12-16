/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import database.*;
import database.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class LogInController implements Initializable {
    
    ObservableList<String> LoginAs = FXCollections.observableArrayList("Student", "Staff");
    Database database;

    @FXML
    private TextField UserNameField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private ChoiceBox<String> ChoiceUser;
    @FXML
    private Button ResetButton;
    @FXML
    private Button LoginButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceUser.setValue("Student");
        ChoiceUser.setItems(LoginAs);
    }    

    @FXML
    private void ResetAction(ActionEvent event) {
    }

    @FXML
    private void LoginAction(ActionEvent event) throws Exception {
        String username = UserNameField.getText();
        String password = PasswordField.getText();
        String user = ChoiceUser.getValue();
        boolean success = new userLogin(user).validateLogin(username, password);
        if(success) {
            database.nextPage();
            System.out.println("yes");
        }
        else {
            showAlert();
        }
    }
    
    public void setDatabase(Database database) {
        this.database = database;
    }
    
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("User Name or Password mismatch");
        alert.show();
    }
    
}