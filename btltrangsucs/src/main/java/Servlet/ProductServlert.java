/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import controller.AccountController;
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
import model.account;
import model.category;
import model.product;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ProductServlert", urlPatterns = {"/editPs", "/editSanPham", "/deletePs"})
public class ProductServlert extends HttpServlet {
    private ProductController control = new ProductController();
    private AccountController controlAc = new AccountController();
    private CategoryController controlCat = new CategoryController();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlert at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.setCharacterEncoding("UTF-8");
        String view = "";
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Object ac = session.getAttribute("acc");
        
        account acs = null;
        try{
            List<category> list = controlCat.findAll();
            if(type.equals("edit")){
                if(!id.equals("") && ac != null){
                    product pr = control.findOne(id);
                    
                    int ids = Integer.parseInt(id);
                    acs = (account)ac;
                    request.setAttribute("Acc", acs);
                    request.setAttribute("editPro", pr);
                    request.setAttribute("findAllCat", list);
                    view = "EditProduct.jsp";
                }
                
            }
            if(ac != null && type.equals("adds")){
                 request.setAttribute("Acc", acs);
                 request.setAttribute("findAllCat", list);
                view = "EditProduct.jsp";
            }
            if(type.equals("deletePr")){
                    control.delete(id);
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
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String catID = request.getParameter("categoty_id");
        String account_ID = request.getParameter("taikhoan");
        String soluong = request.getParameter("soluong");
        
        try{
            
            if(id != null){
                int ids = Integer.parseInt(id);
                double prices = Double.parseDouble(price);
                int cateID = Integer.parseInt(catID);
                int accs = Integer.parseInt(account_ID);
                int soluongs = Integer.parseInt(soluong);
                product prs = new product();
                prs.setId(ids);
                prs.setTitle(title);
                prs.setName(name);
                prs.setImage(image);
                prs.setPrice(prices);
                prs.setDescription(description);
                prs.setCatID(cateID);
                prs.setAccount_ID(accs);
                prs.setSoluong(soluongs);
                control.edit(prs);
                view = "home";
                
            }else{
                
                int cateID = Integer.parseInt(catID);
                int accs = Integer.parseInt(account_ID);
                int soluongs = Integer.parseInt(soluong);
                double prices = Double.parseDouble(price);
                product prs = new product();
                prs.setTitle(title);
                prs.setName(name);
                prs.setImage(image);
                prs.setPrice(prices);
                prs.setDescription(description);
                prs.setCatID(cateID);
                prs.setAccount_ID(accs);
                prs.setSoluong(soluongs);
                control.insert(prs);
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
