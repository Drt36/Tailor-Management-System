<%-- 
    Document   : recommendation_displayrecommendeddesigns
    Created on : Mar 10, 2021, 6:47:15 AM
    Author     : dharm
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" />
<jsp:include page="logo.jsp" />  
 <% 
    String customer_email=request.getAttribute("customer_email").toString(); 
    String product_code=request.getAttribute("product_code").toString(); 
    String design_url=request.getAttribute("design_url").toString(); 
    String design_code=request.getAttribute("design_code").toString(); 

 %>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/recommendation_displayrecommendeddesignsstyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
   
    </head>
    <body>
    <input type="hidden" id="customer_email_id"value="<%=customer_email %>" >
    <input type="hidden" id="product_code_id" value="<%=product_code%>">
    <input type="hidden" id="design_url_id" value="<%=design_url%>">
    <input type="hidden" id="design_code_id" value="<%=design_code%>">
    <div id="table">
    <div class="container text-left">
        <h1>Recommend Designs! Select the one Design!</h1>  
                    <hr>
                    <br>
    </div>
        <div class="card" id="firstdiv"></div> 
        <div class="card" id="seconddiv"></div>
        <div class="card" id="thirddiv"></div>
        <div class="card" id="fourthdiv"></div>
        
        <div class="card" id="fivediv"></div>  
        <div class="card" id="sixdiv"></div>  
        <div class="card" id="sevendiv"></div>  
        <div class="card" id="eightdiv"></div>  
     <script type="text/javascript" src="Scripts/recommendation_displayrecommendeddesigns.js"></script>
    </body>
</html>
