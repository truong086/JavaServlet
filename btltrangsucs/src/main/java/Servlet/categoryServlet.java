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
import model.category;
import model.product;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "categoryServlet", urlPatterns = {"/categoryServlet", "/serch"})
public class categoryServlet extends HttpServlet {
    private CategoryController control = new CategoryController();
    private ProductController controlP = new ProductController();
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
        String id = request.getParameter("id");
        try{
            List<product> list = controlP.findOneCategory(id);
            List<category> cate = control.findAll();
            
            request.setAttribute("ids", id);
            request.setAttribute("listP1", list);
            request.setAttribute("listCs", cate);
            request.getRequestDispatcher("productCategory.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
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
        String timkiem = request.getParameter("timkiem");
        
        try{
            List<product> serchs = controlP.Search(timkiem);
            List<category> listCa = control.findAll();
            request.setAttribute("listP1", serchs);
            request.setAttribute("listCs", listCa);
            request.setAttribute("keys", timkiem);
            request.getRequestDispatcher("productCategory.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
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
