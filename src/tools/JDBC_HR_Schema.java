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
import tools.Case.EmployeeCase;
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

        EmployeeCase emp_case = new EmployeeCase();
        emp_case.Employee_case(emp_conn);
        
    }
}
    
