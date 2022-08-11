package com.wavemaker.training.db.dao;


import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.model.Employee;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

    public List<Employee> getListOfStudents() {
        List<Employee> studentList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
            while (resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, ADDRESS
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String address = resultSet.getString("ADDRESS");
                studentList.add(new Employee(id, name, age, address));
            }
        } catch (SQLException e) {
            //TODO
        }
        return studentList;
    }

    public void createEmployee(Employee employee) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "INSERT INTO  Employees(ID, NAME,AGE,ADDRESS) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setInt(3, employee.getAge());
            statement.setString(4, employee.getAddress());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM Employees WHERE name=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Employee was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(Employee employee) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE Employees SET id=?, name=?, age=? , address=?WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setInt(3, employee.getId());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TDOO
    }
}

