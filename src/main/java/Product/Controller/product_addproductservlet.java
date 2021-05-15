/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Controller;

import Product.Database.AddProduct;
import Product.Database.SaveProductImage;
import Product.Model.Product;
import User.Database.StoreHistory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
@WebServlet(name = "product_addproductservlet", urlPatterns = {"/product_addproductservlet"})
@MultipartConfig(maxFileSize = 16177215)
public class product_addproductservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product_addproductservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product_addproductservlet at " + request.getContextPath() + "</h1>");
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
            String product_category= request.getParameter("product_category_id");
            //get image
            InputStream inputStream = null;
            Part filePart = request.getPart("product_image_id");
            if (filePart != null) {
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            
            
            //creating object
            AddProduct addproduct=new AddProduct();
            
            //creating customer object
            Product product=new Product();
            product.setProduct_code(product_code);
            product.setProduct_name(product_name);
            product.setProduct_cost(product_cost);
            product.setProduct_paymentforstaff(product_paymentforstaff);
            product.setIs_available(is_available);
            product.setProduct_description(product_description);
            product.setProduct_category(product_category);
            
            //saving product
            addproduct.addProduct(product);
            
            //save image
            SaveProductImage saveproductimage=new SaveProductImage();
            saveproductimage.saveProductImage(product_code, inputStream);
            
            
            
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
            storehistory.storeHistory(user_email,"Added Product: "+product_name, datetime);
            
            
            //forward 
            String productaddedsuccessfullymessage= "New Product added Successfully.";
            request.setAttribute("productaddedsuccessfullymessage",productaddedsuccessfullymessage);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("product_userviewproductlist.jsp");
            dispatcher.forward(request, response);
            
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product_addproductservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
