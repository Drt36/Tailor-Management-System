<%-- 
    Document   : logout
    Created on : Oct 10, 2020, 8:22:39 AM
    Author     : dharm
--%>

<%@page import="User.Database.StoreHistory"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>
        <%  
            String user_email = (String)session.getAttribute("user");
           
            //logout time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd      HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String datetime =dtf.format(now).toString();

            //stroing login data
            StoreHistory storehistory=new StoreHistory();
            storehistory.storeHistory(user_email,"Log out from the System", datetime);
            
            session.invalidate();
         %>
         <jsp:forward page="index.jsp"/>
    </body>
</html>
