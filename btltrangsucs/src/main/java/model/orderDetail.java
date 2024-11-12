/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class orderDetail {
    private int oder_id;
    private int product_id;
    private int quantity;
    private float price;

    public orderDetail() {
    }

    public orderDetail(int oder_id, int product_id, int quantity, float price) {
        this.oder_id = oder_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOder_id() {
        return oder_id;
    }

    public void setOder_id(int oder_id) {
        this.oder_id = oder_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    @Override
    public String toString() {
        return "orderDetail{" + "oder_id=" + oder_id + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
}
