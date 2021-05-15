<%-- 
    Document   : product_searchproduct
    Created on : Jan 10, 2021, 3:56:10 PM
    Author     : dharm
--%>

<%@page import="Product.Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Product.Database.AllProductList"%>
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
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/product_userviewproductliststyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    </head>
    <body>
   
    <div id="table">
         <h1>List of Products</h1>  
         <hr>
         <br>
   
    <%
            String search_data=request.getAttribute("search_data").toString();
            //fetching list of products
            AllProductList allproductlist=new AllProductList();
            List < Product > listProduct =allproductlist.searchAllProducts(search_data);
            if(!listProduct.isEmpty()){%> 
        
                       
                            <%for(Product product:listProduct){%> 
                            <%-- Arranging data --%> 
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
                                  
                                    <p>For staff: <%=product.getProduct_paymentforstaff() %> </p>
                                  
                                    <p>Product Code: <%=product.getProduct_code() %></p>
                                  <br>
                                  <button onclick="location.href='product_updateproductservlet?product_code=<%=product.getProduct_code() %>'"  class="btn warning"/>Edit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  <button onclick="location.href='product_deleteproductservlet?product_code=<%=product.getProduct_code() %>'" class="btn danger" >Remove</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  <a href="product_productimageloadservlet?product_code=<%=product.getProduct_code() %>" download="tailorimage" class="btn success" > Download</a>
                                </div>
                             </div>
                                  
                             <%}%> 
                                
        <%}%> 
    
    <%if(listProduct.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
    </div>  
    <br>
     <button id="closebutton" onclick="location.href='product_userviewproductlist.jsp'" type="button">Close</button>
    </body>
</html>
