/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Controller;

import Customer.Database.RegisterCustomer;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addcustomerservlet", urlPatterns = {"/addcustomerservlet"})
public class addcustomerservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addcustomerservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addcustomerservlet at " + request.getContextPath() + "</h1>");
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
            String customer_username = request.getParameter("customer_username_id");
            String customer_fullname = request.getParameter("customer_fullname_id");
            String customer_email = request.getParameter("customer_email_id");
            String customer_contact =request.getParameter("customer_phonenumber_id");
            String customer_address = request.getParameter("customer_address_id");
            String customer_dateofbirth = request.getParameter("customer_dateofbirth_id");
            String customer_gender=request.getParameter("customer_gender_id");
            
            //creating object
            RegisterCustomer registercustomer=new RegisterCustomer();
            
            //creating customer object
            Customer customer=new Customer();
            customer.setCustomer_username(customer_username);
            customer.setCustomer_fullname(customer_fullname);
            customer.setCustomer_email(customer_email);
            customer.setCustomer_contact(customer_contact);
            customer.setCustomer_address(customer_address);
            customer.setCustomer_dateofbirth(customer_dateofbirth);
            customer.setCustomer_gender(customer_gender);
            
            //saving customer
            registercustomer.addCustomer(customer);
            
            
            //email
            EmailSender emailsender=new EmailSender();
            emailsender.welcomeCustomerEmailSender(customer_email, customer_fullname,customer_username);
            
            
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
            storehistory.storeHistory(user_email,"Added Customer: "+customer_email, datetime);
            
            
            //forward 
            String customeraddedsuccessfullymessage= "New Customer added Successfully.";
            request.setAttribute("customeraddedsuccessfullymessage",customeraddedsuccessfullymessage);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_usercustomerlist.jsp");
            dispatcher.forward(request, response);
            
      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addcustomerservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
