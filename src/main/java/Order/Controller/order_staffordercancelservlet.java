/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Finance.Database.RemoveIncome;
import Order.Database.RemoveStaffFormOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "order_staffordercancelservlet", urlPatterns = {"/order_staffordercancelservlet"})
public class order_staffordercancelservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_staffordercancelservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_staffordercancelservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String order_id=request.getParameter("order_id");
            
            //update order database
            RemoveStaffFormOrder removestafffromorder=new  RemoveStaffFormOrder();
            removestafffromorder.removeStaffFromOrder(order_id);
            
            
            //remove income from income list
            RemoveIncome removeincome=new RemoveIncome();
            removeincome.removestaffincome(order_id);
            
            
            request.setAttribute("ordercancelledmessage","You have successfully Cancelled this order!");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_allordersstaffview.jsp");
            dispatcher.forward(request, response);
            
            //history
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_staffordercancelservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_staffordercancelservlet.class.getName()).log(Level.SEVERE, null, ex);
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
