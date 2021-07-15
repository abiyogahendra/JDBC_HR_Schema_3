/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.countries.CountryDAO;
import java.util.Scanner;
import models.countries.Country;

/**
 *
 * @author icha
 */
public class CountryCase {
    public void countryCase(CountryDAO country_conn){
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
                
            }else if(pilih == 1 || pilih == 2){
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
                        for (Country country : country_conn.getAll()) {
                            System.out.println(country);
                        }
                    }else{
                        System.out.println("Gagal Insert Country");
                    }
                break;
                case 2://update
                    m_country.setId(coun_id);
                    m_country.setName(coun_name);
                    m_country.setRegion_id(region);
                    if(country_conn.update(m_country)){
                        System.out.println("Berhasil Update Country");
                        for (Country country : country_conn.getAll()) {
                            System.out.println(country);
                        }
                    }else{
                        System.out.println("Gagal Insert Country");
                    }
                break;
                case 3://delete
                    m_country.setId(coun_id);
                    if(country_conn.delete(m_country)){
                        System.out.println("Berahasil Hapus Country");
                        for (Country country : country_conn.getAll()) {
                            System.out.println(country);
                        }
                    }else{
                        System.out.println("Gagal Delete Country");
                    }
                break;
                case 4:
                    for (Country country : country_conn.getAll()) {
                            System.out.println(country);
                    }
                break;
                case 5:
                    m_country.setId(coun_id);
                    for (Country country : country_conn.search(m_country)) {
                            System.out.println(country);
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
