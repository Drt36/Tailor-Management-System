<%-- 
    Document   : finance_searchedexpenselist
    Created on : Mar 16, 2021, 11:37:47 PM
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
<jsp:include page="logo.jsp" />  
  
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/finance_searchedexpensestyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
        
    </head>
    <body>

  
    <div id="table">
            <h1>List of Searched Expenses</h1>   
            <hr>
            <br>     
          <%
              
            String expense_id=request.getAttribute("search_data").toString();
            
            //fetching list of all expenses
            AllExpensesList allexpenselist=new AllExpensesList();
            List < Expense > listexpenses =allexpenselist.selectSearchedExpenses(expense_id);
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
        <h1 style="color: red;">OOOPS! List is Not Available !!!</h1>
    <%}%>
    </div>
    <button id="closebutton" onclick="location.href='finance_allexpenselist.jsp'" type="button">Close</button>
    </body>
</html>
