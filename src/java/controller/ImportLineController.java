/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ImportDAO;
import entity.ImportLine;
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
public class ImportLineController extends BaseRequiredAuthenticationController {


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher("ImportLine.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id in import Line: "+ id);
        ImportDAO oDAO = new ImportDAO();
        ArrayList<ImportLine> ImportLine = oDAO.getImportLineByIdDB(id);
        request.getSession().setAttribute("importLines", ImportLine);
       request.getRequestDispatcher("ImportLine.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}
