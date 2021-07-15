/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.department.DepartmentDAO;
import java.util.Scanner;
import models.departments.Department;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author icha
 */
public class DepartmentCase {
    public static void departmentCase(){
        DB_Connection connection = new DB_Connection();
        DepartmentDAO department_conn = new DepartmentDAO(connection.getConnection());
        int pilih =0;
        while(pilih != 6){
            Scanner input = new Scanner(System.in);
            int dept_id=0;
            String dept_name=null;
            int manager=0;
            int location =0;
            
            System.out.print(
            "\n\n---------------------------------\n"
                + "-------------Department------------\n"
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
                System.out.print("Masukan Department ID : ");
                input.nextLine();
                dept_id=input.nextInt();
                
            }else if(pilih == 1 || pilih == 2){
                System.out.print("Masukan Department ID : ");
                dept_id = input.nextInt();
                input.nextLine();
                
                System.out.print("Masukan Department Name : ");
                dept_name = input.nextLine();
                
                System.out.print("Masukan Manager ID : ");
                manager = input.nextInt();
                
                System.out.print("Masukan Location ID : ");
                location = input.nextInt();
            }
            
            Department m_department = new Department();
            switch(pilih){
                case 1://insert
                    m_department.setId(dept_id);
                    m_department.setName(dept_name);
                    m_department.setManager_id(manager);
                    m_department.setLocation_id(location);
                    if(department_conn.insert(m_department)){
                        System.out.println("Berhasil Insert Department");
                    }else{
                        System.out.println("Gagal Insert Department");
                    }
                break;
                case 2://update
                    m_department.setId(dept_id);
                    m_department.setName(dept_name);
                    m_department.setManager_id(manager);
                    m_department.setLocation_id(location);
                    if(!department_conn.isEmpty(dept_id)){
                        if(department_conn.update(m_department)){
                        System.out.println("Berhasil Update Department");
                        }else{
                            System.out.println("Gagal Update Department");
                        }
                    }else{
                        System.out.println("Data dengan code "+dept_id+" tidak ada");
                    }
                       
                break;
                case 3:
                    m_department.setId(dept_id);
                    if(!department_conn.isEmpty(dept_id)){
                        if(department_conn.delete(m_department)){
                        System.out.println("Berahasil Hapus Department");
                        }else{
                            System.out.println("Gagal Delete Department");
                        }
                    }else{
                        System.out.println("Data dengan code "+dept_id+" tidak ada");
                    }
                    
                break;
                case 4:
                    System.out.println(String.format("| %-10s | %-20s | %-10s |%-10s", 
                        "Dept ID", "Department Name", "Manager ID", "Location ID"));
                    for (Department department : department_conn.getAll()) {
                            System.out.println(String.format("| %-10s | %-20s | %-10s |%-10s", 
                                    department.getId(),department.getName(), department.getManager_id(), department.getLocation_id()));
                    }
                break;
                case 5:
                    System.out.println(String.format("| %-10s | %-20s | %-10s |%-10s", 
                        "Dept ID", "Department Name", "Manager ID", "Location ID"));
                    m_department.setId(dept_id);
                    for (Department department : department_conn.search(m_department)) {
                            System.out.println(String.format("| %-10s | %-20s | %-10s |%-10s", 
                                    department.getId(),department.getName(), department.getManager_id(), department.getLocation_id()));
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
