/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.employees;

import models.employees.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.employees.Employees;

/**
 *
 * @author abiyo
 */
public class EmployeeDAO {
    private Connection connection;
    
    public EmployeeDAO(Connection conn){
        this.connection = conn;
    }
//    melakukan insert
    public boolean InsertEmployee(Employees emp){
        boolean hasil = false;
        String query = "insert into employees("
                + "employee_id,"
                + "first_name,"
                + "last_name,"
                + "email,"
                + "phone_number,"
                + "hire_date,"
                + "job_id,"
                + "salary,"
                + "manager_id,"
                + "commission_pct,"
                + "department_id) "
                + "values "
                + "(?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?)";
        try {
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, emp.getEmp());
            prep.setString(2, emp.getFirst());
            prep.setString(3, emp.getLast());
            prep.setString(4, emp.getEmail());
            prep.setString(5, emp.getPhone());
            prep.setString(6, emp.getHire());
            prep.setString(7, emp.getJob());
            prep.setInt(8, emp.getSalary());
            prep.setInt(9, emp.getManager());
            prep.setDouble(10, emp.getComm());
            prep.setInt(11, emp.getDepartment());
            System.out.println(prep.getMetaData());
            prep.executeQuery();
            hasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            hasil = false;
        }
          return hasil;
    }
    
    public List<Employees> GetAllEmployee(){
        List<Employees> allEmp = new ArrayList<Employees>();
        String query = "select * from employees";
        try {
            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                Employees e = new Employees();
                e.setEmp(resultSet.getInt(1));
                e.setFirst(resultSet.getString(2));
                e.setLast(resultSet.getString(3));
                e.setEmail(resultSet.getString(4));
                e.setPhone(resultSet.getString(5));
                e.setHire(resultSet.getString(6));
                e.setJob(resultSet.getString(7));
                e.setSalary(resultSet.getInt(8));
                e.setComm(resultSet.getFloat(9));
                e.setManager(resultSet.getInt(10));
                e.setDepartment(resultSet.getInt(11));
                allEmp.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allEmp;
    }
    
    public boolean UpdateEmployee(Employees emp){
        boolean result = false;
        String query = "update employees set "
                + "first_name = ?,"
                + "last_name = ?,"
                + "email = ?,"
                + "phone_number = ?,"
                + "hire_date = ?,"
                + "job_id = ?,"
                + "salary = ?,"
                + "commission_pct = ?,"
                + "manager_id = ?,"
                + "department_id = ? where employee_id = ?";
        try {
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, emp.getFirst());
            prep.setString(2, emp.getLast());
            prep.setString(3, emp.getEmail());
            prep.setString(4, emp.getPhone());
            prep.setString(5, emp.getHire());
            prep.setString(6, emp.getJob());
            prep.setInt(7, emp.getSalary());
            prep.setDouble(8, emp.getComm());
            prep.setInt(9, emp.getManager());
            prep.setInt(10, emp.getDepartment());
            prep.setInt(11, emp.getEmp());
            prep.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
          return result;
    }
    
    public boolean DeletedEmployee(Employees emp){
        boolean result = false;
        String query = "delete from employees where employee_id = ?";
        try {
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, emp.getEmp());
            prep.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public List<Employees> SearchEmployee(Employees empl){
        List<Employees> result_emp = new ArrayList<Employees>();
        String query = "select * from employees where employee_id = ?";
        try {
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, empl.getEmp());
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                Employees e = new Employees();
                e.setEmp(resultSet.getInt(1));
                e.setFirst(resultSet.getString(2));
                e.setLast(resultSet.getString(3));
                e.setEmail(resultSet.getString(4));
                e.setPhone(resultSet.getString(5));
                e.setHire(resultSet.getString(6));
                e.setJob(resultSet.getString(7));
                e.setSalary(resultSet.getInt(8));
                e.setComm(resultSet.getFloat(9));
                e.setManager(resultSet.getInt(10));
                e.setDepartment(resultSet.getInt(11));
                result_emp.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_emp;
    }
    
    public boolean isEmpty(Employees empl) {
        String query = "select 1 from employees where employee_id = ?";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,empl.getEmp());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getBoolean(1);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return !result; //return isi / false
    }
}
