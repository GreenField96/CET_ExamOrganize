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

public class addPaperMovementReciveController implements Initializable {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField courseTextField;
    @FXML
    private DatePicker dateCommitteReciveDatePicker;
    @FXML
    private TableView<CommitteTable> committeTableView;
    @FXML
    private TableColumn<CommitteTable,Integer> idCommitteCol;
    @FXML
    private TableColumn<CommitteTable,Integer> doctorReciveCommitteCol;
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
    VBox committeTakenVbox;
    HBox committeTakenHboxChild;
    Label periodLabelCommitte,doctorReciveCommitte,specificCommitte,courseCommitte,dateCommitte,numberOfRoomCommitte,numberOfPaperCommitte,groupsCommitte;
    @FXML
    private ChoiceBox<String> groupNumberChoiceBox,specificChoiceBox,semesterPeriodChoiceBox,yearChoiceBox;
    @FXML
    private TextField searchCourseTextField;
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
    private ArrayList<CommitteTable> Committes = new ArrayList<>();
    private CommitteModel comm = new CommitteModel();
    private answerPaperMovementModel paperModel = new answerPaperMovementModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateCommitteReciveDatePicker.setValue(LocalDate.now());

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
    public void querySearchOnCommitte() throws SQLException {
        Committes.clear();

        Committes = comm.selectSpecificData(courseTextField.getText(),groupNumberChoiceBox.getValue(),specificChoiceBox.getValue(),semesterPeriodChoiceBox.getValue(),yearChoiceBox.getValue(),false);

        idCommitteCol.setCellValueFactory(new PropertyValueFactory<>("IdCol"));
        doctorReciveCommitteCol.setCellValueFactory(new PropertyValueFactory<>("DoctorName"));
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
        doctorReciveCommitte = new Label();

        committeTakenHboxChild = new HBox();
        committeTakenHboxChild.setStyle("-fx-alignment:center;");
        recentId = String.valueOf(Committes.get(0).getDoctorId());

        periodLabelCommitte.setText(String.valueOf(periodCommitteCol.getCellData(index)));
        doctorReciveCommitte.setText(String.valueOf(doctorReciveCommitteCol.getCellData(index)));
        courseCommitte.setText(courseCommitteCol.getCellData(index));
        dateCommitte.setText(dateCommitteCol.getCellData(index));
        numberOfRoomCommitte.setText(numberOfRoomCommitteCol.getCellData(index));
        numberOfPaperCommitte.setText(String.valueOf(numberOfPaperCommitteCol.getCellData(index)) + " ورقة");
        groupsCommitte.setText("المجموعة: " + groupCommitteCol.getCellData(index));
        specificCommitte.setText(specificCommitteCol.getCellData(index));

        periodLabelCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        doctorReciveCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
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
        committeTakenHboxChild.getChildren().add(doctorReciveCommitte);
        committeTakenVbox.getChildren().add(committeTakenHboxChild);

        answerPaperMovementList.add(new answerPaperMovementTable(idCommitteCol.getCellData(index),Integer.parseInt(recentId),session.getId(),
                dateCommitteReciveDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                String.valueOf(numberOfPaperCommitteCol.getCellData(index)),specificCommitteCol.getCellData(index),groupNumberChoiceBox.getValue() ));
    }

    @FXML
    public void addPaperMovementRecord(){
        answerPaperMovementList.forEach(answerPaperMovementTable -> {
            paperModel.insert(new answerPaperMovementTable(answerPaperMovementTable.getCommitteIdCol(),answerPaperMovementTable.getHeHadCol(),session.getId(),
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
        committeTakenVbox.getChildren().clear();

        answerPaperMovementList.clear();

        courseTextField.clear();
    }
}
