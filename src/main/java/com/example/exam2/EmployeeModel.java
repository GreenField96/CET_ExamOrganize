package com.example.exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel{
    final private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<EmployeeTable> Employees = new ArrayList<>();;

    public ArrayList<EmployeeTable> searchOnTable(String searchKeyWord) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            // note: see library project on Github to take search query
            String query = "SELECT * FROM employees WHERE name LIKE '%"+ searchKeyWord + "%' ";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                if(!resultSet.getBoolean("permisson")) {
                    Employees.add(new EmployeeTable(
                            resultSet.getInt("id"),
                            resultSet.getNString("name"),
                            resultSet.getNString("email"),
                            resultSet.getNString("phone_number"),
                            resultSet.getNString("work_as")
                    ));
                }
            }
        } catch (SQLException exception) {
            log.logException(exception);
        }
        return Employees;
    }
    public void store(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            //  Column: emp_no  birth_date 	first_name 	last_name 	gender 	hire_date
            String query = "INSERT INTO employees (name , email , phone_number , work_as) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(query);

            for (EmployeeTable employee : Employees) {
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getEmail());
                statement.setString(3, employee.getPhone_number());
                statement.setString(4,  employee.getWork_as());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException exception) {
            log.logException(exception);
        }
        Employees.clear();
    }
    public void insert(EmployeeTable emp){
        Employees.add(emp);
    }

    public void update(int id,String name,String email,String workAs,String phoneNumber){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "UPDATE employees SET name=?,email=?,phone_number=?,work_as=? WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phoneNumber);
            statement.setString(4,workAs);
            statement.setInt(5,id);
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
            String query = "DELETE FROM employees WHERE ID IN(";
            StringBuilder deleteQuery = new StringBuilder(query);
            deleteQuery.append(id);
            deleteQuery.append(")");
            statement = connection.prepareStatement(deleteQuery.toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            log.logException(exception);
        }
    }
    public boolean employeeLogin(String email,String pass) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            // SELECT * FROM `employees` WHERE `email` = 'munderjb' AND `password` = '25102510'
            String query = "SELECT * FROM employees WHERE email = '"+ email + "' AND password = '" + pass + "'" ;
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
               if(resultSet.getNString("password").equals(pass) & resultSet.getNString("email").equals(email)) {

                   session.setDataSession(
                           resultSet.getInt("id"),resultSet.getNString("name"),resultSet.getNString("email")
                           , resultSet.getNString("password"),resultSet.getNString("phone_number"),resultSet.getNString("work_as")
                   );

                   return true;
               }
            }
        } catch (SQLException exception) {
            log.logException(exception);
        }
        return false;
    }
}
