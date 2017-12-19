/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import database.Database;
import database.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nazmul
 */
public class AdminLogInController implements Initializable {
    
    private Database database;
    private Student student;
    
    private boolean init = true;
    ObservableList<StudentUser> studentData;
    
    @FXML
    private DatePicker StdBdate;
    @FXML
    private Button StdResetButton;
    @FXML
    private Button StdSubmitButton;
    @FXML
    private Button StdSearchButton;
    @FXML
    private TableView<StudentUser> StdTableView;
    @FXML
    private TableColumn<StudentUser, String> sidColumn;
    @FXML
    private TableColumn<StudentUser, String> sfnameColumn;
    @FXML
    private TableColumn<StudentUser, String> slnameColumn;
    @FXML
    private TableColumn<StudentUser, String> ssexColumn;
    @FXML
    private TableColumn<StudentUser, String> sbdateColumn;
    @FXML
    private ComboBox<String> StdSearchByCombo;
    @FXML
    private Button StdShowAllButton;
    @FXML
    private Tab StdDueMonthCombo;
    @FXML
    private TableView<StudentUser> StdDueTableView;
    @FXML
    private TableColumn<StudentUser, String> sidDueColumn;
    @FXML
    private TableColumn<StudentUser, String> sfnameDueColumn;
    @FXML
    private TableColumn<StudentUser, String> slnameDueColumn;
    @FXML
    private TableColumn<StudentUser, String> sDueAmountColumn;
    @FXML
    private Button StdDueShowButton;
    @FXML
    private TextField TlnameColumn;
    @FXML
    private TextField TsexLabel;
    @FXML
    private TextField TfnameLabel;
    @FXML
    private TextField TidLabel;
    @FXML
    private DatePicker Tbdate;
    @FXML
    private Button TresetButton;
    @FXML
    private Button TsubmitButton;
    @FXML
    private Tab ThighSalCombo;
    @FXML
    private Button ThighSalButton;
    @FXML
    private TextField StdIdField;
    @FXML
    private TextField FnameField;
    @FXML
    private TextField LnameField;
    @FXML
    private TextField StdSexField;
    @FXML
    private TextField StdSearchField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void StdResetAction(ActionEvent event) {
        StdIdField.clear();
        FnameField.clear();
        LnameField.clear();
        StdSexField.clear();
        StdBdate.setValue(null);
    }

    @FXML
    private void StdSubmitAction(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>(5);
        list.add(0, StdIdField.getText());
        list.add(1, FnameField.getText());
        list.add(2, LnameField.getText());
        list.add(3, StdSexField.getText());
        list.add(4, StdBdate.getValue().toString());
        StudentUser s = new StudentUser(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        System.out.println(s.toString());
        new Student().insertStudentData(list);
    }

    @FXML
    private void StdSearchAction(ActionEvent event) {
    }

    @FXML
    private void StdShowAllAction(ActionEvent event) {
        loadAllStudents();
    }

    @FXML
    private void StdDueShowAction(ActionEvent event) {
    }

    @FXML
    private void TresetAction(ActionEvent event) {
    }

    @FXML
    private void TsubmitAction(ActionEvent event) {
    }

    @FXML
    private void ThighSalAction(ActionEvent event) {
    }
    
    
    private void initializeColumns() {
        sidColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("Std Id"));
        sfnameColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("First Name"));
        slnameColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("Last Name"));
        ssexColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("Sex"));
        sbdateColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("Birth Date"));
    
    }
    
    private void loadAllStudents() {
        if(init) {
            initializeColumns();
            init = false;
        }
        studentData = FXCollections.observableArrayList();
        List<List<String>> StudentDataList = new Student().getAllStudents();
        for (List<String> row : StudentDataList)
        {  
            StudentUser us=new StudentUser(row.get(0), row.get(1), row.get(2),row.get(3), row.get(4));
            studentData.add(us);
        }
        StdTableView.setItems(studentData);
    }
    
    public void setDatabase(Database database) {
        this.database = database;
    }
}
