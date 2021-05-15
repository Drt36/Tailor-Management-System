/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Controller;

import Finance.Database.AddExpense;
import Finance.Model.Expense;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "finance_addexpenseservlet", urlPatterns = {"/finance_addexpenseservlet"})
public class finance_addexpenseservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet finance_addexpenseservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finance_addexpenseservlet at " + request.getContextPath() + "</h1>");
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
            Float expense_amount=Float.parseFloat(request.getParameter("expense_amount_id"));
            String expense_description=request.getParameter("expense_description_id");
            
            //creating session
            HttpSession session=request.getSession();
            
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            //getting time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date=dtf.format(now).toString();
            
            //creating unique id
            UUID uniqueid=UUID.randomUUID();
            //creating expense object
            Expense expense=new Expense();
            expense.setExpense_id(uniqueid.toString());
            expense.setExpense_title(expense_title);
            expense.setExpense_amount(expense_amount);
            expense.setExpense_description(expense_description);
            expense.setExpense_date(date);
            expense.setExpense_creator(user_email);
            
            //save Expense
            AddExpense addexpense=new AddExpense();
            addexpense.addExpense(expense);
                    
            //history register
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Expense Added: "+uniqueid, date);
            
            //forward 
            String expenseaddedsuccessfullymessage= "Expense added Successfully.";
            request.setAttribute("expenseaddedsuccessfullymessage",expenseaddedsuccessfullymessage);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("finance_allexpenselist.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(finance_addexpenseservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
