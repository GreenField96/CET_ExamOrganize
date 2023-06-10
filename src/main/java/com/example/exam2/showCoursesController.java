package com.example.exam2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class showCoursesController implements Initializable{
    private static ExceptionLogger log = ExceptionLogger.getInstance();
    @FXML
    private TextField searchInput;
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
    @FXML
    private TextField courseNameTextField,courseNumberTextField;
    int IdRow;
    String NameRow,courseNumberRow;
    CourseModel courseModel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseModel = new CourseModel();
        Courses = new ArrayList<>();
    }
    @FXML
    public void querySearch() throws SQLException {
        Courses.clear();
        Courses = courseModel.searchOnTable(searchInput.getText());

        courseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        courseNumber.setCellValueFactory(new PropertyValueFactory<>("CourseNumber"));
        ObservableArrayCourse =  FXCollections.observableArrayList(Courses);
        CoursesTableView.setItems(ObservableArrayCourse);
//        Courses.clear();
    }
    @FXML
    public void getId(MouseEvent value){
        Integer index = CoursesTableView.getSelectionModel().getSelectedIndex();
        IdRow = courseId.getCellData(index);

        NameRow = courseName.getCellData(index);
        courseNameTextField.setText(courseName.getCellData(index));

        courseNumberRow = courseNumber.getCellData(index);
        courseNumberTextField.setText(courseNumber.getCellData(index));
     }
    @FXML
    public void updateCourseData(ActionEvent event) throws SQLException {
        courseModel.update(IdRow,courseNameTextField.getText(),courseNumberTextField.getText());
        querySearch();

        cleanCourseData();
    }
    @FXML
    public void addCourseData(ActionEvent event) throws SQLException {
        Courses.clear();
        courseModel.insert(new CourseTable(IdRow,courseNameTextField.getText(),courseNumberTextField.getText()));
        courseModel.store();
        querySearch();

        cleanCourseData();
    }

    @FXML
    public void deleteCourseData(ActionEvent event) throws SQLException {
        courseModel.delete(IdRow);
        querySearch();

        cleanCourseData();
    }
    @FXML
    public void cleanCourseData(){
        courseNameTextField.setText("");
        courseNumberTextField.setText("");
        Courses.clear();

        ObservableArrayCourse.clear();
    }
}