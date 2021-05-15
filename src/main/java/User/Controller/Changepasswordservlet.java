/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Password.Encryption.Md5Hashing;
import User.Authentication.ValidateUser;
import User.Database.StoreHistory;
import User.Database.UpdateUserpassword;
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
@WebServlet(name = "Changepasswordservlet", urlPatterns = {"/Changepasswordservlet"})
public class Changepasswordservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Changepasswordservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Changepasswordservlet at " + request.getContextPath() + "</h1>");
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
        
        
             String oldpassword = request.getParameter("oldpassword_id");
             String newpassword = request.getParameter("newpassword_id");
             String confirmnewpassword= request.getParameter("confirmnewpassword_id");
             
             HttpSession session=request.getSession();
             String user_email= (String)session.getAttribute("user");
             
             ValidateUser validateuser=new ValidateUser();
             
             Md5Hashing md5hashing=new Md5Hashing();
             String password=md5hashing.getMd5(newpassword);
             
             
             
          try {
                    //validate old password
                    boolean status=validateuser.validateUserEmailPassword(user_email,oldpassword);
                
             
             if(!newpassword.equals(confirmnewpassword) && status==false){
                String allworongmessage="New password and Confirm New password did not matched!!! Old password is also Wrong!!!";
                request.setAttribute("allworongmessage", allworongmessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("changepassword.jsp");
                dispatcher.forward(request, response);
             
             }
             
             if(newpassword.equals(confirmnewpassword)){
                 
                 if(status==true){
                    //Change password method
                    UpdateUserpassword updateuserpassword=new UpdateUserpassword();
                    updateuserpassword.updateUserpassword(user_email,password);
                    
                    //getting time
                     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                     LocalDateTime now = LocalDateTime.now();  
                     String datetime =dtf.format(now).toString();
                                          
                    //stroing history
                    StoreHistory storehistory=new StoreHistory();
                    storehistory.storeHistory(user_email,"Changed Password.", datetime);

                    session.invalidate();
                    
                   String passwordchangedmessage="Your password has been changed Successfully.";
                   request.setAttribute("passwordchangedmessage",passwordchangedmessage);
                   RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                   dispatcher.forward(request, response);
                 }
                 else{
                   
                        String oldpasswordwrongmessage="Old Password is Wrong!!!";
                        request.setAttribute("oldpasswordwrongmessage",oldpasswordwrongmessage);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("changepassword.jsp");
                        dispatcher.forward(request, response);
                 
                 
                 }
               
             }else{
             
                 
                String newandconfirmpasswordnotmatchedmessage="New password and Confirm New password did not matched!!!";
                request.setAttribute("newandconfirmpasswordnotmatchedmessage",newandconfirmpasswordnotmatchedmessage);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("changepassword.jsp");
                dispatcher.forward(request, response);
             
             
             }
           
        
    }      
    catch (ClassNotFoundException | SQLException ex) {
        
                    Logger.getLogger(Changepasswordservlet.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
