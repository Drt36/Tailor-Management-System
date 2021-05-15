<%-- 
    Document   : Registration
    Created on : Oct 10, 2020, 9:41:50 AM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="logo.jsp" /> 
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="CSS/registerstyle.css" type="text/css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
            <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
            <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
            <script type="text/javascript" src="Scripts/date.js"></script>
            <script type="text/javascript" src="Scripts/Usernameandemailcheck.js"></script>
            <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
            
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    
        <h2>Register Users Here!</h2>
        <form action="<%= request.getContextPath()%>/registerservlet" class="was-validated" id="registerform" method="post">
                <div class="container">
                 
                    <label><b>Username:</b></label>
                    <input type="text" class="form-control" id="usernamecheck" placeholder="Enter username" name="user_username_id" required  maxlength="50">
                    <p id="usernameresult"></p>
                  
                    <label><b>Full Name:</b></label>
                    <input type="text" class="form-control"  placeholder="Enter Full Name"  name="user_fullname_id" required  maxlength="50">
                   
                   
                
                    <label><b>Email:</b></label>
                    <input type="email" class="form-control" id="emailcheck" placeholder="Enter Email"  name="user_email_id" required  maxlength="100">
                    <p id="emailresult"></p>
                  
                    <label><b>Contact:</b></label>
                    <input type="number" class="form-control"  placeholder="Enter Phone Number" name="user_phonenumber_id" required min="9000000000" max="9999999999">
                    
                    
                
                    <label><b>Address:</b></label>
                    <input type="text" class="form-control"  placeholder="Enter Address"  name="user_address_id" required maxlength="50">
                    
                    
              
                    <label><b>Date of Birth:</b></label>
                    <input type="text" class="form-control" id="datepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD"  name="user_dateofbirth_id" required maxlength="30">
                  
                    <br>
                 
                    <label><b>Gender:</b></label>
                    <select name="user_gender_id">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label><b>Role:</b></label>
                    <select name="user_role_id">
                        <option value="Admin">Admin</option>
                        <option value="User">User</option>
                        <option value="Staff">Staff</option>
                    </select>
                    
                  <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember" required> I agree on<a href="agreement.jsp">Terms & Conditions.</a> 
                    </label>
                  </div>
                    <input type="submit" id="submit" value="Submit"></input>
              </form>
</html>

