package com.example.exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel{
    final private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<CourseTable> Courses;
    CourseModel(){
        Courses = new ArrayList<>();
    }
    public ArrayList<CourseTable> searchOnTable(String searchKeyWord) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            // note: see library project on Github to take search query
            String query = "SELECT * FROM course_name WHERE courseName LIKE '%"+ searchKeyWord + "%' ";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                Courses.add(new CourseTable(
                        resultSet.getInt("id") ,
                        resultSet.getNString("courseName") ,
                        resultSet.getNString("courseNumber")
                ));
            }
        } catch (SQLException exception) {
            log.logException(exception);
        }
        return Courses;
    }
    public void store(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            //  Column: emp_no  birth_date 	first_name 	last_name 	gender 	hire_date
            String query = "INSERT INTO course_name (courseName , courseNumber) VALUES (?,?)";
            statement = connection.prepareStatement(query);

            for (CourseTable course : Courses) {
                statement.setString(1, course.getCourseName());
                statement.setString(2, course.getCourseNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException exception) {
            log.logException(exception);
        }
        Courses.clear();
    }
    public void insert(CourseTable course){
        Courses.add(course);
    }
    public void update(int id,String courseName,String courseNumber){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "UPDATE course_name SET courseName=?,courseNumber=? WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1,courseName);
            statement.setString(2,courseNumber);
            statement.setInt(3,id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            log.logException(exception);
        }
    }
    public void delete(int id){
        /*
         when delete record check if have relation with another Table like
         answer_paper_movement,monitor_committe
         check this:
         https://dba.stackexchange.com/questions/153420/mysql-delete-row-that-has-a-foreign-key-constraint-which-reference-to-itself
        */
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "DELETE FROM course_name WHERE ID IN(";
            StringBuilder deleteQuery = new StringBuilder(query);
            deleteQuery.append(id);
            deleteQuery.append(")");
            statement = connection.prepareStatement(deleteQuery.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            log.logException(exception);
        }
    }

}
