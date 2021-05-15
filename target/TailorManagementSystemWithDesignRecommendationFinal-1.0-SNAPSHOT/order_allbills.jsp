<%-- 
    Document   : order_allbills
    Created on : Feb 23, 2021, 10:43:41 PM
    Author     : dharm
--%>

<%@page import="Order.Model.Bill"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.AllBillsList"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/order_allbillsliststyle.css" type="text/css">
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
      <a href="order_allbills.jsp"  class="active">
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
    
       
    <div id="sticky" class="container text-left">
            <h2>List of Bills</h2>   
                    <hr>
                    <br>
           <form action="<%= request.getContextPath() %>//order_searchorderservlet" id="billsearchform" method="post">
               <input type="text" placeholder="Search using Bill No..." name="search_id" required>
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
       
        <h4>Note:Click on View to see updated Due amount.</h4>
        
        <h3 class="hide">${updatecustomermessage}</h3>
        <h3 class="hide">${deletecustomermessage}</h3>
    </div>
    <div id="table">
          <%
            //fetching list of bills
            AllBillsList allbilllist=new AllBillsList();
            List < Bill > billlist=allbilllist.selectAllBills();
            if(!billlist.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Bill ID</th>
                                <th>Bill No.</th>
                                <th>Date</th>
                                <th>Actual Amount</th>
                                <th>Advanced</th>
                                <th>Due Amount(At First)</th>
                                <th>Action</th>
                            </tr>
                        
                       
                            <%for(Bill bill:billlist){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=bill.getBill_id() %></td> 
                                    <td><%=bill.getBill_no() %></td>
                                    <td><%=bill.getBill_date() %></td>
                                    <td><%=bill.getBill_actualamount() %></td>
                                    <td><%=bill.getBill_advanced() %></td>
                                    <td style="color:red;"><b><%=bill.getBill_dueamount() %></b></td>
            
                                    <td>
                                    <form action="<%= request.getContextPath()%>/order_billdetailsservlet" id="beforebilldetailsform" method="post">
                                        <input type="hidden" name="bill_id_id"value="<%=bill.getBill_id() %>" >
                                        <input type="hidden" name="bill_no_id" value="<%=bill.getBill_no() %>">
                                        <input type="hidden" name="bill_date_id" value="<%=bill.getBill_date() %>">
                                        
                                        <input type="hidden" name="bill_actualamount_id" value="<%=bill.getBill_actualamount() %>">
                                        <input type="hidden" name="bill_advanced_id" value="<%=bill.getBill_advanced() %>">
                                        <input type="hidden" name="bill_due_id" value="<%=bill.getBill_dueamount() %>">
                                        
                                        <button  type="submit" class="btn warning">View </button>
                                     </form>                               
                                    </td>
                                       
                                <%}%> 

                                </tr>
                    </table>                 
        <%}%> 
    
    <%if(billlist.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
    </div>  
    </body>
</html>
