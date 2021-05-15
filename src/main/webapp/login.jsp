<%-- 
    Document   : login
    Created on : Oct 8, 2020, 3:33:42 PM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="universalnavbar.jsp" /> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">        
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>     
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="CSS/loginstyle.css" type="text/css">
<script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
<script type="text/javascript" src="Scripts/Hideerrors.js"></script>

<title>Tailor Management System With Design Recommendation</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/loginservlet" id="loginform" method="post">
        <div class="imgcontainer">
          <img src="Images/useravatar.png" alt="Avatar" class="avatar">
        </div>
                <p class="hide">${sessionnotcreated}</p>
                <p class="hide">${rolenotcreated}</p>
                <p class="hide">${wrongcredentials}</p>
                <p class="hide">${sessionnotcreated}</p>
                <p class="hide">${adminpagepermissionmessage}</p>
                <p class="hide">${userpagepermissionmessage}</p>
                <p class="hide">${staffpagepermissionmessage}</p>               
                <p class="hide">${passwordresetmessage}</p>
                <p class="hide">${passwordchangedmessage}</p>
                <p class="hide">${alluserpagepermissionmessage}</p>
                <p class="hide">${blockedmessage}</p>

        <div class="container">

          <label for="email"><b>Email</b></label><br>
          <input  type="email" placeholder="Enter Email" value="${user_email1}" name="email" required>

          <label for="psw"><b>Password</b></label><br>
          <input type="password" id="password" placeholder="Enter Password" name="password" required minlength="8">
          <i class="far fa-eye" id="togglePassword"></i>
          <input type="submit" id="login" value="Log in"></input>
          <label>

        </div>

        <div class="container">
          <button onclick="location.href='index.jsp'" type="button" class="cancelbtn">Cancel</button>
          <span class="psw"><a href="forgetpassword.jsp">${forgetpassword}</a></a></span>
        </div>
</form>
 
<script type="text/javascript" src="Scripts/PasswordToggle.js"></script>        
</body>
</html>
