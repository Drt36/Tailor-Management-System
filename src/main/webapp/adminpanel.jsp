<%-- 
    Document   : adminpanel
    Created on : Oct 9, 2020, 8:49:03 AM
    Author     : dharm
--%>

<%@page import="Customer.Database.CustomerCounter"%>
<%@page import="User.Database.UserCounter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="Finance.Database.GetExpenseFigure"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.GetSalesFigure"%>
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
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/adminpanelstyle.css" type="text/css">
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
      <a href="adminpanel.jsp" class="active">
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
       <a href="order_allordersadminview.jsp">
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
    <%
        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date=dtf.format(now);
        
        //get sales Figure
        GetSalesFigure getsalesfigure=new  GetSalesFigure();
        List<Map<Object, Object>> saleslist=getsalesfigure.getSalesFigure("2000-01-01",date);
        
        //get Expense Figure
        GetExpenseFigure getexpensefigure=new GetExpenseFigure();
         List<Map<Object, Object>> expenselist=getexpensefigure.getExpenseFigure("2000-01-01",date);
        
        Gson gsonObj = new Gson();

        String dataPointssales = null;
        String dataPointsexpense = null;

        
        dataPointssales = gsonObj.toJson(saleslist);
        dataPointsexpense = gsonObj.toJson(expenselist);
        
        //get Total active user
        UserCounter usercounter=new UserCounter();
        int totalactive_users=usercounter.countTotalActiveUsers();
        
        //get Total Blocked user
        int totalblocked_users=usercounter.countTotalBlockedUsers();
        
        //get Total Staffs
        int total_staffs=usercounter.countTotalStaffs();
        //get total customer
        CustomerCounter customercounter=new CustomerCounter();
        int total_customer=customercounter.countTotalCustomers();
        
     %>
    <h2 id="title">Admin Dashboard</h2>
    <h3 class="hide" >${otpcodevalidmessage}</h3>
     <div class="row">
        <div class="column">
          <div class="card">
            <h2>Total Active Users</h2>
            <h2 class="value"><%=totalactive_users %></h2>
            
          </div>
        </div>
         
        <div class="column">
          <div class="card">
            <h2>Total Blocked Users</h2>
            <h2 class="value"><%=totalblocked_users %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Total Staffs</h2>
            <h2 class="value"><%=total_staffs %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Total Customers</h2>
            <h2 class="value"><%=total_customer %></h2>
          </div>
        </div>

        
     </div>
     
   
     <div id="chartContainersales"></div>
     <div id="chartContainerexpense"></div>
     <script type="text/javascript">
        window.onload = function() { 
     
        <% if(dataPointssales != null) { %>
        var chartsales = new CanvasJS.Chart("chartContainersales", {
                animationEnabled: true,
                animationDuration: 5000,
                backgroundColor:"#f1f1f1",
                exportEnabled: true,
                theme: "light1",
                title: {
                        text: "Lifetime Sales Figure",
                        fontColor: "green",
                        fontWeight: "bold",
                        fontFamily: "Geneva"
                },
                axisY:{
		title: "Amount",
		prefix: "Rs.",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
                    }
                },
                axisX:{
		title: "Date",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
                
               
                },
                data: [{
                        type: "line", //change type to bar, line, area, pie, etc
                        xValueType: "dateTime",
                        color: "green",
                        dataPoints: <%out.print(dataPointssales);%>
                }]
        });
        chartsales.render();
        <% } %> 

        <% if(dataPointsexpense != null) { %>
        var chartexpense = new CanvasJS.Chart("chartContainerexpense", {
                animationEnabled: true,
                animationDuration: 5000,
                backgroundColor:"#f1f1f1",
                exportEnabled: true,
                theme: "light1",
                title: {
                        text: "Lifetime Expenses Figure",
                        fontColor: "red",
                        fontWeight: "bold",
                        fontFamily: "Geneva"
                },
                axisY:{
		title: "Amount",
		prefix: "Rs.",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
                    }
                
                },
                axisX:{
		title: "Date",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
                
               
                },
                data: [{
                        type: "area", //change type to bar, line, area, pie, etc
                        xValueType: "dateTime",
                        color: "orange",
                        dataPoints: <%out.print(dataPointsexpense);%>
                }]
        });
        chartexpense.render();
        <% } %> 
        };
      </script>
     <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    
    </body>
</html>
