/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "order_billdetailsservlet", urlPatterns = {"/order_billdetailsservlet"})
public class order_billdetailsservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order_billdetailsservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_billdetailsservlet at " + request.getContextPath() + "</h1>");
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
        int bill_id=Integer.parseInt(request.getParameter("bill_id_id"));
        String bill_no=request.getParameter("bill_no_id");
        String bill_date=request.getParameter("bill_date_id");
        float bill_actualamount=Float.parseFloat(request.getParameter("bill_actualamount_id"));
        float bill_advanced=Float.parseFloat(request.getParameter("bill_advanced_id"));
        float bill_dueamount=Float.parseFloat(request.getParameter("bill_due_id"));
        
        
        request.setAttribute("bill_id",bill_id);
        request.setAttribute("bill_no",bill_no);
        request.setAttribute("bill_date",bill_date);
        
        request.setAttribute("bill_actualamount",bill_actualamount);
        request.setAttribute("bill_advanced",bill_advanced);
        request.setAttribute("bill_dueamount",bill_dueamount);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("order_billdetails.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
