<%-- 
    Document   : userandadminpagepeotection
    Created on : Jan 19, 2021, 12:29:37 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%
  //proptecting admin page
  String sessioncontainer = (String)session.getAttribute("user");
  String userpagepermissionmessage="You are not User or Admin.Please login as User or Admin!!!";
  
   if(sessioncontainer==null){
        
        request.setAttribute("userpagepermissionmessage",userpagepermissionmessage);
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
        
           if(user.getUser_role().equalsIgnoreCase("staff")){
               
                request.setAttribute("userpagepermissionmessage",userpagepermissionmessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
        
             }  
        
        }
   
   
   }

%>
