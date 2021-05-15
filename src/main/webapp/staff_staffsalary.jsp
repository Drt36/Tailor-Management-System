<%-- 
    Document   : staff_staffsalary
    Created on : Mar 17, 2021, 12:36:54 PM
    Author     : dharm
--%>
<%@page import="Finance.Database.SumSalaryOfStaff"%>
<%@page import="Finance.Database.SumTotalIncome"%>
<%@page import="Finance.Model.Salary"%>
<%@page import="Finance.Database.StaffSalaryList"%>
<%@page import="Finance.Model.Income"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Finance.Database.StaffIncomeList"%>
<%@page import="Finance.Database.AllExpensesList"%>
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
        <link rel="stylesheet" href="CSS/staff_staffsalarystyle.css" type="text/css">
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
      <a href="staffpanel.jsp" >
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
        <a href="order_allordersstaffview.jsp">
          <i class="fas fa-shopping-cart"></i>
          <span>Orders</span>
        </a>
        <a href="staff_staffsalary.jsp" class="active">
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
    <%
                    
            SumTotalIncome sumtotalincome=new SumTotalIncome();
            Float totalincome=sumtotalincome.sumTotalIncomeOfStaff(user_email);
            
              
            SumSalaryOfStaff sumsalaryofstaff=new SumSalaryOfStaff(); 
            Float totalpaidsalary=sumsalaryofstaff.sumTotalPaidSalaryOfStaff(user_email);
            
            Float Due=totalincome-totalpaidsalary;
    
    %>
    <h2 style="text-align: center;">List of Salary</h2>   
                    <hr>
                    <br>
                    <h2>Total Income: <%=totalincome %></h2><br>
                    <h2>Total Paid: <%=totalpaidsalary %></h2><br>
                    <h2 id="due"> Due:<%=Due %></h2><br>
                    
        <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'Income')" id="defaultOpen">Income</button>
                <button class="tablinks" onclick="openCity(event, 'PaidSalary')">Paid Salary</button>
        </div>
        <div id="Income" class="tabcontent">
          <%
            //fetching list of all income
            StaffIncomeList staffincomelist=new StaffIncomeList();
            List < Income > incomelist =staffincomelist.getStaffIncomeList(user_email);

            
            if(!incomelist.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Income ID</th>
                                <th>Staff Email</th>
                                <th>Order Id</th>
                                <th>Product Code</th>
                                <th>Amount</th>
                            </tr>
                        
                       
                            <%for(Income income:incomelist){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=income.getIncome_id() %></td> 
                                    <td><%=income.getStaff_email() %></td>
                                    <td><%=income.getOrder_id() %></td>
                                    <td><%=income.getProduct_code() %></td>
                                    <td><%=income.getAmount() %></td>   
                                <%}%> 

                                </tr>
                                <tr>
                                    <td>Total:</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><%=totalincome %></td>
                                    
                                </tr>
                    </table>                 
        <%}%> 
    
    <%if(incomelist.isEmpty()){%>
        <h1 style="color: red;">OOOPS! List is Not Available !!!</h1>
    <%}%>
    </div>
    
    <div id="PaidSalary" class="tabcontent">
        <%
            //fetching list of all salary
            StaffSalaryList staffsalarylist=new StaffSalaryList();
            List < Salary > salarylist =staffsalarylist.getStaffSalaryList(user_email);
          
            if(!salarylist.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Salary ID</th>
                                <th>Staff Email</th>
                                <th>Date</th>
                                <th>Amount</th>
                            </tr>
                        
                       
                            <%for(Salary salary:salarylist){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=salary.getSalary_id() %></td> 
                                    <td><%=salary.getStaff_email() %></td>
                                    <td><%=salary.getSalary_date() %></td>
                                    <td><%=salary.getAmount() %></td>  
                                <%}%> 

                                </tr>
                                <tr>
                                    <td>Total:</td>
                                    <td></td>
                                    <td></td>
                                    <td><%=totalpaidsalary %></td>
                                    
                                </tr>
                    </table>                 
        <%}%> 
    
        <%if(salarylist.isEmpty()){%>
            <h1 style="color: red;">OOOPS! List is Not Available !!!</h1>
        <%}%>
        
    </div>
    <script type="text/javascript" src="Scripts/tabview.js"></script>
    </body>
</html>
