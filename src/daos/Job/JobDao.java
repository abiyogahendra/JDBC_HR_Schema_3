/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job.Job;

/**
 *
 * @author putug
 */
public class JobDao {

    private Connection _connection;

    public JobDao(Connection connection) {
        _connection = connection;
    }

    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();
        String query = "select * from jobs";
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j = new Job();
                j.setId(resultSet.getString("job_id"));
                j.setTitle(resultSet.getString("job_title"));
                j.setMaxSalary(resultSet.getInt("max_salary"));
                j.setMinSalary(resultSet.getInt("min_salary"));
                jobs.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean insert(Job newJob) {
        String query = "insert into jobs(job_id, job_title, min_salary, max_salary) values(?, ?, ?, ?)";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            preparedStatement.setString(1, newJob.getId());
            preparedStatement.setString(2, newJob.getTitle());
            preparedStatement.setInt(3, newJob.getMinSalary());
            preparedStatement.setInt(4, newJob.getMaxSalary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String id) {
        String query = "delete from jobs where job_id = ?";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Job updatedData) {
        String query = "update jobs set job_title = ?, min_salary = ?, max_salary = ? "
                + "where job_id = ?";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            preparedStatement.setString(1, updatedData.getTitle());
            preparedStatement.setInt(2, updatedData.getMinSalary());
            preparedStatement.setInt(3, updatedData.getMaxSalary());
            preparedStatement.setString(4, updatedData.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isEmpty(String id) {
        String query = "select 1 from jobs where job_id = ?";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getBoolean(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !result; //return isi / false
    }
    
    public Job getJobById(String id){
        String query = "select * from jobs where job_id = ?";
        Job selectedData = new Job();
        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                selectedData.setId(resultSet.getString("job_id"));
                selectedData.setTitle(resultSet.getString("job_title"));
                selectedData.setMaxSalary(resultSet.getInt("max_salary"));
                selectedData.setMinSalary(resultSet.getInt("min_salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedData;
    }
}
