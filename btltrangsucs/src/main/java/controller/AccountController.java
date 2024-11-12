/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.IAccountService;
import Service.impl.AccountService;
import java.util.List;
import model.account;


/**
 *
 * @author ASUS
 */
public class AccountController {
    private IAccountService dao;
    public AccountController(){
        dao = new AccountService();
    }
    
    public account login(String user, String pass) throws Exception {
        return dao.login(user, pass);
    }
    
    public account check(String user) throws Exception {
        return dao.check(user);
    }
    public boolean insert(account accs) throws Exception{
        return dao.insert(accs);
    }
    public boolean update(account accs) throws Exception {
        return dao.update(accs);
    }
    public boolean delet(int accs) throws Exception {
        return dao.delet(accs);
    }
    public List<account> findAll() throws Exception {
        return dao.findAll();
    }
    public account findOne(int id) throws Exception {
        return dao.findOne(id);
    }
}
