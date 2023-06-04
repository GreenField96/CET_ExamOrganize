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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

 public class addCommitteController  implements Initializable{
    private static ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TableView<EmployeeTable> EmployeeTableView;
    @FXML
    private TableColumn<EmployeeTable,Integer> idEmployeeCol;
    @FXML
    private TableColumn<EmployeeTable, String> nameEmployeeCol;
    @FXML
    private TableColumn<EmployeeTable, String> phoneNumberEmployeeCol;
    @FXML
    private TableColumn<EmployeeTable, String> workAsEmployeeCol;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ChoiceBox<String> semesterChoiceBox,specificChoiceBox,groupNumberChoiceBox,poeriodChoiceBox,semesterPeriodChoiceBox,yearChoiceBox;
    @FXML
    private TextField classNumberTextField,numberPaperTextField,searchTextField;
    @FXML
    private TextField idStudentNnmberTextField,phoneNumberStudentTextField,nameStudentTextField,searchCourseTextField;
    @FXML
    private TextArea noteOnStudentTextField;
    @FXML
    private VBox nameTakenVbox1,nameTakenVbox2,nameTakenVbox3;
    private HBox nameChoiceHbox1,nameChoiceHbox2=new HBox(),nameChoiceHbox3=new HBox();
    @FXML
    private HBox courseNameTakenHbox;
    @FXML
    private VBox idNumberTakenVbox1,idNumberTakenVbox2,idNumberTakenVbox3;
    ObservableList<EmployeeTable> ObservableArrayEmployee;
    private ArrayList<EmployeeTable> Employees;
    private EmployeeModel emp;
    private Label monitorName;
    private Label studentName;
    private ArrayList<EmployeeTable> MonitorsList;
    private ArrayList<studentAbsenceTable> students;
    private CommitteModel commModel = new CommitteModel();
    private int counterMonitors=0,counterStudentAbsence = 0;
    public boolean deleteStudentFlag = true;
    public boolean deleteMonitorFlag = true;
     @FXML
     private TableView<CourseTable> CoursesTableView;
     @FXML
     private TableColumn<CourseTable,Integer> courseId;
     @FXML
     private TableColumn<CourseTable, String> courseName;
     @FXML
     private TableColumn<CourseTable, String> courseNumber;
     ObservableList<CourseTable> ObservableArrayCourse;
     private ArrayList<CourseTable> Courses;
     int IdRow;
     String NameRow,courseNumberRow;
     CourseModel courseModel;
     boolean addChilderen = true;
     public Label courseNameLabel = new Label() , courseNumberLabel = new Label();
     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        poeriodChoiceBox.setValue("09:00-11:00");
        poeriodChoiceBox.getItems().add("09:00-11:00");
        poeriodChoiceBox.getItems().add("11:30-13:30");

        dateDatePicker.setValue(LocalDate.now());

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

        emp = new EmployeeModel();
        Employees = new ArrayList<>();
        courseModel = new CourseModel();
        Courses = new ArrayList<>();
        MonitorsList = new ArrayList<>();
    }
    @FXML
    public void searchOnEmployeeTable() throws SQLException {
        Employees.clear();
        Employees = emp.searchOnTable(searchTextField.getText());
        idEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        workAsEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Work_as"));
        phoneNumberEmployeeCol.setCellValueFactory(new PropertyValueFactory<>("Phone_number"));
        ObservableArrayEmployee =  FXCollections.observableArrayList(Employees);
        EmployeeTableView.setItems(ObservableArrayEmployee);
    }
    @FXML
    public void getُEmployeeId(MouseEvent value){
        Integer index = EmployeeTableView.getSelectionModel().getSelectedIndex();
        monitorName = new Label();

        monitorName.setText(nameEmployeeCol.getCellData(index));
        monitorName.setStyle("-fx-opacity:0.7;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 14;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:  #398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1");

        MonitorsList.add(new EmployeeTable(idEmployeeCol.getCellData(index),nameEmployeeCol.getCellData(index)));

        monitorName.setOnMouseClicked(MouseEvent -> {
            deleteMonitorFlag = true;
            for (EmployeeTable monitor : MonitorsList){
                 if(MouseEvent.getSource().toString().contains(monitor.getName()) & deleteMonitorFlag) {
                     monitor.setId(-1);
                    deleteMonitorFlag = false;
                }
            }
            if(nameTakenVbox1.getChildren().contains(MouseEvent.getSource())) {
                nameTakenVbox1.getChildren().remove(MouseEvent.getSource());
            } else if(nameTakenVbox2.getChildren().contains(MouseEvent.getSource())) {
                nameTakenVbox2.getChildren().remove(MouseEvent.getSource());
            } else if(nameTakenVbox3.getChildren().contains(MouseEvent.getSource())) {
                nameTakenVbox3.getChildren().remove(MouseEvent.getSource());
            }
        });
        if(counterMonitors == 0) {
            nameTakenVbox1.getChildren().add(monitorName);
            counterMonitors++;
        } else if (counterMonitors == 1) {
            nameTakenVbox2.getChildren().add(monitorName);
            counterMonitors++;
        }else {
            nameTakenVbox3.getChildren().add(monitorName);
            counterMonitors = 0;
        }
    }
    @FXML
    public void addStudentAbsence(){
        students = commModel.getStudentAbsence();
        studentName = new Label();
        studentName.setText(idStudentNnmberTextField.getText());
        studentName.setStyle("-fx-opacity:0.5;"+"-fx-border-width:4;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 14;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:  #398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1");
        studentName.setOnMouseClicked(MouseEvent -> {
            deleteStudentFlag = true;
            for (studentAbsenceTable student : students) {
                if(MouseEvent.getSource().toString().contains(String.valueOf(student.getStudentIdCol())) & deleteStudentFlag) {
                    student.setStudentIdCol(-1);
                    deleteStudentFlag = false;
                }
            }
            if(idNumberTakenVbox1.getChildren().contains(MouseEvent.getSource())) {
                idNumberTakenVbox1.getChildren().remove(MouseEvent.getSource());
            } else if(idNumberTakenVbox2.getChildren().contains(MouseEvent.getSource())) {
                idNumberTakenVbox2.getChildren().remove(MouseEvent.getSource());
            } else if(idNumberTakenVbox3.getChildren().contains(MouseEvent.getSource())) {
                idNumberTakenVbox3.getChildren().remove(MouseEvent.getSource());
            }
        });
        if(counterStudentAbsence == 0) {
            idNumberTakenVbox1.getChildren().add(studentName);
            counterStudentAbsence++;
        } else if (counterStudentAbsence == 1) {
            idNumberTakenVbox2.getChildren().add(studentName);
            counterStudentAbsence++;
        }else {
        idNumberTakenVbox3.getChildren().add(studentName);
        counterStudentAbsence = 0;
        }
        commModel.insert(new studentAbsenceTable(Integer.parseInt(idStudentNnmberTextField.getText()),nameStudentTextField.getText(),phoneNumberStudentTextField.getText(),
                groupNumberChoiceBox.getValue(),noteOnStudentTextField.getText()));

        idStudentNnmberTextField.setText("");
        nameStudentTextField.setText("");
        groupNumberChoiceBox.setValue("الاولى");
        phoneNumberStudentTextField.setText("");
        noteOnStudentTextField.setText("");
    }
    @FXML
    public void addFullCommitte() throws IOException {
        commModel.insert(new CommitteTable(
                classNumberTextField.getText(),dateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                IdRow,semesterChoiceBox.getValue(),numberPaperTextField.getText(),specificChoiceBox.getValue(),poeriodChoiceBox.getValue(),
                yearChoiceBox.getValue(),semesterPeriodChoiceBox.getValue()
        ));

        commModel.store(MonitorsList);
        cancleAllInputCommitte();
    }
     @FXML
     public void cancleAllInputCommitte(){
         // clear all the input Field & Choice Field
         idStudentNnmberTextField.setText("");
         nameStudentTextField.setText("");
         groupNumberChoiceBox.setValue("الاولى");
         phoneNumberStudentTextField.setText("");
         noteOnStudentTextField.setText("");
         classNumberTextField.setText("");
         specificChoiceBox.setValue("عام");
         semesterChoiceBox.setValue("تمهيدي");
         numberPaperTextField.setText("");
         idNumberTakenVbox1.getChildren().clear();
         idNumberTakenVbox2.getChildren().clear();
         idNumberTakenVbox3.getChildren().clear();
         nameTakenVbox1.getChildren().clear();
         nameTakenVbox2.getChildren().clear();
         nameTakenVbox3.getChildren().clear();

         if(MonitorsList != null) {
             MonitorsList.clear();
         }
         if(students != null) {
             students.clear();
         }
         addChilderen = true;
         courseNameTakenHbox.getChildren().clear();
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
         IdRow = courseId.getCellData(index);

         NameRow = courseName.getCellData(index);
         courseNumberRow = courseNumber.getCellData(index);

         courseNameLabel.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 60 1 60");
         courseNumberLabel.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 90 1 90");
         courseNameLabel.setText(NameRow);
         courseNumberLabel.setText(courseNumberRow);

         if(addChilderen) {
             addChilderen = false;
             courseNameTakenHbox.getChildren().add(courseNameLabel);
             courseNameTakenHbox.getChildren().add(courseNumberLabel);
         }

     }
}
