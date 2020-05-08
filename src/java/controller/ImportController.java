/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ImportDAO;
import entity.Import;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class ImportController extends BaseRequiredAuthenticationController {

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
        ImportDAO iDAO = new ImportDAO();
        ArrayList<Import> ip = iDAO.getImportDB();
        request.getSession().setAttribute("ip", ip);
        request.getRequestDispatcher("Import.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String nguoiNhap = request.getParameter("nguoiNhap");
        String sdt = request.getParameter("sdt");
        String dateT = request.getParameter("dateT");
        String dateF = request.getParameter("dateF");
        name = (name==null)?"":name;
        sdt = (sdt==null)?"":sdt;
        nguoiNhap = (nguoiNhap==null)?"":nguoiNhap;
        Date from = (dateF == null || dateF.equals(""))
                ? null : Date.valueOf(dateF);
        Date to = (dateT == null || dateT.equals(""))
                ? null : Date.valueOf(dateT);
        ImportDAO iDAO = new ImportDAO();
        
        ArrayList<Import> imports = iDAO.searchImportDB(name, sdt, to, from,nguoiNhap);
        request.getSession().setAttribute("ip", imports);
        request.getRequestDispatcher("Import.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}
