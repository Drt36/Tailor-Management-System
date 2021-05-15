<%-- 
    Document   : historyadmin
    Created on : Jan 4, 2021, 11:11:13 PM
    Author     : dharm
--%>

<%@page import="User.Model.History"%>
<%@page import="User.Database.HistoryList"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Database.UserAllData"%>
<%@page import="java.util.List"%>
<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
   <% 
         //getting data from session
         String user_email= (String)session.getAttribute("user");
         //getting user details from database
         UserAllData useralldata=new UserAllData();
         User usersidebar= (User) useralldata.getAllDataOfUser(user_email);
   
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
        <link rel="stylesheet" href="CSS/historystyle.css" type="text/css">
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
           <h3 id="sidebarfullname"><%=usersidebar.getUser_fullname()%></h3>
       </div>
     
   
   <a href="adminpanel.jsp">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
       <a href="users.jsp" >
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
      <a href="historyadmin.jsp" class="active">
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
          <h2>List of History</h2>   
                    <hr>
                    <br>
           <h3 class="hide">${Clearedsuccessfullymessage}</h3>
         <%
            //fetching list of history
            HistoryList historylist=new HistoryList();
            List < History > listhistory=historylist.getHistory(user_email);
            
            if(!listhistory.isEmpty()){%>
           <button id="clearbutton" onclick="location.href='DeleteHistoryServlet?user_email=<%=user_email%>'" type="button">Clear All</button>
        </div>
        <br>
        
            <div id="table">
            <table id="t01">
                        
                            <tr>
                                <th>User Email</th>
                                <th>Task</th>
                                <th>Time</th>
                            </tr>
                        
                       
                            <%for(History history:listhistory){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=history.getEmail()%></td> 
                                    <td><%=history.getTask()%></td>
                                    <td><%=history.getDatetime()%></td>                                    
                                <%}%> 

                                </tr>
  
                    </table>
                                
        <%}%> 
    
    <%if(listhistory.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
              </div>
    </body>
</html>
