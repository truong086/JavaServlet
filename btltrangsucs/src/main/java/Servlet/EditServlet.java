/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controller.CategoryController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.category;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/edits", "/editData", "/delete"})
public class EditServlet extends HttpServlet {
    private CategoryController control = new CategoryController();
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
        request.setCharacterEncoding("UTF-8");
        String view = "";
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        
        try{
            if(type.equals("edit")){
                if(id != null){
                    int ids = Integer.parseInt(id);
                    try{
                        category cate = control.findOne(ids);
                        List<category> list = control.findAll();
                        request.setAttribute("list", list);
                        request.setAttribute("editData", cate);
                        view = "EditFrom.jsp";
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    view = "EditFrom.jsp"; 
                }
            }
            
            if(type.equals("delete")){
                if(id != null){
                    try{
                        control.delete(id);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                view = "home"; 
            }

           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        request.getRequestDispatcher(view).forward(request, response);
        
        
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
        request.setCharacterEncoding("UTF-8");
        String view = "";
        String id = request.getParameter("id");
        String tenloai = request.getParameter("tenloai");
        String ngaytao = request.getParameter("ngaytao");
        try{
            if(id != null){
                int ids = Integer.parseInt(id);
                category ca = control.findOne(ids);
                if(ca != null){
                    category cas = new category();
                    cas.setId(ids);
                    cas.setTenloai(tenloai);
                    cas.setNgaytao(ngaytao);
                    control.edit(cas);
                    view = "home";
                    
                }
            }else if(id == null){
                category cas = new category();
                cas.setTenloai(tenloai);
                cas.setNgaytao(ngaytao);
                
                control.insert(cas);
                view = "home";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        response.sendRedirect(view);
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
