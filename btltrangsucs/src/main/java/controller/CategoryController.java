/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.ICategoryService;
import Service.impl.categoryService;
import java.util.List;
import model.category;

/**
 *
 * @author ASUS
 */
public class CategoryController {
    private ICategoryService dao;
    
    public CategoryController(){
       dao = new categoryService();
    }
    
    public boolean insert(category ca) throws Exception {
        return dao.insert(ca);
    }

    public boolean edit(category ca) throws Exception {
        return dao.edit(ca);
    }

    public boolean delete(String ca) throws Exception {
        return dao.delete(ca);
    }

    public List<category> findAll() throws Exception {
        return dao.findAll();
    }
    
    public category findOne(int id) throws Exception{
        return dao.findOne(id);
    }
}
