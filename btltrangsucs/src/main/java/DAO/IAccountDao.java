/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.account;


/**
 *
 * @author ASUS
 */
public interface IAccountDao {
    public account login(String user, String pass) throws Exception;
    public account check(String user) throws Exception;
    public boolean insert(account accs) throws Exception;
    public boolean update(account accs) throws Exception;
    public boolean delet(int accs) throws Exception;
    public List<account> findAll() throws Exception;
    public account findOne(int id) throws Exception;
}
