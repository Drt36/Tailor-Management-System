/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Customer.Database.CustomerAllData;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import Order.Database.ClearDue;
import Order.Database.OrderAllData;
import Order.Model.Order;
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
@WebServlet(name = "order_clearduesaveservlet", urlPatterns = {"/order_clearduesaveservlet"})
public class order_clearduesaveservlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_clearduesaveservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_clearduesaveservlet at " + request.getContextPath() + "</h1>");
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
            String order_id=request.getParameter("order_id");
            String customer_email=request.getParameter("customer_email_id");
            Float paying_amount=Float.parseFloat(request.getParameter("paying_amount_id"));
            
            //getting order details
            OrderAllData orderalldata=new OrderAllData();
            Order order=orderalldata.getAllDataOfOrder(order_id);
            
            Float order_remainingamount=order.getOrder_remainingamount();
            Float updatedamount;
            boolean is_paymentclear;
            
            if(paying_amount.equals(order_remainingamount)){
            
                is_paymentclear=true;
                updatedamount=0.0f;
                

            }
            else{
                is_paymentclear=false;
                updatedamount=order_remainingamount-paying_amount;
                
            }
            
            //update database
            ClearDue cleardue=new ClearDue();
            cleardue.clearDue(updatedamount, is_paymentclear, order_id);
          
            //get data of customer
            CustomerAllData customeralldata=new CustomerAllData();
            Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
            String customer_fullname=customer.getCustomer_fullname();
           
            
            //send email to customer
            EmailSender emailsender=new EmailSender();
            emailsender.orderPaymentEmailSender(customer_email,customer_fullname, order_id,updatedamount,paying_amount);
            
            
            //creating session
            HttpSession session=request.getSession();
            
            
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            
            //getting time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String datetime =dtf.format(now).toString();
            
            
            //history register
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Paid amount updated: "+order_id, datetime);
            
            
            request.setAttribute("customer_email",customer_email);
            request.setAttribute("paymentupdatemessage","Paid amount updated.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_specificcustomerorderslist.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_clearduesaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_clearduesaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
