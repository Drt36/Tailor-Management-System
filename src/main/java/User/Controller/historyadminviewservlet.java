/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Database.HistoryList;
import User.Model.History;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dharm
 */
@WebServlet(name = "historyadminviewservlet", urlPatterns = {"/historyadminviewservlet"})
public class historyadminviewservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet historyadminviewservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet historyadminviewservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String user_email=request.getParameter("user_email");
            
            //get list of history
            HistoryList historylist=new HistoryList();
            List < History > listhistory=historylist.getHistory(user_email);
            
            request.setAttribute("listhistory",listhistory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("historyadminview.jsp");
            dispatcher.forward(request, response);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(historyadminviewservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(historyadminviewservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
