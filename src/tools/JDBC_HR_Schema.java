/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.regions.RegionDAO;
import models.regions.Regions;
import daos.locations.LocationDAO;
import models.locations.Locations;
import tools.Case.RegionCase;
import tools.DB_Connection.DB_Connection;


/**
 *
 * @author abiyo
 */
public class JDBC_HR_Schema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DB_Connection connection = new DB_Connection();
        System.out.println(connection.getConnection());
        
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        LocationDAO lokdao = new LocationDAO(connection.getConnection());
        
        RegionCase regCase = new RegionCase();
        regCase.Regions_Case(rdao);
        
    }
}
