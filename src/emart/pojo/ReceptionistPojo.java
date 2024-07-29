/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author Acer
 */
public class ReceptionistPojo {

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return Empname;
    }

    public void setEmpname(String Empname) {
        this.Empname= Empname;
    }

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String Empid) {
        this.Empid = Empid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ReceptionistPojo(String UserId, String Username, String Empid, String job, int salary) {
        this.UserId = UserId;
        this.Empname = Empname;
        this.Empid = Empid;
        this.job = job;
        this.salary = salary;
    }
    public ReceptionistPojo(){
    
}
    private String UserId;
    private String Empname;
    private String Empid;
    private String job;
    private int salary;
    
}
