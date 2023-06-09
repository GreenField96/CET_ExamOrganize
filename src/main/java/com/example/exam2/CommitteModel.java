package com.example.exam2;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CommitteModel{
    private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<CommitteTable> committes;
    private ArrayList<studentAbsenceTable> students;
    private CourseModel courseModel;
    CommitteModel(){
        committes = new ArrayList<>();
        students = new ArrayList<>();
        courseModel = new CourseModel();
    }

    public ArrayList<studentAbsenceTable> getStudentAbsence(){
        return students;
    }

    public int store(ArrayList<EmployeeTable> monitorsId){
        Connection connection = null;
        PreparedStatement statement = null;
        int idCommitteRow = 1000;
        try {
            connection = db.getDBConnection();
            String queryComitte = "INSERT INTO committe (class,date,course,number_answer_paper,periodExam,year,semester_period) VALUES (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryComitte);
            for (CommitteTable committe : committes) {
                statement.setString(1, committe.getClassNumberCol());
                statement.setString(2, committe.getDateCol());
                statement.setInt(3, committe.getCourseCol());
                statement.setString(4,  committe.getNumberAnswerPaperCol());
                statement.setString(5,  committe.getPeriodCol());
                statement.setString(6,  committe.getYearCol());
                statement.setString(7,  committe.getSemesterPeriodCol());
                statement.addBatch();
            }
            statement.executeBatch();

            statement = connection.prepareStatement( "select id from committe ORDER BY id DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                idCommitteRow = resultSet.getInt("id");
            }
            String queryStudent = "INSERT INTO student_absence (student_id,name,phone_number,specification,group_number,committe_id,note) VALUES (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryStudent);
            for (studentAbsenceTable student : students) {
                 if(student.getStudentIdCol() > -1){
                    statement.setInt(1, student.getStudentIdCol());
                    statement.setString(2, student.getNameCol());
                    statement.setString(3, student.getPhoneNumberCol());
                     statement.setString(4, student.getSpecification());
                    statement.setString(5, student.getGroupNumberCol());
                    statement.setInt(6, idCommitteRow);
                    statement.setString(7, student.getNoteCol());
                    statement.addBatch();
                }
            }
            statement.executeBatch();

            statement = connection.prepareStatement( "INSERT INTO monitor_committe (personal_info_id,committe_id,absence) VALUES (?,?,?)");
            for (EmployeeTable monId : monitorsId) {
                    statement.setInt(1, monId.getId());
                    statement.setInt(2, idCommitteRow);
                    statement.setBoolean(3, monId.isAbsence());
                    statement.addBatch();
            }
            statement.executeBatch();

            } catch (SQLException exception) {
            log.logException(exception);
        }
        committes.clear();
        students.clear();

       return idCommitteRow;
    }
    public void insert(CommitteTable committe)
    {
        committes.add(committe);
    }
    public void insert(studentAbsenceTable student)
    {
        students.add(student);
    }

    public ArrayList<CommitteTable> selectSpecificData(String course,String groupNumber,String specific,String semesterPeriod,String year,boolean stateQuery){

        Connection connection = null;
        PreparedStatement statement = null;
        int id_have_paper = -1;

        try {
            connection = db.getDBConnection();
            String query = "SELECT " +
                    " committe.id,committe.class,committe.date,committe.course,answer_paper_movement.specification,committe.number_answer_paper,committe.periodExam,course_name.id as courseId,course_name.courseName,course_name.courseNumber,answer_paper_movement.group,answer_paper_movement.number_papers_received,answer_paper_movement.he_had_id,answer_paper_movement.he_have_id " +
                    " FROM " +
                    " committe,course_name,answer_paper_movement " +
                    "WHERE " +
                    "committe.year LIKE '"+ year +"' AND " +
                    "committe.semester_period LIKE '"+ semesterPeriod +"' AND " +
                    "course_name.courseName LIKE '"+ course +"' AND " +
                    "answer_paper_movement.specification LIKE '"+ specific +"' AND " +
                    "answer_paper_movement.group LIKE '"+ groupNumber + "' AND " +
                    "course_name.id = committe.course AND " +
                    "answer_paper_movement.committe_id = committe.id " +
                    "ORDER BY answer_paper_movement.id DESC LIMIT 1 ";

            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                id_have_paper = resultSet.getInt("he_have_id");
                    committes.add(new CommitteTable(
                            resultSet.getInt("id"),
                            resultSet.getNString("class"),
                            resultSet.getDate("date").toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            resultSet.getInt("course"),
                            resultSet.getNString("specification"),
                            resultSet.getNString("number_answer_paper"),
                            resultSet.getInt("courseId"),
                            resultSet.getNString("courseName"),
                            resultSet.getNString("courseNumber"),
                            resultSet.getNString("periodExam"),
                            resultSet.getNString("group"),
                            resultSet.getInt("number_papers_received")
                    ));
            }
            statement = connection.prepareStatement("SELECT * FROM employees WHERE id = " + id_have_paper);
            ResultSet subResultSet = statement.executeQuery();
            if(subResultSet.next())
            {
                committes.get(0).setDoctorId(subResultSet.getInt("id"));
                committes.get(0).setDoctorName(subResultSet.getNString("name"));

                if(stateQuery) {
                    if (!subResultSet.getBoolean("permisson")) {
                        committes.clear();
                    }
                }else{
                    if (subResultSet.getBoolean("permisson")) {
                        committes.clear();
                    }
                }

            }

        } catch (SQLException exception) {
            log.logException(exception);
        }
        return committes;
    }

    public void update(int id,String name,String email,String workAs,String phoneNumber){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "UPDATE committe SET name=?,email=?,phone_number=?,work_as=? WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phoneNumber);
            statement.setString(4,workAs);
            statement.setInt(   5,id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            log.logException(exception);
        }
    }
    public void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "DELETE FROM committe WHERE ID IN(";
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
