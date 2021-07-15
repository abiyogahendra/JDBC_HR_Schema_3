/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.regions.RegionDAO;
import java.util.Scanner;
import models.regions.Regions;
/**
 *
 * @author aceng
 */
public class RegionCase {
    public void Regions_Case(RegionDAO region){
        
        int pilih = 0;
        while(pilih != 6){
        Scanner input = new Scanner(System.in);
        int id = 0;
        String name = null; 
        
        System.out.print(
                  "/n/n---------------------------------\n"
                + "-------------Employee------------\n"
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
            } else if(pilih == 1 || pilih == 2) {
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
                    regionModels.setId(id);
                    regionModels.setNama(name);
                    if(region.update(regionModels)){
                        System.out.println("Update berhasil");
                    }
                break;
                case 3://Delete data
                regionModels.setId(id);
                if(region.delete(regionModels)){
                    System.out.println("Delete berhasil");
                }
                    
                break;
                case 4:
                   for(Regions reg : region.getAll()){
                    System.out.println(reg);
                    //System.out.println(region.getId() +" - "+ region.getNama());
                }
                break;
                case 5:
                    regionModels.setId(id);
                    for (Regions reg : region.Search(id)) {
                        System.out.println(reg);
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
