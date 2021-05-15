<%-- 
    Document   : profileimageload
    Created on : Nov 11, 2020, 8:11:31 PM
    Author     : dharm
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <% 
         //getting data from session
         String user_email= (String)session.getAttribute("user");
         //getting user details from database
         Blob blob=null;
         GetProfilePicture getprofilepicture=new GetProfilePicture();
         blob=getprofilepicture.getProfilePicture(user_email);
         
        byte byteArray[] = blob.getBytes(1, (int)blob.length());
 
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
    %>