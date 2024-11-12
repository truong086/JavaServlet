/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controller.CategoryController;
import controller.ProductController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.carts;
import model.category;
import model.item;
import model.product;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "GioHangServlet", urlPatterns = {"/muahang"})
public class GioHangServlet extends HttpServlet {
    private ProductController control = new ProductController();
     private CategoryController catControl = new CategoryController();
    private ProductController proControl = new ProductController();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        carts cart = null;
//        Object o = session.getAttribute("cart");
//        if(o != null){
//            cart = (carts)o;
//        }else{
//            cart = new carts();
//        }
//        String ids = request.getParameter("id");
//        String nums = request.getParameter("num");
//        int id;
//        int num;
//        try{
//            
//            id = Integer.parseInt(ids);
//            num = Integer.parseInt(nums);
//            product pr = control.findOne(ids);
//            double price = pr.getPrice() * 1.2;
//            item t = new item(pr, num, price);
//            
//            cart.Add(t);
//            
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        List<item> list = cart.getList();
//        session.setAttribute("cart", cart);
//        session.setAttribute("size", list.size());
//        request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession(true);
        carts cart = null;
        Object o = session.getAttribute("cart");
        double tong = 0;
        double s = 0;
        if(o != null){
            cart = (carts)o;
        }else{
            cart = new carts();
        }
        String ids = request.getParameter("id");
        String nums = request.getParameter("num");
        try{
            int id;
            int num;
            id = Integer.parseInt(ids);
            num = Integer.parseInt(nums);
            product pr = control.findOne(ids);
            double price = pr.getPrice() * 1.2;
            item t = new item(pr, num, price);
            
            cart.Add(t);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            List<category> listCa = catControl.findAll();
            List<product> listPr = proControl.findAll();
            List<product> listNew = proControl.productNew();
            request.setAttribute("listC", listCa);
            request.setAttribute("listP", listPr);
            request.setAttribute("newList", listNew);
        }catch(Exception e){
            e.printStackTrace();
        }
        List<item> list = cart.getList();
        for(item i : list){
            double gia = i.getPrice();
            int soluong = i.getNum();
            s = gia * soluong;
            tong = tong + s;
        }
        session.setAttribute("tongSP", tong);
        session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
