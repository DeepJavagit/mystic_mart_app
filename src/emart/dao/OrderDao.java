/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class OrderDao {
     public static String getOrderId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(order_id) from orders");
        rs.next();
        String ordid =rs.getString(1);
        if(ordid == null){
            return "O-101";
        }
        int id = Integer.parseInt(ordid.substring(2));
        id = id+1;
        return "O-"+id;
    }
     public static boolean addOrders(ArrayList<ProductPojo> al, String ordid)throws SQLException{
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps= conn.prepareStatement("insert into ordres values(?,?,?,?)");
         int count = 0;
         for(ProductPojo p:al){
             ps.setString(1, ordid);
             ps.setString(2, p.getProductId());
             ps.setInt(3, p.getQuantity());
             ps.setString(4, UserProfile.getUserid());
            count = count + ps.executeUpdate();
         }
         return count == al.size();
     }
}
