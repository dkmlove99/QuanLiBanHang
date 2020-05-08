/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import dal.StatisticalDAO;
import entity.Order;
import entity.Statistical;
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
public class StatisticalController extends BaseRequiredAuthenticationController {

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
        float rate = 0;
        request.setAttribute("rate", Float.toString(rate));
        request.getRequestDispatcher("Statistical.jsp").forward(request, response);

    }

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
        String date = request.getParameter("date");
        Date date1 = (date == null || date.equals(""))
                ? null : Date.valueOf(date);
        StatisticalDAO sDAO = new StatisticalDAO();
        ArrayList<Statistical> stt = sDAO.getStatisticalByDateDB(date1);
        float rate = 0;
        for (int i = 0; i < stt.size(); i++) {
            float temp = stt.get(i).getTotal() - stt.get(i).getPriceIn();
            rate = rate + temp;
        }
        OrderDAO oDAO = new OrderDAO();
        ArrayList<Order> orders = oDAO.getOrderByDateDB(date1);
        request.setAttribute("orders", orders);
        request.setAttribute("rate", Float.toString(rate));
        request.getRequestDispatcher("Statistical.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}
