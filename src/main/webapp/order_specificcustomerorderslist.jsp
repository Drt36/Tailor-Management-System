<%-- 
    Document   : order_specificcustomerorderslist
    Created on : Jan 13, 2021, 3:45:55 PM
    Author     : dharm
--%>

<%@page import="Customer.Model.Customer"%>
<%@page import="Customer.Database.CustomerAllData"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.GetOrder"%>
<%@page import="Order.Model.Order"%>
<%@page import="java.util.ArrayList"%>
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
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
        <link rel="stylesheet" href="CSS/order_specificcustomerorderliststyle.css" type="text/css">
         
    <body>
    <div id="sticky" class="container text-left">
       <% 
        String customer_email=request.getAttribute("customer_email").toString(); 
        CustomerAllData customeralldata=new CustomerAllData();
        Customer customer=customeralldata.getAllDataOfCustomer(customer_email);
        String customer_name=customer.getCustomer_fullname();
       %>
        <h2>Order:<%=customer_name %>!</h2>   
                    <hr>
                    <br>
        <button id="addneworderbutton" onclick="location.href='order_beforeorderservlet?customer_email=<%=customer_email %>'">Order Now</button>
        <button id="generatebillbutton" onclick="location.href='order_beforeorderbillservlet?customer_email=<%=customer_email %>'">Generate Bill</button>  
        <button id="closebutton" onclick="location.href='customer_usercustomerlist.jsp'" >Close</button>
        <h3 class="hide">${orderaddedsuccessfullymessage}</h3>
        <h3 class="hide">${orderdeletedmessage}</h3>
        <h3 class="hide">${orderupdatedsuccessfullymessage}</h3>
        <h3 class="hide">${orderprocessedmessage}</h3>
        <h3 class="hide">${ordercompletedmessage}</h3>
        <h3 class="hide">${orderdelivereddmessage}</h3>
        <h3 class="hide">${paymentupdatemessage}</h3>

        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'New')" id="defaultOpen">New</button>
            <button class="tablinks" onclick="openCity(event, 'Processed')">Processed</button>
            <button class="tablinks" onclick="openCity(event, 'Completed')">Completed</button>
            <button class="tablinks" onclick="openCity(event, 'Delivered')">Delivered</button>
        </div>
     </div>
     <div id="table">
       
     <div id="New" class="tabcontent">
            
              <%
                 String order_status="New";
                //fetching list of order for specific customer
                GetOrder getorder=new GetOrder();
                ArrayList < Order > orderlist=(ArrayList)getorder.getOrders(customer_email,order_status);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){%> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                                
                                <% if(order.isIs_paymentclear()==true){%>
                                  <p id="paymentdone"><b>Payment Done</b></p>
                                  <%}else{%>
                                  
                                   <p id="paymentdue"><b>Payment Due</b></p>
                                   
                                   <%}%>
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                    <h3><b><%=order.getOrder_title() %></b></h3>
                                    <h3><b>RS.<%=order.getOrder_totalamount() %></b></h3> 
                                    <h4>ID:<%=order.getOrder_id() %></h4> 
                                    <p style="color: red;"><b>Due Amount:Rs.<%=order.getOrder_remainingamount() %></b></p>
                              
                                  <br>
                                  <button onclick="location.href='order_editorderservlet?order_id=<%=order.getOrder_id() %>'"  class="btn warning"/>Edit</button>&nbsp;
                                 <%if(order.isIs_billed()==true){%>
                                  <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" disabled>Cancel</button>&nbsp;
                                  <button onclick="location.href='order_processedservlet?order_id=<%=order.getOrder_id() %>'" class="btn warning" >Process</button>&nbsp;
                                 <%}
                                else{%>
                                     <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" >Cancel</button>&nbsp;
                                     <button onclick="location.href='order_processedservlet?order_id=<%=order.getOrder_id() %>'" class="btn warning" disabled >Process</button>&nbsp;
                                <%}%>
                               
                                  <button onclick="location.href='order_orderdetailsservlet?order_id=<%=order.getOrder_id() %>'" class="btn success" >Details</button>&nbsp;
                                </div>
                             </div>
       
                            <%}%> 
              
                <%}%> 

            <%if(orderlist.isEmpty()){%>
                <h1 style="color: red;"> List is Not Available !!!</h1>
            <%}%>
              
            </div>

            <div id="Processed" class="tabcontent">
              <%
                String order_status1="Processed";
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getOrders(customer_email,order_status1);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){%> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                                
                                <% if(order.isIs_paymentclear()==true){%>
                                  <p id="paymentdone"><b>Payment Done</b></p>
                                  <%}else{%>
                                  
                                   <p id="paymentdue"><b>Payment Due</b></p>
                                   
                                   <%}%>
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                   <h3><b><%=order.getOrder_title() %></b></h3>
                                    <h3><b>RS.<%=order.getOrder_totalamount() %></b></h3> 
                                   <h4>ID:<%=order.getOrder_id() %></h4> 
                                    <p style="color: red;"><b>Due Amount:Rs.<%=order.getOrder_remainingamount() %></b></p>
                                   
                                  <br>
                                   <% if(order.isIs_paymentclear()==false){%>
                                    <button onclick="location.href='order_cleardueservlet?order_id=<%=order.getOrder_id() %>'"  class="btn default"/>Pay Due</button>
                                  <%} %>
                                    &nbsp;&nbsp;&nbsp;
                                  <button onclick="location.href='order_completedservlet?order_id=<%=order.getOrder_id() %>'"  class="btn warning"/>Complete</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                  <button onclick="location.href='order_orderdetailsservlet?order_id=<%=order.getOrder_id() %>'" class="btn success" >Details</button>
                                </div>
                             </div>
       
                            <%}%> 
              
                <%}%> 

            <%if(orderlist.isEmpty()){%>
                <h1 style="color: red;"> List is Not Available !!!</h1>
            <%}%>
            </div>

            <div id="Completed" class="tabcontent">
              <%
                String order_status2="Completed";
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getOrders(customer_email,order_status2);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){%> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                                
                                <% if(order.isIs_paymentclear()==true){%>
                                  <p id="paymentdone"><b>Payment Done</b></p>
                                  <%}else{%>
                                  
                                   <p id="paymentdue"><b>Payment Due</b></p>
                                   
                                   <%}%>
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                   <h3><b><%=order.getOrder_title() %></b></h3>
                                    <h3><b>RS.<%=order.getOrder_totalamount() %></b></h3> 
                                    <h4>ID:<%=order.getOrder_id() %></h4> 
                                    <p style="color: red;"><b>Due Amount:Rs.<%=order.getOrder_remainingamount() %></b></p>
                                   
                                  <br>
                                  
                                  <% if(order.isIs_paymentclear()==true){%>
                                  <button onclick="location.href='order_deliveredservlet?order_id=<%=order.getOrder_id() %>'"  class="btn warning"/>Deliver</button>
                                  <%}else{%>
                                  
                                   <button onclick="location.href='order_cleardueservlet?order_id=<%=order.getOrder_id() %>'"  class="btn default"/>Pay Due</button>
                                   
                                   <%}%>
                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
                                  <button onclick="location.href='order_orderdetailsservlet?order_id=<%=order.getOrder_id() %>'" class="btn success" >Details</button>
                                </div>
                             </div>
       
                            <%}%> 
              
                <%}%> 

            <%if(orderlist.isEmpty()){%>
                <h1 style="color: red;"> List is Not Available !!!</h1>
            <%}%>
            </div>
           
           <div id="Delivered" class="tabcontent">
              <%
                String order_status3="Delivered";
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getOrders(customer_email,order_status3);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){%> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                                
                                <% if(order.isIs_paymentclear()==true){%>
                                  <p id="paymentdone"><b>Payment Done</b></p>
                                  <%}else{%>
                                  
                                   <p id="paymentdue"><b>Payment Due</b></p>
                                   
                                   <%}%>
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                    <h3><b><%=order.getOrder_title() %></b></h3>
                                    <h3><b>RS.<%=order.getOrder_totalamount() %></b></h3> 
                                    <h4>ID:<%=order.getOrder_id() %></h4> 
                                    <p style="color: red;"><b>Due Amount:Rs.<%=order.getOrder_remainingamount() %></b></p>
                                   
                                    <br>
                                  <button onclick="location.href='order_orderdetailsservlet?order_id=<%=order.getOrder_id() %>'" class="btn success" >Details</button>
                                </div>
                             </div>
       
                            <%}%> 
              
                <%}%> 

            <%if(orderlist.isEmpty()){%>
                <h1 style="color: red;"> List is Not Available !!!</h1>
            <%}%>
    </div>
    </div>
    <script type="text/javascript" src="Scripts/tabview.js"></script>
   </body>
</html>