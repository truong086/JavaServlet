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
public class product {
    private int id;
    private String title;
    private String name;
    private String image;
    private double price;
    private String description;
    private int catID;
    private int account_ID;
    private int soluong;

    public product() {
    }

    public product(int id, String title, String name, String image, double price, String description, int catID, int account_ID, int soluong) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.catID = catID;
        this.account_ID = account_ID;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(int account_ID) {
        this.account_ID = account_ID;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "product{" + "id=" + id + ", title=" + title + ", name=" + name + ", image=" + image + ", price=" + price + ", description=" + description + ", catID=" + catID + ", account_ID=" + account_ID + ", soluong=" + soluong + '}';
    }

    
    
}
