/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Order.Database.AddBillNo;
import Order.Database.GetOrder;
import Order.Database.SaveBill;
import Order.Model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dharm
 */
@WebServlet(name = "order_beforeorderbillservlet", urlPatterns = {"/order_beforeorderbillservlet"})
public class order_beforeorderbillservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_beforeorderbillservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_beforeorderbillservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String customer_email=request.getParameter("customer_email");
           
            
            //getting current Date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String currentdate=formatter.format(date).toString();
            
            //generating unique id
            UUID uniqueid=UUID.randomUUID();
            String bill_id=uniqueid.toString();
            
            String order_status="New";
            boolean is_billed=false;
            //fetching list of order for specific customer
            GetOrder getorder=new GetOrder();
            ArrayList < Order > orderlist=(ArrayList)getorder.getOrdersToGenerateBill(customer_email, order_status, is_billed);
            float total_amount=0f;
            float total_advance=0f;
            float total_remaining=0f;
            if(!orderlist.isEmpty()){
                
                //calculate total
                for(Order order:orderlist){

                    total_amount=total_amount+order.getOrder_totalamount();
                    total_advance=total_advance+order.getOrder_advance();
                    total_remaining=total_remaining+order.getOrder_remainingamount();
                }

                //save Bill
                SaveBill savebill=new SaveBill();
                savebill.saveBill(bill_id,currentdate, total_amount, total_advance, total_remaining);

                for(Order order:orderlist){

                //update order table
                AddBillNo addbillno=new AddBillNo();
                addbillno.addBillNo(order.getOrder_id(), bill_id, true);

                }
            }
            
            
            request.setAttribute("customer_email",customer_email);
            request.setAttribute("current_date",currentdate);
            request.setAttribute("bill_id",bill_id);
     
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_newordersbill.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_beforeorderbillservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_beforeorderbillservlet.class.getName()).log(Level.SEVERE, null, ex);
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
