<%-- 
    Document   : finance_paysalary
    Created on : Mar 22, 2021, 10:11:30 PM
    Author     : dharm
--%>

<%@page import="Finance.Database.SumSalaryOfStaff"%>
<%@page import="Finance.Database.SumTotalIncome"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.OrderAllData"%>
<%@page import="Product.Model.Product"%>
<%@page import="Product.Database.ProductAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" />
<jsp:include page="logo.jsp" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <link rel="stylesheet" href="CSS/finance_paysalarystyle.css" type="text/css">
    </head>
    <body>
        <%       
            String user_email=request.getAttribute("user_email").toString();
            
            //get sum of income
            SumTotalIncome sumtotalincome=new SumTotalIncome();
            Float totalincome=sumtotalincome.sumTotalIncomeOfStaff(user_email);
            
            //get sum of paid salary
            SumSalaryOfStaff summsalaryodstaff=new SumSalaryOfStaff();
            Float totalpaidsalary=summsalaryodstaff.sumTotalPaidSalaryOfStaff(user_email);
            
            //get due salary
            Float duesalary=totalincome-totalpaidsalary;
        %>
        
      <div id="masterdiv">    
          <h1>Pay Salary Here!</h1>
           <hr>
           <br>
       <form action="<%= request.getContextPath() %>/finance_paysalaryfinalservlet" id="paysalaryform" method="post">
           
          <h2>Payment Form:</h2> 
          <br>
          <label><b>Total Income: <%=totalincome %></b></label> <br>
          <br>
          <label><b>Total Paid: <%=totalpaidsalary %></b></label><br>
          <br>
          <h3>Due Salary Amount: Rs.<%=duesalary %>/- </h3><br>
          
          <label><b>Paying Amount:</b></label>
          <input  type="number" placeholder="Enter paying amount"  name="paying_amount_id"  required  max="<%=duesalary %>" min="0">
          <br>
    
        <input type="hidden" name="staff_email_id" value="<%=user_email %>">
        <input type="submit" id="paysalarybutton" value="Pay"></input>
        <button onclick="history.back()" type="button" id="cancelbtn" class="cancelbtn">Cancel</button>
        
       </form>
      </div>
    </body>
</html>