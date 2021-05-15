<%-- 
    Document   : customer_admincustomerlist
    Created on : Jan 5, 2021, 10:14:22 PM
    Author     : dharm
--%>

<%@page import="Customer.Model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="Customer.Database.AllCustomerList"%>
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
        <link rel="stylesheet" href="CSS/adminpanelstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/customer_customerliststyle.css" type="text/css">
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
      <a href="customer_admincustomerlist.jsp" class="active">
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
            <h2>List of Customers</h2>   
                    <hr>
                    <br>

          <%
            //fetching list of all customers
            AllCustomerList allcustomerlist=new AllCustomerList();
            List < Customer > listCustomer =allcustomerlist.selectAllCustomers();
            if(!listCustomer.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Username</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Contact</th>
                                <th>Address</th>
                                <th>Date Of Birth</th>
                                <th>Gender</th>
                                
                            </tr>
                        
                       
                            <%for(Customer customer:listCustomer){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=customer.getCustomer_username()%></td> 
                                    <td><%=customer.getCustomer_fullname()%></td>
                                    <td><%=customer.getCustomer_email()%></td>
                                    <td><%=customer.getCustomer_contact()%></td>
                                    <td><%=customer.getCustomer_address()%></td>
                                    <td><%=customer.getCustomer_dateofbirth()%></td>
                                    <td><%=customer.getCustomer_gender()%></td>
                                       
                                <%}%> 
                             
                                
                            
                                </tr>
                        
                       
                      

                    </table>
                                
        <%}%> 
    
    <%if(listCustomer.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
    </div>
   </div>
       
       
       
       
       
    </body>
</html>
