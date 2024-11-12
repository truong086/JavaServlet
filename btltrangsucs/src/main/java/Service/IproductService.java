/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import model.product;

/**
 *
 * @author ASUS
 */
public interface IproductService {
    public boolean insert(product pr) throws Exception;
    public boolean edit(product pr) throws Exception;
    public boolean delete(String pr) throws Exception;
    public List<product> findAll() throws Exception;
    public List<product> findOneCategory(String id) throws Exception;
    public product findOne(String id) throws Exception;
    public List<product> Search(String name) throws Exception;
    public List<product> productNew() throws Exception;
    public List<product> productMax() throws Exception;
    public product top1(int soluong) throws Exception;
}
