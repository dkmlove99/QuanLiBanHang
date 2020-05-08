/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author asus
 */
public class OrderLine {
    private Order order;
    private Product product;
    private int quantity;
    private  float price;
    private float disscount;
    private float total;

    public float getTotal() {
        return total;
    }
      
    public void setTotal(float total) {
        this.total = total;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDisscount() {
        return disscount;
    }

    public void setDisscount(float disscount) {
        this.disscount = disscount;
    }
    
}
