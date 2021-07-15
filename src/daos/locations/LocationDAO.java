/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.locations.Locations;
/**
 *
 * @author aceng
 */
public class LocationDAO {
    private Connection connection;
    
    public LocationDAO(Connection connection){
        this.connection = connection;
        
    }
    public List<Locations> getAll() {
        List<Locations> locations = new ArrayList<Locations>();
        String query = "SELECT * FROM REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Locations lok = new Locations();
                lok.setId(resultSet.getInt(1));
                lok.setStreetAddress(resultSet.getString(2));
                lok.setPostalCode(resultSet.getString(2));
                lok.setCity(resultSet.getString(2));
                lok.setStateProvince(resultSet.getString(2));
                lok.setCountry(resultSet.getString(1));
                locations.add(lok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    public boolean insert(Locations locations) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, locations.getId());
            preparedStatement.setString(2, locations.getStreetAddress());
            preparedStatement.setString(2, locations.getPostalCode());
            preparedStatement.setString(2, locations.getCity());
            preparedStatement.setString(2, locations.getStateProvince());
            preparedStatement.setString(1, locations.getCountry());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public boolean update(Locations locationsUpdate) {
        boolean result = false;
        String queryUpdate = "update regions set street_address = ? postal_code = ? city = ? state_province = ? country_id = ? where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setInt(1, locationsUpdate.getId());
            preparedStatement.setString(2, locationsUpdate.getStreetAddress());
            preparedStatement.setString(2, locationsUpdate.getPostalCode());
            preparedStatement.setString(2, locationsUpdate.getCity());
            preparedStatement.setString(2, locationsUpdate.getStateProvince());
            preparedStatement.setString(1, locationsUpdate.getCountry());
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
    public boolean delete(Locations locationsDelete) {
        boolean result = false;
        String queryDelete = "delete from locations where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, locationsDelete.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public List<Locations> SearchLocations(int Id) {
        List<Locations> locations = new ArrayList<Locations>();
        String query = "SELECT * FROM locations where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Locations lok = new Locations();
                lok.setId(resultSet.getInt(1));
                lok.setStreetAddress(resultSet.getString(2));
                lok.setPostalCode(resultSet.getString(3));
                lok.setCity(resultSet.getString(4));
                lok.setStateProvince(resultSet.getString(5));
                lok.setCountry(resultSet.getString(6));
                locations.add(lok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
}
