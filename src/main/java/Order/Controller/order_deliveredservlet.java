/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Customer.Database.CustomerAllData;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import Order.Database.ChangeOrderStatus;
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
@WebServlet(name = "order_deliveredservlet", urlPatterns = {"/order_deliveredservlet"})
public class order_deliveredservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_deliveredservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_deliveredservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String order_id=request.getParameter("order_id");
            String order_status="Delivered";
            
            //get customer email
            OrderAllData orderalldata=new OrderAllData();
            Order order=orderalldata.getAllDataOfOrder(order_id);
            String customer_email=order.getCustomer_email();
            
            
            //apply update on database
            ChangeOrderStatus changeorderstatus=new ChangeOrderStatus();
            changeorderstatus.updateOrderStatus(order_id,order_status);
            
            //get data of customer
            CustomerAllData customeralldata=new CustomerAllData();
            Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
            String customer_fullname=customer.getCustomer_fullname();
           
            
            //send email to customer
            EmailSender emailsender=new EmailSender();
            emailsender.orderStatusEmailSender(customer_email,customer_fullname, order_id,order_status);
            
            
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
            storehistory.storeHistory(user_email,"Order Delivered: "+order_id, datetime);
            
            
            request.setAttribute("orderdelivereddmessage","Order has been Delivered Successfully");
            request.setAttribute("customer_email",customer_email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_specificcustomerorderslist.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_deliveredservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_deliveredservlet.class.getName()).log(Level.SEVERE, null, ex);
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
