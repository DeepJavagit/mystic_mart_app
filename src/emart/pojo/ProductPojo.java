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
public class ProductPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public ProductPojo(){
        
    }

    public ProductPojo(String productId, String productname, String productcompany, double producprice, double ourprice, int tax, int quantity, double total) {
        this.productId = productId;
        this.productname = productname;
        this.productcompany = productcompany;
        this.producprice = producprice;
        this.ourprice = ourprice;
        this.tax = tax;
        this.quantity = quantity;
        this.total = total;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductcompany() {
        return productcompany;
    }

    public void setProductcompany(String productcompany) {
        this.productcompany = productcompany;
    }

    public double getProducprice() {
        return producprice;
    }

    public void setProducprice(double producprice) {
        this.producprice = producprice;
    }

    public double getOurprice() {
        return ourprice;
    }

    public void setOurprice(double ourprice) {
        this.ourprice = ourprice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private String productId;
    private String productname;
    private String productcompany;
    private double producprice;
    private double ourprice;
    private int tax;
    private int quantity;
    private double total;
}
