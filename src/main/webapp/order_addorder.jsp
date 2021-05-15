<%-- 
    Document   : order_addorder
    Created on : Jan 12, 2021, 9:16:18 PM
    Author     : dharm
--%>

<%@page import="Product.Model.Product"%>
<%@page import="Product.Database.ProductAllData"%>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
        <script type="text/javascript" src="Scripts/orderdate.js"></script>
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <link rel="stylesheet" href="CSS/order_addorderstyle.css" type="text/css">
    </head>
    <body>
        <%       
            String customer_email=request.getAttribute("customer_email").toString();
            String product_code=request.getAttribute("product_code").toString();
            String design_url=null;
            if(request.getAttribute("design_url")!=null){
                design_url=request.getAttribute("design_url").toString();
            }
            //get data of product
            ProductAllData productalldata=new ProductAllData();
            Product product=productalldata.getAllDataOfProduct(product_code);
        %>
        
       <form action="<%= request.getContextPath() %>/order_addorderservlet" id="addorderform" method="post">
         <h1>Add Order Here!</h1>
         <hr>
         <br>
        <div id="measurementform">
          <h2>Measurement Form:</h2> 
          <% if(request.getAttribute("design_url")!=null){ %>
           <img src="<%=design_url %>" alt="Avatar" id="measurementimage">
           
          <%}
          else{%>
            <img src="product_productimageloadservlet?product_code=<%=product.getProduct_code() %>" alt="Avatar" id="measurementimage">
            <%} %>
          <br>
          <label><b>Measurement Title:</b></label>
          <input  type="text" class="inputbox" placeholder="Enter measurement title"  name="measurement_title_id" required>
          <br>
          <label><b>Length:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter length"  name="length_id" required>
          <br>
          <label><b>Waist:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter waist"  name="waist_id" required>
          <br>
          <label><b>Shoulder:</b></label>
          <input  type="number"class="inputbox" placeholder="Enter shoulder"  name="shoulder_id" required>
          <br>
          <label><b>Length Of Hand:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter length of hand"  name="length_of_hand_id" required>
          <br>
          <label><b>Neck:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter neck"  name="neck_id" required>
          <br>
          <label><b>Chest:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter chest"  name="chest_id" required>
          <br>
          <label><b>Thigh:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter thigh"  name="thigh_id" required>
          <br>
          <label><b>Inner Height:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter inner height"  name="inner_height_id" required>
          <br>
          <label><b>Hip:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter hip"  name="hip_id" required>
        </div>
            
        <div id="orderform">
          <h2>Order Form:</h2>  
          <img src="product_productimageloadservlet?product_code=<%=product.getProduct_code() %>" alt="Avatar" id="orderimage"><br>
          <label><b>Order Title:</b></label>
          <input  type="text" placeholder="Enter order title"  name="order_title_id" required>
          <br>
          <label><b>Date:</b></label>
          <input type="text"  id="orderdatepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD"  name="order_date_id" required >
          <br>
          <label><b>Delivery Date:</b></label>
          <input type="text"  id="orderdeliverydatepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD"  name="order_deliverydate_id" required >
          <br>
          <label><b>Status:</b></label>
          <select name="order_status_id">
                <option value="New">New</option>
            </select> 
          <br>
          <label><b>Amount:</b></label>
          <input  type="number" placeholder="Enter order amount" value="<%=product.getProduct_cost() %>" name="order_amount_id" readonly required>
          <br>
          <label><b>Amount of Cloth:</b></label>
          <input  type="number" placeholder="Enter amount of cloth"  name="order_clothamount_id" required>
          <br>
          <label><b>Discount:</b></label>
          <input  type="number" placeholder="Enter discount amount"  name="order_discount_id" required>
          <br>
          <label><b>Advance:</b></label>
          <input  type="number" placeholder="Enter advance amount"  name="order_advance_id" required>
          <br>
          <label><b>Description:</b></label>
          <textarea placeholder="Enter description"  name="order_description_id" maxlength="5000" required></textarea>
        
        </div>
        <input type="hidden" name="customer_email_id" value="<%=customer_email %>" >
        <input type="hidden" name="product_code_id" value="<%=product_code %>">
        <% if(request.getAttribute("design_url")!=null){ %>
            <input type="hidden" name="design_url_id" value="<%=design_url %>">
        <%}%>
        <input type="submit" id="addorderbutton" value="Add Order"></input>
        <button onclick="history.go(-2)" type="button" id="cancelbtn" class="cancelbtn">Cancel</button>
        
</form>
    </body>
</html>
