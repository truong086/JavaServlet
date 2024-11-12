/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
import model.item;
import model.product;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SoluongController", urlPatterns = {"/soluong"})
public class SoluongController extends HttpServlet {
    private ProductController control = new ProductController();
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
        response.setContentType("text/html;charset=UTF-8");
        
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
        int id = Integer.parseInt(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));
        try{
            if((num == -1) && (cart.getBySoLuong(id) <= 1)){
                cart.deletes(id);
            }else{
                 product pr = control.findOne(ids);
                 double price = pr.getPrice() * 1.2;
                 item i = new item(pr, num, price);
                 
                 cart.Add(i);
                 
                 
                 
            }
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
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
        
        try{
            String id = request.getParameter("id");
            int ids;
            ids = Integer.parseInt(id);
            cart.deletes(ids);
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
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
