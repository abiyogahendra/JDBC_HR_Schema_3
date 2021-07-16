/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.employees.EmployeeDAO;
import java.util.Scanner;
import models.employees.Employees;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author abiyo
 */
public class EmployeeCase {
    public static void Employee_case(){
        DB_Connection conn = new DB_Connection();
        EmployeeDAO emp_conn = new EmployeeDAO(conn.getConnection());
        
        int pilih = 0;
        while(pilih != 6){
        Scanner input = new Scanner(System.in);
        int emp_id      = 0;
        String first    = null;
        String last     = null;
        String email    = null;
        String phone    = null;
        String hire     = null;
        String job      = null;
        int salary      = 0;
        double comm     = 0;
        int manager     = 0;
        int department  = 0;
        
        System.out.print(
              "\n\n---------------------------------\n"
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
        Employees m_emp = new Employees();
            if (pilih == 3 || pilih==5) {
                System.out.print("Masukkan Employee ID : ");
                emp_id = input.nextInt();
            } else if(pilih == 1) {
                System.out.print("Masukkan Employee ID : ");
                emp_id = input.nextInt();
                input.nextLine();
                
                System.out.print("Masukkan Employee First Name : ");
                first = input.nextLine();

                System.out.print("Masukkan Employee Last Name : ");
                last = input.nextLine();

                System.out.print("Masukkan Employee Email Name : ");
                email = input.nextLine();
                 while(!emp_conn.emailCheck(email)){
                    System.out.println("");
                    System.out.print("Masukkan Employee Ulang Email Name : ");
                    email = input.nextLine();
                }

                
                System.out.print("Masukkan Employee Phone Number : ");
                phone = input.nextLine();

                System.out.print("Masukkan Employee Hire Date : ");
                hire = input.nextLine();

                System.out.print("Masukkan Employee Job ID : ");
                job = input.nextLine();

                System.out.print("Masukkan Employee Salary : ");
                salary = input.nextInt();

                System.out.print("Masukkan Employee Commission PCT : ");
                comm = input.nextDouble();

                System.out.print("Masukkan Employee Manager ID : ");
                manager = input.nextInt();

                System.out.print("Masukkan Employee Department ID : ");
                department = input.nextInt();

            }
            
            switch(pilih){
                case 1: //insert
                    m_emp.setEmp(emp_id);
                    m_emp.setFirst(first);
                    m_emp.setLast(last);
                    m_emp.setEmail(email);
                    m_emp.setPhone(phone);
                    m_emp.setHire(hire);
                    m_emp.setJob(job);
                    m_emp.setSalary(salary);
                    m_emp.setComm(comm);
                    m_emp.setManager(manager);
                    m_emp.setDepartment(department);
                    if(emp_conn.InsertEmployee(m_emp)){
                        System.out.println("Berhasil");
                        System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",

                            "ID", 
                            "Fisrt name", 
                            "Last Name", 
                            "Email", 
                            "Phone Number", 
                            "Hire Date", 
                            "Job ID", 
                            "Salary", 
                            "Commission PCT", 
                            "Manager ID", 
                            "Department ID"));
                        System.out.println("");
                        for (Employees employ : emp_conn.GetAllEmployee()) {
                        System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",

                            employ.getEmp(), 
                            employ.getFirst(), 
                            employ.getLast(), 
                            employ.getEmail(), 
                            employ.getPhone(), 
                            employ.getHire(), 
                            employ.getJob(), 
                            employ.getSalary(), 
                            employ.getComm(), 
                            employ.getManager(), 
                            employ.getDepartment()));
                        }
                    }else{
                        System.out.println("Gagal");
                    }
                break;
                case 2://update
                    Employees oldData;
                    
                    System.out.print("Masukkan Employee ID : ");
                    emp_id = input.nextInt();
                    input.nextLine();
                    
                    if (!emp_conn.isEmpty(emp_id)) {
                        oldData = emp_conn.SearchEmployee(emp_id);
                    } else {
                        System.out.println("Data dengan code \'" + emp_id + "\' tidak ada");
                        return;
                    }
                    System.out.println("Employee First Name lama - " + oldData.getFirst());
                    System.out.print("Masukkan Employee First Name : ");
                    first = input.nextLine();

                    System.out.println("Employee Last Name lama - " + oldData.getLast());
                    System.out.print("Masukkan Employee Last Name : ");
                    last = input.nextLine();

                    System.out.println("Employee Email lama - " + oldData.getEmail());
                    System.out.print("Masukkan Employee Email Name : ");
                    email = input.nextLine();
                    while(!emp_conn.emailCheck(email)){
                        System.out.println("");
                        System.out.println("Employee Email lama - " + oldData.getEmail());
                        System.out.print("Masukkan Employee Email Name Yang Berbeda: ");
                        email = input.nextLine();
                    }

                    System.out.println("Employee Phone lama - " + oldData.getPhone());
                    System.out.print("Masukkan Employee Phone Number : ");
                    phone = input.nextLine();

                    System.out.println("Employee Hire Date lama - " + oldData.getHire());
                    System.out.print("Masukkan Employee Hire Date : ");
                    hire = input.nextLine();

                    System.out.println("Employee Job ID lama - " + oldData.getJob());
                    System.out.print("Masukkan Employee Job ID : ");
                    job = input.nextLine();

