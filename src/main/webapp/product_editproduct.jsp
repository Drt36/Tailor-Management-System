<%-- 
    Document   : product_editproduct
    Created on : Jan 10, 2021, 5:13:16 PM
    Author     : dharm
--%>

<%@page import="Product.Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="logo.jsp" /> 
<jsp:include page="userpageprotection.jsp" />  
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="CSS/product_editproductstyle.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
            
        <title>Tailor Management System With Design Recommendation</title>
    </head>
        <%  
          Product product= (Product)request.getAttribute("product");
          
         %>
    
        <h2>Edit Product Details Here!</h2>
        <form action="<%= request.getContextPath()%>/product_updatesaveproductservlet" class="was-validated" id="producteditform" method="post" enctype="multipart/form-data">
                <div class="container">

                    <label><b>Product Name:</b></label>
                    <input type="text" class="form-control" placeholder="Enter product Name" value="<%=product.getProduct_name() %>"  name="product_name_id" required  maxlength="50">
                   

                    <label><b>Product Cost:</b></label>
                    <input type="number" class="form-control" placeholder="Enter Product cost" value="<%=product.getProduct_cost() %>" name="product_cost_id" required min="0">
                    
                    <label><b>Payment For Staff:</b></label>
                    <input type="number" class="form-control" placeholder="Enter payment for staff" value="<%=product.getProduct_paymentforstaff() %>" name="product_paymentforstaff_id" required min="0">
                    
                    <br>
                 
                    <label><b>In Stock:</b></label>
                    <select name="is_available_id">
                        <option value="true">YES</option>
                        <option value="false">NO</option>
                    </select>
                    <label><b>Category:</b></label>
                    <select name="product_category_id">
                        <option value="suit">Suit</option>
                        <option value="halfSuit">HalfSuit</option>
                        <option value="3piecesuit">3PieceSuit</option>
                        <option value="other">Other</option>
                    </select>
                    <br>
                    <br>
                    <lable><b>Profile Photo:</b> </lable>
                    <input type="file" name="product_image_id"  />
                    <br>
                    <br>
                    <label><b>Description:</b></label>
                    <textarea class="form-control" placeholder="Enter description"  name="product_description_id" required maxlength="5000"><%=product.getProduct_description() %></textarea>
                    <br>
                    <input type="hidden" name="product_code_id"  value="<%=product.getProduct_code() %>">
                  <div class="form-group form-check">
                      
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember" required> I agree on<a href="agreement.jsp">Terms & Conditions.</a> 
                    </label>
                  </div>
                    <input type="submit" id="editproduct" value="Add"></input>
              </form>
</html>

