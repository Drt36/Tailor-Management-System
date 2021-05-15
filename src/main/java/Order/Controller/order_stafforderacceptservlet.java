/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import Finance.Database.AddIncome;
import Finance.Model.Income;
import Order.Database.AddStaffInOrder;
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

/**
 *
 * @author dharm
 */
@WebServlet(name = "order_stafforderacceptservlet", urlPatterns = {"/order_stafforderacceptservlet"})
public class order_stafforderacceptservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_stafforderacceptservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_stafforderacceptservlet at " + request.getContextPath() + "</h1>");
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
            String order_id=request.getParameter("order_id_id");
            String staff_email=request.getParameter("staff_email_id");
            String product_code=request.getParameter("product_code_id");
            float paymentforstaff=Float.parseFloat(request.getParameter("paymentforstaff_id"));
            
            //update order database
            AddStaffInOrder addstaffinorder=new AddStaffInOrder();
            addstaffinorder.addStaffInOrder(staff_email, order_id);
            
            //getting date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date=dtf.format(now).toString();
            
            //add income of staff
            Income income=new Income();
            income.setOrder_id(order_id);
            income.setStaff_email(staff_email);
            income.setProduct_code(product_code);
            income.setAmount(paymentforstaff);
            income.setIncome_date(date);
            AddIncome addincome=new AddIncome();
            addincome.addIncome(income);
            
            request.setAttribute("orderacceptedmessage","You have successfully accepted this order!");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_allordersstaffview.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(order_stafforderacceptservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(order_stafforderacceptservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
