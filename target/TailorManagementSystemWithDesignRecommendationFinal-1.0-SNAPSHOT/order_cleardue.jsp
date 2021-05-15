<%-- 
    Document   : order_cleardue
    Created on : Jan 18, 2021, 11:59:46 PM
    Author     : dharm
--%>

<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.OrderAllData"%>
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
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <link rel="stylesheet" href="CSS/order_clearduestyle.css" type="text/css">
    </head>
    <body>
        <%       
            String order_id=request.getAttribute("order_id").toString();
            
            //get all order data
            OrderAllData orderalldata=new OrderAllData();
            Order order=orderalldata.getAllDataOfOrder(order_id);
  
        %>
        
      <div id="masterdiv">    
          <h1>Pay Due Amount Here!</h1>
           <hr>
           <br>
       <form action="<%= request.getContextPath() %>/order_clearduesaveservlet" id="cleardueform" method="post">
           
          <h2>Payment Form:</h2> 
          
          <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>" alt="Avatar" id="orderimage"><br>
          
          <h3>Due Amount: Rs.<%=order.getOrder_remainingamount() %>/- </h3><br>
          
          <label><b>Paying Amount:</b></label>
          <input  type="number" placeholder="Enter paying amount"  name="paying_amount_id"  required max="<%=order.getOrder_remainingamount() %>" min="0">
          <br>
      
        <input type="hidden" name="order_id" value="<%=order.getOrder_id() %>">
        <input type="hidden" name="customer_email_id" value="<%=order.getCustomer_email() %>">
        <input type="submit" id="clearduebutton" value="Pay"></input>
        <button onclick="history.back()" type="button" id="cancelbtn" class="cancelbtn">Cancel</button>
        
       </form>
      </div>
    </body>
</html>