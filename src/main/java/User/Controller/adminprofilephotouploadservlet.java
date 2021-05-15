/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import User.Database.GetProfilePicture;
import User.Database.ProfilePictureUpload;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(name = "adminprofilephotouploadservlet", urlPatterns = {"/adminprofilephotouploadservlet"})
@MultipartConfig(maxFileSize = 16177215)
public class adminprofilephotouploadservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet profilephotouploadservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profilephotouploadservlet at " + request.getContextPath() + "</h1>");
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
            
            String user_email= (String)session.getAttribute("user");
            boolean status=false;
            InputStream inputStream = null; // input stream of the upload file
            
            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            
            ProfilePictureUpload profilepictureupload=new ProfilePictureUpload();
            GetProfilePicture getprofilepicture=new GetProfilePicture();
            //check profile already uploaded or not
            status=getprofilepicture.checkProfilePicture(user_email);
            
            if(status==true){
                //save in database
                profilepictureupload.updateUserProfile(user_email, inputStream);
                
                //getting time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                 LocalDateTime now = LocalDateTime.now();  
                 String datetime =dtf.format(now).toString();
                                          
                //stroing history
                StoreHistory storehistory=new StoreHistory();
                storehistory.storeHistory(user_email,"Profile Picture Updated.", datetime);
                
                String uploadsuccessfullymessage = "Updated Successfully.";
                request.setAttribute("uploadsuccessfullymessage",uploadsuccessfullymessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminprofile.jsp");
                dispatcher.forward(request, response);
            }
            else{
                //save in database
                profilepictureupload.saveUserProfile(user_email, inputStream);
                
                //getting time
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
                 LocalDateTime now = LocalDateTime.now();  
                 String datetime =dtf.format(now).toString();
                                          
                //stroing history
                StoreHistory storehistory=new StoreHistory();
                storehistory.storeHistory(user_email,"Profile Picture Uploaded.", datetime);
                
                String uploadsuccessfullymessage = "Saved Successfully.";
                request.setAttribute("uploadsuccessfullymessage",uploadsuccessfullymessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminprofile.jsp");
                dispatcher.forward(request, response);
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminprofilephotouploadservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminprofilephotouploadservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
