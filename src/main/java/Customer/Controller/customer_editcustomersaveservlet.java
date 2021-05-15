/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Controller;

import Customer.Database.UpdateCustomerDetails;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "customer_editcustomersaveservlet", urlPatterns = {"/customer_editcustomersaveservlet"})
public class customer_editcustomersaveservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customer_editcustomersaveservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customer_editcustomersaveservlet at " + request.getContextPath() + "</h1>");
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
            String customer_fullname = request.getParameter("customer_fullname_id");
            String customer_contact =request.getParameter("customer_phonenumber_id");
            String customer_address = request.getParameter("customer_address_id");
            String customer_dateofbirth = request.getParameter("customer_dateofbirth_id");
            String customer_gender=request.getParameter("customer_gender_id");
            String customer_email = request.getParameter("customer_email_id");
            
            
            //update database
            UpdateCustomerDetails updatecustomerdetails=new UpdateCustomerDetails();
            updatecustomerdetails.updateUserDetails(customer_email, customer_fullname, customer_contact, customer_address, customer_dateofbirth, customer_gender);
            
            
             //creating session
            HttpSession session=request.getSession();
            
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            //getting time
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             String datetime =dtf.format(now).toString();
                                          
            //stroing history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Edited customer details: "+customer_email, datetime);
            
            
            String updatecustomermessage="Customer details are updated Successfully.";
            request.setAttribute("updatecustomermessage",updatecustomermessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_usercustomerlist.jsp");                         
            dispatcher.forward(request, response);
            
    
     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customer_editcustomersaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(customer_editcustomersaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
