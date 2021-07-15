
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.employees;

import java.text.DecimalFormat;

/**
 *
 * @author abiyo
 */
public class Employees {
    private int emp;
    private String first;
    private String last;
    private String email;
    private String phone;
    private String hire;
    private String job;
    private int salary;
    private double comm;
    private int manager;
    private int department;

    public int getEmp() {
        return emp;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHire() {
        return hire;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public double getComm() {
        return comm;
    }

    public int getManager() {
        return manager;
    }

    public int getDepartment() {
        return department;
    }

    public void setEmp(int emp) {
        this.emp = emp;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setComm(double comm) {
        this.comm = Double.parseDouble(new DecimalFormat("##.####").format(comm));
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" + "emp=" + emp + ", first=" + first + ", last=" + last + ", email=" + email + ", phone=" + phone + ", hire=" + hire + ", job=" + job + ", salary=" + salary + ", comm=" + comm + ", manager=" + manager + ", department=" + department + '}';
    }
}
