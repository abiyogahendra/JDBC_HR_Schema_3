/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.regions.Regions;

/**
 *
 * @author aceng
 */
public class RegionDAO {
    private Connection connection;
    
    public RegionDAO(Connection connection){
        this.connection = connection;
        
    }
    public List<Regions> getAll() {
        List<Regions> regions = new ArrayList<Regions>();
        String query = "SELECT * FROM REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Regions r = new Regions();
                r.setId(resultSet.getInt(1));
                r.setNama(resultSet.getString(2));
                regions.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    public boolean insert(Regions regions) {
        boolean result = false;
        String query = "INSERT INTO REGIONS(region_name,region_id) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, regions.getNama());
            preparedStatement.setInt(2, regions.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public boolean update(Regions regionUpdate) {
        boolean result = false;
        String queryUpdate = "update regions set region_name = ? where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, regionUpdate.getNama());
            preparedStatement.setInt(2, regionUpdate.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            result = false;
        }
        finally{
            return result;
        }
    }
    public boolean delete(Regions regionDelete) {
        boolean result = false;
        String queryDelete = "delete from regions where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, regionDelete.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public List<Regions> Search(int Id) {
        List<Regions> regions = new ArrayList<Regions>();
        String query = "SELECT * FROM REGIONS where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Regions r = new Regions();
                r.setId(resultSet.getInt(1));
                r.setNama(resultSet.getString(2));
                regions.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
}
