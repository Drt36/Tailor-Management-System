/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Database.UserAllData;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "editprofileservlet", urlPatterns = {"/editprofileservlet"})
public class editprofileservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editprofileservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editprofileservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           
        try {
            String user_email=request.getParameter("user_email");
            //get user
            UserAllData useralldata=new UserAllData();
            User user=useralldata.getAllDataOfUser(user_email);
            
            
            request.setAttribute("user",user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editprofile.jsp");
            dispatcher.forward(request, response);
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editprofileservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editprofileservlet.class.getName()).log(Level.SEVERE, null, ex);
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
