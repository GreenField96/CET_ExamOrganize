package com.example.exam2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class mainController {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private AnchorPane base;
    @FXML
    private Pane mainStage;
    private VBox addEmployeeStage;
    private VBox showEmployeeStage;
    private VBox addCommitteStage;
    private VBox addPaperMovementStageDelivery;
    private VBox manageCoursesStage;
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
        System.out.print(session.getEmail());
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
    @FXML
    public void manageCoursesStage(){
        try {
            if(manageCoursesStage == null) {
                FXMLLoader fxml = new FXMLLoader();
                fxml.setLocation(getClass().getResource("showCoursesStage.fxml"));
                manageCoursesStage = fxml.load();
            }
            mainStage.getChildren().setAll(manageCoursesStage);
        }catch (Exception e){
            log.logException(e);
        }
    }
    @FXML
    public void createReportStage() {
        try {
            new ProcessBuilder("cmd", "/c", " start https://127.0.0.1/exam_organize/").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

