package com.example.exam2;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CommitteModel{
    private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<CommitteTable> committes;
    private ArrayList<studentAbsenceTable> students;
    CommitteModel(){
        committes = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<studentAbsenceTable> getStudentAbsence(){
        return students;
    }

    public void store(ArrayList<EmployeeTable> monitorsId){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String queryComitte = "INSERT INTO committe (class,date,course,semester,specification,number_answer_paper) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryComitte);
            for (CommitteTable committe : committes) {
                statement.setString(1, committe.getClassNumberCol());
                statement.setString(2, committe.getDateCol());
                statement.setString(3, committe.getCourseCol());
                statement.setString(4,  committe.getSemesterCol());
                statement.setString(5,  committe.getSpecificCol());
                statement.setString(6,  committe.getNumberAnswerPaperCol());
                statement.addBatch();
            }
            statement.executeBatch();

            statement = connection.prepareStatement( "select id from committe ORDER BY id DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            int idCommitteRow = 1000;
            while(resultSet.next()){
                idCommitteRow = resultSet.getInt("id");
            }
            String queryStudent = "INSERT INTO student_absence (student_id,name,phone_number,group_number,committe_id,note) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryStudent);
            for (studentAbsenceTable student : students) {
                 if(student.getStudentIdCol() > -1){
                    statement.setInt(1, student.getStudentIdCol());
                    statement.setString(2, student.getNameCol());
                    statement.setString(3, student.getPhoneNumberCol());
                    statement.setString(4, student.getGroupNumberCol());
                    statement.setInt(5, idCommitteRow);
                    statement.setString(6, student.getNoteCol());
                    statement.addBatch();
                }
            }
            statement.executeBatch();

            statement = connection.prepareStatement( "INSERT INTO monitor_committe (personal_info_id,committe_id) VALUES (?,?)");
            for (EmployeeTable monId : monitorsId) {
                if(monId.getId() > -1) {
                    statement.setInt(1, monId.getId());
                    statement.setInt(2, idCommitteRow);
                    statement.addBatch();
                }
            }
            statement.executeBatch();

        } catch (SQLException exception) {
            log.logException(exception);
        }
        committes.clear();
        students.clear();
    }
    public void insert(CommitteTable committe)
    {
        committes.add(committe);
    }
    public void insert(studentAbsenceTable student)
    {
        students.add(student);
    }

    public ArrayList<CommitteTable> selectSpecificData(String Class, String course, String date){
//        committes.clear();
        Connection connection = null;
        PreparedStatement statement = null;
        date = date.replace('/','-');
//        System.out.println(date);
        try {
            connection = db.getDBConnection();
            String query = "SELECT * FROM committe WHERE class LIKE '%"+ Class +"%' AND date LIKE '%"+ date +"%' AND course LIKE '%"+ course +"%'";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                committes.add(new CommitteTable(
                        resultSet.getInt("id") ,
                        resultSet.getNString("class") ,
                        resultSet.getDate("date").toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) ,
                        resultSet.getNString("course"),
                        resultSet.getNString("specification"),
                        resultSet.getNString("number_answer_paper")
                ));
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
