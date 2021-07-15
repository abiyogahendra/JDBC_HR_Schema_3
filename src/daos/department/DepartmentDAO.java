/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.departments.Department;

/**
 *
 * @author icha
 */
public class DepartmentDAO {
    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }
    
    //view
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department();
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                departments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
    
    //insert
    public boolean insert(Department department) {
        boolean result = false;
        String query = "INSERT INTO DEPARTMENTS(department_id,department_name,manager_id,location_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.setInt(3, department.getManager_id());
            preparedStatement.setInt(4, department.getLocation_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    //update
    public boolean update(Department department) {
        boolean result = false;
        String query = "UPDATE DEPARTMENTS SET department_name=?, manager_id=?, location_id=? WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getManager_id());
            preparedStatement.setInt(3, department.getLocation_id());
            preparedStatement.setInt(4, department.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    //delete
    public boolean delete(Department department) {
        boolean result = false;
        String query = "DELETE FROM DEPARTMENTS WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    //search
    public List<Department> search(Department department){
        List<Department> result = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_id=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getId());
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Department d = new Department();
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                result.add(d);
            }
        }catch(Exception e){
        
        }
        return result;
    }
}
