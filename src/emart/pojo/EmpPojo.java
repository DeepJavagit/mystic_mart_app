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
public class EmpPojo {

    public EmpPojo(String id, String name, String job, int sal) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.sal = sal;
    }
    public EmpPojo(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
   private String id;
   private String name;
   private String job;
   private int sal;
}
