package com.wavemaker.training.db.dao;

import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAO {
    public List<Department> getListOfDepartments() {
        List<Department> DepartmentList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                DepartmentList.add(new Department(id, name));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return DepartmentList;
    }

    public void createDepartment() {
            Connection connection = MySQLConnectionUtility.getConnection();
            try {
                String sql = "INSERT INTO Department (id, name) VALUES (?, ?)";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, 1);
                statement.setString(2, "frontend");
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new Department was inserted successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public void deleteEmployee(Department department) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM Department  WHERE name=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department.getName() );

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A department was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void UpdateDepartment(Department department){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE Department SET id=?, name=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,department.getId() );
            statement.setString(2, department.getName());



            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing department was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
