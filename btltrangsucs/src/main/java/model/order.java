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
public class order {
    private int id;
    private String createDate;
    private int customer_id;
    private int tongtien;

    public order() {
    }

    public order(int id, String createDate, int customer_id, int tongtien) {
        this.id = id;
        this.createDate = createDate;
        this.customer_id = customer_id;
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "order{" + "id=" + id + ", createDate=" + createDate + ", customer_id=" + customer_id + ", tongtien=" + tongtien + '}';
    }
    
    
}
