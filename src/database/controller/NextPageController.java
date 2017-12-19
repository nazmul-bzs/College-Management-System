/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;
import database.controller.StudentUser;
import database.Database;
import database.model.Student;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class NextPageController{
    
    Database database;

 
    @FXML
    private Button regButton;
    @FXML
    private Button showAllButton;
    @FXML
    private TableView<StudentUser> tableView;
    ObservableList<StudentUser> data;
    private boolean init = true;
    @FXML
    private TableColumn<StudentUser, String> stdId;
    @FXML
    private TableColumn<StudentUser, String> fName;
    @FXML
    private TableColumn<StudentUser, String> lName;
    @FXML
    private TableColumn<StudentUser, String> sex;
    @FXML
    private TableColumn<StudentUser, String> bDate;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    private void initializeColumns()
    {
        stdId.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("STDID"));
        fName.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("FIRSTNAME"));
        lName.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("LASTNAME"));
        sex.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("SEX"));
        bDate.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("BDATE"));
    }

    
    
    
    public void setDatabase(Database database) {
        this.database = database;
    }

    @FXML
    private void regButtonAction(ActionEvent event) {
        try {
            database.showRegPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void load()
    {
         if (init)
        {
            initializeColumns();
            init = false;
        }
        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new Student().getAllStudents();
        for (List<String> row : userDataList)
        {  
            StudentUser us=new StudentUser(row.get(0), row.get(1), row.get(2),row.get(3), row.get(4));
            data.add(us);
        }
        tableView.setItems(data);
    }

    @FXML
    private void showButtonAction(ActionEvent event) {
        load();
    }
    
}
