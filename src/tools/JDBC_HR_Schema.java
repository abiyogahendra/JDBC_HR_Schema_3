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
        
        
        
//        

//         //insert data locations
//        Locations locations = new Locations();
//        locations.setId(600);
//        locations.setStreetAddress("dubai rt berapa");
//        locations.setPostalCode("53354");
//        locations.setCity("arab");
//        locations.setStateProvince("arab");
//        locations.setCountry("jk");
////        if(lokdao.insert(locations)){
////            System.out.println("insert berhasil");
////        }
//        
//        //update data
////        Locations locationsUpdate = new Locations();
////        locationsUpdate.setId(600);
////        locationsUpdate.setStreetAddress("Sleman receh banget");
////        locationsUpdate.setPostalCode("55665");
////        locationsUpdate.setCity("Sleman aja");
////        locationsUpdate.setStateProvince("jogja");
////        locationsUpdate.setCountry("kl");
////        if(lokdao.update(locationsUpdate)){
////            System.out.println("Update berhasil");
////        }
//        //Delete data locations
//        Locations locationsDelete = new Locations();
//        locationsDelete.setId(600);
//        if(lokdao.delete(locationsDelete)){
//            System.out.println("Delete berhasil");
//        }
//        
        for(Locations lok : lokdao.getAll()){
                   System.out.println(lok);
                   //System.out.println(locations.getId() +" - "+ region.getNama());
               }
    }
    }
