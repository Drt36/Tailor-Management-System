/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Controller;

import Email.Sender.EmailSender;
import Finance.Database.AddSalary;
import Finance.Model.Salary;
import User.Database.StoreHistory;
import User.Database.UserAllData;
import User.Model.User;
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
@WebServlet(name = "finance_paysalaryfinalservlet", urlPatterns = {"/finance_paysalaryfinalservlet"})
public class finance_paysalaryfinalservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet finance_paysalaryfinalservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finance_paysalaryfinalservlet at " + request.getContextPath() + "</h1>");
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
            String staff_email=request.getParameter("staff_email_id");
            Float paying_amount=Float.parseFloat(request.getParameter("paying_amount_id"));
            
            //getting staff all data
            UserAllData useralldata=new UserAllData();
            User staff=useralldata.getAllDataOfUser(staff_email);
            
            //getting staff name
            String staff_fullname=staff.getUser_fullname();
            
            //getting date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date=dtf.format(now).toString();
            
            //making Object
            Salary salary=new Salary();
            salary.setStaff_email(staff_email);
            salary.setSalary_date(date);
            salary.setAmount(paying_amount);
            
            //update in database
            AddSalary addsalary=new AddSalary();
            addsalary.addSalry(salary);
            
            //email
            EmailSender emailsender=new EmailSender();
            emailsender.salaryPaymentEmailSender(staff_email,staff_fullname, paying_amount);
            
            //creating session
            HttpSession session=request.getSession();
            
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            
            //history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Salary paid: "+staff_fullname, date);
            
            
            request.setAttribute("salarypaymentupdatemessage","Salary Paid amount updated.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userview_allstafflist.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(finance_paysalaryfinalservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(finance_paysalaryfinalservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
