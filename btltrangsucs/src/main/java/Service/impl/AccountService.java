/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.impl;

import DAO.IAccountDao;
import DAO.IMPL.AccountDao;
import Service.IAccountService;
import java.util.List;
import model.account;


/**
 *
 * @author ASUS
 */
public class AccountService implements IAccountService{
    private IAccountDao dao;
    public AccountService(){
        dao = new AccountDao();
    }
    @Override
    public account login(String user, String pass) throws Exception {
        return dao.login(user, pass);
    }

    @Override
    public account check(String user) throws Exception {
        return dao.check(user);
    }

    @Override
    public boolean insert(account accs) throws Exception {
        return dao.insert(accs);
    }

    @Override
    public boolean update(account accs) throws Exception {
        return dao.update(accs);
    }

    @Override
    public boolean delet(int accs) throws Exception {
        return dao.delet(accs);
    }

    @Override
    public List<account> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public account findOne(int id) throws Exception {
        return dao.findOne(id);
    }
    
}
