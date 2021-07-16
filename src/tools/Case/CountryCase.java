/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.countries.CountryDAO;
import java.util.Scanner;
import models.countries.Country;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author icha
 */
public class CountryCase {
    public static void countryCase(){
        DB_Connection connection = new DB_Connection();
        CountryDAO country_conn = new CountryDAO(connection.getConnection());
        int pilih =0;
        while(pilih !=6){
            Scanner input = new Scanner(System.in);
            String coun_id = null;
            String coun_name = null;
            int region = 0;
            
            System.out.print(
            "\n\n---------------------------------\n"
                + "-------------Country------------\n"
                + "Aksi :\n "
                + "1. Insert \n "
                + "2. Update \n "
                + "3. Delete \n "
                + "4. Read All Data \n "
                + "5. Search \n "
                + "6. Back to Menu\n "
                + "---------------------------------\n"
                + "---------------------------------\n" 
            );
            
            System.out.print("Pilih : ");
            
            pilih = input.nextInt();
            
            if(pilih == 3 || pilih == 5){
                System.out.print("Masukan Country ID : ");
                input.nextLine();
                coun_id = input.nextLine();
                
            }else if(pilih == 1){
                System.out.print("Masukan Country ID : ");
                input.nextLine();
                coun_id = input.nextLine();
                
                System.out.print("Masukan Country Name : ");
                coun_name = input.nextLine();
                
                System.out.print("Masukan Region ID : ");
                region = input.nextInt();
                
            }
            
            Country m_country = new Country();
            switch(pilih){
                case 1://insert
                    m_country.setId(coun_id);
                    m_country.setName(coun_name);
                    m_country.setRegion_id(region);
                    if(country_conn.insert(m_country)){
                        System.out.println("Berhasil Insert Country");
                    }else{
                        System.out.println("Gagal Insert Country");
                    }
                break;
                case 2://update
                    Country oldData;
                    System.out.print("Masukan Country ID : ");
                    input.nextLine();
                    coun_id = input.nextLine();
                    if(!country_conn.isEmpty(coun_id)){
                        oldData = country_conn.search(coun_id);
                    }else{
                        System.out.println("Data dengan code "+coun_id+" tidak ada");
                        return;
                    }
                    System.out.println("Nama Country Lama :  " + oldData.getName());
                    System.out.print("Masukkan Country Baru : ");
                    coun_name = input.nextLine();
                    
                    System.out.println("Region ID Lama - " + oldData.getRegion_id());
                    System.out.print("Masukkan Region ID : ");
                    region = input.nextInt();
                    
                    m_country.setId(coun_id);
                    m_country.setName(coun_name);
                    m_country.setRegion_id(region);
                    
                    if(!country_conn.isEmpty(coun_id)){
                        if(country_conn.update(m_country)){
                            System.out.println("Berhasil Update Country");
                        }
                        else{
                            System.out.println("Gagal Update Data");
                        }
                    }
                    
                break;
                case 3://delete
                    m_country.setId(coun_id);
                    if(!country_conn.isEmpty(coun_id)){
                        if(country_conn.delete(m_country)){
                            System.out.println("Berahasil Hapus Country");
                        }else{
                            System.out.println("Gagal Delete Country");
                        }
                    }else{
                        System.out.println("Data dengan code "+coun_id+" tidak ada");
                    }
                    
                break;
                case 4://show all data
                    System.out.println(String.format("| %-10s | %-25s | %-10s ", 
                        "Country ID", "Country Name", "Region ID"));
                    System.out.println("");
                    for (Country country : country_conn.getAll()) {
                            System.out.println(String.format("| %-10s | %-25s | %-10s ", 
                                    country.getId(),country.getName(), country.getRegion_id()));
                    }
                break;
                case 5://search
                    if(!country_conn.isEmpty(coun_id)){
                        Country country = country_conn.search(coun_id);
                        
                    System.out.println(String.format("| %-10s | %-25s | %-10s ", 
                        "Country ID", "Country Name", "Region ID"));
                    System.out.println(String.format("| %-10s | %-25s | %-10s ", 
                                country.getId(),country.getName(), country.getRegion_id()));
                    }else{
                        System.out.println("Data dengan code "+coun_id+" tidak ada");
                    }
                break;
                case 6:
                    System.out.println("Kembali ke Menu Awal");
                break;
                default:
                    System.out.println("Kesalahan Penginputan");
            }
            
        }
    }
}
