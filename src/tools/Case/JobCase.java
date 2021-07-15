/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.Job.JobDao;
import java.util.Scanner;
import models.Job.Job;
import tools.DB_Connection.DB_Connection;

/**
 *
 * @author putug
 */
public class JobCase {
    private static Scanner _input = new Scanner(System.in);
    private static DB_Connection _conn = new DB_Connection();
    private static JobDao _jobDao = new JobDao(_conn.getConnection());
    public static void jobMenu(){
        int pilihan = 0;
        do{
            System.out.println("----------------------------------------------------------------------------");
            menu();
            System.out.print("Masukkan pilihan: ");
            pilihan = _input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("");
                    showAllData();
                    break;
                case 2:
                    System.out.println("Cari Data belum di implement");
                    break;
                case 3:
                    System.out.println("");
                    insertNewData();
                    break;
                case 4:
                    System.out.println("Ubah Data belum di implement");
                    break;
                case 5:
                    System.out.println("hapus Data belum di implement");
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Terimakasih telah menggunakan APLIKASI HR");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Maaf menu tersebut tidak ada, silahkan pilih menu yang tersedia");
                    pilihan = 0;
            }
            System.out.println("");
        }while(pilihan != 6);
    }
    
    static void menu(){
        System.out.println("Selamat datang di menu Job:");
        System.out.println("1. Lihat Semua Data");
        System.out.println("2. Cari Data");
        System.out.println("3. Tambah Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("6. Kembali ke menu utama");
        System.out.println("7. Keluar");
    }
    
    static void showAllData(){
        System.out.println(String.format("| %-32s | %-10s | %-15s | %-15s |", 
                "Job Title", "Job Code", "Minimal Salary", "Maximal Salary"));
        System.out.println("");
        for (Job job : _jobDao.getAll()) {
            System.out.println(String.format("| %-32s | %-10s | %-15d | %-15d |", 
                    job.getTitle(), job.getId(), job.getMinSalary(), job.getMaxSalary()));
        }
    }
    
    static void insertNewData(){
        Job newData = new Job();
        System.out.print("Masukkan Job Title: ");
        _input.nextLine(); // Consume newline left-over
        newData.setTitle(_input.nextLine());
        System.out.print("Masukkan Job Code: ");
        newData.setId(_input.nextLine());
        System.out.print("Masukkan Minimal Salary: ");
        newData.setMinSalary(_input.nextInt());
        System.out.print("Masukkan Maximal Salary: ");
        newData.setMaxSalary(_input.nextInt());
        System.out.println("Loading...");
        if (_jobDao.insert(newData)) {
            System.out.println("Insert Berhasil");
        }
        else{
            System.out.println("Insert Gagal");
        }
    }
    
    static void testManualJob(JobDao jobDao) {
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
