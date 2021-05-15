<%-- 
    Document   : order_editorder
    Created on : Jan 18, 2021, 9:02:46 PM
    Author     : dharm
--%>

<%@page import="Order.Model.Measurement"%>
<%@page import="Order.Database.MeasurementAllData"%>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
        <script type="text/javascript" src="Scripts/orderdate.js"></script>
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <link rel="stylesheet" href="CSS/order_editorderstyle.css" type="text/css">
    </head>
    <body>
        <%       
            String order_id=request.getAttribute("order_id").toString();
            
            //get all order data
            OrderAllData orderalldata=new OrderAllData();
            Order order=orderalldata.getAllDataOfOrder(order_id);
            
            
            //getting Measurement details
            MeasurementAllData measurementalldata=new MeasurementAllData();
            Measurement measurement=measurementalldata.getAllDataOfMeasurement(order_id);
            
            
        %>
        
            
       <form action="<%= request.getContextPath() %>/order_editordersaveservlet" id="editorderform" method="post">
           <h1>Edit Order Details Here!</h1>
           <hr>
           <br>
        <div id="measurementform">
            <h2>Measurement Form:</h2> 
          <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>" alt="Avatar" id="measurementimage">
          <br>
          <label><b>Measurement Title:</b></label>
          <input  type="text" class="inputbox" placeholder="Enter measurement title" value="<%=measurement.getMeasurment_title() %>" name="measurement_title_id" required>
          <br>
          <label><b>Length:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter length" value="<%=measurement.getLength() %>"  name="length_id" required>
          <br>
          <label><b>Waist:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter waist" value="<%=measurement.getWaist() %>"  name="waist_id" required>
          <br>
          <label><b>Shoulder:</b></label>
          <input  type="number"class="inputbox" placeholder="Enter shoulder" value="<%=measurement.getShoulder() %>"  name="shoulder_id" required>
          <br>
          <label><b>Length Of Hand:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter length of hand" value="<%=measurement.getLength_of_hand() %>"  name="length_of_hand_id" required>
          <br>
          <label><b>Neck:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter neck" value="<%=measurement.getNeck() %>"  name="neck_id" required>
          <br>
          <label><b>Chest:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter chest" value="<%=measurement.getChest() %>" name="chest_id" required>
          <br>
          <label><b>Thigh:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter thigh" value="<%=measurement.getThigh() %>"  name="thigh_id" required>
          <br>
          <label><b>Inner Height:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter inner height" value="<%=measurement.getInner_lenght() %>"  name="inner_height_id" required>
          <br>
          <label><b>Hip:</b></label>
          <input  type="number" class="inputbox" placeholder="Enter hip" value="<%=measurement.getHip() %>" name="hip_id" required>
        </div>
            
        <div id="orderform">
            <h2>Order Form:</h2> 
            <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>" alt="Avatar" id="orderimage"><br>
          <label><b>Order Title:</b></label>
          <input  type="text" placeholder="Enter order title" value="<%=order.getOrder_title() %>" name="order_title_id" required>
          <br>
          
          <label><b>Delivery Date:</b></label>
          <input type="text"  id="orderdeliverydatepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD" value="<%=order.getOrder_deliverydate() %>"  name="order_deliverydate_id" required >
          <br>
          <label><b>Status:</b></label>
          <select name="order_status_id">
                <option value="New">New</option>
            </select> 
          <br>
          <label><b>Amount:</b></label>
          <input  type="number" placeholder="Enter order amount" value="<%=order.getOrder_amount() %>" name="order_amount_id" readonly required>
          <br>
          <label><b>Amount of Cloth:</b></label>
          <input  type="number" placeholder="Enter amount of cloth" value="<%=order.getOrder_clothamount() %>"  name="order_clothamount_id" required>
          <br>
          <label><b>Discount:</b></label>
          <input  type="number" placeholder="Enter discount amount" value="<%=order.getOrder_discount() %>"  name="order_discount_id" required>
          <br>
          <label><b>Advance:</b></label>
          <input  type="number" placeholder="Enter advance amount" value="<%=order.getOrder_advance() %>" name="order_advance_id" required>
          <br>
          <br>
          <label><b>Description:</b></label>
          <textarea placeholder="Enter description"  name="order_description_id" maxlength="5000" required><%=order.getOrder_description() %></textarea>
        
        </div>
        <input type="hidden" name="order_id" value="<%=order.getOrder_id() %>">
        <input type="hidden" name="customer_email_id" value="<%=order.getCustomer_email() %>">
        <input type="submit" id="editorderbutton" value="Save"></input>
        <button onclick="history.back()" type="button" id="cancelbtn" class="cancelbtn">Cancel</button>
        
</form>
    </body>
</html>

