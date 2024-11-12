/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.account;
import model.carts;


/**
 *
 * @author ASUS
 */
public interface IOrderService {
    public void insert(account ac, carts car) throws Exception;
}
