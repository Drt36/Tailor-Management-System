<%-- 
    Document   : forgetpassword
    Created on : Nov 2, 2020, 9:36:15 AM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="logo.jsp" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="CSS/forgetpasswordstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <script type="text/javascript" src="Scripts/Emailcheck.js"></script>
    </head>
    <body>
        <h1>Forget Password</h1>
        <h3>Please enter valid email which is associated with this System.</h3>
        <form id="emailverificationform" action="<%= request.getContextPath() %>/Forgetpasswordservlet" method="post">
                <div class="container">
                  <label for="email"><b>Email:</b></label><br>
                  <input type="email" id="checkemail" placeholder="Enter Email" name="user_email_id" required>
                  <p id="emailexist"></p>
                  <input type="submit" id="submitemail" value="Send Code">
                </div>

                
         </form>  
    </body>
</html>
