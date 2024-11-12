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
public class category {
    private int id;
    private String tenloai;
    private String ngaytao;

    public category() {
    }

    public category(int id, String tenloai, String ngaytao) {
        this.id = id;
        this.tenloai = tenloai;
        this.ngaytao = ngaytao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    @Override
    public String toString() {
        return "category{" + "id=" + id + ", tenloai=" + tenloai + ", ngaytao=" + ngaytao + '}';
    }
    
    
    
}
