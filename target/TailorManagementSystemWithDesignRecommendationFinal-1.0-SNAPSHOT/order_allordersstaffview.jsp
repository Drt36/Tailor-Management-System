<%-- 
    Document   : order_allordersstaffview
    Created on : Mar 17, 2021, 12:33:52 PM
    Author     : dharm
--%>

<%@page import="Product.Model.Product"%>
<%@page import="Product.Database.ProductAllData"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.GetOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="staffpageprotection.jsp" /> 
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
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <title>Tailor Management System With Design Recommendation</title>
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/order_allorderstaffviewstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
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
      <a href="staffpanel.jsp" >
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
        <a href="order_allordersstaffview.jsp" class="active">
          <i class="fas fa-shopping-cart"></i>
          <span>Orders</span>
        </a>
       
        <a href="staff_staffsalary.jsp" >
          <i class="fas fa-money-check-alt"></i>
          <span>Salary</span>
        </a>
       
      <a href="changepassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="staffprofile.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historystaff.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
    <div id="table">
    <div class="container text-left">
        <h2>All Orders!</h2>   
                    <hr>
                    <br> 
                    <h4 id="orderacceptmessage" class="hide" >${orderacceptedmessage}</h4>
                    <h4 id="ordercancelmessage" class="hide" >${ordercancelledmessage}</h4>
                    
        </div>
    
           <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'Processed')" id="defaultOpen">Orders</button>
                <button class="tablinks" onclick="openCity(event, 'Taken')">Taken</button>
            </div>


            <div id="Processed" class="tabcontent">
              <%
                String order_status1="Processed";
                //fetching list of order for specific customer
                GetOrder getorder=new GetOrder();
                ArrayList < Order > orderlist=(ArrayList)getorder.getOrdersForAllStaffs(order_status1);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){
                       
                         String product_code=order.getProduct_code();
                         ProductAllData productalldata=new ProductAllData();
                         Product product=productalldata.getAllDataOfProduct(product_code);
                         Float paymentforstaff=product.getProduct_paymentforstaff();
                       %> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                              
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                    <h3><b><%=order.getOrder_title() %></b></h3> 
                                    <h3><b>RS.<%=paymentforstaff %></b></h3> 
                                    <h4>Id:<%=order.getOrder_id() %></h4>
                                  <br>
                                  <form action="<%= request.getContextPath()%>/order_stafforderacceptservlet" id="stafforderacceptform" method="post">
                                        <input type="hidden" name="order_id_id"value="<%=order.getOrder_id() %>" >
                                        <input type="hidden" name="paymentforstaff_id" value="<%=paymentforstaff %>">
                                        <input type="hidden" name="staff_email_id" value="<%=user_email %>">                                      
                                        <input type="hidden" name="product_code_id" value="<%=order.getProduct_code() %>">
                                        <button  type="submit" class="btn success">Accept</button>
                                   </form>  
                                </div>
                             </div>
       
                            <%}%> 
              
                <%}%> 

            <%if(orderlist.isEmpty()){%>
                <h1 style="color: red;"> List is Not Available !!!</h1>
            <%}%>
            </div>

            <div id="Taken" class="tabcontent">
              <%
                String staff_email=(String)session.getAttribute("user");
                //fetching list of order for specific customer
                
                orderlist=(ArrayList)getorder.getOrdersForSpecificStaff(staff_email);

                if(!orderlist.isEmpty()){
              %> 
     
                       
                       <%for(Order order:orderlist){
                         String product_code=order.getProduct_code();
                         ProductAllData productalldata=new ProductAllData();
                         Product product=productalldata.getAllDataOfProduct(product_code);
                         Float paymentforstaff=product.getProduct_paymentforstaff();
                       %> 
                            <%-- Arranging data in tabular form --%> 
                            <div class="card">
                                <img src="product_productimageloadservlet?product_code=<%=order.getProduct_code() %>"  width="200" height="200">
                                 <p id="orderstatus"><%=order.getOrder_status() %></p>
                                <div class="container">
                                   <h3><b><%=order.getOrder_title() %></b></h3> 
                                   <h3><b>RS.<%=paymentforstaff%></b></h3> 
                                   <h4>order Id:<%=order.getOrder_id() %></h4>
                                  <br>
                             </div>
                             <button onclick="location.href='order_staffordercancelservlet?order_id=<%=order.getOrder_id()%>'" class="btn danger" >Cancel</button>
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

