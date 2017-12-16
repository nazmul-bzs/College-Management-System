/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.model.*;
import database.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nazmul
 */
public class Database extends Application{

    /**
     * @param args the command line arguments
     */
    Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        showLoginPage();
    }
    
    public void showLoginPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/LogIn.fxml"));
        Parent root = loader.load();
        LogInController controller = loader.getController();
        controller.setDatabase(this);
        stage.setTitle("Log In Page");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }
    
    public void nextPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/NextPage.fxml"));
        Parent root = loader.load();
        NextPageController controller = loader.getController();
        controller.setDatabase(this);
        stage.setTitle("Next Page");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
    
    public void showRegPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/studentReg.fxml"));
        Parent root = loader.load();
        StudentRegController controller = loader.getController();
        controller.setDatabase(this);
        Stage regStage = new Stage();
        regStage.setTitle("Student Registration");
        regStage.setScene(new Scene(root, 450, 400));
        regStage.show();
    }
    
}
