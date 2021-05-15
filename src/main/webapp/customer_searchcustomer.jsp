<%-- 
    Document   : customer_searchcustomer
    Created on : Jan 7, 2021, 11:27:19 PM
    Author     : dharm
--%>

<%@page import="Customer.Model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="Customer.Database.AllCustomerList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" />  
<jsp:include page="logo.jsp" />
  
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="CSS/customer_customerliststyle.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    </head>
    <body>

    
    <div id="table">
            <h1>List of Customers</h1>   
                    <hr>
                    <br>
          <%
              
            String search_data=request.getAttribute("search_data").toString();
            
            //fetching list of all customers
            AllCustomerList allcustomerlist=new AllCustomerList();
            List < Customer > listCustomer =allcustomerlist.searchAllCustomers(search_data);
            if(!listCustomer.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Username</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Contact</th>
                                <th>Address</th>
                                <th>Date Of Birth</th>
                                <th>Gender</th>
                                <th>Actions</th>
                            </tr>
                        
                       
                            <%for(Customer customer:listCustomer){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=customer.getCustomer_username()%></td> 
                                    <td><%=customer.getCustomer_fullname()%></td>
                                    <td><%=customer.getCustomer_email()%></td>
                                    <td><%=customer.getCustomer_contact()%></td>
                                    <td><%=customer.getCustomer_address()%></td>
                                    <td><%=customer.getCustomer_dateofbirth()%></td>
                                    <td><%=customer.getCustomer_gender()%></td>
                                    <td>
                                    <button onclick="location.href='customer_editcustomerservlet?customer_email=<%=customer.getCustomer_email()%>'"  class="btn warning"/>Edit</button> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='customer_deletecustomerservlet?customer_email=<%=customer.getCustomer_email()%>'" class="btn danger" >Remove</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='#'" class="btn success" >Orders</button>
                                    
                                    </td>
                                       
                                <%}%> 
                             
                                
                            
                                </tr>
                        
                       
                      

                    </table>
                                
        <%}%> 
    
    <%if(listCustomer.isEmpty()){%>
        <h1 style="color: red;"> Sorry,Not Found !!!</h1>
    <%}%>
    </div>
   </div>
   <br>
   <button id="closebutton" onclick="location.href='customer_usercustomerlist.jsp'" type="button">Close</button>
       
       
       
       
    </body>
</html>