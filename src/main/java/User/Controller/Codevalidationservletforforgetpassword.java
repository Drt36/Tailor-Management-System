/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import Password.Encryption.Md5Hashing;
import Random.Generator.PasswordGenerator;
import User.Database.DeleteOtpCode;
import User.Database.StoreHistory;
import User.Database.UpdateUserContactVerified;
import User.Database.UpdateUserpassword;
import User.Database.UserAllData;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Codevalidationservletforforgetpassword", urlPatterns = {"/Codevalidationservletforforgetpassword"})
public class Codevalidationservletforforgetpassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Codevalidationservletforforgetpassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Codevalidationservletforforgetpassword at " + request.getContextPath() + "</h1>");
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
        
      try{             
            boolean status=true;
            
            HttpSession sessionforreset=request.getSession();
            String user_email= (String)sessionforreset.getAttribute("user_email");
        
            
            UserAllData useralldata=new UserAllData();
                              
            User user=useralldata.getAllDataOfUser(user_email);
            //get userrole
            String user_fullname=user.getUser_fullname();
            
            //delete otp code
             DeleteOtpCode deleteotpcode=new DeleteOtpCode();
             deleteotpcode.deleteOtpCode(user_email);
             
             //generate random password
             PasswordGenerator passwordgenerator=new PasswordGenerator();
             String password= passwordgenerator.generatePassword();
             
            //send email
            EmailSender emailsender=new EmailSender();
            emailsender.resetPasswordEmailSender(user_email, user_fullname, password);
           
            //hash password
            Md5Hashing md5hashing=new Md5Hashing();
            String HashedPassword=md5hashing.getMd5(password);
            
            //update user database
            UpdateUserpassword updateuserpassword=new UpdateUserpassword();
            updateuserpassword.updateUserpassword(user_email, HashedPassword);
            
            //getting time
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             String datetime =dtf.format(now).toString();
                                          
            //stroing history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Password Reseted.", datetime);
            
            sessionforreset.invalidate();
            
            String passwordresetmessage = "Password is Reseted successfully.Please Check your email!";
            request.setAttribute("passwordresetmessage",passwordresetmessage);
                
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);                     
              
       
        } catch (Exception ex) {
            Logger.getLogger(Codevalidationservletforcontact.class.getName()).log(Level.SEVERE, null, ex);
        } 

        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
