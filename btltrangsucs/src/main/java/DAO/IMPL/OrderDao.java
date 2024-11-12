/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IMPL;


import DAO.IOrderDao;
import DBHelper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import model.account;
import model.carts;
import model.item;

/**
 *
 * @author ASUS
 */
public class OrderDao implements IOrderDao{

    @Override
    public void insert(account ac, carts car) throws Exception {
        LocalDate date = java.time.LocalDate.now();// Lấy ra dữ liệu ngày tháng hiện tại
        String dateTime = date.toString(); // Đưa dữ liệu này tháng về kiểu "String"
        String sql = "insert into oder(createDate, customer_id, tongtien) values(?, ?, ?)";
        Connection conn = new DBContext().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dateTime);
        stmt.setInt(2, ac.getId());
        stmt.setInt(3, car.tongtien());
        stmt.executeUpdate();
        
        String sql2 = "select id from oder order by id desc limit 1";
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        if(rs.next()){
            int id = rs.getInt(1);
            for(item i : car.getList()){
                String sql3 = "insert into orderline(oder_id, product_id, quantity, price) values (?, ?, ?, ?)";
                PreparedStatement stmt3 = conn.prepareStatement(sql3);
                stmt3.setInt(1, id);
                stmt3.setInt(2, i.getProduc().getId());
                stmt3.setInt(3, i.getNum());
                stmt3.setDouble(4, i.getPrice());
                stmt3.executeUpdate();
            }
        }
    }
    
}
