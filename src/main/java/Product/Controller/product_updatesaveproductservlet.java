/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Controller;

import Product.Database.SaveProductImage;
import Product.Database.UpdateProductDetails;
import User.Database.StoreHistory;
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
@WebServlet(name = "product_updatesaveproductservlet", urlPatterns = {"/product_updatesaveproductservlet"})
@MultipartConfig(maxFileSize = 16177215)
public class product_updatesaveproductservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product_updatesaveproductservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product_updatesaveproductservlet at " + request.getContextPath() + "</h1>");
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
            String product_code = request.getParameter("product_code_id");
            String product_name = request.getParameter("product_name_id");
            Float product_cost = Float.parseFloat(request.getParameter("product_cost_id"));
            Float product_paymentforstaff = Float.parseFloat(request.getParameter("product_paymentforstaff_id"));
            boolean is_available =Boolean.parseBoolean(request.getParameter("is_available_id"));
            String product_description = request.getParameter("product_description_id");
            String product_category = request.getParameter("product_category_id");
            
            //get image
            Part filePart = request.getPart("product_image_id");
            if (filePart.getSize()>0) {
                // obtains input stream of the upload file
               InputStream inputStream = filePart.getInputStream();
                
                //update image
                SaveProductImage saveproductimage=new SaveProductImage();
                saveproductimage.updateProductImage(product_code, inputStream);
            }
            
            //update product details
            UpdateProductDetails updateproductdetails=new UpdateProductDetails();
            updateproductdetails.updateProductDetails(product_name, product_cost, product_paymentforstaff, is_available, product_description, product_code,product_category);
            
         
             //creating session
            HttpSession session=request.getSession();
            //get session data
            String user_email= (String)session.getAttribute("user");
            
            //getting time
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             String datetime =dtf.format(now).toString();
                                          
            //stroing history
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Edited Products details: "+product_code, datetime);
            
            
            String updateproductmessage="Product details are updated Successfully.";
            request.setAttribute("updateproductmessage",updateproductmessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product_userviewproductlist.jsp");                         
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product_updatesaveproductservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product_updatesaveproductservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
