/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.countries.CountryDAO;
import daos.department.DepartmentDAO;
import models.countries.Country;
import models.departments.Department;
import tools.Case.CountryCase;
import tools.Case.DepartmentCase;
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
        DB_Connection connection = new DB_Connection();
        System.out.println(connection.getConnection());
        
        CountryDAO countryDAO = new CountryDAO(connection.getConnection());
        DepartmentDAO departmentDAO = new DepartmentDAO(connection.getConnection());
        
        CountryCase coun_case = new CountryCase();
        coun_case.countryCase(countryDAO);
        
//        DepartmentCase dept_case = new DepartmentCase();
//        dept_case.departmentCase(departmentDAO);
    }
    
}
