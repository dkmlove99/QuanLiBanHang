/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import entity.Customer;
import entity.Order;
import entity.OrderLine;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class ShoppingCartController extends BaseRequiredAuthenticationController {

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
        System.out.println("111111111111111111111");
        OrderDAO oDAO = new OrderDAO();
        String id = request.getParameter("id");
        OrderLine ol = oDAO.getOderByID(id);        
        ArrayList<Order> orders = oDAO.getOderDB();
        request.getSession().setAttribute("orders", orders);
        request.getSession().setAttribute("oderLine", ol);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helu");   
        String name = request.getParameter("name");
        String sdt = request.getParameter("sdt");
        String dateT = request.getParameter("dateT");
        String dateF = request.getParameter("dateF");
        name = (name==null)?"":name;
        sdt = (sdt==null)?"":sdt;
        Date from = (dateF == null || dateF.equals(""))
                ? null : Date.valueOf(dateF);
        Date to = (dateT == null || dateT.equals(""))
                ? null : Date.valueOf(dateT);
        OrderDAO oDAO = new OrderDAO();
        
        ArrayList<Order> orders = oDAO.searchOrder(name, sdt, to, from);
        request.getSession().setAttribute("orders", orders);
        request.getRequestDispatcher("Cart.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}
