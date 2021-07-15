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
    public void Employee_case(){
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
                System.out.print("Masukkan Employee ID : ");
                emp_id = input.nextInt();
            } else if(pilih == 1 || pilih == 2) {
                System.out.print("Masukkan Employee ID : ");
                emp_id = input.nextInt();
                input.nextLine();

                System.out.print("Masukkan Employee First Name : ");
                first = input.nextLine();


                System.out.print("Masukkan Employee Last Name : ");
                last = input.nextLine();

                System.out.print("Masukkan Employee Email Name : ");
                email = input.nextLine();

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
            Employees m_emp = new Employees();
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
                        for (Employees employ : emp_conn.GetAllEmployee()) {
                            System.out.println(employ);
                        }
                    }else{
                        System.out.println("Gagal");
                    }
                break;
                case 2://update
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
                    if(emp_conn.UpdateEmployee(m_emp)){
                        System.out.println("Berhasil");
                        for (Employees employ : emp_conn.GetAllEmployee()) {
                            System.out.println(employ);
                        }
                    }else{
                        System.out.println("Gagal");
                    }
                break;
                case 3:
                    m_emp.setEmp(emp_id);
                    if(emp_conn.DeletedEmployee(m_emp)){
                        System.out.println("Berhasil "+ m_emp.getEmp() +" Dihapus");
    //                    for (Employees employ : emp_conn.GetAllEmployee()) {
    //                        System.out.println(employ);
    //                    }
                    }else{
                        System.out.println("Gagal");
                    }
                break;
                case 4:
                    for (Employees employ : emp_conn.GetAllEmployee()) {
                        System.out.println(employ);
                    }
                break;
                case 5:
                    m_emp.setEmp(emp_id);
                    for (Employees data : emp_conn.SearchEmployee(m_emp)) {
                        System.out.println(data);
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
