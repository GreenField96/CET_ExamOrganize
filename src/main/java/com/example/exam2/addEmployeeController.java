package com.example.exam2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class addEmployeeController  implements Initializable{
    private static ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private ChoiceBox<String> workAs;
    @FXML
    private TextField name,phoneNumber,email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workAs.setValue("موظف");
        workAs.getItems().add("موظف");
        workAs.getItems().add("دكتور");
    }
    @FXML
    public void insertEmployeeData(ActionEvent event) {
        EmployeeModel emp = new EmployeeModel();

        emp.insert(new EmployeeTable(name.getText(),email.getText(),phoneNumber.getText(),workAs.getValue()));
        emp.store();

        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        workAs.setValue("");
    }
    @FXML
    public void cancleinsertEmployeeData(){
        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        workAs.setValue("");
    }

}
