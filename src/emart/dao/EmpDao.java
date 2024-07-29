/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class EmpDao {
    public static boolean AddEmp(EmpPojo ep) throws SQLException{
        Connection cnn = DBConnection.getConnection();
        PreparedStatement ps = cnn.prepareStatement("Insert into Employees values(?,?,?,?)");
        ps.setString(1, ep.getId());
        ps.setString(2, ep.getName());
        ps.setString(3, ep.getJob());
        ps.setInt(4, ep.getSal());
        return ps.executeUpdate() == 1;
    }
    public static String getEmployeeId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(empid) from employees");
        rs.next();
        String empid =rs.getString(1);
        int id = Integer.parseInt(empid.substring(1));
        id = id+1;
        return "E"+id;
    }
    public static List<EmpPojo> getAllEmployees()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Employees where empid=?");
        
        ArrayList <EmpPojo> emplist=new ArrayList<>();
        while(rs.next()){
            EmpPojo emp = new EmpPojo();
            emp.setId(rs.getString(1));
            emp.setName(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSal(rs.getInt(4));
            emplist.add(emp);
        }
        return emplist;
    }
    public static List<String> getEmpId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select empid from employees order by empid");
        ArrayList<String> allid = new ArrayList<>();
        while (rs.next()){
          allid.add(rs.getString(1));
        }
        return allid;      
    }
    public static EmpPojo findEmpbyId(String empid)throws SQLException{
        Connection cnn = DBConnection.getConnection();
        PreparedStatement ps = cnn.prepareStatement("Select * from employees where empid=?");
        ps.setString(1, empid);
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmpPojo epp = new EmpPojo();
        epp.setId(rs.getString(1));
        epp.setName(rs.getString(2));
        epp.setJob(rs.getString(3));
        epp.setSal(rs.getInt(4));
        return epp;
    }
    public static boolean updateEmployee(EmpPojo e)throws SQLException{
        Connection cnn = DBConnection.getConnection();
        PreparedStatement ps = cnn.prepareStatement("update employees set empName = ?, job=?, salary=? where empid=?");
        ps.setString(1, e.getName());
        ps.setString(2, e.getJob());
        ps.setInt(3, e.getSal());
        ps.setString(4, e.getId());
        int x = ps.executeUpdate();
        if(x==0)
            return false;
        else{
            boolean result = UserDao.isUserPresent(e.getId());
            if(result == false)
            return true;
        ps = cnn.prepareStatement("update users set username=?, usertype=? where empid=?");
        ps.setString(1, e.getName());
        ps.setString(2, e.getJob());
        ps.setString(3, e.getId());
        int y=ps.executeUpdate();
        return y==1;
    }
    }
    public static boolean DeleteEmp(String empid)throws SQLException{
        Connection cnn = DBConnection.getConnection();
        PreparedStatement ps = cnn.prepareStatement("delete from employees where empid=?");
        ps.setString(1, empid);
        int x = ps.executeUpdate();
        return x==1;
    }
}
