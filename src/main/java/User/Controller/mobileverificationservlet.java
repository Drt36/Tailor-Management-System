/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import Random.Generator.OtpCodeGenerator;
import Sms.Sender.SendSms;
import User.Database.DeleteOtpCode;
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
@WebServlet(name = "mobileverificationservlet", urlPatterns = {"/mobileverificationservlet"})
public class mobileverificationservlet extends HttpServlet {
    
    long time=120000;
    String user_email;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mobileverificationservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mobileverificationservlet at " + request.getContextPath() + "</h1>");
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
                
                String user_contact= request.getParameter("user_phonenumber_id");
                
                //creating session
                HttpSession session=request.getSession();
                
                user_email= (String)session.getAttribute("user");
                //get data of user
                
                UserAllData useralldata=new UserAllData();
                
                User user=useralldata.getAllDataOfUser(user_email);
                //get username
                String user_fullname=user.getUser_fullname();
                
                //get ranmdom OTP code
                OtpCodeGenerator otpcodegenerator=new OtpCodeGenerator();
                String otpcode=otpcodegenerator.generateOtpcode();
                
   
                //store Otpcode in the database
                StoreOtpCode storeotpcode=new StoreOtpCode();
                storeotpcode.saveOtpCode(user_email, otpcode);
                
                //send sms to user's contact number
                SendSms sendsms=new SendSms();
                sendsms.sendMessage(user_contact, user_fullname, user_email,otpcode);

                String otpcodesuccessfullysentmessage = "OTP code has been sent to your phone.";
                request.setAttribute("otpcodesuccessfullysentmessage",otpcodesuccessfullysentmessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("otpcodevalidationforcontact.jsp");
                dispatcher.forward(request, response);
 } 
 catch (Exception ex) {           
     Logger.getLogger(mobileverificationservlet.class.getName()).log(Level.SEVERE, null, ex);
  }
            
            
            
 }      
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
