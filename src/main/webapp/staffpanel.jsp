<%-- 
    Document   : staffpanel
    Created on : Oct 9, 2020, 11:03:16 AM
    Author     : dharm
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="Finance.Database.GetStaffincomeFigure"%>
<%@page import="Finance.Database.StaffTaskCounter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Finance.Database.SumSalaryOfStaff"%>
<%@page import="Finance.Database.SumTotalIncome"%>
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
        <link rel="stylesheet" href="CSS/staffpanelstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
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
      <a href="staffpanel.jsp" class="active">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
        <a href="order_allordersstaffview.jsp">
          <i class="fas fa-shopping-cart"></i>
          <span>Orders</span>
        </a>
        <a href="staff_staffsalary.jsp">
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
    <%
        //getting date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date=dtf.format(now).toString();
        
        //getting income details
        SumTotalIncome sumtotalincome=new SumTotalIncome();
        Float totalincome=sumtotalincome.sumTotalIncomeOfStaff(user_email);
        Float todays_income=sumtotalincome.sumTodaysIncomeOfStaff(user_email, date);

        //getting paid salary details
        SumSalaryOfStaff sumsalaryofstaff=new SumSalaryOfStaff(); 
        Float totalpaidsalary=sumsalaryofstaff.sumTotalPaidSalaryOfStaff(user_email);
        Float todays_paidsalary=sumsalaryofstaff.sumTodaysPaidSalaryOfStaff(user_email, date);
        
        //getting due details
        Float TotalDue=totalincome-totalpaidsalary;
        Float Todays_due=todays_income-todays_paidsalary;
        
        //count Task
        StaffTaskCounter  stafftaskCounter =new StaffTaskCounter();
        int todays_tasks=stafftaskCounter.countTodaysTask(date,user_email);
        int total_tasks=stafftaskCounter.countLifetimeTask(user_email);
        
        //get staff income figure
        GetStaffincomeFigure getstaffincomefigure=new  GetStaffincomeFigure();
        List<Map<Object, Object>> staffincomelist=getstaffincomefigure.getStaffIncomeFigure(user_email,"2000-01-01",date);
        
        Gson gsonObj = new Gson();

        String dataPointsstaffincome = null;
        dataPointsstaffincome = gsonObj.toJson(staffincomelist);
        
    
    %>
    <h2>Staff Dashboard</h2>
    <hr>
    <h3 class="hide">${otpcodevalidmessage}</h3>
    <div class="row">
        <div class="column">
          <div class="card">
            <h2>Today's Task</h2>
            <h2 class="value"><%=todays_tasks %></h2>
            
          </div>
        </div>
         
        <div class="column">
          <div class="card">
            <h2>Today's Earning</h2>
            <h2 class="value">Rs.<%=todays_income %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Today's Paid Salary</h2>
            <h2 class="value">Rs.<%=todays_paidsalary %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Today's Due Salary</h2>
            <h2 class="value">Rs.<%=Todays_due %></h2>
          </div>
            
        </div>
        <div class="column">
          <div class="card">
            <h2>Lifetime Task</h2>
            <h2 class="value"><%=total_tasks %></h2>
            
          </div>
        </div>
         
        <div class="column">
          <div class="card">
            <h2>Lifetime Earning</h2>
            <h2 class="value">Rs.<%=totalincome %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Lifetime Paid Salary</h2>
            <h2 class="value">Rs.<%=totalpaidsalary %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Lifetime Due Salary</h2>
            <h2 class="value">Rs.<%=TotalDue %></h2>
          </div>
            
        </div>
        
     </div>
          
    <div id="chartContainerincome"></div>  
    <script type="text/javascript">
        window.onload = function() { 
     
        <% if(dataPointsstaffincome!= null) { %>
        var chartincome = new CanvasJS.Chart("chartContainerincome", {
                animationEnabled: true,
                animationDuration: 5000,
                backgroundColor:"#f1f1f1",
                exportEnabled: true,
                theme: "light1",
                title: {
                        text: "Lifetime Income Figure",
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
                        dataPoints: <%out.print(dataPointsstaffincome);%>
                }]
        });
        chartincome.render();
        <% } %> 
    };
      </script>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
</html>
