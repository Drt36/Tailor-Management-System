<%-- 
    Document   : finance_allexpenselist
    Created on : Feb 24, 2021, 2:06:24 PM
    Author     : dharm
--%>

<%@page import="Finance.Model.Expense"%>
<%@page import="java.util.List"%>
<%@page import="Finance.Database.AllExpensesList"%>
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
        <link rel="stylesheet" href="CSS/finance_allexpenseliststyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
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
      <a href="finance_allexpenselist.jsp"  class="active">
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
            <h2>List of Expenses</h2>   
                    <hr>
                    <br>
           <button id="addexpensebutton" onclick="location.href='finance_addexpenseform.jsp'" type="button">Add New Expense</button>
           
           <form action="<%= request.getContextPath() %>/finance_searchexpenseservlet" id="expensesearchform" method="post">
               <input type="text" placeholder="Search using Expense id..." name="search_id" required>
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
             <h3 class="hide">${expenseaddedsuccessfullymessage}</h3>
            <h3 class="hide">${expenseeditedsuccessfullymessage}</h3>
            <h3 class="hide">${expensedeletedsuccessfullymessage}</h3>
        </div>
       <div id="table">
            
          <%
            //fetching list of all expenses
            AllExpensesList allexpenselist=new AllExpensesList();
            List < Expense > listexpenses =allexpenselist.selectAllExpenses();
            if(!listexpenses.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Expense ID</th>
                                <th>Title</th>
                                <th>Amount</th>
                                <th>Description</th>
                                <th>Creator</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        
                       
                            <%for(Expense expense:listexpenses){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=expense.getExpense_id() %></td> 
                                    <td><%=expense.getExpense_title() %></td>
                                    <td><%=expense.getExpense_amount() %></td>
                                    <td><%=expense.getExpense_description() %></td>
                                    <td><%=expense.getExpense_creator() %></td>
                                    <td><%=expense.getExpense_date() %></td>
                                    <td>
                                    <button onclick="location.href='finance_deleteexpenseservlet?expense_id=<%=expense.getExpense_id()%>'"  class="btn danger"/>Remove</button> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='finance_beforeexpenseupdateservlet?expense_id=<%=expense.getExpense_id()%>'" class="btn warning" >Edit</button>
                                    
                                    </td>
                                       
                                <%}%> 

                                </tr>
                    </table>                 
        <%}%> 
    
    <%if(listexpenses.isEmpty()){%>
        <h2 style="color: red;">OOOPS! Record Not Found!!!</h2>
    <%}%>
    </div>
    </body>
</html>