/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.IOrderService;
import Service.impl.OrderService;
import model.account;
import model.carts;


/**
 *
 * @author ASUS
 */
public class OrderController {
    private IOrderService daoService;
    public OrderController(){
        daoService = new OrderService();
    }
    public void insert(account ac, carts car) throws Exception {
        daoService.insert(ac, car);
    }
}
