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
    private TextField searchInput,courseTextField;
    @FXML
    private DatePicker dateCommitteReciveDatePicker;
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
    private TableColumn<CommitteTable,String> groupCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> dateCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> numberOfPaperCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> specificCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> numberOfRoomCommitteCol;
    @FXML
    private TableColumn<CommitteTable, String> periodCommitteCol;
    ObservableList<CommitteTable> ObservableArrayCommitte;
    private ArrayList<EmployeeTable> Employees;
    private EmployeeModel emp;
    private ArrayList<CommitteTable> Committes;
    private CommitteModel comm;
    @FXML
    HBox doctorNameTakenHbox;
    @FXML
    VBox committeTakenVbox;
    HBox committeTakenHboxChild;
    Label doctorName=new Label(),doctorPhoneNumber=new Label(),periodLabelCommitte,courseCommitte,dateCommitte,numberOfRoomCommitte,numberOfPaperCommitte;
    boolean addChilderen = true ;
    @FXML
    private ChoiceBox<String> groupNumberChoiceBox,semesterChoiceBox,specificChoiceBox,semesterPeriodChoiceBox,yearChoiceBox;
    private answerPaperMovementModel paperModel = new answerPaperMovementModel();
    private int countHboxItems=0;
    private String committeId,recentId;
    private ArrayList<String> arrayHboxTextField = new ArrayList<>();
    private ArrayList<String> arrayHboxChoice = new ArrayList<>();
    private ArrayList<answerPaperMovementTable> answerPaperMovementList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emp = new EmployeeModel();
        Employees = new ArrayList<>();
        Committes = new ArrayList<>();
        comm = new CommitteModel();
        dateCommitteReciveDatePicker.setValue(LocalDate.now());


        semesterChoiceBox.setValue("تمهيدي");
        semesterChoiceBox.getItems().add("تمهيدي");
        semesterChoiceBox.getItems().add("الأول");
        semesterChoiceBox.getItems().add("التاني");
        semesterChoiceBox.getItems().add("التالت");
        semesterChoiceBox.getItems().add("الرابع");
        semesterChoiceBox.getItems().add("الخامس");
        semesterChoiceBox.getItems().add("السادس");
        semesterChoiceBox.getItems().add("السابع");
        semesterChoiceBox.getItems().add("التامن");

        specificChoiceBox.setValue("عام");
        specificChoiceBox.getItems().add("عام");
        specificChoiceBox.getItems().add("حاسب ألي");
        specificChoiceBox.getItems().add("تحكم ألي");
        specificChoiceBox.getItems().add("اتصالات");

        groupNumberChoiceBox.setValue("الاولى");
        groupNumberChoiceBox.getItems().add("الاولى");
        groupNumberChoiceBox.getItems().add("التانية");
        groupNumberChoiceBox.getItems().add("التالتة");
        groupNumberChoiceBox.getItems().add("الرابعة");
        groupNumberChoiceBox.getItems().add("الخامسة");
        groupNumberChoiceBox.getItems().add("السادسة");
        groupNumberChoiceBox.getItems().add("السابعة");
        groupNumberChoiceBox.getItems().add("التامنة");
        groupNumberChoiceBox.getItems().add("التاسعة");
        groupNumberChoiceBox.getItems().add("العاشرة");
        groupNumberChoiceBox.getItems().add("الحادية عشرة");
        groupNumberChoiceBox.getItems().add("اثنا عشر");
        groupNumberChoiceBox.getItems().add("ثلاثة عشر");
        groupNumberChoiceBox.getItems().add("أربعة عشر");
        groupNumberChoiceBox.getItems().add("خمسة عشر");
        groupNumberChoiceBox.getItems().add("ستة عشر");
        groupNumberChoiceBox.getItems().add("سبعة عشر");
        groupNumberChoiceBox.getItems().add("ثمانية عشر");
        groupNumberChoiceBox.getItems().add("تسعة عشر");
        groupNumberChoiceBox.getItems().add("عشرون");

        yearChoiceBox.setValue(Integer.toString(LocalDate.now().getYear()));
        int intYear = LocalDate.now().getYear();
        intYear--;
        for (int i=0;i<=3;i++) {
            yearChoiceBox.getItems().add(Integer.toString(intYear++));
        }

        semesterPeriodChoiceBox.setValue("ربيعي");
        semesterPeriodChoiceBox.getItems().add("ربيعي");
        semesterPeriodChoiceBox.getItems().add("خريفي");
        semesterPeriodChoiceBox.getItems().add("صيفي");


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

