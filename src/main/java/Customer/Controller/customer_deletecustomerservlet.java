/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Controller;

import Customer.Database.CustomerAllData;
import Customer.Database.DeleteCustomer;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import User.Database.StoreHistory;
import User.Model.User;
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
@WebServlet(name = "customer_deletecustomerservlet", urlPatterns = {"/customer_deletecustomerservlet"})
public class customer_deletecustomerservlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customer_deletecustomerservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customer_deletecustomerservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            String customer_email=request.getParameter("customer_email");

            
            
            //get data of customer
            CustomerAllData customeralldata=new CustomerAllData();
            Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
            String customer_fullnmae=customer.getCustomer_fullname();
            
            //delete customer
            DeleteCustomer deletecustomer=new DeleteCustomer();
            deletecustomer.deleteCustomer(customer_email);
            
            //send email
            EmailSender emailsender=new EmailSender();
            emailsender.customerRemovedEmailSender(customer_email, customer_fullnmae);
            
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
            storehistory.storeHistory(user_email,"Removed customer:"+customer_email, datetime);
            
            
            String deletecustomermessage="Selected Customer is deleted Successfully.";
            request.setAttribute("deletecustomermessage",deletecustomermessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_usercustomerlist.jsp");                         
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customer_deletecustomerservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(customer_deletecustomerservlet.class.getName()).log(Level.SEVERE, null, ex);
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
