/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Customer.Database.CustomerAllData;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import Order.Database.UpdateMeasurement;
import Order.Database.UpdateOrder;
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
@WebServlet(name = "order_editordersaveservlet", urlPatterns = {"/order_editordersaveservlet"})
public class order_editordersaveservlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_editordersaveservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_editordersaveservlet at " + request.getContextPath() + "</h1>");
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
            //measurment form data
            String measurement_title=request.getParameter("measurement_title_id");
            Float length= Float.parseFloat(request.getParameter("length_id"));
            Float waist= Float.parseFloat(request.getParameter("waist_id"));
            Float shoulder= Float.parseFloat(request.getParameter("shoulder_id"));
            Float length_of_hand= Float.parseFloat(request.getParameter("length_of_hand_id"));
            Float neck= Float.parseFloat(request.getParameter("neck_id"));
            Float chest= Float.parseFloat(request.getParameter("chest_id"));
            Float thigh= Float.parseFloat(request.getParameter("thigh_id"));
            Float inner_height= Float.parseFloat(request.getParameter("inner_height_id"));
            Float hip= Float.parseFloat(request.getParameter("hip_id"));
            
            //order form data
            String order_title=request.getParameter("order_title_id");
            String order_deliverydate=request.getParameter("order_deliverydate_id");
            Float order_amount= Float.parseFloat(request.getParameter("order_amount_id"));
            Float order_clothamount= Float.parseFloat(request.getParameter("order_clothamount_id"));
            Float order_discount= Float.parseFloat(request.getParameter("order_discount_id"));
            Float order_advance= Float.parseFloat(request.getParameter("order_advance_id"));
            String order_description=request.getParameter("order_description_id");
            
            boolean is_paymentclear;
            
            
            Float order_totalamount=(order_amount+order_clothamount)-order_discount;
            Float order_remainingamount=order_totalamount-order_advance;
            
            if(order_remainingamount<=0){
                is_paymentclear=true;
            }
            else{
                is_paymentclear=false;
            }
            
            
            String order_id=request.getParameter("order_id");
            String customer_email=request.getParameter("customer_email_id");
            
            //update measurment details
            UpdateMeasurement updatemeasurement=new UpdateMeasurement();
            updatemeasurement.updateMeasurmentDetails(measurement_title, length, waist, shoulder, length_of_hand, neck, chest, thigh, inner_height, hip, order_id);
            
            //update order details
            UpdateOrder updateorder=new UpdateOrder();
            updateorder.updateOrderDetails(order_title, order_deliverydate, order_clothamount, order_discount, order_advance, order_totalamount, order_remainingamount, order_description, is_paymentclear, order_id);
            
            //get data of customer
            CustomerAllData customeralldata=new CustomerAllData();
            Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
            String customer_fullname=customer.getCustomer_fullname();
           
            
            //send email to customer
            EmailSender emailsender=new EmailSender();
            emailsender.orderStatusEmailSender(customer_email,customer_fullname, order_id,"Updated");
            
            
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
            storehistory.storeHistory(user_email,"Order updated: "+order_id, datetime);
            
            request.setAttribute("orderupdatedsuccessfullymessage","Order updated Successfully!");
            request.setAttribute("customer_email",customer_email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_specificcustomerorderslist.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_editordersaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_editordersaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
