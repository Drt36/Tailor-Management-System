<%-- 
    Document   : order_allordersadminview
    Created on : Jan 19, 2021, 12:18:02 PM
    Author     : dharm
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.GetOrder"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
   <% 
         //getting data from session
         String user_email= (String)session.getAttribute("user");
         //getting user details from database
         UserAllData useralldata=new UserAllData();
         User user= (User) useralldata.getAllDataOfUser(user_email);
         
         boolean status=false;
         GetProfilePicture getprofilepicture=new GetProfilePicture();
         status=getprofilepicture.checkProfilePicture(user_email);
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/order_allordersstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>

    <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>    
    <div class="sidebar">
      <div id="sidebarprofile">
          <%if(status==true){%> 
            <img src="profileimageload.jsp" id="sidebarprofilepic" height="100" width="100">
           <%}
            else{%>
            <img src="Images/profilepicture.png" id="sidebarprofilepic" height="100" width="100">
            <%}%>
           <h3 id="sidebarfullname"><%=user.getUser_fullname()%></h3>
       </div>
      <a href="adminpanel.jsp" >
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
       <a href="users.jsp">
        <i class="fas fa-users"></i>
        <span>Users</span>
      </a>
      <a href="BlockedUsers.jsp">
        <i class="fas fa-users"></i>
        <span>Blocked Users</span>
      </a>
      <a href="customer_admincustomerlist.jsp">
        <i class="fas fa-users"></i>
        <span>Customers</span>
      </a>
      <a href="product_adminviewproductlist.jsp">
        <i class="fas fa-tshirt"></i>
        <span>Products</span>
      </a>
      <a href="order_allordersadminview.jsp" class="active">
        <i class="fas fa-shopping-cart"></i>
        <span>Orders</span>
      </a>
      <a href="finance_allexpenselistadminview.jsp" >
        <i class="fas fa-money-check-alt"></i>
        <span>Expenses</span>
      </a>  
      <a href="changepassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="adminprofile.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historyadmin.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="adminreport.jsp">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
    
    <div id="sticky" class="container text-left">
        <h2>All Orders!</h2>   
                    <hr>
                    <br> 
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
                ArrayList < Order > orderlist=(ArrayList)getorder.getAllOrders(order_status);

                if(!orderlist.isEmpty()){
              %> 
               
                       <%for(Order order:orderlist){%> 
              
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
                
                orderlist=(ArrayList)getorder.getAllOrders(order_status1);

                if(!orderlist.isEmpty()){
              %> 
              <%for(Order order:orderlist){%> 
                            
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

            <div id="Completed" class="tabcontent">
              <%
                String order_status2="Completed";
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getAllOrders(order_status2);

                if(!orderlist.isEmpty()){
              %> 
              <%for(Order order:orderlist){%> 
                          
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
           
           <div id="Delivered" class="tabcontent">
              <%
                String order_status3="Delivered";
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getAllOrders(order_status3);

                if(!orderlist.isEmpty()){
              %> 
                <%for(Order order:orderlist){%> 
                        
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
           
           
    </div>
    <script type="text/javascript" src="Scripts/tabview.js"></script>
    
      
       
       
       
       
    </body>
</html>
