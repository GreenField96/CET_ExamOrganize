package com.example.exam2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private AnchorPane baseLogin;
    @FXML
    private TextField emailTextField , paswordTextField;
    private EmployeeModel employeeModel;
    private Alert alert;
    private AnchorPane base;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeModel = new EmployeeModel();
        alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("خطأ");
        alert.setAlertType(Alert.AlertType.INFORMATION);
    }
    @FXML
    private void onClickLogout() {
        Stage stage = (Stage) baseLogin.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void onClickLogin() {
        String email = emailTextField.getText();
        String pass = paswordTextField.getText();
        if(pass.length() < 1 | email.length() < 1){
            alert.setContentText("ادخل جميع الخانات");
            alert.show();
        }else if(pass.length() < 8){
            alert.setContentText("ادخل 8 خانات على الاقل");
            alert.show();
        }else if(employeeModel.employeeLogin(email,pass)){
            try {
                if(base == null) {
                    FXMLLoader fxml = new FXMLLoader();
                    fxml.setLocation(getClass().getResource("main-view.fxml"));
                    base = fxml.load();
                }
             baseLogin.getChildren().setAll(base);
             baseLogin.getScene().getWindow().setHeight(645);
             baseLogin.getScene().getWindow().setWidth(1300);
             baseLogin.getScene().getWindow().setX(40);
             baseLogin.getScene().getWindow().setY(40);
             }catch (Exception e) {
                log.logException(e);
             }
          }else{
            alert.setContentText("كلمة المرور او اسم المستخدم خاطئة");
            alert.show();
        }


    }
}
