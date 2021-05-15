/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import User.Database.DeleteUser;
import User.Database.StoreHistory;
import User.Database.UserAllData;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
@WebServlet(name = "deleteuserservlet", urlPatterns = {"/deleteuserservlet"})
public class deleteuserservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deleteuserservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deleteuserservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String user_email=request.getParameter("user_email");
            
            //get data of user
            UserAllData useralldata=new UserAllData();
            User user=useralldata.getAllDataOfUser(user_email);
            String fullnmae=user.getUser_fullname();
            
            //delete user
            DeleteUser deleteuser=new DeleteUser();
            deleteuser.deleteUser(user_email);
            
            //send email
            EmailSender emailsender=new EmailSender();
            emailsender.removededEmailSender(user_email, fullnmae);
            
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
            storehistory.storeHistory(user_emailadmin,"Removed user:"+user_email, datetime);
            
            
            String deleteusermessage="Selected user is deleted Successfully.";
            request.setAttribute("deleteusermessage",deleteusermessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");                         
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteuserservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(deleteuserservlet.class.getName()).log(Level.SEVERE, null, ex);
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
