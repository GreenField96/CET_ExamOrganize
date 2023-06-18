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
import java.util.Optional;
import java.util.ResourceBundle;

public class addPaperMovementReciveController implements Initializable {
    private static final ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField courseTextField,classTextField;
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
    Label idCommitte,periodLabelCommitte,doctorReciveCommitte,specificCommitte,courseCommitte,dateCommitte,numberOfRoomCommitte,groupsCommitte;
    @FXML
    private ChoiceBox<String> classNameChoiceBox,groupNumberChoiceBox,specificChoiceBox,semesterPeriodChoiceBox,yearChoiceBox,poeriodChoiceBox;
    private TextField numberOfPaperTextField;
    private String recentId;
    private ArrayList<answerPaperMovementTable> answerPaperMovementList = new ArrayList<>();
    private ArrayList<CourseTable> Courses = new ArrayList<>();
    private CourseModel courseModel = new CourseModel();
    private ArrayList<CommitteTable> Committes = new ArrayList<>();
    private CommitteModel comm = new CommitteModel();
    private answerPaperMovementModel paperModel = new answerPaperMovementModel();
    private Alert alert;
    private int countOfRecive = 0;

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

        alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("خطأ");
        alert.setAlertType(Alert.AlertType.INFORMATION);

        classNameChoiceBox.setValue("");
    }
    @FXML
    public void querySearchOnCommitte() throws SQLException {

        if(classTextField.getText().equals("") | classNameChoiceBox.getValue().equals("")){
            alert.setContentText("الرجاء ادخال جميع الخانات");
            alert.show();
            return;
        }

        Committes.clear();

        Committes = comm.selectSpecificData(classNameChoiceBox.getValue(),groupNumberChoiceBox.getValue(),specificChoiceBox.getValue(),poeriodChoiceBox.getValue(),classTextField.getText(),semesterPeriodChoiceBox.getValue(),yearChoiceBox.getValue(),false);

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

        if(committeTableView.getSelectionModel().getSelectedIndex() < 0){
            return;
        }
        Integer index = committeTableView.getSelectionModel().getSelectedIndex();

        idCommitte = new Label();
        periodLabelCommitte = new Label();
        courseCommitte = new Label();
        dateCommitte = new Label();
        numberOfRoomCommitte = new Label();
        groupsCommitte = new Label();
        specificCommitte = new Label();
        doctorReciveCommitte = new Label();
        numberOfPaperTextField = new TextField();


        committeTakenHboxChild = new HBox();
        committeTakenHboxChild.setStyle("-fx-alignment:center;");
        recentId = String.valueOf(Committes.get(0).getDoctorId());

        idCommitte.setText(String.valueOf(idCommitteCol.getCellData(index)));
        periodLabelCommitte.setText(String.valueOf(periodCommitteCol.getCellData(index)));
        doctorReciveCommitte.setText(String.valueOf(doctorReciveCommitteCol.getCellData(index)));
        courseCommitte.setText(courseCommitteCol.getCellData(index));
        dateCommitte.setText(dateCommitteCol.getCellData(index));
        numberOfRoomCommitte.setText(numberOfRoomCommitteCol.getCellData(index));
        numberOfPaperTextField.setText(String.valueOf(numberOfPaperCommitteCol.getCellData(index)));
        groupsCommitte.setText(groupCommitteCol.getCellData(index));
        specificCommitte.setText(specificCommitteCol.getCellData(index));

        idCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        periodLabelCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        doctorReciveCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        courseCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        dateCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        numberOfPaperTextField.setStyle("-fx-opacity:1;"+"-fx-border-width:0.5;"+"-fx-border-color:black;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:White;"+"-fx-padding: 1 10 1 10");
        numberOfRoomCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        groupsCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");
        specificCommitte.setStyle("-fx-opacity:0.8;"+"-fx-border-width:0.5;"+"-fx-border-color:#FFFF;"+"-fx-border-radius:10;"+"-fx-font-size: 15;"+"-fx-alignment:center;"+"-fx-background-radius:10;"+"-fx-background-color:#398AB9;"+"-fx-text-fill: #FFFF;"+"-fx-padding: 1 10 1 10");

        committeTakenHboxChild.getChildren().add(idCommitte);
        committeTakenHboxChild.getChildren().add(numberOfRoomCommitte);
        committeTakenHboxChild.getChildren().add(numberOfPaperTextField);
        committeTakenHboxChild.getChildren().add(groupsCommitte);
        committeTakenHboxChild.getChildren().add(dateCommitte);
        committeTakenHboxChild.getChildren().add(periodLabelCommitte);
        committeTakenHboxChild.getChildren().add(courseCommitte);
        committeTakenHboxChild.getChildren().add(specificCommitte);

        committeTakenHboxChild.getChildren().add(doctorReciveCommitte);
        committeTakenVbox.getChildren().add(committeTakenHboxChild);

    }

    @FXML
    public void addPaperMovementRecord(){
        if(committeTakenVbox.getChildren().isEmpty()){
            alert.setContentText("الرجاء اختيار اللجنة او اللجان المراد تسليمها");
            alert.show();
            return;
        }
        // verify
        countOfRecive = 0;

        committeTakenVbox.getChildren().forEach( box -> {
            HBox H = (HBox) box;

            answerPaperMovementTable cloumnAnswerPaper = new answerPaperMovementTable();

            cloumnAnswerPaper.setHeHadCol(Integer.parseInt(recentId));
            cloumnAnswerPaper.setHeHaveCol(session.getId());
            cloumnAnswerPaper.setDateCol(dateCommitteReciveDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            if(H.getChildren().get(0) instanceof Label) {
                Label l = (Label) H.getChildren().get(0);
                cloumnAnswerPaper.setCommitteIdCol(Integer.parseInt(l.getText()));
            }
            if(H.getChildren().get(2) instanceof TextField) {
                TextField l = (TextField) H.getChildren().get(2);
                cloumnAnswerPaper.setNumberPaperRecivedCol(l.getText());
            }
            if(H.getChildren().get(3) instanceof Label) {
                Label l = (Label) H.getChildren().get(3);
                cloumnAnswerPaper.setGroupCol(l.getText());
            }
            if(H.getChildren().get(7) instanceof Label) {
                Label l = (Label) H.getChildren().get(7);
                cloumnAnswerPaper.setSpecificCol(l.getText());
            }
            paperModel.insert(cloumnAnswerPaper);
            countOfRecive++;
        });

        paperModel.store();

//        ButtonType yesButton = new ButtonType("حسنا");
//        ButtonType noButton = new ButtonType("لا");
//        alert.setContentText("هل تريد انشاء تقرير؟");
//        alert.getButtonTypes().setAll(yesButton,noButton);
//        Optional<ButtonType> resutlAction = alert.showAndWait();
//        if(resutlAction.get() == yesButton) {

            for (int i = 0; i < countOfRecive; i++) {
                try {
                    new ProcessBuilder("cmd", "/c", " start https://127.0.0.1/exam_organize/reports/reciveCreateReport.php?Recive_id=" + (paperModel.getLastRecord() - i)).inheritIO().start().waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        cancleAllInput();
    }
    @FXML
    public void searchOnCourseTable() throws SQLException {
        Courses.clear();
        classNameChoiceBox.getItems().clear();
        classNameChoiceBox.setValue("");

        if(courseTextField.getText().equals("")){
            alert.setContentText("الرجاء ادخال قيمة للبحت");
            alert.show();
            return;
        }

        Courses = courseModel.searchOnTable(courseTextField.getText());

        Courses.forEach(course -> {
            classNameChoiceBox.getItems().add(course.getCourseName());
        });

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

        committeTableView.getItems().clear();
    }
}
