/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.impl;

import DAO.IMPL.OrderDao;
import DAO.IOrderDao;
import Service.IOrderService;
import model.account;
import model.carts;



/**
 *
 * @author ASUS
 */
public class OrderService implements IOrderService{
    private IOrderDao dao;
    public OrderService(){
        dao = new OrderDao();
    }

    @Override
    public void insert(account ac, carts car) throws Exception {
        dao.insert(ac, car);
    }
    
}
