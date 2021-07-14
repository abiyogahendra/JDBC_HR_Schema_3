/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.employees.EmployeeDAO;
import models.employees.Employees;
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
    }
    
}
