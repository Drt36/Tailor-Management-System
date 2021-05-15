<%-- 
    Document   : order_orderdetailspage
    Created on : Jan 18, 2021, 3:52:26 PM
    Author     : dharm
--%>

<%@page import="Order.Database.ValidateOrderInDesign"%>
<%@page import="Order.Model.Design"%>
<%@page import="Order.Database.DesignAllData"%>
<%@page import="Order.Model.Measurement"%>
<%@page import="Order.Database.MeasurementAllData"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.OrderAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userandadminpagepeotection.jsp" />  
<jsp:include page="logo.jsp" />  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/order_orderdetailspagestyle.css" type="text/css">
      
    </head>
    <body>
         <%
            String order_id=request.getAttribute("order_id").toString(); 
            
            //getting order details
            OrderAllData orderalldata=new OrderAllData();
            Order order=orderalldata.getAllDataOfOrder(order_id);
            
            //getting Measurement details
            MeasurementAllData measurementalldata=new MeasurementAllData();
            Measurement measurement=measurementalldata.getAllDataOfMeasurement(order_id);
            
            
            //check order in design
            ValidateOrderInDesign validateorderindesign=new ValidateOrderInDesign();
            boolean status=validateorderindesign.validateOrderInDesign(order_id);
            //getting Design details
            String design_url=null;
            if(status==true){
                DesignAllData designalldata=new DesignAllData();
                Design design=designalldata.getAllDataOfDesign(order_id);
                design_url=design.getDesign_url().toString();
            }
         %>
         
         
        
        <div id="maindiv"> 
         <h1>Selected Order's Details!</h1>
         <hr>
        <div id="measurementtable">
          <h2>Measurement Details!</h2>
          <p id="orderstatus"><%=order.getOrder_status() %></p>
          <%if(status==true){%>
             <img src="<%=design_url %>" alt="Avatar" id="measurementimage">
             
          <%}
          else{%>
             <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>" alt="Avatar" id="measurementimage">
          <%}%>
          <table> 
                                   
            <tr>
              <td>Order ID:</td>
              <td><%=order.getOrder_id() %></td>
            </tr>
            <tr>
              <td>Title:</td>
              <td><%=measurement.getMeasurment_title() %></td>
            </tr>
            <tr>
              <td>Length:</td>
              <td><%=measurement.getLength() %></td>
            </tr>
            <tr>
              <td>Waist:</td>
              <td><%=measurement.getWaist() %></td>
            </tr>
            <tr>
              <td>Shoulder:</td>
              <td><%=measurement.getShoulder() %></td>
            </tr>
            <tr>
              <td>Length of Hand:</td>
              <td><%=measurement.getLength_of_hand() %></td>
            </tr>
            <tr>
              <td>Neck:</td>
              <td><%=measurement.getNeck() %></td>
            </tr>
            <tr>
              <td>Chest:</td>
              <td><%=measurement.getChest() %></td>
            </tr>
             <tr>
              <td>Thigh:</td>
              <td><%=measurement.getThigh() %></td>
            </tr>
             <tr>
              <td>Inner Length:</td>
              <td><%=measurement.getInner_lenght() %></td>
            </tr>
             <tr>
              <td>Hip:</td>
              <td><%=measurement.getHip() %></td>
            </tr>
          </table>
          
        </div>
            
        <div id="ordertable">
          <h2>Order Details!</h2>
          <% if(order.isIs_paymentclear()==true){%>
            <p id="paymentdone"><b>Payment Done</b></p>
            <%}else{%>

             <p id="paymentdue"><b>Payment Due</b></p>

          <%}%>
          <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>" alt="Avatar" id="orderimage"><br>
          
          <table> 
                               
            <tr>
              <td>Order ID:</td>
              <td><%=order.getOrder_id() %></td>
            </tr>
            <tr>
              <td>Description:</td>
              <td><%=order.getOrder_description() %></td>
            </tr>
            <tr>
              <td>Order Amount:</td>
              <td>Rs.<%=order.getOrder_amount() %></td>
            </tr>
            <tr>
              <td>Cloth:</td>
              <td>Rs.<%=order.getOrder_clothamount() %></td>
            </tr>
            <tr>
              <td>Discount:</td>
              <td>Rs.<%=order.getOrder_discount() %></td>
            </tr>
            <tr>
              <td>Advance Amount:</td>
              <td>Rs.<%=order.getOrder_advance() %></td>
            </tr>
            <tr>
              <td>Date:</td>
              <td><%=order.getOrder_date() %></td>
            </tr>
            <tr>
              <td>Delivery:</td>
              <td><%=order.getOrder_deliverydate() %></td>
            </tr>
            <tr>
              <td>Status:</td>
              <td><%=order.getOrder_status() %></td>
            </tr>
            <tr>
              <td>Remaining Amount:</td>
              <td style="color:red;"><%=order.getOrder_remainingamount() %></td>
            </tr>
            <tr>
              <td>Product Code:</td>
              <td><%=order.getProduct_code() %></td>
            </tr>
          </table>

        </div>
        <button onclick="window.print()" class="btn success"/>Print Details</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button onclick="history.back()" class="btn danger" >Close</button>
        
        </div>
    </body>
</html>
