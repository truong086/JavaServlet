/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.impl;


import DAO.IMPL.ProductDao;
import DAO.IproductDao;
import Service.IproductService;
import java.util.List;
import model.product;

/**
 *
 * @author ASUS
 */
public class productService implements IproductService{
    private IproductDao dao;
    public productService(){
        dao = new ProductDao();
    }
    @Override
    public boolean insert(product pr) throws Exception {
        return dao.insert(pr);
    }

    @Override
    public boolean edit(product pr) throws Exception {
        return dao.edit(pr);
    }

    @Override
    public boolean delete(String p) throws Exception {
        return dao.delete(p);
    }

    @Override
    public List<product> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<product> findOneCategory(String id) throws Exception {
        return dao.findOneCategory(id);
    }

    @Override
    public product findOne(String id) throws Exception {
        return dao.findOne(id);
    }

    @Override
    public List<product> Search(String name) throws Exception {
        return dao.Search(name);
    }

    @Override
    public List<product> productNew() throws Exception {
        return dao.productNew();
    }

    @Override
    public List<product> productMax() throws Exception {
        return dao.productMax();
    }

    @Override
    public product top1(int soluong) throws Exception {
        return dao.top1(soluong);
    }
    
}
