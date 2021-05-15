/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Database.StoreHistory;
import User.Database.UpdateUserDetails;
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
@WebServlet(name = "editprofilesaveservlet", urlPatterns = {"/editprofilesaveservlet"})
public class editprofilesaveservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editprofilesaveservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editprofilesaveservlet at " + request.getContextPath() + "</h1>");
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
            String user_fullname = request.getParameter("user_fullname_id");
            String user_email = request.getParameter("user_email_id");
            String user_address = request.getParameter("user_address_id");
            String user_dateofbirth = request.getParameter("user_dateofbirth_id");
            String user_gender=request.getParameter("user_gender_id");
            String role=request.getParameter("user_role_id");
            
            
            //update user details
            UpdateUserDetails updateuserdetails=new UpdateUserDetails();
            updateuserdetails.updateUserDetails(user_email, user_fullname, user_address, user_dateofbirth, user_gender,role);
            
         
            //getting time
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             String datetime =dtf.format(now).toString();
                                          
            //stroing history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Edited user details.", datetime);
            
            String updateusermessage="User details are updated Successfully.";
            request.setAttribute("updateusermessage",updateusermessage);
            
            //redirect user according to role
            if(role.equalsIgnoreCase("admin")){
                           
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminprofile.jsp");                         
                dispatcher.forward(request, response);
                        
            }
                                        
            else if(role.equalsIgnoreCase("user")){
                                 
                RequestDispatcher dispatcher = request.getRequestDispatcher("userprofile.jsp");                         
                dispatcher.forward(request, response);
                  
            }
                                        
            else if(role.equalsIgnoreCase("staff")){
                     
                RequestDispatcher dispatcher = request.getRequestDispatcher("staffprofile.jsp");                                      
                dispatcher.forward(request, response);
                           
            }
                                        
            else{
                       
                String rolenotcreated=" Role is not created. contact the support Department";
                                          
                request.setAttribute("rolenotcreated",rolenotcreated);
                                          
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                          
                dispatcher.forward(request, response);
                                      
                                      
                                        
            }
              
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editprofilesaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editprofilesaveservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