                    System.out.println("Employee Salary lama - " + oldData.getSalary());
                    System.out.print("Masukkan Employee Salary : ");
                    salary = input.nextInt();

                    System.out.println("Employee Commission PCT lama - " + oldData.getComm());
                    System.out.print("Masukkan Employee Commission PCT : ");
                    comm = input.nextDouble();

                    System.out.println("Employee Manager ID lama - " + oldData.getManager());
                    System.out.print("Masukkan Employee Manager ID : ");
                    manager = input.nextInt();

                    System.out.println("Employee Department ID lama - " + oldData.getDepartment());
                    System.out.print("Masukkan Employee Department ID : ");
                    department = input.nextInt();

                    m_emp.setEmp(emp_id);
                    m_emp.setFirst(first);
                    m_emp.setLast(last);
                    m_emp.setEmail(email);
                    m_emp.setPhone(phone);
                    m_emp.setHire(hire);
                    m_emp.setJob(job);
                    m_emp.setSalary(salary);
                    m_emp.setComm(comm);
                    m_emp.setManager(manager);
                    m_emp.setDepartment(department);
                    if (!emp_conn.isEmpty(emp_id)) {
                        if(emp_conn.UpdateEmployee(m_emp)){
                            System.out.println("Berhasil");
                            System.out.println(String.format(""
                                + "| %-5s |"
                                + " %-15s |"
                                + " %-15s |"
                                + " %-18s |"
                                + " %-20s |"
                                + " %-22s |"
                                + " %-12s |"
                                + " %-10s |"
                                + " %-15s |"
                                + " %-13s |"
                                + " %-13s |",

                                "ID", 
                                "Fisrt name", 
                                "Last Name", 
                                "Email", 
                                "Phone Number", 
                                "Hire Date", 
                                "Job ID", 
                                "Salary", 
                                "Commission PCT", 
                                "Manager ID", 
                                "Department ID"));
                            System.out.println("");
                            for (Employees employ : emp_conn.GetAllEmployee()) {
                            System.out.println(String.format(""
                                + "| %-5s |"
                                + " %-15s |"
                                + " %-15s |"
                                + " %-18s |"
                                + " %-20s |"
                                + " %-22s |"
                                + " %-12s |"
                                + " %-10s |"
                                + " %-15s |"
                                + " %-13s |"
                                + " %-13s |",

                                employ.getEmp(), 
                                employ.getFirst(), 
                                employ.getLast(), 
                                employ.getEmail(), 
                                employ.getPhone(), 
                                employ.getHire(), 
                                employ.getJob(), 
                                employ.getSalary(), 
                                employ.getComm(), 
                                employ.getManager(), 
                                employ.getDepartment()));
                            }
                        }else{
                            System.out.println("Gagal");
                        }
                    }else{
                        System.out.println("Data dengan code \'" + emp_id + "\' tidak ada");
                    }
                break;
                case 3:
                    if (!emp_conn.isEmpty(emp_id)) {
                        if(emp_conn.DeletedEmployee(m_emp)){
                            System.out.println("Berhasil "+ m_emp.getEmp() +" Dihapus");
        //                    for (Employees employ : emp_conn.GetAllEmployee()) {
        //                        System.out.println(employ);
        //                    }
                        }else{
                            System.out.println("Gagal");
                        }
                    }else{
                        System.out.println("Data dengan code \'" + emp_id + "\' tidak ada");         
                    }
                break;
                case 4:
                    System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",
                            
                              "ID", 
                              "Fisrt name", 
                              "Last Name", 
                              "Email", 
                              "Phone Number", 
                              "Hire Date", 
                              "Job ID", 
                              "Salary", 
                              "Commission PCT", 
                              "Manager ID", 
                              "Department ID"));
                    System.out.println("");
                    for (Employees employ : emp_conn.GetAllEmployee()) {
                        System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",
                            
                              employ.getEmp(), 
                              employ.getFirst(), 
                              employ.getLast(), 
                              employ.getEmail(), 
                              employ.getPhone(), 
                              employ.getHire(), 
                              employ.getJob(), 
                              employ.getSalary(), 
                              employ.getComm(), 
                              employ.getManager(), 
                              employ.getDepartment()));
                    }
                break;
                case 5:
                    if (!emp_conn.isEmpty(emp_id)) {
                        Employees data =  emp_conn.SearchEmployee(emp_id);
                        System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",
                            
                              "ID", 
                              "Fisrt name", 
                              "Last Name", 
                              "Email", 
                              "Phone Number", 
                              "Hire Date", 
                              "Job ID", 
                              "Salary", 
                              "Commission PCT", 
                              "Manager ID", 
                              "Department ID"));
                        System.out.println("");
                        System.out.println(String.format(""
                            + "| %-5s |"
                            + " %-15s |"
                            + " %-15s |"
                            + " %-18s |"
                            + " %-20s |"
                            + " %-22s |"
                            + " %-12s |"
                            + " %-10s |"
                            + " %-15s |"
                            + " %-13s |"
                            + " %-13s |",
                            data.getEmp(), 
                            data.getFirst(), 
                            data.getLast(), 
                            data.getEmail(), 
                            data.getPhone(), 
                            data.getHire(), 
                            data.getJob(), 
                            data.getSalary(), 
                            data.getComm(), 
                            data.getManager(), 
                            data.getDepartment()));
                    }else{
                        System.out.println("Data dengan code \'" + emp_id + "\' tidak ada");
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
