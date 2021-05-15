/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Authentication.ValidateOtpCode;
import User.Database.DeleteOtpCode;
import User.Database.StoreHistory;
import User.Database.UpdateUserContactVerified;
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
@WebServlet(name = "codevalidationservlet", urlPatterns = {"/codevalidationservlet"})
public class Codevalidationservletforcontact extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet codevalidationservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet codevalidationservlet at " + request.getContextPath() + "</h1>");
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
   
            //creating session
            HttpSession session=request.getSession();
            //get session data
            String user_email= (String)session.getAttribute("user");
        
            
            UserAllData useralldata=new UserAllData();
                              
            User user=useralldata.getAllDataOfUser(user_email);
            //get userrole
            String role=user.getUser_role();
            
                //delete otp code
                DeleteOtpCode deleteotpcode=new DeleteOtpCode();
                deleteotpcode.deleteOtpCode(user_email);
                
                boolean usercontactverifiedstatus=true;
                
                //update user database
                UpdateUserContactVerified updateusercontactverified=new UpdateUserContactVerified();
                updateusercontactverified.updateUserContactVerified(user_email,usercontactverifiedstatus);
                
                //getting time
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                 LocalDateTime now = LocalDateTime.now();  
                 String datetime =dtf.format(now).toString();
                                          
                //stroing history
                StoreHistory storehistory=new StoreHistory();
                storehistory.storeHistory(user_email,"Verified mobile number.", datetime);
                
                String otpcodevalidmessage = "your Mobile Number has been Verified Successfully.";
                request.setAttribute("otpcodevalidmessage",otpcodevalidmessage);

                if(role.equalsIgnoreCase("admin")){
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("adminpanel.jsp");
                    dispatcher.forward(request, response);                     
                }
                                        
                else if(role.equalsIgnoreCase("user")){                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("userpanel.jsp");                                         
                    dispatcher.forward(request, response);
                       
                }
                                        
                else if(role.equalsIgnoreCase("staff")){
                          
                    RequestDispatcher dispatcher = request.getRequestDispatcher("staffpanel.jsp");                                          
                    dispatcher.forward(request, response);
                           
                }
                                        
                else{
                 
                    String rolenotcreated=" Role is not created. contact the support Department";                     
                    request.setAttribute("rolenotcreated",rolenotcreated);                                          
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");                                          
                    dispatcher.forward(request, response);
                 
                
            
            }
       
        } catch (Exception ex) {
            Logger.getLogger(Codevalidationservletforcontact.class.getName()).log(Level.SEVERE, null, ex);
        } 
          
    
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
