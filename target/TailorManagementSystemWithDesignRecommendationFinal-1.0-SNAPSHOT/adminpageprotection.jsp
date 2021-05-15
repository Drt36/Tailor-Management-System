<%-- 
    Document   : adminpageprotection
    Created on : Oct 9, 2020, 3:39:06 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%
    response.setHeader("cache-control","no-cache,no-store,must-revalidate");
    
    //proptecting admin page
  String sessioncontainer = (String)session.getAttribute("user");
  String adminpagepermissionmessage="You are not admin.Please login as admin!!!";
  
   if(sessioncontainer==null){
        
        request.setAttribute("adminpagepermissionmessage",adminpagepermissionmessage);
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
            if(!user.getUser_role().equalsIgnoreCase("admin")){
               request.setAttribute("adminpagepermissionmessage",adminpagepermissionmessage);
               RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
               dispatcher.forward(request, response);

            }
        }
   }

%>