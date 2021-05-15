/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Email.Sender.EmailSender;
import Random.Generator.OtpCodeGenerator;
import User.Database.StoreOtpCode;
import User.Database.UserAllData;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Forgetpasswordservlet", urlPatterns = {"/Forgetpasswordservlet"})
public class Forgetpasswordservlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Forgetpasswordservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Forgetpasswordservlet at " + request.getContextPath() + "</h1>");
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
            String user_email = request.getParameter("user_email_id");
            
            //generate otp code
            OtpCodeGenerator otpcodegenerator=new OtpCodeGenerator();
            String otpcode=otpcodegenerator.generateOtpcode();
            
            //get data of user
            UserAllData useralldata=new UserAllData();
            User user=useralldata.getAllDataOfUser(user_email);
            String fullnmae=user.getUser_fullname();
            
            //send email
            EmailSender emailsender=new EmailSender();
            emailsender.otpCodeEmailSender(user_email, fullnmae, otpcode);
            
            //save otpcode
            StoreOtpCode saveotpcode=new StoreOtpCode();
            saveotpcode.saveOtpCode(user_email, otpcode);
            
            String otpcodesuccessfullysentmessage = "OTP code has been sent to Email.";
            request.setAttribute("otpcodesuccessfullysentmessage",otpcodesuccessfullysentmessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("otpcodevalidationforforgetpassword.jsp");
            dispatcher.forward(request, response);
            
            HttpSession sessionforreset= request.getSession();
            sessionforreset.setAttribute("user_email",user_email);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Forgetpasswordservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Forgetpasswordservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
