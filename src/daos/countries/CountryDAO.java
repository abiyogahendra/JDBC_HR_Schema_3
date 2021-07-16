/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.countries.Country;

/**
 *
 * @author icha
 */
public class CountryDAO {
    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }
    
    //view
    public List<Country> getAll() {
        List<Country> countries = new ArrayList<Country>();
        String query = "SELECT * FROM COUNTRIES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country c = new Country();
                c.setId(resultSet.getString(1));
                c.setName(resultSet.getString(2));
                c.setRegion_id(resultSet.getInt(3));
                countries.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
    
    //insert
    public boolean insert(Country country) {
        boolean result = false;
        String query = "INSERT INTO COUNTRIES(country_id,country_name,region_id) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            preparedStatement.setString(2, country.getName());
            preparedStatement.setInt(3, country.getRegion_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    //update
    public boolean update(Country country) {
        boolean result = false;
        String query = "UPDATE COUNTRIES SET country_name=?, region_id=? WHERE country_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getRegion_id());
            preparedStatement.setString(3, country.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean isEmpty(String id){
        String query = "SELECT 1 FROM COUNTRIES WHERE country_id=?";
        boolean result = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getBoolean(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return !result;//returns isi / false
    }
    
    //delete
    public boolean delete(Country country) {
        boolean result = false;
        String query = "DELETE FROM COUNTRIES WHERE country_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    //search
    public Country search(String id){
        String query = "SELECT * FROM COUNTRIES WHERE country_id=?";
        Country c = new Country();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                c.setId(resultSet.getString(1));
                c.setName(resultSet.getString(2));
                c.setRegion_id(resultSet.getInt(3));
            }
        }catch(Exception e){
        
        }
        return c;
    }
}
