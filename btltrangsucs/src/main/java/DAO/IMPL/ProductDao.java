/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IMPL;

import DAO.IproductDao;
import DBHelper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.product;

/**
 *
 * @author ASUS
 */
public class ProductDao implements IproductDao{
    public Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    @Override
    public boolean insert(product p) throws Exception {
        String sql = "insert into product(title, name, image, price, description, catID, account_ID, soluong) values (?, ?, ?, ?, ?, ?, ?, ?)";
        conn = new DBContext().getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getTitle());
        stmt.setString(2, p.getName());
        stmt.setString(3, p.getImage());
        stmt.setDouble(4, p.getPrice());
        stmt.setString(5, p.getDescription());
        stmt.setInt(6, p.getCatID());
        stmt.setInt(7, p.getAccount_ID());
        stmt.setInt(8, p.getSoluong());
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean edit(product p) throws Exception {
        String sql = "update product set title = ?, name = ?, image = ?, price = ?, description = ?, catID = ?, account_ID = ?, soluong = ? where id = ?";
        conn = new DBContext().getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getTitle());
        stmt.setString(2, p.getName());
        stmt.setString(3, p.getImage());
        stmt.setDouble(4, p.getPrice());
        stmt.setString(5, p.getDescription());
        stmt.setInt(6, p.getCatID());
        stmt.setInt(7, p.getAccount_ID());
        stmt.setInt(8, p.getSoluong());
        stmt.setInt(9, p.getId());
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String p) throws Exception {
        String sql = "delete from product where id = ?";
        conn = new DBContext().getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, p);
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public List<product> findAll() throws Exception {
        List<product> list = new ArrayList<>();
        String sql = "select * from product";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9)));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        try{
            ProductDao dao = new ProductDao();
            List<product> list = dao.productMax();
            for(product p : list){
                System.out.print(p.toString());
            }
            System.out.print("kết nối thành công");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<product> findOneCategory(String id) throws Exception {
        int ids = 0;
        List<product> list = new ArrayList<>();
        String sql = "select * from product as p left join categry as c on p.catID = c.id where p.catID = ?";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            ids = Integer.parseInt(id);
            stmt.setInt(ids, 1);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public product findOne(String id) throws Exception {
        int ids = 0;
        String sql = "select * from product where id = ?";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            ids = Integer.parseInt(id);
            stmt.setInt(1, ids);
            rs = stmt.executeQuery();
            while(rs.next()){
                return new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<product> Search(String name) throws Exception {
        List<product> list = new ArrayList<>();
        String sql = "select * from product where title like ?";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public List<product> productNew() throws Exception {
        List<product> list = new ArrayList<>();
        String sql = "select * from product order by id desc limit 6";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
        
    }

    @Override
    public List<product> productMax() throws Exception {
        List<product> list = new ArrayList<>();
        String sql = "select *, count(product_id) from orderline inner join product on orderline.product_id = product.id group by product_id having count(product_id) > 0 order by count(product_id) desc limit 6";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new product(rs.getInt(5),
                                     rs.getString(6),
                                     rs.getString(7),
                                     rs.getString(8),
                                     rs.getDouble(9),
                                     rs.getString(10),
                                     rs.getInt(11),
                                     rs.getInt(12),
                                     rs.getInt(13)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public product top1(int soluong) throws Exception {
        String sql = "select * from product order by id desc limit ?";
        try{
            conn = new DBContext().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, soluong);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new product(rs.getInt(1),
                                     rs.getString(2),
                                     rs.getString(3),
                                     rs.getString(4),
                                     rs.getDouble(5),
                                     rs.getString(6),
                                     rs.getInt(7),
                                     rs.getInt(8),
                                     rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
