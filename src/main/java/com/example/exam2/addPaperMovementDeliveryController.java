package com.example.exam2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addPaperMovementDeliveryController implements Initializable {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField searchInput,courseTextField,classTextField,searchCourseTextField;
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
    @FXML
    HBox doctorNameTakenHbox;
    @FXML
    VBox committeTakenVbox;
    HBox committeTakenHboxChild;
    Label doctorName=new Label(),doctorPhoneNumber=new Label(),periodLabelCommitte,courseCommitte,dateCommitte,numberOfRoomCommitte,numberOfPaperCommitte,groupsCommitte,specificCommitte;
    boolean addChilderen = true ;
    @FXML
    private ChoiceBox<String> groupNumberChoiceBox,specificChoiceBox,semesterPeriodChoiceBox,yearChoiceBox,poeriodChoiceBox;
    private String recentId;
    private ArrayList<answerPaperMovementTable> answerPaperMovementList = new ArrayList<>();
    @FXML
    private TableView<CourseTable> CoursesTableView;
    @FXML
    private TableColumn<CourseTable,Integer> courseId;
    @FXML
    private TableColumn<CourseTable, String> courseName;
    @FXML
    private TableColumn<CourseTable, String> courseNumber;
    ObservableList<CourseTable> ObservableArrayCourse;
    private ArrayList<CourseTable> Courses = new ArrayList<>();
    private CourseModel courseModel = new CourseModel();
    private ArrayList<EmployeeTable> Employees = new ArrayList<>();
    private ArrayList<CommitteTable> Committes = new ArrayList<>();
    private EmployeeModel emp = new EmployeeModel();
    private CommitteModel comm = new CommitteModel();
    private answerPaperMovementModel paperModel = new answerPaperMovementModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateCommitteReciveDatePicker.setValue(LocalDate.now());


        specificChoiceBox.setValue("عام");
        specificChoiceBox.getItems().add("عام");
        specificChoiceBox.getItems().add("تمهيدي");
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

        poeriodChoiceBox.setValue("09:00-11:00");
        poeriodChoiceBox.getItems().add("09:00-11:00");
        poeriodChoiceBox.getItems().add("11:30-13:30");

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

        Committes = comm.selectSpecificData(courseTextField.getText(),groupNumberChoiceBox.getValue(),specificChoiceBox.getValue(),poeriodChoiceBox.getValue(),classTextField.getText(),semesterPeriodChoiceBox.getValue(),yearChoiceBox.getValue(),true);

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

        periodLabelCommitte = new Label();
        courseCommitte = new Label();
        dateCommitte = new Label();
        numberOfRoomCommitte = new Label();
        numberOfPaperCommitte = new Label();
        groupsCommitte = new Label();
        specificCommitte = new Label();

        committeTakenHboxChild = new HBox();
        committeTakenHboxChild.setStyle("-fx-alignment:center;");

        periodLabelCommitte.setText(String.valueOf(periodCommitteCol.getCellData(index)));
        courseCommitte.setText(courseCommitteCol.getCellData(index));
        dateCommitte.setText(dateCommitteCol.getCellData(index));
        numberOfRoomCommitte.setText(numberOfRoomCommitteCol.getCellData(index));
        numberOfPaperCommitte.setText(String.valueOf(numberOfPaperCommitteCol.getCellData(index)) + " ورقة");
        groupsCommitte.setText("المجموعة: " + groupCommitteCol.getCellData(index));
        specificCommitte.setText(specificCommitteCol.getCellData(index));

        periodLabelCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        courseCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        dateCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        numberOfRoomCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        numberOfPaperCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        groupsCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        specificCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");


        committeTakenHboxChild.getChildren().add(numberOfRoomCommitte);
        committeTakenHboxChild.getChildren().add(numberOfPaperCommitte);
        committeTakenHboxChild.getChildren().add(groupsCommitte);
        committeTakenHboxChild.getChildren().add(dateCommitte);
        committeTakenHboxChild.getChildren().add(periodLabelCommitte);
        committeTakenHboxChild.getChildren().add(courseCommitte);
        committeTakenHboxChild.getChildren().add(specificCommitte);

        committeTakenVbox.getChildren().add(committeTakenHboxChild);

        answerPaperMovementList.add(new answerPaperMovementTable(idCommitteCol.getCellData(index),session.getId(),Integer.parseInt(recentId),
                dateCommitteReciveDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                String.valueOf(numberOfPaperCommitteCol.getCellData(index)),specificCommitteCol.getCellData(index),groupNumberChoiceBox.getValue() ));
    }

    @FXML
    public void addPaperMovementRecord(){
        answerPaperMovementList.forEach(answerPaperMovementTable -> {
            paperModel.insert(new answerPaperMovementTable(answerPaperMovementTable.getCommitteIdCol(),session.getId(),Integer.parseInt(recentId),
                    answerPaperMovementTable.getDateCol(),answerPaperMovementTable.getNumberPaperRecivedCol(),answerPaperMovementTable.getSpecificCol(),answerPaperMovementTable.getGroupCol()));
        });

        paperModel.store();

        cancleAllInput();
    }
    @FXML
    public void searchOnCourseTable() throws SQLException {
        Courses.clear();
        Courses = courseModel.searchOnTable(searchCourseTextField.getText());

        courseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        courseNumber.setCellValueFactory(new PropertyValueFactory<>("CourseNumber"));
        ObservableArrayCourse =  FXCollections.observableArrayList(Courses);
        CoursesTableView.setItems(ObservableArrayCourse);
    }
    @FXML
    public void getCourseId(MouseEvent value){
        Integer index = CoursesTableView.getSelectionModel().getSelectedIndex();

        courseTextField.setText(courseName.getCellData(index));

    }
    @FXML
    public void cleanMonitorsData(){
        committeTakenVbox.getChildren().clear();
        answerPaperMovementList.clear();
    }
    @FXML
    public void cancleAllInput(){
        doctorNameTakenHbox.getChildren().clear();
        committeTakenVbox.getChildren().clear();

        addChilderen = true;

        answerPaperMovementList.clear();

        courseTextField.clear();

        ObservableArrayEmployee.clear();
        ObservableArrayCourse.clear();
        ObservableArrayCommitte.clear();

    }
}
