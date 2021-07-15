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
import java.util.Scanner;
import models.Job.Job;
import tools.Case.JobCase;
import tools.Case.EmployeeCase;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author abiyo
 */
public class JDBC_HR_Schema {

    private static Scanner _input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;
        System.out.println("==== APLIKASI HR ====");
        System.out.println("Selmat datang!! aplikasi ini dapat melihat, menambah, menghapus, memperbarui data pada menu yang disediakan");
        do {
            menu();
            System.out.print("Masukkan pilihan: ");
            pilihan = _input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Country belum di implement");
                    break;
                case 2:
                    System.out.println("Departement belum di implement");
                    break;
                case 3:
                    System.out.println("Employee belum di implement");
                    break;
                case 4: //Job
                    System.out.println("");
                    JobCase.jobMenu();
                    break;
                case 5:
                    System.out.println("Location belum di implement");
                    break;
                case 6:
                    System.out.println("Region belum di implement");
                    break;
                case 7:
                    System.out.println("Terimakasih telah menggunakan APLIKASI HR");
                    break;
                default:
                    System.out.println("Maaf menu tersebut tidak ada, silahkan pilih menu yang tersedia");
                    pilihan = 0;
            }
            System.out.println("===========================================================================");
            System.out.println("");
        } while (pilihan != 7);
    }

    static void menu() {
        System.out.println("Menu Utama:");
        System.out.println("1. Country");
        System.out.println("2. Department");
        System.out.println("3. Employee");
        System.out.println("4. Job");
        System.out.println("5. Location");
        System.out.println("6. Region");
        System.out.println("7. Keluar");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        EmployeeCase emp_case = new EmployeeCase();
        emp_case.Employee_case();
        
    }
}
    
