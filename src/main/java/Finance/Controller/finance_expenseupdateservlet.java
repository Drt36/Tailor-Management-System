/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Controller;

import Finance.Database.UpdateExpense;
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
@WebServlet(name = "finance_expenseupdateservlet", urlPatterns = {"/finance_expenseupdateservlet"})
public class finance_expenseupdateservlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet finance_expenseupdateservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finance_expenseupdateservlet at " + request.getContextPath() + "</h1>");
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
            String expense_title=request.getParameter("expense_title_id");
            Float  expense_amount=Float.parseFloat(request.getParameter("expense_amount_id"));
            String expense_description=request.getParameter("expense_description_id");
            String expense_id=request.getParameter("expense_id");
            //creating session
            HttpSession session=request.getSession();
            
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            //update expense
            UpdateExpense updateexpense=new UpdateExpense();
            updateexpense.updateExpenseDetails(expense_title, expense_amount, expense_description,user_email,expense_id);
            
            
            //getting time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String datetime =dtf.format(now).toString();
            
             //history register
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Expense updated: "+expense_id, datetime);
            
            //forward 
            String expenseeditedsuccessfullymessage= "Expense edited Successfully.";
            request.setAttribute("expenseeditedsuccessfullymessage",expenseeditedsuccessfullymessage);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("finance_allexpenselist.jsp");
            dispatcher.forward(request, response);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(finance_expenseupdateservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(finance_expenseupdateservlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
