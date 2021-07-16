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
            } else if(pilih == 1) {
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
                    Locations oldData;
                    System.out.println("Masukan Location ID   :");
                    id = input.nextInt();
                    if(!locations.isEmpty(id)){
                        oldData = locations.SearchLocations(id);
                    }else{
                        System.out.println("data dengan ID "+ id + " tidak ada");
                        return;
                    }
                    System.out.println("Address lama - "+ oldData.getStreetAddress());
                    input.nextLine();
                    System.out.println("Masukan Address Baru : ");
                    address = input.nextLine();
                    
                    System.out.println("Postal Code Lama - " + oldData.getPostalCode());
                    System.out.print("Masukkan Postal Code Baru : ");
                    code = input.nextLine();
                    
                    System.out.println("City Lama - " + oldData.getCity());
                    System.out.print("Masukkan City Baru : ");
                    city = input.nextLine();
                    
                    System.out.println("Province Lama - " + oldData.getStateProvince());
                    System.out.print("Masukkan Province Baru : ");
                    province = input.nextLine();
                    
                    System.out.println("Country ID Lama - " + oldData.getCountry());
                    System.out.print("Masukkan Country ID Baru : ");
                    country = input.nextLine();
                    
                    locationModels.setId(id);
                    locationModels.setStreetAddress(address);
                    locationModels.setPostalCode(code);
                    locationModels.setCity(city);
                    locationModels.setStateProvince(province);
                    locationModels.setCountry(country);
                    
                    if(!locations.isEmpty(id)){
                        if(locations.update(locationModels)){
                            System.out.println("Update locations berhasil");
                        }else{
                            System.out.println("Update locations gagal");
                        }
                    }
                break;
                case 3://Delete data locations
                    locationModels.setId(id);
                    if (!locations.isEmpty(id)) {
                        if(locations.delete(locationModels)){
                            System.out.println("Delete berhasil");
                        }
                    }else{
                        System.out.println("Data dengan code \'" + id + "\' tidak ada");   
                    }
                    
                break;
                case 4:
                   System.out.println(String.format("| %10s | %40s | %30s| %30s| %30s| %30s|","Location ID","treet Address","Postal Code","City","State Province","Country ID" ));
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                   for(Locations lok : locations.getAll()){
                   System.out.println(String.format("| %10s | %40s | %30s| %30s| %30s| %30s|",lok.getId(),lok.getStreetAddress(),lok.getPostalCode(),lok.getCity(),lok.getStateProvince(),lok.getCountry() ));
                }
                break;
                case 5:
                    if(!locations.isEmpty(id)){
                        Locations location = locations.SearchLocations(id);
                           System.out.println("Location ID     : "+ location.getId());
                           System.out.println("Street Address  : "+ location.getStreetAddress());
                           System.out.println("Postal Code     : "+ location.getPostalCode());
                           System.out.println("City            : "+ location.getCity());
                           System.out.println("State Province  : "+ location.getStateProvince());
                           System.out.println("Country ID      : "+ location.getCountry());
                    }else{
                        System.out.println("Data dengan code "+id+" tidak ada");
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
