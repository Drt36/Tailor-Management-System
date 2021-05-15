<%-- 
    Document   : BlockedUsers
    Created on : Jan 4, 2021, 11:44:01 AM
    Author     : dharm
--%>

<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Database.UserAllData"%>
<%@page import="java.util.List"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.AllUsersList"%>
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
        <link rel="stylesheet" href="CSS/alluserslist.css" type="text/css">
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
       <a href="users.jsp">
        <i class="fas fa-users"></i>
        <span>Users</span>
      </a>
      <a href="BlockedUsers.jsp" class="active">
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
       
    <div id="table">
            <h2>List of Blocked Users</h2>   
                    <hr>
                    <br>
        <br>
        <h3 class="hide">${blockedsuccessfullymessage}</h3>
        <h3 class="hide">${deleteusermessage}</h3>
         
        <%
            //fetching list of all users
            AllUsersList alluserslist=new AllUsersList();
            List < User > listUser =alluserslist.selectAllBlockedUsers();
            if(!listUser.isEmpty()){%>  
            
            <table id="t01">
                        
                            <tr>
                                <th>Username</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Contact</th>
                                <th>Address</th>
                                <th>Date Of Birth</th>
                                <th>Gender</th>
                                <th>Role</th>
                                <th>Actions</th>
                            </tr>
                        
                          <%for(User user:listUser){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=user.getUsername()%></td> 
                                    <td><%=user.getUser_fullname()%></td>
                                    <td><%=user.getUser_email()%></td>
                                    <td><%=user.getUser_contact()%></td>
                                    <td><%=user.getUser_address()%></td>
                                    <td><%=user.getUser_dateofbirth()%></td>
                                    <td><%=user.getUser_gender()%></td>
                                    <td><%=user.getUser_role()%></td>
                                    <td>
                                    <button onclick="location.href='userunblockservlet?user_email=<%=user.getUser_email() %>'"  class="btn warning"/>Unblock</button> 
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='historyadminviewservlet?user_email=<%=user.getUser_email() %>'" class="btn success" >History</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='deleteuserservlet?user_email=<%=user.getUser_email() %>'" class="btn danger" >Remove</button>
                                    </td>  
                                    <%}%> 
                                </tr>
                    </table>
<%}%> 
    
    <%if(listUser.isEmpty()){%>
        <h2 style="color: red;"> Records Not Found !!!</h2>
    <%}%>
              </div>
            </div>
            
    </body>
</html>

