<%-- 
    Document   : userview_staffsalarylist
    Created on : Mar 22, 2021, 11:17:27 PM
    Author     : dharm
--%>

<%@page import="Finance.Model.Salary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="User.Model.History"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" />
<jsp:include page="logo.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/userview_staffsalaryliststyle.css" type="text/css">
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>
        <div id="table">
            <h2>List of Salary</h2>   
                    <hr>
                    <br>
                    
       <div class="container text-left">
         <%
            //fetching list of salary
            ArrayList<Salary> listsalary=(ArrayList<Salary>)request.getAttribute("liststaffsalary");
            
            if(!listsalary.isEmpty()){%>
        </div>
        <br>
            <table id="t01">
                            <tr>
                                <th>Salary Id</th>
                                <th>Staff Email</th>
                                <th>Date</th>
                                <th>Amount</th>
                            </tr>
                        
                       
                            <%for(Salary salary:listsalary){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=salary.getSalary_id() %></td> 
                                    <td><%=salary.getStaff_email() %></td>
                                    <td><%=salary.getSalary_date() %></td>  
                                    <td><%=salary.getAmount() %></td>
                                <%}%> 

                                </tr>
  
                    </table>
                                
        <%}%> 
    
    <%if(listsalary.isEmpty()){%>
        <h2 style="color: red;"> List is Not Available !!!</h2>
    <%}%>
        </div>
     </div>
     <br>
     <button id="closebutton" onclick="location.href='userview_allstafflist.jsp'" type="button">Close</button>
    </body>
</html>
