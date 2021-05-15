/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Controller;

import Product.Authentication.ValidateProductCode;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "product_productcodecheckservlet", urlPatterns = {"/product_productcodecheckservlet"})
public class product_productcodecheckservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product_productcodecheckservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product_productcodecheckservlet at " + request.getContextPath() + "</h1>");
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
            String product_code = request.getParameter("product_code");
            boolean status=false;
            
            ValidateProductCode validateproductcode=new ValidateProductCode();
            status=validateproductcode.validateProductCode(product_code);
            
            
            
            if(status==true){
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                out.print("Product Code Already Exist!");
            }
            
            if(status==false)
            {
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                out.print("NotExist");
            }
            
            
            
            ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product_productcodecheckservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product_productcodecheckservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
