/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.Job.JobDao;
import daos.regions.RegionDAO;
import java.util.Scanner;
import models.regions.Regions;
import tools.DB_Connection.DB_Connection;
/**
 *
 * @author aceng
 */
public class RegionCase {
    public static void Regions_Case(){
    DB_Connection _conn = new DB_Connection();
        RegionDAO region = new RegionDAO(_conn.getConnection());   
        int pilih = 0;
        while(pilih != 6){
        Scanner input = new Scanner(System.in);
        int id = 0;
        String name = null; 
        
        System.out.print(
                  "---------------------------------\n"
                + "-------------Regions------------\n"
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
                System.out.print("Masukkan Region ID : ");
                id = input.nextInt();
            } else if(pilih == 1) {
                System.out.print("Masukkan Region ID : ");
                id = input.nextInt();
                input.nextLine();

                System.out.print("Masukkan Region Name : ");
                name = input.nextLine();
            }
            Regions regionModels = new Regions();
            switch(pilih){
                case 1: //insert data
                        regionModels.setId(id);
                        regionModels.setNama(name);
                        if(region.insert(regionModels)){
                            System.out.println("insert berhasil");
                      }
                break;
                case 2://update data region
                    Regions oldData;
                    System.out.println("Masukan Region ID   :");
                    id = input.nextInt();
                    if(!region.isEmpty(id)){
                        oldData = region.Search(id);
                    }else{
                        System.out.println("data dengan code"+ id + "tidak ada");
                        return;
                    }
                    System.out.println("Region lama - "+ oldData.getNama());
                    input.nextLine();
                    System.out.println("Masukan region baru : ");
                    name = input.nextLine();
                    
                    regionModels.setId(id);
                    regionModels.setNama(name);
                    
                    if(!region.isEmpty(id)){
                        if(region.update(regionModels)){
                            System.out.println("Update region berhasil");
                        }else{
                            System.out.println("Update region gagal");
                        }
                    }
                break;
                case 3://Delete data
                regionModels.setId(id);
                if (!region.isEmpty(id)) {
                    if(region.delete(regionModels)){
                        System.out.println("Delete berhasil");
                    }
                }else{
                    System.out.println("Data dengan code \'" + id + "\' tidak ada");
                }   
                break;
                case 4:
                   System.out.println(String.format("| %10s | %30s |","Region ID","Region Name" ));
                    System.out.println("----------------------------");
                   for(Regions reg : region.getAll()){
                   System.out.println(String.format("| %10d | %30s |",reg.getId(),reg.getNama() ));
                }
                break;
                case 5:
                       if(!region.isEmpty(id)){
                        Regions regions = region.Search(id);
                           System.out.println("Region ID    : "+ regions.getId());
                           System.out.println("Region Name  : "+ regions.getNama());
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
