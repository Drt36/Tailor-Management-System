<%-- 
    Document   : otpcodevalidationforforgetpassword
    Created on : Nov 3, 2020, 11:00:36 AM
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
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <link rel="stylesheet" href="CSS/codevalidationstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <script type="text/javascript" src="Scripts/timerforforgetpassword.js"></script>
        <script type="text/javascript" src="Scripts/otpcodecheckforforgetpassword.js"></script>
    </head>
    <body>
        <h2>OTP Code Validation Form</h2>
        <h3>This code will expire in 2 minutes!</h3>
        <p id="timer"><p>
        <p id="expire"><p>
        <p id="sentmessage">${otpcodesuccessfullysentmessage}</p>
        <form id="codevalidationform" action="<%= request.getContextPath() %>/Codevalidationservletforforgetpassword" method="post">
                <div class="container">
                  <label><b>Code:</b></label>
                  <input type="number" class="form-control" id="otpcode" placeholder="Enter OTP Code" name="otpcode_id" required>
                  <p id="matched"></p>
                  <p id="notmatched"></p>
                  <input type="submit" id="submit" value="Submit"></input>
                </div>      
         </form>
    </body>
</html>