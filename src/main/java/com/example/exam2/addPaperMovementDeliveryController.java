package com.example.exam2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addPaperMovementDeliveryController implements Initializable {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField searchInput,numberRoomTextField,courseTextField;
    @FXML
    private DatePicker dateCommitteReciveDatePicker,dateCommitteDatePicker;
    @FXML
    private TableView<EmployeeTable> EmployeeTableView;
    @FXML
    private TableColumn<EmployeeTable,Integer> idEmployeeCol;
    @FXML
    private TableColumn<EmployeeTable, String> nameEmployeeCol;
    @FXML
    private TableColumn<EmployeeTable, String> phoneNumberEmployeeCol;
    ObservableList<EmployeeTable> ObservableArrayEmployee;
    @FXML
    private TableView<CommitteTable> committeTableView;
    @FXML
    private TableColumn<CommitteTable,Integer> idCommitteCol;
    @FXML
    private TableColumn<CommitteTable,String> courseCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> dateCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> numberOfPaperCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> specificCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> numberOfRoomCommitteCol;
    ObservableList<CommitteTable> ObservableArrayCommitte;
    private ArrayList<EmployeeTable> Employees;
    private EmployeeModel emp;
    private ArrayList<CommitteTable> Committes;
    private CommitteModel comm;
    @FXML
    HBox doctorNameTakenHbox,committeTakenHbox,groupForm1;
    @FXML
    VBox groupsForm;
    Label doctorName= new Label(),doctorPhoneNumber= new Label(),idCommitte= new Label(),courseCommitte= new Label(),dateCommitte= new Label(),numberOfRoomCommitte= new Label(),numberOfPaperCommitte= new Label();
    boolean addChilderen = true , addChilderenCommitte = true;
    private HBox HboxGroup;
    @FXML
    private ChoiceBox<String> groupNumberChoiceBox;
    private answerPaperMovementModel paperModel;
    private answerPaperMovementTable paperTable;
    private int countHboxItems=0;
    private String committeId,recentId;
    private ArrayList<String> arrayHboxTextField = new ArrayList<>();
    private ArrayList<String> arrayHboxChoice = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emp = new EmployeeModel();
        Employees = new ArrayList<>();
        Committes = new ArrayList<>();
        comm = new CommitteModel();
        dateCommitteReciveDatePicker.setValue(LocalDate.now());
        try {
            addGroup();
        } catch (IOException e) {
            log.logException(e);
        }
        paperModel = new answerPaperMovementModel();
    }
    @FXML
    public void querySearchOnDoctor() throws SQLException {
        Employees.clear();
        Employees = emp.searchOnTable(searchInput.getText());
        idEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        phoneNumberEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Phone_number"));
        ObservableArrayEmployee =  FXCollections.observableArrayList(Employees);
        EmployeeTableView.setItems(ObservableArrayEmployee);
    }
    @FXML
    public void getDoctorId(MouseEvent value){
        Integer index = EmployeeTableView.getSelectionModel().getSelectedIndex();

        recentId = String.valueOf(idEmployeeCol.getCellData(index));
        doctorName.setText(nameEmployeeCol.getCellData(index));
        doctorPhoneNumber.setText(phoneNumberEmployeeCol.getCellData(index));

        doctorName.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 60 1 60");
        doctorPhoneNumber.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 90 1 90");

        if(addChilderen) {
            addChilderen = false;
            doctorNameTakenHbox.getChildren().add(doctorPhoneNumber);
            doctorNameTakenHbox.getChildren().add(doctorName);
        }
        if(phoneNumberEmployeeCol.getCellData(index).equals("")){
            doctorNameTakenHbox.getChildren().remove(doctorPhoneNumber);
        }
    }
    @FXML
    public void querySearchOnCommitte() throws SQLException {
        Committes.clear();
        String date = "";
        if(dateCommitteDatePicker.getValue() != null){
            date = dateCommitteDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        Committes = comm.selectSpecificData(numberRoomTextField.getText(),courseTextField.getText(),date);

        idCommitteCol.setCellValueFactory(new PropertyValueFactory<>("IdCol"));
        courseCommitteCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        dateCommitteCol.setCellValueFactory(new PropertyValueFactory<>("DateCol"));
        specificCommitteCol.setCellValueFactory(new PropertyValueFactory<>("NumberAnswerPaperCol"));
        numberOfRoomCommitteCol.setCellValueFactory(new PropertyValueFactory<>("ClassNumberCol"));
        numberOfPaperCommitteCol.setCellValueFactory(new PropertyValueFactory<>("SpecificCol"));
        ObservableArrayCommitte =  FXCollections.observableArrayList(Committes);
        committeTableView.setItems(ObservableArrayCommitte);
    }
    @FXML
    public void getCommitteId(MouseEvent value){
        Integer index = committeTableView.getSelectionModel().getSelectedIndex();

        committeId = String.valueOf(idCommitteCol.getCellData(index));
        idCommitte.setText(String.valueOf(idCommitteCol.getCellData(index)));
        courseCommitte.setText(courseCommitteCol.getCellData(index));
        dateCommitte.setText(dateCommitteCol.getCellData(index));
        numberOfRoomCommitte.setText(numberOfRoomCommitteCol.getCellData(index));
        numberOfPaperCommitte.setText(numberOfPaperCommitteCol.getCellData(index) + " ورقة");

        idCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        courseCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        dateCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        numberOfRoomCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        numberOfPaperCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");

        if(addChilderenCommitte) {
            addChilderenCommitte = false;
            committeTakenHbox.getChildren().add(numberOfRoomCommitte);
            committeTakenHbox.getChildren().add(numberOfPaperCommitte);
            committeTakenHbox.getChildren().add(dateCommitte);
            committeTakenHbox.getChildren().add(courseCommitte);
            committeTakenHbox.getChildren().add(idCommitte);
        }
    }
    @FXML
    public void addGroup() throws IOException {
        FXMLLoader fxml = new FXMLLoader();
        try {
            fxml.setLocation(getClass().getResource("groupFormHbox.fxml"));
            HboxGroup = fxml.load();
        } catch (IOException e) {
               log.logException(e);
        }

        groupsForm.getChildren().add(HboxGroup);
    }
    @FXML
    public void addPaperMovementRecord(){
        // verify input like doctor id, committe id ... , to avoid replicated data

        groupsForm.getChildren().forEach(HboxGroup -> {
            ((HBox) HboxGroup).getChildren().forEach(input -> {
                if (input instanceof TextField){
                    String a = ((TextField) input).getText();
                    arrayHboxTextField.add(a);
                    countHboxItems++;
                }
                if (input instanceof ChoiceBox<?>){
                    String b = ((ChoiceBox<String>) input).getValue();
                    arrayHboxChoice.add(b);
                }
            });
        });

        for (int i=0;i < countHboxItems ; i++) {
         if(!arrayHboxChoice.get(i).equals("") | !arrayHboxTextField.get(i).equals("") ){
             paperModel.insert(new answerPaperMovementTable(Integer.parseInt(committeId), Integer.parseInt(recentId),
                     dateCommitteReciveDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                     arrayHboxTextField.get(i), arrayHboxChoice.get(i))
             );
         }
        }
        paperModel.store();

        // cancle all input and options
        cancleAllInput();
    }
    @FXML
    public void cancleAllInput(){
        doctorNameTakenHbox.getChildren().clear();
        committeTakenHbox.getChildren().clear();

        addChilderen = true;
        addChilderenCommitte = true;

        groupsForm.getChildren().forEach(HboxGroup -> {
            ((HBox) HboxGroup).getChildren().clear();
        });
        groupsForm.getChildren().clear();

        arrayHboxChoice.clear();
        arrayHboxTextField.clear();
        countHboxItems = 0;
    }
}
