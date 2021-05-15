<%-- 
    Document   : order_orderviewproductlist
    Created on : Jan 13, 2021, 2:49:36 PM
    Author     : dharm
--%>

<%@page import="Product.Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Product.Database.AllProductList"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" />
<jsp:include page="logo.jsp" />  
  
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/order_orderviewproductstyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
      
         
    </head>
    <body>

    
    <div id="table">
    <div class="container text-left">
        <h1>Select the Product!</h1>   
                    <hr>
                    <br>
    </div>
    <%
            //fetching list of products
            AllProductList allproductlist=new AllProductList();
            List < Product > listProduct =allproductlist.selectAllProducts();
            if(!listProduct.isEmpty()){%> 
     
                       
                        <%for(Product product:listProduct){%> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=product.getProduct_code() %>"  width="200" height="200">
                                
                                <% if(product.isIs_available()==true){%>
                                  <p id="available" style="color:green"><b>In Stock</b></p>
                                  <%}else{%>
                                  
                                   <p id="available" style="color:red"><b>Out Of Stock</b></p>
                                   
                                   <%}%>
                                   
                                <div class="container">
                                    <h4><b><%=product.getProduct_name() %>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            
                                    RS.<%=product.getProduct_cost() %></b></h4> 
                                    <p>Description: <%=product.getProduct_description() %></p>
                                  
                                    <p>Product Code: <%=product.getProduct_code() %></p>
                                  <br>
                                   <% String customer_email=request.getAttribute("customer_email").toString(); %>
                                   
                                   <form action="<%= request.getContextPath() %>/order_afterproductselectservlet" id="beforeorderform" method="post">
                                        <input type="hidden" name="customer_email_id"value="<%=customer_email %>" >
                                        <input type="hidden" name="product_code_id" value="<%=product.getProduct_code() %>">
                                       <% if(product.isIs_available()==true){%>
                                        <button id="selectbutton" type="submit" class="btn  success">Select</button>
                                        <%}
                                        else{%>
                                            <button id="selectbutton" type="submit" disabled class="btn  success">Select</button>
                                        <% }%>                     
                                     </form>
                                  
                                   &nbsp;&nbsp;&nbsp;&nbsp;
                                   
                                   <% if(product.getProduct_category().equals("suit")){%>
                                    <form action="<%= request.getContextPath() %>/recommendation_displaysampledesignsservlet" id="beforeorderrecommendationform1" method="post">
                                        <input type="hidden" name="customer_email_id"value="<%=customer_email %>" >
                                        <input type="hidden" name="product_code_id" value="<%=product.getProduct_code() %>">
                                       <% if(product.isIs_available()==true){%>
                                        <button id="recommendationbutton" type="submit" class="btn  default">Recommend</button>
                                        <%}
                                        else{%>
                                            <button id="recommendationbutton" type="submit" disabled class="btn  default">Recommend</button>
                                        <% }%>
                                        
                                     </form>
                                   <%}%> 
                                  <% if(product.getProduct_category().equals("halfSuit")){%>
                                      <form action="<%= request.getContextPath() %>/recommendation_displaysamplehalfsuitdesignservlet" id="beforeorderrecommendationform2" method="post">
                                        <input type="hidden" name="customer_email_id"value="<%=customer_email %>" >
                                        <input type="hidden" name="product_code_id" value="<%=product.getProduct_code() %>">
                                       <% if(product.isIs_available()==true){%>
                                        <button id="recommendationbutton" type="submit" class="btn  default">Recommend</button>
                                        <%}
                                        else{%>
                                            <button id="recommendationbutton" type="submit" disabled class="btn  default">Recommend</button>
                                        <% }%>
                                        
                                     </form>
                                   <% }%>  
                                    <% if(product.getProduct_category().equals("3piecesuit")){%>
                                      <form action="<%= request.getContextPath() %>/recommendation_displaysample3Piecesuitdesignservlet" id="beforeorderrecommendationform3" method="post">
                                        <input type="hidden" name="customer_email_id"value="<%=customer_email %>" >
                                        <input type="hidden" name="product_code_id" value="<%=product.getProduct_code() %>">
                                       <% if(product.isIs_available()==true){%>
                                        <button id="recommendationbutton" type="submit" class="btn  default">Recommend</button>
                                        <%}
                                        else{%>
                                            <button id="recommendationbutton" type="submit" disabled class="btn  default">Recommend</button>
                                        <% }%>
                                        
                                     </form>
                                  <% }%>  
                                  <% if(product.getProduct_category().equals("other")){%>
                                    <form action="" id="beforeorderrecommendationform" method="post">
                                      
                                            <button id="recommendationbutton" type="submit" disabled class="btn  default">Recommend</button>
                                
                                     </form>
                                  <% }%>
                                   &nbsp;&nbsp;&nbsp;&nbsp;
                                  <a id="downloadbtn" href="product_productimageloadservlet?product_code=<%=product.getProduct_code() %>" download="tailorimage" class="btn warning" > Download</a>
                                  
                                </div>
                             </div>
       
                            <%}%> 
              
        <%}%> 
    
    <%if(listProduct.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
    </div>  
    </body>
</html>