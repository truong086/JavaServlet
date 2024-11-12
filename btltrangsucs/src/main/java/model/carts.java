/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class carts {
    private List<item> list;

    public carts(List<item> list) {
        this.list = list;
    }

    public carts() {
        list = new ArrayList<>();
    }

    public List<item> getList() {
        return list;
    }

    public void setList(List<item> list) {
        this.list = list;
    }
    
    public item getProductOne(int id){
        for(item i : list){
            if(i.getProduc().getId() == id){
                return i;
            }
        }
        return null;
        }
    
    public int getBySoLuong(int id){
        return getProductOne(id).getNum();
    }
    
    public void Add(item i){
        if(getProductOne(i.getProduc().getId()) != null){
            // Lấy ra id của sản phẩm vừa được chuyền vào
            item t = getProductOne(i.getProduc().getId());
            t.setNum(t.getNum()+ i.getNum());
        }else{
            list.add(i);
        }
    }
    
    public void deletes(int id){
        for(item i : list){
            if(getProductOne(id) != null){
                list.remove(getProductOne(id));
            }
        }
    }
    
    public int tongtien(){
        int sum = 0;
        
        for(item i : list){
            sum += i.getNum() * i.getPrice();
        }
        return sum;
    }
    
}
