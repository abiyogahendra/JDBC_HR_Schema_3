/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.employees.EmployeeDAO;
import models.employees.Employees;
import daos.Job.JobDao;
import java.sql.Connection;
import models.Job.Job;
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
        
        DB_Connection conn = new DB_Connection();
        
        EmployeeDAO emp_conn = new EmployeeDAO(conn.getConnection());
//        
////        coba select semua data
//        for (Employees employ : emp.GetAllEmployee()) {
//            System.out.println(employ);
//        }
//            Employees emp = new Employees();
//            emp.setEmp(301);
//            emp.setFirst("Abiyoga");
//            emp.setLast("Hendra Wijaya");
//            emp.setEmail("abiyogakhusus@gmail.com");
//            emp.setPhone("082154926473");
//            emp.setHire("10/12/2005");
//            emp.setJob("AD_PRES");
//            emp.setSalary(50000);
//            emp.setComm(2);
//            emp.setManager(100);
//            emp.setDepartment(100);
//            if(emp_conn.InsertEmployee(emp)){
//                System.out.println("Berhasil");
//                for (Employees employ : emp_conn.GetAllEmployee()) {
//                    System.out.println(employ);
//                }
//            }else{
//                System.out.println("Gagal");
//            }

            Employees emp = new Employees();
            emp.setEmp(100);
            for (Employees data : emp_conn.SearchEmployee(emp)) {
                System.out.println(data);
            }
        JobDao jobDao = new JobDao(conn.getConnection());
        
        testManualJob(jobDao);
    }
    
    static void testManualJob(JobDao jobDao){
        System.out.println("Data Awal");
        for (Job job : jobDao.getAll()) {
            System.out.println(job);
        }
        System.out.println("");

        System.out.println("----------------------------------------");
        Job data = new Job("SYG", "Sayoga", 1000, 2000);
        System.out.println("Insert: " + data);
        if (jobDao.insert(data)) {
            System.out.println("Setelah Insert");
            for (Job job : jobDao.getAll()) {
                System.out.println(job);
            }
        }
        System.out.println("");

        System.out.println("----------------------------------------");
        data.setTitle("Putu Gede Sayoga");
        data.setMinSalary(555);
        data.setMaxSalary(999);
        System.out.println("Update: " + data);
        if (jobDao.update(data)) {
            System.out.println("Setelah Update");
            for (Job job : jobDao.getAll()) {
                System.out.println(job);
            }
        }
        System.out.println("");

        System.out.println("----------------------------------------");
        System.out.println("Delete dengan id = " + data.getId());
        if (jobDao.delete(data.getId())) {
            System.out.println("Setelah Delete");
            for (Job job : jobDao.getAll()) {
                System.out.println(job);
            }
        }
        System.out.println("");
        
    }
    
}
