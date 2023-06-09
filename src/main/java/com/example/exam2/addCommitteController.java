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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

 public class addCommitteController implements Initializable{
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
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
    private ChoiceBox<String> groupNumberChoiceBox,poeriodChoiceBox,semesterPeriodChoiceBox,yearChoiceBox,MonitorTransportPaperChoiceBox,specificChoiceBox;
    @FXML
    private TextField classNumberTextField,searchTextField,numberPaperTextField;
    @FXML
    private TextField idStudentNnmberTextField,phoneNumberStudentTextField,nameStudentTextField,searchCourseTextField;
    @FXML
    private TextArea noteOnStudentTextField;
    private HBox nameChoiceHbox2=new HBox(),nameChoiceHbox3=new HBox(),HboxGroup;
    @FXML
    private HBox courseNameTakenHbox;
    @FXML
    private VBox idNumberTakenVbox1,idNumberTakenVbox2,idNumberTakenVbox3;
    @FXML
    private VBox nameTakenVbox1,nameTakenVbox2,nameTakenVbox3,groupsForm;
    ObservableList<EmployeeTable> ObservableArrayEmployee;
    private ArrayList<EmployeeTable> Employees;
    private EmployeeModel emp;
    private Label studentName;
    private ArrayList<EmployeeTable> MonitorsList;
    private ArrayList<studentAbsenceTable> students;
    private CommitteModel commModel = new CommitteModel();
    private int counterMonitors=0,counterStudentAbsence = 0;
    public boolean deleteStudentFlag = true;
    public boolean MonitorFlag = false;
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
    int IdRow;
    String NameRow,courseNumberRow;
    private CourseModel courseModel = new CourseModel();
    boolean addChilderen = true;
    private CheckBox checkAbsenceMonitor;
    public Label courseNameLabel = new Label() , courseNumberLabel = new Label();
    private ArrayList<String> arrayHboxChoice = new ArrayList<>();
    private ArrayList<String> arrayHboxTextField = new ArrayList<>();
    private ArrayList<String> arrayHboxSpecificChoiceBox = new ArrayList<>();
    private int countHboxItems=0;
    private answerPaperMovementModel paperModel = new answerPaperMovementModel();
    private Alert alert;


     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        MonitorTransportPaperChoiceBox.setValue("اسم الملاحظ");


        specificChoiceBox.setValue("عام");
        specificChoiceBox.getItems().add("عام");
        specificChoiceBox.getItems().add("حاسب ألي");
        specificChoiceBox.getItems().add("تحكم ألي");
        specificChoiceBox.getItems().add("اتصالات");

        emp = new EmployeeModel();
        Employees = new ArrayList<>();
        MonitorsList = new ArrayList<>();

        try {
            addGroup();
        } catch (IOException e) {
            log.logException(e);
        }
         alert = new Alert(Alert.AlertType.NONE);
         alert.setTitle("خطأ");
         alert.setAlertType(Alert.AlertType.INFORMATION);
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

        MonitorFlag = false;
        for (EmployeeTable monitor : MonitorsList){
            if(nameEmployeeCol.getCellData(index).equals(monitor.getName())) {
                MonitorFlag = true;
            }
        }
        if(!MonitorFlag) {
            checkAbsenceMonitor = new CheckBox(nameEmployeeCol.getCellData(index));
            checkAbsenceMonitor.setSelected(true);
            checkAbsenceMonitor.setStyle("-fx-opacity:0.7;" + "-fx-border-width:1.5;" + "-fx-border-color:#FFFF;" + "-fx-border-radius:5;" + "-fx-font-size: 14;" + "-fx-alignment:center;" + "-fx-background-radius:10;" + "-fx-background-color:  #398AB9;" + "-fx-text-fill: #FFFF;" + "-fx-padding: 1");
            MonitorsList.add(new EmployeeTable(idEmployeeCol.getCellData(index), nameEmployeeCol.getCellData(index),checkAbsenceMonitor.isSelected()));
        }

        checkAbsenceMonitor.setOnMouseClicked(MouseEvent -> {
            for (EmployeeTable monitor : MonitorsList){
                if(MouseEvent.getSource().toString().contains(monitor.getName())) {
                    monitor.setAbsence(false);
                }
            }
        });

        if(counterMonitors == 0) {
            nameTakenVbox1.getChildren().add(checkAbsenceMonitor);
            counterMonitors++;
        } else if (counterMonitors == 1) {
            nameTakenVbox2.getChildren().add(checkAbsenceMonitor);
            counterMonitors++;
        }else {
            nameTakenVbox3.getChildren().add(checkAbsenceMonitor);
            counterMonitors = 0;
        }

    }
    @FXML
    public void addMonitorsCheckBox(){
        MonitorTransportPaperChoiceBox.getItems().clear();
        for (EmployeeTable monitor : MonitorsList){
            if(monitor.isAbsence()) {
                MonitorTransportPaperChoiceBox.getItems().add(monitor.getName());
            }
        }
    }
     @FXML
     public void cleanMonitorsData(){
         MonitorTransportPaperChoiceBox.getItems().clear();
         nameTakenVbox1.getChildren().clear();
         nameTakenVbox2.getChildren().clear();
         nameTakenVbox3.getChildren().clear();
         MonitorsList.clear();
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
        commModel.insert(new studentAbsenceTable(Integer.parseInt(idStudentNnmberTextField.getText()),nameStudentTextField.getText(),phoneNumberStudentTextField.getText(),specificChoiceBox.getValue(),
                groupNumberChoiceBox.getValue(),noteOnStudentTextField.getText()));

        idStudentNnmberTextField.setText("");
        nameStudentTextField.setText("");
        groupNumberChoiceBox.setValue("الاولى");
        phoneNumberStudentTextField.setText("");
        noteOnStudentTextField.setText("");
    }
    public int getMonitorIdByName(){
        for (EmployeeTable monitor : MonitorsList){
            if(monitor.getName().equals(MonitorTransportPaperChoiceBox.getValue())) {
                return monitor.getId();
            }
        }
        return -1;
    }
    @FXML
    public void addFullCommitte() throws IOException {

        if(getMonitorIdByName() == -1){
            alert.setContentText("قم بأختيار المراقب الدي تم الاستلام منه");
            alert.show();
            return;
        }

         commModel.insert(new CommitteTable(
                classNumberTextField.getText(),dateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                IdRow,numberPaperTextField.getText(),poeriodChoiceBox.getValue(),
                yearChoiceBox.getValue(),semesterPeriodChoiceBox.getValue()
        ));

        int idCommitteLastRow = commModel.store(MonitorsList);

        // verify input like doctor id, committe id ... , to avoid replicated data
        groupsForm.getChildren().forEach(HboxGroup -> {
            ((HBox) HboxGroup).getChildren().forEach(input -> {
                if (input instanceof TextField){
                    String a = ((TextField) input).getText();
                    arrayHboxTextField.add(a);
                    countHboxItems++;
                }
                if (input instanceof ChoiceBox<?>) {
                    String b = ((ChoiceBox<String>) input).getValue();
                    if (b == "اتصالات" | b == "تحكم ألي" | b == "حاسب ألي" | b == "عام") {
                        arrayHboxSpecificChoiceBox.add(b);
                    }else{
                        arrayHboxChoice.add(b);
                    }
                }

            });
        });

        for (int i=0;i < countHboxItems ; i++) {
            if(!arrayHboxChoice.get(i).equals("") | !arrayHboxTextField.get(i).equals("") ){
                paperModel.insert(new answerPaperMovementTable(idCommitteLastRow,getMonitorIdByName(),session.getId(),
                        dateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        arrayHboxTextField.get(i), arrayHboxSpecificChoiceBox.get(i),arrayHboxChoice.get(i))
                );
            }
        }
        paperModel.store();

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

         groupsForm.getChildren().forEach(HboxGroup -> {
             ((HBox) HboxGroup).getChildren().clear();
         });
         groupsForm.getChildren().clear();
         countHboxItems=0;
         arrayHboxChoice.clear();

         try {
             addGroup();
         } catch (IOException e) {
             log.logException(e);
         }// create ane block of group CheckList

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
