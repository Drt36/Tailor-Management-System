/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import Password.Encryption.Md5Hashing;
import Random.Generator.PasswordGenerator;
import User.Authentication.ValidateEmail;
import User.Authentication.ValidateUsername;
import User.Database.StoreHistory;
import User.Database.UserRegister;
import User.Model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

/**
 *
 * @author dharm
 */
@WebServlet(name = "registerservlet", urlPatterns = {"/registerservlet"})
public class registerservlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerservlet at " + request.getContextPath() + "</h1>");
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
            String username = request.getParameter("user_username_id");
            String user_fullname = request.getParameter("user_fullname_id");
            String user_email = request.getParameter("user_email_id");
            String user_contact =request.getParameter("user_phonenumber_id");
            String user_address = request.getParameter("user_address_id");
            String user_dateofbirth = request.getParameter("user_dateofbirth_id");
            String user_gender=request.getParameter("user_gender_id");
            String user_role=request.getParameter("user_role_id");
            boolean user_contactverified=false;
            PasswordGenerator passwordgenerator=new PasswordGenerator();
            
            String user_passwordforhashing=passwordgenerator.generatePassword();
            String user_passwordforuser=user_passwordforhashing;
            
            
            //make object of Md5hashing Class
            Md5Hashing md5hashing=new Md5Hashing();
            
            //make object of UserRegister class
            UserRegister userregister=new UserRegister();
            
            
            //Hash password
            String user_password=md5hashing.getMd5(user_passwordforhashing);
            
            //create new user
            User user = new User();
            user.setUsername(username);
            user.setUser_fullname(user_fullname);
            user.setUser_email(user_email);
            user.setUser_contact(user_contact);
            user.setUser_address(user_address);
            user.setUser_dateofbirth(user_dateofbirth);
            user.setUser_gender(user_gender);
            user.setUser_role(user_role);
            user.setUser_password(user_password);
            user.setUser_contactverified(user_contactverified);
            //save user Object
            userregister.saveUser(user);
            
            //send email to users
            EmailSender emailsender=new EmailSender();
            emailsender.welcomeEmailSender(user_email, user_fullname,user_passwordforuser);
            
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
            storehistory.storeHistory(user_emailadmin,"Added User: "+user_email, datetime);
            
            
            String usercreatesuccessfullymessage = "New user added Successfully.";
            request.setAttribute("usercreatesuccessfullymessage",usercreatesuccessfullymessage);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
             
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
