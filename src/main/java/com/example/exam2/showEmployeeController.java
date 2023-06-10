package com.example.exam2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class showEmployeeController implements Initializable{
    private static ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField searchInput;
    @FXML
    private TableView<EmployeeTable> EmployeeTableView;
    @FXML
    private TableColumn<EmployeeTable,Integer> Id;
    @FXML
    private TableColumn<EmployeeTable, String> Name;
    @FXML
    private TableColumn<EmployeeTable, String> Email;
    @FXML
    private TableColumn<EmployeeTable, String> PhoneNumber;
    @FXML
    private TableColumn<EmployeeTable, String> WorkAs;
    ObservableList<EmployeeTable> ObservableArrayEmployee;
    private ArrayList<EmployeeTable> Employees;
    @FXML
    private TextField nameTextField,phoneNumberTextField,emailTextField;
    @FXML
    private ChoiceBox<String> workAsChoiceBox;
    int IdRow;
    String EmailRow,NameRow,WorkAsRow,PhoneNumberRow;
    EmployeeModel emp;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workAsChoiceBox.setValue("موظف");
        workAsChoiceBox.getItems().add("موظف");
        workAsChoiceBox.getItems().add("دكتور");
        emp = new EmployeeModel();
        Employees = new ArrayList<>();
    }
    @FXML
    public void querySearch() throws SQLException {
        Employees.clear();
        Employees = emp.searchOnTable(searchInput.getText());

        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        WorkAs.setCellValueFactory(new PropertyValueFactory<>("Work_as"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone_number"));
        ObservableArrayEmployee =  FXCollections.observableArrayList(Employees);
        EmployeeTableView.setItems(ObservableArrayEmployee);

//        FilteredList<EmployeeTable> filterData = new FilteredList<>(ObservableArrayEmployee, b -> true);
//        SortedList<EmployeeTable> sortData = new SortedList<>(filterData);
//        sortData.comparatorProperty().bind(EmployeeTableView.comparatorProperty());
//        EmployeeTableView.setItems(sortData);
    }
    @FXML
    public void getId(MouseEvent value){
        Integer index = EmployeeTableView.getSelectionModel().getSelectedIndex();
        IdRow = Id.getCellData(index);

        NameRow = Name.getCellData(index);
        nameTextField.setText(Name.getCellData(index));

        PhoneNumberRow = PhoneNumber.getCellData(index);
        phoneNumberTextField.setText(PhoneNumber.getCellData(index));

        EmailRow = Email.getCellData(index);
        emailTextField.setText(Email.getCellData(index));

        WorkAsRow = WorkAs.getCellData(index);
        workAsChoiceBox.setValue(WorkAs.getCellData(index));
    }
    @FXML
    public void updateEmployeeData(ActionEvent event) throws SQLException {

        emp.update(IdRow,nameTextField.getText(),emailTextField.getText(), workAsChoiceBox.getValue(),phoneNumberTextField.getText());
        querySearch();

        cleanEmployeeData();
    }
    @FXML
    public void deleteEmployeeData(ActionEvent event) throws SQLException {
        emp.delete(IdRow);
        querySearch();

        cleanEmployeeData();
    }
    @FXML
    public void insertEmployeeData() throws SQLException {
        EmployeeModel emp = new EmployeeModel();

        emp.insert(new EmployeeTable(nameTextField.getText(),emailTextField.getText(),phoneNumberTextField.getText(),workAsChoiceBox.getValue()));
        emp.store();

        querySearch();
        cleanEmployeeData();
    }
    @FXML
    public void cleanEmployeeData(){
        nameTextField.setText("");
        emailTextField.setText("");
        phoneNumberTextField.setText("");
        workAsChoiceBox.setValue("");

        ObservableArrayEmployee.clear();

    }
}