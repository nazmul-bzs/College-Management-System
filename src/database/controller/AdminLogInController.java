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
import javafx.scene.control.Label;
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
    
    ObservableList<StudentUser> studentData;
    private final ObservableList<String> StdSearchBy = FXCollections.observableArrayList("Student Id", "First Name");
    private final ObservableList<String> stdDueMonth = FXCollections.observableArrayList("January", "February");
    
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
    private ComboBox<String> StdDueMonthCombo;
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
    @FXML
    private Label profileFname;
    @FXML
    private Label profileId;
    @FXML
    private Label profileLname;
    @FXML
    private Label profileSex;
    @FXML
    private Label profileBdate;
    @FXML
    private TextField editProfileId;
    @FXML
    private TextField editProfileFname;
    @FXML
    private TextField editProfileLname;
    @FXML
    private TextField editProfileSex;
    @FXML
    private TextField editProfileBdate;
    @FXML
    private Button editProfileSaveButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StdSearchByCombo.setItems(StdSearchBy);
        StdDueMonthCombo.setItems(stdDueMonth);
        initializeColumns();
        initializeColumns2();
        //initializeAdminProfile();
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
        new Student().insertStudentData(list);
    }

    @FXML
    private void StdSearchAction(ActionEvent event) {
        stdSearchBy();
    }

    @FXML
    private void StdShowAllAction(ActionEvent event) {
        loadAllStudents();
    }

    @FXML
    private void StdDueShowAction(ActionEvent event) {
        loadStdDueList();
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
        sidColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("STDID"));
        sfnameColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("FIRSTNAME"));
        slnameColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("LASTNAME"));
        ssexColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("SEX"));
        sbdateColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("BDATE"));
    
    }
    
    private void initializeColumns2() {
        sidDueColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("STDID"));
        sfnameDueColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("FIRSTNAME"));
        slnameDueColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("LASTNAME"));
        sDueAmountColumn.setCellValueFactory(new PropertyValueFactory<StudentUser, String>("DUEAMOUNT"));
    }
    
    private void loadAllStudents() {
        studentData = FXCollections.observableArrayList();
        List<List<String>> StudentDataList = new Student().getAllStudents();
        for (List<String> row : StudentDataList) {  
            StudentUser us=new StudentUser(row.get(0), row.get(1), row.get(2),row.get(3), row.get(4));
            studentData.add(us);
        }
        StdTableView.setItems(studentData);
    }
    
    private void stdSearchBy() {
        studentData = FXCollections.observableArrayList();
        List<List<String>> StudentDataList = null;
        switch(StdSearchByCombo.getValue()) {
            case "Student Id" :
                StudentDataList = new Student().searchById(StdSearchField.getText());
                break;
            case "First Name" :
                StudentDataList = new Student().searchByfName(StdSearchField.getText());
                break;
        }
        for (List<String> row : StudentDataList) {  
            StudentUser us=new StudentUser(row.get(0), row.get(1), row.get(2),row.get(3), row.get(4));
            studentData.add(us);
        }
        StdTableView.setItems(studentData);
    }
    
    private void loadStdDueList() {
        studentData = FXCollections.observableArrayList();
        List<List<String>> StudentDataList = new Student().dueStdList(StdDueMonthCombo.getValue());
        for (List<String> row : StudentDataList) {  
            StudentUser us=new StudentUser(row.get(0), row.get(1), row.get(2));
            studentData.add(us);
        }
        StdDueTableView.setItems(studentData);
    }
    
    public void setDatabase(Database database) {
        this.database = database;
    }
    
    
    public void initializeAdminProfile() {
        List<String> admin = Admin.getAnAdmin();
        List<String> staff = STAFF.getAStaff();
        profileId.setText(admin.get(0));
        profileFname.setText(staff.get(1));
        profileLname.setText(staff.get(2));
        profileSex.setText(staff.get(3));
        profileBdate.setText(staff.get(4));
    }
}
