/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IMPL;


import DAO.IAccountDao;
import DBHelper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.account;

/**
 *
 * @author ASUS
 */
public class AccountDao implements IAccountDao{

    @Override
    public account login(String user, String pass) throws Exception {
        String sql = "select * from account where username = ? and password = ?";
        try{
            Connection conn = new DBContext().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public account check(String user) throws Exception {
        String sql = "select * from account where username = ?";
        try{
            Connection conn = new DBContext().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(account accs) throws Exception {
        String sql = "insert into account(username, password, isSell, isAdmin) values (?, ?, 0, 0)";
        try(
                Connection conn = new DBContext().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, accs.getUsername());
            stmt.setString(2, accs.getPassword());
            return stmt.executeUpdate() > 0;
            
        }
    }

    @Override
    public boolean update(account accs) throws Exception {
        String sql = "update account set username = ?, password = ?, isSell = ?, isAdmin = ? where id = ? ";
        try(
                Connection conn = new DBContext().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, accs.getUsername());
            stmt.setString(2, accs.getPassword());
            stmt.setInt(3, accs.getSell_ID());
            stmt.setInt(4, accs.getIsAdmin());
            stmt.setInt(5, accs.getId());
            return stmt.executeUpdate() > 0;
            
        }
    }

    @Override
    public boolean delet(int accs) throws Exception {
        String sql = "delete from account where id = ? ";
        try(
                Connection conn = new DBContext().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, accs);
            return stmt.executeUpdate() > 0;
            
        }
    }

    @Override
    public List<account> findAll() throws Exception {
        List<account> list = new ArrayList<>();
        String sql = "select * from account";
        Connection conn = new DBContext().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            list.add(new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        
        return list;
    }

    @Override
    public account findOne(int id) throws Exception {
        String sql = "select * from account where id = ?";
        Connection conn = new DBContext().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            return new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
        }
        return null;
    }
    
}
