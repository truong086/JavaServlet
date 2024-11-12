/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IMPL;


import DAO.ICategoryDao;
import DBHelper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.category;

/**
 *
 * @author ASUS
 */
public class CategoryDao implements ICategoryDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    @Override
    public boolean insert(category ca) throws Exception {
        String sql = "insert into categry(tenloai, ngaytao) values (?, ?)";
        conn = new DBContext().getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, ca.getTenloai());
        stmt.setString(2, ca.getNgaytao());
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean edit(category ca) throws Exception{
        String sql = "update categry set tenloai = ?, ngaytao = ? where id = ?";
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ca.getTenloai());
            stmt.setString(2, ca.getNgaytao());
            stmt.setInt(3, ca.getId());
            
            return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String ca) throws Exception {
        int id = 0;
        String sql = "delete from categry where id = ?";
        conn = new DBContext().getConnection();
        stmt = conn.prepareStatement(sql);
        id = Integer.parseInt(ca);
        stmt.setInt(1, id);
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public List<category> findAll() throws Exception {
        List<category> list = new ArrayList<>();
        String sql = "select * from categry";
        try{
            conn =  new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new category(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getString(3)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        try{
            CategoryDao dao = new CategoryDao();
            List<category> list = dao.findAll();
            for(category ca : list){
                System.out.print(ca.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public category findOne(int id){
        String sql = "select * from categry where id = ?";
        try{
            conn = new DBContext().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                return new category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
}
