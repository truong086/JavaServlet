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
public class account {
    private int id;
    private String username;
    private String password;
    private int sell_ID;
    private int isAdmin;

    public account() {
    }

    public account(int id, String username, String password, int sell_ID, int isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sell_ID = sell_ID;
        this.isAdmin = isAdmin;
    }
    public account(String username, String password, int sell_ID, int isAdmin) {
        this.username = username;
        this.password = password;
        this.sell_ID = sell_ID;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSell_ID() {
        return sell_ID;
    }

    public void setSell_ID(int sell_ID) {
        this.sell_ID = sell_ID;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "account{" + "id=" + id + ", username=" + username + ", password=" + password + ", sell_ID=" + sell_ID + ", isAdmin=" + isAdmin + '}';
    }
    
    
}
