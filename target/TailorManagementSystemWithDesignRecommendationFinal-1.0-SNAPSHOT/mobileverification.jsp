<%-- 
    Document   : mobileverification
    Created on : Oct 29, 2020, 1:16:00 PM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="alluserspageprotection.jsp" />
<jsp:include page="logo.jsp" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="CSS/mobileverificationstyle.css" type="text/css">
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
    </head>
    <body>
        <h2>Hello ${username} !!!</h2>
        <h3>Welcome to this TMSWDR Family.</h3>
        <h3 id="notverified">To unlock All the features of this system verify your Contact Number.</h3>
        <form id="mobileverificationform" action="<%= request.getContextPath() %>/mobileverificationservlet" method="post">
                <div class="container">
                  <label><b>Contact:</b></label>
                  <input type="number" class="form-control" placeholder="Enter Phone Number" value="${user_contact}" name="user_phonenumber_id" required min="9000000000" max="9999999999" readonly>
                  <input type="submit" id="verify" value="Verify"></input>
                </div>      
         </form>  
                   
                  
                  
                   
                  
    </body>
</html>
