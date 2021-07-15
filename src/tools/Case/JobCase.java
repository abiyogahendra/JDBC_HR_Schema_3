/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Case;

import daos.Job.JobDao;
import java.text.NumberFormat;
import java.util.Locale;
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

    public static void jobMenu() {
        int pilihan = 0;
        do {
            System.out.println("----------------------------------------------------------------------------");
            menu();
            System.out.print("Masukkan pilihan: ");
            pilihan = _input.nextInt();
            switch (pilihan) {
                case 1: //Lihat Semua
                    System.out.println("");
                    showAllData();
                    break;
                case 2: //Cari Data
                    System.out.println("");
                    searchById();
                    break;
                case 3: //Insert Data
                    System.out.println("");
                    insertNewData();
                    break;
                case 4: //Ubah Data
                    System.out.println("");
                    updateData();
                    break;
                case 5: //Hapus Data
                    System.out.println("");
                    deleteData();
                    break;
                case 6: //Kembali
                    break;
                case 7: //Keluar
                    System.out.println("Terimakasih telah menggunakan APLIKASI HR");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Maaf menu tersebut tidak ada, silahkan pilih menu yang tersedia");
                    pilihan = 0;
            }
            System.out.println("");
        } while (pilihan != 6);
    }

    static void menu() {
        System.out.println("Selamat datang di menu Job:");
        System.out.println("1. Lihat Semua Data");
        System.out.println("2. Cari Data");
        System.out.println("3. Tambah Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("6. Kembali ke menu utama");
        System.out.println("7. Keluar");
    }

    static void showAllData() {
        System.out.println(String.format("| %-32s | %-10s | %-15s | %-15s |",
                "Job Title", "Job Code", "Minimal Salary", "Maximal Salary"));
        System.out.println("");
        for (Job job : _jobDao.getAll()) {
            System.out.println(String.format("| %-32s | %-10s | %-15d | %-15d |",
                    job.getTitle(), job.getId(), job.getMinSalary(), job.getMaxSalary()));
        }
    }

    static void insertNewData() {
        Job newData = new Job();
        System.out.print("Masukkan Job Title: ");
        _input.nextLine(); // Consume newline left-over
        newData.setTitle(_input.nextLine());
        System.out.print("Masukkan Job Code: ");
        newData.setId((_input.nextLine()).toUpperCase());
        System.out.print("Masukkan Minimal Salary: ");
        newData.setMinSalary(_input.nextInt());
        System.out.print("Masukkan Maximal Salary: ");
        newData.setMaxSalary(_input.nextInt());
        System.out.println("Loading...");
        System.out.println("");
        if (_jobDao.insert(newData)) {
            System.out.println("Data baru berhasil ditambah");
            showOne(newData.getId());
        } else {
            System.out.println("Data baru gagal ditambah");
        }
    }

    static void deleteData() {
        System.out.print("Masukkan Job Code: ");
        _input.nextLine();
        String jobId = (_input.nextLine()).toUpperCase();
        System.out.println("Loading...");
        System.out.println("");
        if (!_jobDao.isEmpty(jobId)) {
            if (_jobDao.delete(jobId)) {
                System.out.println("Data berhasil dihapus");
            } else {
                System.out.println("Data gagal dihapus");
            }
        } else {
            System.out.println("Data dengan code \'" + jobId + "\' tidak ada");
        }
    }

    static void updateData() {
        Job oldData, newData;
        System.out.print("Masukkan Job Code: ");
        _input.nextLine();
        String jobId = (_input.nextLine()).toUpperCase();
        System.out.println("Loading...");
        System.out.println("");
        if (!_jobDao.isEmpty(jobId)) {
            oldData = _jobDao.getJobById(jobId);
        } else {
            System.out.println("Data dengan code \'" + jobId + "\' tidak ada");
            return;
        }
        newData = new Job();
        System.out.println("Job Title lama - " + oldData.getTitle());
        System.out.print("Masukkan Job Title baru: ");
        newData.setTitle(_input.nextLine());

        newData.setId(jobId);

        System.out.println("Minimal Salary lama - " + oldData.getMinSalary());
        System.out.print("Masukkan Minimal Salary baru: ");
        newData.setMinSalary(_input.nextInt());

        System.out.println("Maximal Salary lama - " + oldData.getMaxSalary());
        System.out.print("Masukkan Maximal Salary: ");
        newData.setMaxSalary(_input.nextInt());

        System.out.println("Loading...");
        System.out.println("");
        if (_jobDao.update(newData)) {
            System.out.println("Data berhasil diubah");
            showOne(newData.getId());
        } else {
            System.out.println("Data gagal diubah");
        }
    }

    static void searchById() {
        System.out.print("Masukkan Job Code: ");
        _input.nextLine();
        String jobId = (_input.nextLine()).toUpperCase();
        System.out.println("Loading...");
        System.out.println("");
        if (!_jobDao.isEmpty(jobId)) {
            showOne(jobId);
        } else {
            System.out.println("Data dengan code \'" + jobId + "\' tidak ada");
            return;
        }
    }

    static void showOne(String id) {
        Job searchedData = _jobDao.getJobById(id);
        System.out.println("Job Title: " + searchedData.getTitle());
        System.out.println("Job Code : " + searchedData.getId());
        System.out.println("Minimal Salary: "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(searchedData.getMinSalary()));
        System.out.println("Maximal Salary: "
                + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(searchedData.getMaxSalary()));
    }
}
