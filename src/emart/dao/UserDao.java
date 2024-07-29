/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.UserProfile;
import emart.pojo.UsersPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class UserDao {
    public static boolean ValidateUser(UsersPojo p)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement sp = conn.prepareStatement("Select * from Users where userid=? and usertype=? and password=?");
        sp.setString(1, p.getUserid());
        sp.setString(2, p.getUsertype());
        sp.setString(3, p.getPassword());
        ResultSet rs = sp.executeQuery();
        while (rs.next()) {
            UserProfile.setUsername(rs.getString(5));
            return true;
        }
        return false;
        
    }
    public static boolean isUserPresent(String empId)throws SQLException{
       Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("Select 1 from users where empid = ?");
       ps.setString(1, empId);
       ResultSet rs =ps.executeQuery();
       return rs.next();
    }
}
