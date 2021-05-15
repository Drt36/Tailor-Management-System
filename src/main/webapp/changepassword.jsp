<%-- 
    Document   : changepassword
    Created on : Nov 3, 2020, 9:27:06 PM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="logo.jsp" /> 
<jsp:include page="alluserspageprotection.jsp" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="CSS/changepasswordstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
    </head>
    <body>
        <h1>Change Password</h1>
        <p>${allworongmessage}</p>
        <p>${oldpasswordwrongmessage}</p>
        <p>${newandconfirmpasswordnotmatchedmessage}</p>
        <form id="changepasswordform"action="<%= request.getContextPath() %>/Changepasswordservlet" method="post">     
                <div class="container">
                  <label for="password"><b>Old Password:</b></label><br>
                  <input type="password" placeholder="Enter Old Password" name="oldpassword_id" required ><br>
                  <label for="password"><b>New Password:</b></label><br>
                  <input type="password" placeholder="Enter New Password" name="newpassword_id" required minlength="8" ><br>
                  <label for="password"><b>Confirm New Password:</b></label><br>
                  <input type="password" placeholder="Confirm New Password" name="confirmnewpassword_id" required minlength="8" >
                  <input type="submit" value="Submit" id="changepasswordbutton">
                </div>
         </form>
    </body>
</html>
