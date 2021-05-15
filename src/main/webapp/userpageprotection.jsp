<%-- 
    Document   : userpageprotection
    Created on : Oct 9, 2020, 4:02:14 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%
    //proptecting admin page
  String sessioncontainer = (String)session.getAttribute("user");
  String userpagepermissionmessage="You are not User.Please login as User!!!";
  
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
        
           if(!user.getUser_role().equalsIgnoreCase("user")){
                request.setAttribute("userpagepermissionmessage",userpagepermissionmessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
        
             }
        
        }
   
   
   }

%>
