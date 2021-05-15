<%-- 
    Document   : historyadminview
    Created on : Jan 4, 2021, 11:08:23 PM
    Author     : dharm
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="User.Model.History"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<jsp:include page="logo.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/historystyle.css" type="text/css">
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>
        <div id="table">
            <h1>List of History</h1>   
                    <hr>
                    <br>
                    
       <div class="container text-left">
         <%
            //fetching list of history
            ArrayList<History> listhistory=(ArrayList<History>)request.getAttribute("listhistory");
            
            if(!listhistory.isEmpty()){%>
        </div>
        <br>
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
        <h2 style="color: red;"> List is Not Available !!!</h2>
    <%}%>
        </div>
     </div>
     <br>
     <button id="closebutton" onclick="location.href='users.jsp'" type="button">Close</button>
    </body>
</html>
