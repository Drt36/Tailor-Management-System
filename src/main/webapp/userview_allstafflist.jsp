<%-- 
    Document   : userview_allstafflist
    Created on : Mar 22, 2021, 12:48:45 PM
    Author     : dharm
--%>

<%@page import="java.util.List"%>
<%@page import="User.Database.AllUsersList"%>
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
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/userview_allstaffliststyle.css" type="text/css">
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
      <a href="userview_allstafflist.jsp"  class="active">
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
      <a href="userreport.jsp">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
    <div id="table">
            <h2>List of All Staffs</h2>   
                    <hr>
                    <br>
        <h3 class="hide">${salarypaymentupdatemessage}</h3>
          <%
            //fetching list of all users
            AllUsersList alluserslist=new AllUsersList();
            List < User > listUser =alluserslist.selectAllStaffs();
            if(!listUser.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Actions</th>
                                <th>Contact</th>
                            </tr>
                        
                       
                            <%for(User userdata:listUser){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=userdata.getUser_fullname()%></td>
                                    <td><%=userdata.getUser_email()%></td>
                                    <td><%=userdata.getUsername() %></td>
                                    <td><%=userdata.getUser_contact() %></td>
                                    <td>
                                    <button onclick="location.href='finance_userviewsalaryservlet?user_email=<%=userdata.getUser_email() %>'" class="btn default" >View Salary</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='finance_paysalaryservlet?user_email=<%=userdata.getUser_email() %>'" class="btn warning" >Pay Salary</button>
                         
                                    </td>
                                       
                                <%}%> 
                                </tr>

                    </table>
                                
        <%}%> 
    
    <%if(listUser.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
  </div>
     
       
       
       
       
       
       
       
       
       
       
       
    </body>
