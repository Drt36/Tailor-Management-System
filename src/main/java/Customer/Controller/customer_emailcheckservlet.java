/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Controller;

import Customer.Authentication.ValidateCustomerEmail;
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

/**
 *
 * @author dharm
 */
@WebServlet(name = "customer_emailcheckservlet", urlPatterns = {"/customer_emailcheckservlet"})
public class customer_emailcheckservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customer_emailcheckservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customer_emailcheckservlet at " + request.getContextPath() + "</h1>");
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
        try {
            String customer_email = request.getParameter("customer_email");
            boolean status=false;
            ValidateCustomerEmail validatecustomeremail=new ValidateCustomerEmail();
            status=validatecustomeremail.validateCustomerEmail(customer_email);
            
            
            if(status==true)
            {
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                out.print("Email Already Exist!");
                
            }
            if(status==false)
            {
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                out.print("NotExist");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customer_emailcheckservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(customer_emailcheckservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
      
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
