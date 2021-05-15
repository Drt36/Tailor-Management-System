/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Database.DeleteOtpCode;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dharm
 */
@WebServlet(name = "Expireotpcodeservletforforgetpassword", urlPatterns = {"/Expireotpcodeservletforforgetpassword"})
public class Expireotpcodeservletforforgetpassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Expireotpcodeservletforforgetpassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Expireotpcodeservletforforgetpassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
            HttpSession sessionforreset=request.getSession();
            String user_email= (String)sessionforreset.getAttribute("user_email");
            
            //delete otp code
            DeleteOtpCode deleteotpcode=new DeleteOtpCode();
            deleteotpcode.deleteOtpCode(user_email);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Expireotpcodeservletforforgetpassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Expireotpcodeservletforforgetpassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
