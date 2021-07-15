/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import java.util.Scanner;
import tools.Case.CountryCase;
import tools.Case.DepartmentCase;
import tools.Case.EmployeeCase;
import tools.Case.JobCase;
import tools.Case.LocationCase;
import tools.Case.RegionCase;

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
                    System.out.println("");
                    CountryCase.countryCase();
                    break;
                case 2:
                    System.out.println("");
                    DepartmentCase.departmentCase();
                    break;
                case 3:
                    System.out.println("");
                    EmployeeCase.Employee_case();
                    break;
                case 4: //Job
                    System.out.println("");
                    JobCase.jobMenu();
                    break;
                case 5:
                    LocationCase.Locations_Case();
                    break;
                case 6:
                    RegionCase.Regions_Case();
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

    
}
    
