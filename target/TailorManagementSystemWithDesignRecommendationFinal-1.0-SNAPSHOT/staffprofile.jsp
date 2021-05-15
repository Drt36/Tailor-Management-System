<%-- 
    Document   : staffprofile
    Created on : Nov 5, 2020, 8:50:31 AM
    Author     : dharm
--%>

<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="staffpageprotection.jsp" /> 
<% 
         //getting data from session
         String user_email= (String)session.getAttribute("user");
         //getting user details from database
         UserAllData useralldata=new UserAllData();
         User user= (User) useralldata.getAllDataOfUser(user_email);
         
         //getting profile picture available or not
         boolean status=false;
         GetProfilePicture getprofilepicture=new GetProfilePicture();
         status=getprofilepicture.checkProfilePicture(user_email);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <script type="text/javascript" src="Scripts/Hideerrors.js"></script>
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script>
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
         <link rel="stylesheet" href="CSS/profilestyle.css" type="text/css">
         <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
         <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>
    <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>    
    <div class="sidebar">
      <div id="sidebarprofile">
          <%if(status==true){%> 
            <img src="profileimageload.jsp" id="sidebarprofilepic" height="100" width="100">
           <%}
            else{%>
            <img src="Images/profilepicture.png" id="sidebarprofilepic" height="100" width="100">
            <%}%>
           <h3 id="sidebarfullname"><%=user.getUser_fullname()%></h3>
       </div>
      <a href="staffpanel.jsp">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
       <a href="order_allordersstaffview.jsp">
          <i class="fas fa-shopping-cart"></i>
          <span>Orders</span>
        </a>
        <a href="staff_staffsalary.jsp">
          <i class="fas fa-money-check-alt"></i>
          <span>Salary</span>
        </a>
      <a href="changepassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="staffprofile.jsp" class="active">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historystaff.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
   
    <h2>Profile</h2>
        
    <div class="card">
        <%if(status==true){%> 
          <img src="profileimageload.jsp"id="profilepicture">
        <%}
          else{%>
               <img src="Images/profilepicture.png"id="profilepicture">
         <%}%>

          <h2><%=user.getUser_fullname()%></h2>

         <div>
          <fieldset>
              <legend><b>About ME:</b></legend>
              <table id="profile">

                  <tr>
                      <td><i class="fas fa-user-tag"></i></td>
                      <td> <h3 class="title">Admin</h3></td> 
                  </tr>

                  <tr>
                      <td><i class="fas fa-mobile-alt"></i></td>
                      <td><h3 class="title" ><%=user.getUser_contact()%></h3></td>
                  </tr>
                  <tr>
                       <td><i class="fas fa-map-marker-alt"></i></td>
                       <td> <h3 class="title" ><%=user.getUser_address()%></h3></td>
                  </tr>
                  <tr>
                      <td> <i class="far fa-calendar-alt"></i></td>  
                      <td> <h3 class="title" ><%=user.getUser_dateofbirth()%></h3></td>
                  </tr>
                    <tr>
                       <td><i class="fas fa-male"></i></td>
                       <td> <h3 class="title" ><%=user.getUser_gender()%></h3></td>
                  </tr>
              </table>
          </fieldset> 
          </div>
          <div >
              <button onclick="location.href='editprofileservlet?user_email=<%=user.getUser_email()%>'"/>Edit</button>
              <p class="hide" id="editsuccesmessage" >${updateusermessage}</p>
              <p class="hide" id="updateprofilepicmessage" >${uploadsuccessfullymessage}</p>
          </div>
          <div>
              <fieldset>
              <legend><b>Profile Picture:</b></legend>
              <form id="profileform" method="post" action="<%= request.getContextPath()%>/staffprofilephotouploadservlet" enctype="multipart/form-data">

                  <lable><b>Profile Photo:</b> </lable>
                  <input type="file" name="photo" required/>
                  <input id="updateprofilepicture" type="submit" value="Update">
              </form>

              </fieldset> 
          </div>


    </div>
    </body>
</html>
