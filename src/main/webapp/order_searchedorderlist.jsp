<%-- 
    Document   : order_searchedorderlist
    Created on : Mar 16, 2021, 5:36:11 PM
    Author     : dharm
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.GetOrder"%>
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
        <link rel="stylesheet" href="CSS/order_searchedorderliststyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    </head>
    <body>

   <div id="table">
    <div class="container text-left">
        <h1>Searched Orders!</h1>   
                    <hr>
                    <br> 
        </div>
    
           <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'New')" id="defaultOpen">New</button>
                <button class="tablinks" onclick="openCity(event, 'Processed')">Processed</button>
                <button class="tablinks" onclick="openCity(event, 'Completed')">Completed</button>
                <button class="tablinks" onclick="openCity(event, 'Delivered')">Delivered</button>
            </div>

            <div id="New" class="tabcontent">
                
              <%
                String order_id=request.getAttribute("search_data").toString();
                String order_status="New";
                //fetching list of order for specific customer
                GetOrder getorder=new GetOrder();
                ArrayList < Order > orderlist=(ArrayList)getorder.getsearchedAllOrders(order_status, order_id);

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
                                    <p style="color: red;"><b>Due Amount:Rs.<%=order.getOrder_remainingamount() %></b></p>
                                   
                                  <br>
                                  <button onclick="location.href='order_editorderservlet?order_id=<%=order.getOrder_id() %>'"  class="btn warning"/>Edit</button>&nbsp;
                                   <%if(order.isIs_billed()==true){%>
                                       <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" disabled>Cancel</button>
                                  <%}
                                else{%>
                                    <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" >Cancel</button>
                                <%}%>
                                  &nbsp;
                                  <button onclick="location.href='order_processedservlet?order_id=<%=order.getOrder_id() %>'" class="btn warning" >Process</button>&nbsp;
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
                
                orderlist=(ArrayList)getorder.getsearchedAllOrders(order_status1, order_id);

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
                
                orderlist=(ArrayList)getorder.getsearchedAllOrders(order_status2, order_id);

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
                
                orderlist=(ArrayList)getorder.getsearchedAllOrders(order_status3,order_id);

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
             <br>
     <button id="closebutton" onclick="location.href='order_allorders.jsp'" type="button">Close</button>
           
    </div>
    <script type="text/javascript" src="Scripts/tabview.js"></script>
        

   
    </body>
</html>