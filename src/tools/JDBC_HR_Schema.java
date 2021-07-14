/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
        DB_Connection conn = new DB_Connection();
        System.out.println(conn.getConnection());
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
