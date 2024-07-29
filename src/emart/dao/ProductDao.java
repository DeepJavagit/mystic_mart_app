/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
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
public class ProductDao {
    public static String getProductId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(p_id) from Products");
        rs.next();
        String empid =rs.getString(1);
        if(empid == null){
            return "P101";
        }
        int id = Integer.parseInt(empid.substring(1));
        id = id+1;
        return "P"+id;
    }
    public static boolean addproduct(ProductPojo p)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into products values(?,?,?,?,?,?,?,'Y')");
        ps.setString(1, p.getProductId());
        ps.setString(2, p.getProductname());
        ps.setString(3, p.getProductcompany());
        ps.setDouble(4, p.getProducprice());
        ps.setDouble(5, p.getOurprice());
        ps.setInt(6, p.getTax());
        ps.setInt(7, p.getQuantity());
        return ps.executeUpdate() == 1;
    }
    public static List<ProductPojo> getProductDetails()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from products where status='Y' order by p_id");
        ArrayList<ProductPojo> productList = new ArrayList<>();
        while(rs.next()){
            ProductPojo p=new ProductPojo();
            p.setProductId(rs.getString(1));
            p.setProductname(rs.getString(2));
            p.setProductcompany(rs.getString(3));
            p.setProducprice(rs.getDouble(4));
            p.setOurprice(rs.getDouble(5));
            p.setTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
            productList.add(p);
        }
        return productList;
    }
    public static boolean deleteProduct(String productId)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set Status ='N' where p_id = ?");
        ps.setString(1, productId);
        return ps.executeUpdate()==1;
    }
    public static boolean updateProduct(ProductPojo p)throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set p_name=?,p_companyname=?,p_price=?,our_price=?,p_tax=?,quantity=? where p_id = 'P103'");
        ps.setString(1, p.getProductname());
        ps.setString(2, p.getProductcompany());
        ps.setDouble(3, p.getProducprice());
        ps.setDouble(4, p.getOurprice());
        ps.setInt(5, p.getTax());
        ps.setInt(6, p.getQuantity());
      //  ps.setString(7, p.getProductId());
        return ps.executeUpdate() == 1;
    }   
    public static ProductPojo getProductDetails(String id)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from products where p_id = ? and status = 'Y'");
       ps.setString(0, id);
       ResultSet rs = ps.executeQuery();
       ProductPojo p = new ProductPojo(); 
       if(rs.next()){
            p.setProductId(rs.getString(1));
            p.setProductname(rs.getString(2));
            p.setProductcompany(rs.getString(3));
            p.setProducprice(rs.getDouble(4));
            p.setOurprice(rs.getDouble(5));
            p.setTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
       }
       return p;
       
    }
    public static boolean updateStock(List<ProductPojo> productList)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set quantity = quantity-? where p_id =? ");
        int x =0;
       for(ProductPojo pj:productList){
           ps.setInt(1, pj.getQuantity());
           ps.setString(2, pj.getProductId());
           int row = ps.executeUpdate();
           if(row !=0){
               x++;
           }
        }
       return x==productList.size();
    }
}
