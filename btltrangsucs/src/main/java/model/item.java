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
public class item {
    private product produc;
    private int num;
    private double price;

    public item() {
    }

    public item(product produc, int num, double price) {
        this.produc = produc;
        this.num = num;
        this.price = price;
    }

    public product getProduc() {
        return produc;
    }

    public void setProduc(product produc) {
        this.produc = produc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "item{" + "produc=" + produc + ", num=" + num + ", price=" + price + '}';
    }

    

    
    
    
}
