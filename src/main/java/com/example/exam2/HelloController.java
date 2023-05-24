package com.example.exam2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class HelloController {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private AnchorPane base;
    @FXML
    private Pane mainStage;
    private VBox addEmployeeStage;
    private VBox showEmployeeStage;
    private VBox addCommitteStage;
    private VBox addPaperMovementStageDelivery;

    @FXML
    private void onClickLogout() {
        Stage stage = (Stage) base.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void addEmployeeStage(){
        try {
        if(addEmployeeStage == null) {
            FXMLLoader fxml = new FXMLLoader();
            fxml.setLocation(getClass().getResource("addEmployeeStage.fxml"));
            addEmployeeStage = fxml.load();
        }
            mainStage.getChildren().setAll(addEmployeeStage);
        }catch (Exception e){
            log.logException(e);
        }
    }
    @FXML
    public void addCommitteStage(){
        try {
            if(addCommitteStage == null) {
                FXMLLoader fxml = new FXMLLoader();
                fxml.setLocation(getClass().getResource("addCommitteStage.fxml"));
                addCommitteStage = fxml.load();
            }
            mainStage.getChildren().setAll(addCommitteStage);
        }catch (Exception e){
            log.logException(e);
        }
    }
    @FXML
    public void showEmployeeStage(){
        try {
        if(showEmployeeStage == null) {
            FXMLLoader fxml = new FXMLLoader();
            fxml.setLocation(getClass().getResource("showEmployeeStage.fxml"));
            showEmployeeStage = fxml.load();
        }
            mainStage.getChildren().setAll(showEmployeeStage);
        }catch (Exception e){
            log.logException(e);
        }
    }
    @FXML
    public void addPaperMovementStageDelivery(){
        try {
            if(addPaperMovementStageDelivery == null) {
                FXMLLoader fxml = new FXMLLoader();
                fxml.setLocation(getClass().getResource("addPaperMovementStageDelivery.fxml"));
                addPaperMovementStageDelivery = fxml.load();
            }
            mainStage.getChildren().setAll(addPaperMovementStageDelivery);
        }catch (Exception e){
            log.logException(e);
        }
    }
}

