/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controller.AccountController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.account;

/**
 *
 * @author Bac Viet PC
 */
@WebServlet(name = "accountAdmin", urlPatterns = {"/accountAdmin", "/editTaikhoan"})
public class accountAdmin extends HttpServlet {
    private AccountController acccontroller = new AccountController();
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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        String view = "";
        HttpSession session = request.getSession();
        
        Object ac = session.getAttribute("acc");
        
        account acs = null;
        if(type.equals("add") && ac != null){
            acs = (account)ac;
            request.setAttribute("acc", acs);
            view = "EditAccount.jsp";
        }
        else if(type.equals("edit") && !id.equals("") && ac != null){
            account acOne = acccontroller.findOne(Integer.parseInt(id));
            acs = (account)ac;
            request.setAttribute("acc", ac);
            request.setAttribute("editPro", ac);
            view = "EditAccount.jsp";
        }else{
            acccontroller.delet(Integer.parseInt(id));
            view = "Home.jsp";
        }
        
        request.getRequestDispatcher(view).forward(request, response);
        
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
        try {
           response.setContentType("text/html;charset=UTF-8");
            String type = request.getParameter("type");
            String id = request.getParameter("id");
            String view = "";
            HttpSession session = request.getSession();

            Object ac = session.getAttribute("acc");

            account acs = null;
            if(type.equals("add") && ac != null){
                acs = (account)ac;
                request.setAttribute("acc", acs);
                view = "EditAccount.jsp";
            }
            else if(type.equals("edit") && !id.equals("") && ac != null){
                account acOne = acccontroller.findOne(Integer.parseInt(id));
                acs = (account)ac;
                request.setAttribute("acc", ac);
                request.setAttribute("editPro", acOne);
                view = "EditAccount.jsp";
            }else{
                acccontroller.delet(Integer.parseInt(id));
                view = "home";
            }
        
            request.getRequestDispatcher(view).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(accountAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String view = "";
        try {
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isSell = request.getParameter("is_sell");
            String isAdmin = request.getParameter("is_admin");
            
            
            if(id != null){
                account accsEdit = new account(Integer.parseInt(id), username, password, Integer.parseInt(isSell), Integer.parseInt(isAdmin));
                acccontroller.update(accsEdit);
                view = "home";
            }else{
                account accsEdit = new account(username, password, Integer.parseInt(isSell), Integer.parseInt(isAdmin));
                acccontroller.insert(accsEdit);
                view = "home";
            }
        } catch (Exception ex) {
            Logger.getLogger(accountAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher(view).forward(request, response);
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
