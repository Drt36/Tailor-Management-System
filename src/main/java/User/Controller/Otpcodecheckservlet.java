/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;
import User.Authentication.ValidateOtpCode;
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
@WebServlet(name = "Otpcodecheckservlet", urlPatterns = {"/Otpcodecheckservlet"})
public class Otpcodecheckservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Otpcodecheckservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Otpcodecheckservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String otpcode= request.getParameter("otpcode");
        boolean status=false;
        ValidateOtpCode validateotpcode=new ValidateOtpCode();
        
        //creating session       
        HttpSession session=request.getSession();  
        String user_email= (String)session.getAttribute("user");
        try {
            status=validateotpcode.validateOtpCode(user_email, otpcode);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(usernamecheckservlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if(status==true)
        {
          response.setContentType("text/html");
          PrintWriter out=response.getWriter();
          out.print("True");
        
        }
        if(status==false)
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.print("False");
        
        
        }
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
