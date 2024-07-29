package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UsersPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceptionistDao {
    public static Map<String,String> getNonRegisterReceptioniste()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("Select empid ,empname from employees where job='Receptionist' and empid not in (Select empid from users where usertype= 'Receptionist')");
        HashMap<String,String> recptionist = new HashMap<>();
        while(rs.next()){
            String id=rs.getString(1);
            String name = rs.getString(2);
            recptionist.put(id, name);
        }
        return recptionist;
    }
    public static boolean AddReceptionist(UsersPojo user)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into users values(?,?,?,?,?)");
        ps.setString(1, user.getEmpid());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getUserid());
        ps.setString(4, user.getPassword());
        return ps.executeUpdate() == 1;
    }
    public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("Select users.empid ,empname, userid, job, salary from users,employees where usertype= 'Receptionist' and users.empid = employees.empid");
        ArrayList<ReceptionistPojo> al = new ArrayList<>();
        while(rs.next()){
            ReceptionistPojo rp = new ReceptionistPojo();
            rp.setEmpid(rs.getString(1));
            rp.setEmpname(rs.getString(2));
            rp.setUserId(rs.getString(3));
            rp.setJob(rs.getString(4));
            rp.setSalary(rs.getInt(5));
            al.add(rp);
        }
        return al;
    }
    public static Map<String, String> getAllReceptionistId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("Select userid ,username from users where usertype= 'Receptionist' order by userid");
        HashMap<String,String> recptionist = new HashMap<>();
        while(rs.next()){
            String id=rs.getString(1);
            String name = rs.getString(2);
            recptionist.put(id, name);
        }
        return recptionist;
    }
    public static boolean updateReceptionist(String pwd, String id)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password =?, where userid = ?");
        ps.setString(1, pwd);
        ps.setString(2, id);
        return ps.executeUpdate() == 1;
    }
    public static List<String> getAllReceptionistuserId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("Select userid from users where usertype= 'Receptionist' order by userid");
        List<String> recptionist = new ArrayList<>();
        while(rs.next()){
            String id=rs.getString(1);
            recptionist.add(id);
        }
        return recptionist;
    }
    public static boolean deleteReceptionist(String id)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from users where userid = ?");
        ps.setString(2, id);
        return ps.executeUpdate() == 1;
    }
}
