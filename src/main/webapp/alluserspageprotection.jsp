<%-- 
    Document   : alluserspageprotection
    Created on : Nov 4, 2020, 8:53:28 PM
    Author     : dharm
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
<%
    response.setHeader("cache-control","no-cache,no-store,must-revalidate");
    
    //proptecting admin page
  String sessioncontainer = (String)session.getAttribute("user");
  String alluserpagepermissionmessage="You are not logged In. Please login first!!!";
  
   if(sessioncontainer==null){
        
        request.setAttribute("alluserpagepermissionmessage",alluserpagepermissionmessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
   }

%>