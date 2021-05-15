<%-- 
    Document   : staffpageprotection
    Created on : Oct 9, 2020, 4:02:41 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%
    //proptecting admin page
  String sessioncontainer = (String)session.getAttribute("user");
  String staffpagepermissionmessage="You are not staff.Please login as staff!!!";
  
   if(sessioncontainer==null){
        
        request.setAttribute("staffpagepermissionmessage",staffpagepermissionmessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
   }else{
   
        UserAllData useralldata=new UserAllData();
        User user=useralldata.getAllDataOfUser(sessioncontainer);
        
        if(user.isIs_blocked()==true){
              String blockedmessage="You are Blocked!!! You can not use this system!";
              request.setAttribute("blockedmessage",blockedmessage);
              RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
              dispatcher.forward(request, response);
        
        }
        else{
            if(!user.getUser_role().equalsIgnoreCase("staff")){
               request.setAttribute("adminpagepermissionmessage",staffpagepermissionmessage);
               RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
               dispatcher.forward(request, response);

            }
        }
   
   
   }

%>
