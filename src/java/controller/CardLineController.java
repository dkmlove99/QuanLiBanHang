/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import entity.Order;
import entity.OrderLine;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class CardLineController extends BaseRequiredAuthenticationController {



 
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
         request.getRequestDispatcher("CartLine.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
        OrderDAO oDAO = new OrderDAO();
        ArrayList<OrderLine> orderLines = oDAO.getOderLineByIdOder(id);
       request.getSession().setAttribute("orderLines", orderLines);
        request.getRequestDispatcher("CartLine.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}
