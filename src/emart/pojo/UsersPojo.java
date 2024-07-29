/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;


public class UsersPojo {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public UsersPojo(String username, String password, String userid, String empid, String usertype) {
        this.username = username;
        this.password = password;
        this.userid = userid;
        this.empid = empid;
        this.usertype = usertype;
    }
    public UsersPojo(){
        
    }
    private String username;
    private String password;
    private String userid;
    private String empid;
    private String usertype;
}