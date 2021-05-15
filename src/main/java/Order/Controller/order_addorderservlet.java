/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Customer.Database.CustomerAllData;
import Customer.Model.Customer;
import Email.Sender.EmailSender;
import Order.Database.AddDesign;
import Order.Database.AddMeasurement;
import Order.Database.AddOrder;
import Order.Model.Design;
import Order.Model.Measurement;
import Order.Model.Order;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
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
@WebServlet(name = "order_addorderservlet", urlPatterns = {"/order_addorderservlet"})
public class order_addorderservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_addorderservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_addorderservlet at " + request.getContextPath() + "</h1>");
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
            String order_date=request.getParameter("order_date_id");
            String order_deliverydate=request.getParameter("order_deliverydate_id");
            String  order_status=request.getParameter("order_status_id");
            Float order_amount= Float.parseFloat(request.getParameter("order_amount_id"));
            Float order_clothamount= Float.parseFloat(request.getParameter("order_clothamount_id"));
            Float order_discount= Float.parseFloat(request.getParameter("order_discount_id"));
            Float order_advance= Float.parseFloat(request.getParameter("order_advance_id"));
            boolean is_paymentclear;
            String order_description=request.getParameter("order_description_id");
            
            Float order_totalamount=(order_amount+order_clothamount)-order_discount;
            Float order_remainingamount=order_totalamount-order_advance;
            
            if(order_remainingamount<=0){
                is_paymentclear=true;
            }
            else{
                is_paymentclear=false;
            }
            
            String customer_email=request.getParameter("customer_email_id");
            
            
            String product_code=request.getParameter("product_code_id");
            
            
            //generating unique id
            UUID uniqueid=UUID.randomUUID();
            String order_id=uniqueid.toString();
            
            //create order object
            Order order=new Order();
            order.setOrder_id(order_id);
            order.setCustomer_email(customer_email);
            order.setProduct_code(product_code);
            order.setOrder_title(order_title);
            order.setOrder_date(order_date);
            order.setOrder_deliverydate(order_deliverydate);
            order.setOrder_status(order_status);
            order.setOrder_amount(order_amount);
            order.setOrder_clothamount(order_clothamount);
            order.setOrder_discount(order_discount);
            order.setOrder_advance(order_advance);
            order.setOrder_totalamount(order_totalamount);
            order.setOrder_remainingamount(order_remainingamount);
            order.setIs_paymentclear(is_paymentclear);
            order.setOrder_description(order_description);
            
            //save order table
            AddOrder addorder=new AddOrder();
            addorder.addOrder(order);
            
            //create measurement object
            Measurement measurment=new Measurement();
            measurment.setOrder_id(uniqueid.toString());
            measurment.setMeasurment_title(measurement_title);
            measurment.setLength(length);
            measurment.setWaist(waist);
            measurment.setShoulder(shoulder);
            measurment.setLength_of_hand(length_of_hand);
            measurment.setNeck(neck);
            measurment.setChest(chest);
            measurment.setThigh(thigh);
            measurment.setInner_lenght(inner_height);
            measurment.setHip(hip);
            
            //save measurment
            AddMeasurement addmeasurement=new AddMeasurement();
            addmeasurement.addMeasurement(measurment);
            
           if(request.getParameter("design_url_id")!=null){ 
                String design_url=request.getParameter("design_url_id");
                //save design image from recommendation
                Design design=new Design();
                design.setOrder_id(order_id);
                design.setDesign_url(design_url);
                AddDesign adddesign=new AddDesign();
                adddesign.addDesign(design);
           }
           
           //get data of customer
            CustomerAllData customeralldata=new CustomerAllData();
            Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
            String customer_fullname=customer.getCustomer_fullname();
           
            
            //send email to customer
            EmailSender emailsender=new EmailSender();
            emailsender.orderStatusEmailSender(customer_email,customer_fullname, order_id,"Added");
            
            
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
            storehistory.storeHistory(user_email,"Order Created: "+order_id, datetime);
            
            
            request.setAttribute("orderaddedsuccessfullymessage","Order Added Successfully!");
            request.setAttribute("customer_email",customer_email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_specificcustomerorderslist.jsp");
            dispatcher.forward(request, response);
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_addorderservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_addorderservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
