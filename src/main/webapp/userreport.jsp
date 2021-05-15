<%-- 
    Document   : userreport
    Created on : Apr 25, 2021, 12:16:26 PM
    Author     : dharm
--%>

<%@page import="Order.Database.OrderCounter"%>
<%@page import="Order.Database.SalesCalculator"%>
<%@page import="Finance.Database.ExpenseCalculator"%>
<%@page import="Customer.Database.CustomerCounter"%>
<%@page import="Finance.Database.GetExpenseFigure"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Map"%>
<%@page import="Order.Model.Order"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.GetSalesFigure"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/reportdate.js"></script>
        <link rel="stylesheet" href="CSS/userreportstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        
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
      <a href="userpanel.jsp">
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
     
      <a href="order_allorders.jsp" >
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
       <a href="changepassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="userprofile.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historyuser.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="userreport.jsp"  class="active">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
     <h2>Report</h2>
     
      <form id="reportdateform" action="<%= request.getContextPath() %>/finance_generatereportservlet" method="post">
                <div class="container">
                  <label for="date"><b>Start Date:</b></label>
                  <input type="text" id="startdatepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD"  name="start_date_id" required maxlength="30">
                 
                  <label for="date"><b>End Date:</b></label>
                  <input type="text" id="enddatepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD"  name="end_date_id" required maxlength="30">
                  <input type="submit" id="submitdate" value="Generate Report">
                </div>
     </form>  
     <h4>Select Start and End date and click on Generate Report! Thank YOU.</h4>
     
    </body>
</html>