//        groupNumberChoiceBox,semesterChoiceBox,specificChoiceBox,semesterPeriodChoiceBox,yearChoiceBox;

        Committes = comm.selectSpecificData(courseTextField.getText(),groupNumberChoiceBox.getValue(),semesterChoiceBox.getValue(), specificChoiceBox.getValue(),semesterPeriodChoiceBox.getValue(),yearChoiceBox.getValue());

        idCommitteCol.setCellValueFactory(new PropertyValueFactory<>("IdCol"));
        courseCommitteCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        groupCommitteCol.setCellValueFactory(new PropertyValueFactory<>("GroupCol"));
        dateCommitteCol.setCellValueFactory(new PropertyValueFactory<>("DateCol"));
        specificCommitteCol.setCellValueFactory(new PropertyValueFactory<>("SpecificCol"));
        numberOfRoomCommitteCol.setCellValueFactory(new PropertyValueFactory<>("ClassNumberCol"));
        numberOfPaperCommitteCol.setCellValueFactory(new PropertyValueFactory<>("NumberPapersReceivedCol"));
        periodCommitteCol.setCellValueFactory(new PropertyValueFactory<>("periodCol"));

        ObservableArrayCommitte =  FXCollections.observableArrayList(Committes);
        committeTableView.setItems(ObservableArrayCommitte);
    }
    @FXML
    public void getCommitteId(MouseEvent value){
        Integer index = committeTableView.getSelectionModel().getSelectedIndex();

        committeId = String.valueOf(idCommitteCol.getCellData(index));


        periodLabelCommitte = new Label();
        courseCommitte = new Label();
        dateCommitte = new Label();
        numberOfRoomCommitte = new Label();
        numberOfPaperCommitte = new Label();

        committeTakenHboxChild = new HBox();
        committeTakenHboxChild.setStyle("-fx-alignment:center;");

        periodLabelCommitte.setText(String.valueOf(periodCommitteCol.getCellData(index)));
        courseCommitte.setText(courseCommitteCol.getCellData(index));
        dateCommitte.setText(dateCommitteCol.getCellData(index));
        numberOfRoomCommitte.setText(numberOfRoomCommitteCol.getCellData(index));
        numberOfPaperCommitte.setText(String.valueOf(numberOfPaperCommitteCol.getCellData(index)) + " ورقة");

        periodLabelCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        courseCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        dateCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        numberOfRoomCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");
        numberOfPaperCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 30 1 30");

        committeTakenHboxChild.getChildren().add(numberOfRoomCommitte);
        committeTakenHboxChild.getChildren().add(numberOfPaperCommitte);
        committeTakenHboxChild.getChildren().add(dateCommitte);
        committeTakenHboxChild.getChildren().add(courseCommitte);
        committeTakenHboxChild.getChildren().add(periodLabelCommitte);
        committeTakenVbox.getChildren().add(committeTakenHboxChild);

        answerPaperMovementList.add(new answerPaperMovementTable(idCommitteCol.getCellData(index),session.getId(),Integer.parseInt(recentId),
                dateCommitteReciveDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                String.valueOf(numberOfPaperCommitteCol.getCellData(index)),groupNumberChoiceBox.getValue() ));
    }

    @FXML
    public void addPaperMovementRecord(){
        answerPaperMovementList.forEach(answerPaperMovementTable -> {
            paperModel.insert(new answerPaperMovementTable(answerPaperMovementTable.getCommitteIdCol(),session.getId(),Integer.parseInt(recentId),
                    answerPaperMovementTable.getDateCol(),answerPaperMovementTable.getNumberPaperRecivedCol(),answerPaperMovementTable.getGroupCol()));
        });

        paperModel.store();

        cancleAllInput();
    }
    @FXML
    public void cleanMonitorsData(){
        committeTakenVbox.getChildren().clear();
//        MonitorsList.clear();
    }
    @FXML
    public void cancleAllInput(){
        doctorNameTakenHbox.getChildren().clear();
        committeTakenVbox.getChildren().clear();

        addChilderen = true;

        arrayHboxChoice.clear();
        arrayHboxTextField.clear();
        countHboxItems = 0;

    }
}
