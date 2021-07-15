/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.Job.JobDao;
import daos.locations.LocationDAO;
import java.util.Scanner;
import models.locations.Locations;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author aceng
 */
public class LocationCase {
    public static void Locations_Case(){
    DB_Connection _conn = new DB_Connection();
    LocationDAO locations = new LocationDAO(_conn.getConnection());    
        int pilih = 0;
        while(pilih != 6){
        Scanner input = new Scanner(System.in);
        int id = 0;
        String address = null;
        String code = null;
        String city = null;
        String province = null;
        String country = null;
        System.out.print(
                  "---------------------------------\n"
                + "-------------Locations------------\n"
                + "Aksi :\n "
                + "1. Insert \n "
                + "2. Update \n "
                + "3. Delete \n "
                + "4. Read All Data \n "
                + "5. Search \n "
                + "6. Back to Menu\n "
                + "---------------------------------\n"
                + "---------------------------------\n" );
        
        
        System.out.print("Pilih: ");
        
        pilih = input.nextInt();
        
            if (pilih == 3 || pilih==5) {
                System.out.print("Masukkan Location ID : ");
                id = input.nextInt();
            } else if(pilih == 1 || pilih == 2) {
                System.out.print("Masukkan Location ID : ");
                id = input.nextInt();
                input.nextLine();

                System.out.print("Masukkan Street Address : ");
                address = input.nextLine();
                
                System.out.print("Masukkan Postal Code : ");
                code = input.nextLine();

                System.out.print("Masukkan City : ");
                city = input.nextLine();

                System.out.print("Masukkan Province : ");
                province = input.nextLine();

                System.out.print("Masukkan Country ID : ");
                country = input.nextLine();

            }
            Locations locationModels = new Locations();
            switch(pilih){
                case 1: //insert data locations
                    locationModels.setId(id);
                    locationModels.setStreetAddress(address);
                    locationModels.setPostalCode(code);
                    locationModels.setCity(city);
                    locationModels.setStateProvince(province);
                    locationModels.setCountry(country);
                    if(locations.insert(locationModels)){
                        System.out.println("insert berhasil");
                    }
                break;
                case 2://update data location
                    locationModels.setId(id);
                    locationModels.setStreetAddress(address);
                    locationModels.setPostalCode(code);
                    locationModels.setCity(city);
                    locationModels.setStateProvince(province);
                    locationModels.setCountry(country);
                    if(locations.update(locationModels)){
                        System.out.println("Update berhasil");
                    }
                break;
                case 3://Delete data locations
                    locationModels.setId(id);
                    if(locations.delete(locationModels)){
                        System.out.println("Delete berhasil");
                    }
                    
                break;
                case 4:
                   for(Locations lok : locations.getAll()){
                   System.out.println(lok);
                   //System.out.println(locations.getId() +" - "+ region.getNama());
               }
                break;
                case 5:
                    for (Locations lok : locations.SearchLocations(id)) {
                        System.out.println(lok);
                    }
                break;
                case 6:
                    System.out.println("Kembali Ke Menu Awal");
                break;
                default:
                    System.out.println("Kesalahan Penginputan");
            }
        }
    }
}
