/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recommendation.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dharm
 */
@WebServlet(name = "recommendation_displaysample3Piecesuitdesignservlet", urlPatterns = {"/recommendation_displaysample3Piecesuitdesignservlet"})
public class recommendation_displaysample3Piecesuitdesignservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet recommendation_displaysample3Piecesuitdesignservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet recommendation_displaysample3Piecesuitdesignservlet at " + request.getContextPath() + "</h1>");
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
        String customer_email=request.getParameter("customer_email_id");
        String product_code=request.getParameter("product_code_id");
       
  
    
        request.setAttribute("customer_email",customer_email);
        request.setAttribute("product_code",product_code);
        RequestDispatcher dispatcher = request.getRequestDispatcher("recommendation_display3piecesuitsampledesigns.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
