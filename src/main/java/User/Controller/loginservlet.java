/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import User.Authentication.ValidateUser;
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
@WebServlet(name = "loginservlet", urlPatterns = {"/loginservlet"})
public class loginservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginservlet at " + request.getContextPath() + "</h1>");
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
    
             String email= request.getParameter("email");
             String password = request.getParameter("password"); 
             
             request.setAttribute("user_email1",email);
             
             boolean status=false;
             ValidateUser validateuser=new ValidateUser();
             
        try {
            status=validateuser.validateUserEmailPassword(email, password);
                     if (status==true) {
                                  //creating session
                                  HttpSession session=request.getSession();
                                  session.setAttribute("user",email);
                                
                                  String sessioncontainer = (String)session.getAttribute("user");
                                  //get data of user
                                  UserAllData useralldata=new UserAllData();
                                  User user=useralldata.getAllDataOfUser(email);
                                  //get role
                                  String role=user.getUser_role();
                                  //get username
                                  String name=user.getUsername();
                                  //get email
                                  String user_email=user.getUser_email();
                                  
                                  //get user_contactverified
                                  boolean user_contactverified=user.isUser_contactverified();
                                  
                                  //get user is_blocked
                                  boolean is_blocked=user.isIs_blocked();
                                  //get user_conatct
                                  String user_contact=user.getUser_contact();
                              
                                  if(sessioncontainer!=null){
                                  
                                   if(is_blocked==false){
                                      
                                        if(user_contactverified==true){


                                            if(role.equalsIgnoreCase("admin")){
                                                
                                               //login time
                                               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                                               LocalDateTime now = LocalDateTime.now();  
                                               String datetime =dtf.format(now).toString();

                                               //stroing login data
                                               StoreHistory storehistory=new StoreHistory();
                                               storehistory.storeHistory(user_email,"Login into System", datetime);
                                               

                                              response.sendRedirect("adminpanel.jsp");  

                                            }
                                            else if(role.equalsIgnoreCase("user")){
                                                
                                              //login time
                                               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                                               LocalDateTime now = LocalDateTime.now();  
                                               String datetime =dtf.format(now).toString();
                                          
                                               //stroing login data
                                               StoreHistory storehistory=new StoreHistory();
                                               storehistory.storeHistory(user_email,"Login into System", datetime);

                                              response.sendRedirect("userpanel.jsp");  


                                              }
                                            else if(role.equalsIgnoreCase("staff")){
                                                
                                              //login time
                                               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                                               LocalDateTime now = LocalDateTime.now();  
                                               String datetime =dtf.format(now).toString();
                                          
                                               //stroing login data
                                               StoreHistory storehistory=new StoreHistory();
                                               storehistory.storeHistory(user_email,"Login into System", datetime);

                                              response.sendRedirect("staffpanel.jsp");  

                                                }
                                            else{


                                              String rolenotcreated=" Role is not created. contact the support Department";
                                              request.setAttribute("rolenotcreated",rolenotcreated);
                                              RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                              dispatcher.forward(request, response);


                                            }



                                            }
                                             else{
                                                   String username=name;
                                                   request.setAttribute("username",username);
                                                   request.setAttribute("user_contact",user_contact);
                                                   RequestDispatcher dispatcher = request.getRequestDispatcher("mobileverification.jsp");
                                                   dispatcher.forward(request, response);
                                             }
                                   }
                                   else{
                                   
                                       String blockedmessage="You are Blocked!!! You can not use this system!";
                                       request.setAttribute("blockedmessage",blockedmessage);
                                       RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                          dispatcher.forward(request, response);
           
                                   }
                                  } 
                                  else{
                                      
                                       String sessionnotcreated="session is not created.contact the support Department";
                                       request.setAttribute("sessionnotcreated",sessionnotcreated);
                                       RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                          dispatcher.forward(request, response);
                                  }
                                   
                                  }
                            else{
                               String wrongcredentials = "Wrong Credentials!!! \n Email and Password did not matched.";
                               request.setAttribute("wrongcredentials", wrongcredentials);
                                String forgetpassword="Forget Password?";
                                request.setAttribute("forgetpassword",forgetpassword);
                                         
                                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                dispatcher.forward(request, response);
                              }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
