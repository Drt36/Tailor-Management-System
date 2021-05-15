/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import User.Database.StoreHistory;
import User.Database.UpdateIsBlocked;
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
@WebServlet(name = "userblockservlet", urlPatterns = {"/userblockservlet"})
public class userblockservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userblockservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userblockservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user_email=request.getParameter("user_email");
            boolean status=true;
            
            //get data of user
            UserAllData useralldata=new UserAllData();
            User user=useralldata.getAllDataOfUser(user_email);
            String fullnmae=user.getUser_fullname();
            
            //apply change in database
            UpdateIsBlocked updateisblocked=new UpdateIsBlocked();
            updateisblocked.updateIsBlock(user_email, status);
            
            
            //send email
            EmailSender emailsender=new EmailSender();
            emailsender.blockedEmailSender(user_email, fullnmae);
            
            //creating session
            HttpSession session=request.getSession();
            //get session data
            String user_emailadmin= (String)session.getAttribute("user");
                    
            //getting time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String datetime =dtf.format(now).toString();

            //stroing history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_emailadmin,"Blocked User: "+user_email, datetime);
            
            
            //forward
            String blockedsuccessfullymessage = "Selected user is blocked Successfully.";
            request.setAttribute("blockedsuccessfullymessage",blockedsuccessfullymessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("BlockedUsers.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userblockservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userblockservlet.class.getName()).log(Level.SEVERE, null, ex);
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
