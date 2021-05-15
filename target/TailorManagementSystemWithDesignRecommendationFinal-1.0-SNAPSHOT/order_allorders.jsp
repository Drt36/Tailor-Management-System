<%-- 
    Document   : order_allorders
    Created on : Jan 19, 2021, 11:46:46 AM
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
<% 
  //getting data from session
  String user_email= (String)session.getAttribute("user");
  //getting user details from database
  UserAllData useralldata=new UserAllData();
  User user= (User) useralldata.getAllDataOfUser(user_email);
  
  //getting profile picture available or not
  boolean status=false;
  GetProfilePicture getprofilepicture=new GetProfilePicture();
  status=getprofilepicture.checkProfilePicture(user_email);
 %>    
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/order_allordersstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
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
      <a href="userpanel.jsp" >
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
      <a href="customer_usercustomerlist.jsp">
        <i class="fas fa-users"></i>
        <span>Customers</span>
      </a>
      <a href="userview_allstafflist.jsp">
        <i class="fas fa-users"></i>
        <span>Staffs</span>
      </a>
       
      <a href="product_userviewproductlist.jsp">
        <i class="fas fa-tshirt"></i>
        <span>Products</span>
      </a>
      <a href="changepassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="order_allorders.jsp" class="active">
        <i class="fas fa-shopping-cart"></i>
        <span>Orders</span>
      </a>
      <a href="order_allbills.jsp">
        <i class="fas fa-file-invoice"></i>
        <span>Bills</span>
      </a>
      <a href="finance_allexpenselist.jsp" >
        <i class="fas fa-money-check-alt"></i>
        <span>Expenses</span>
      </a>
      <a href="userprofile.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historyuser.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="userreport.jsp">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
   
    <div id="sticky"  class="container text-left">
        <h2>All Orders</h2>   
                    <hr>
                    <br> 
        <form action="<%= request.getContextPath() %>/order_searchorderservlet" id="ordersearchform" method="post">
           <input type="text" placeholder="Search using order ID..." name="search_id" required>
           <button type="submit"><i class="fa fa-search"></i></button>
        </form>
        <br>
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'New')" id="defaultOpen">New</button>
            <button class="tablinks" onclick="openCity(event, 'Processed')">Processed</button>
            <button class="tablinks" onclick="openCity(event, 'Completed')">Completed</button>
            <button class="tablinks" onclick="openCity(event, 'Delivered')">Delivered</button>
       </div>
    </div>
    
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
                                  <button onclick="location.href='order_editorderservlet?order_id=<%=order.getOrder_id() %>'"  class="btn warning"/>Edit</button>&nbsp;
                                   <%if(order.isIs_billed()==true){%>
                                       <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" disabled>Cancel</button>&nbsp;
                                       <button onclick="location.href='order_processedservlet?order_id=<%=order.getOrder_id() %>'" class="btn warning" >Process</button>&nbsp;
                                  <%}
                                else{%>
                                    <button onclick="location.href='order_deleteorderservlet?order_id=<%=order.getOrder_id() %>'" class="btn danger" >Cancel</button>&nbsp;
                                    <button onclick="location.href='order_processedservlet?order_id=<%=order.getOrder_id() %>'" class="btn warning" disabled>Process</button>&nbsp;
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
    <script type="text/javascript" src="Scripts/tabview.js"></script>
  
    </body>
</html>