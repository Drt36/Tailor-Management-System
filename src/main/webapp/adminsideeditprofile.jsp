<%-- 
    Document   : adminsideeditprofile
    Created on : Nov 7, 2020, 1:41:13 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<jsp:include page="logo.jsp" /> 
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="CSS/adminsideeditprofilestyle.css" type="text/css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
            <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
            <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
            <script type="text/javascript" src="Scripts/date.js"></script>
            <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
            
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <%  
         User user= (User)request.getAttribute("user");
     %>
    
        <h2>Edit Selected user's Information!</h2>
        <form action="<%= request.getContextPath()%>/adminsideeditprofilesaveservlet" class="was-validated" id="adminsideeditprofileform" method="post">
                <div class="container">
                 
                    <label><b>Full Name:</b></label>
                    <input type="text" class="form-control" placeholder="Enter Full Name" value="<%=user.getUser_fullname() %>" name="user_fullname_id" required  maxlength="50">
                  
                    <label><b>Address:</b></label>
                    <input type="text" class="form-control" placeholder="Enter Address" value="<%=user.getUser_address() %>"  name="user_address_id" required maxlength="50">
 
                    <label><b>Date of Birth:</b></label>
                    <input type="text" class="form-control" id="datepicker" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="YYYY-MM-DD" value="<%=user.getUser_dateofbirth()%>" name="user_dateofbirth_id" required maxlength="30">
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
                    <input type="hidden" name="user_email_id" value="<%=user.getUser_email() %>">
                  <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember" required> I agree on<a href="#">Terms & Conditions.</a> 
                    </label>
                  </div>
                    <input type="submit" id="adminsideeditprofilesubmit" value="Submit"></input>
              </form>
</html>
