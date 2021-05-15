<%-- 
    Document   : order_billdetails
    Created on : Mar 16, 2021, 9:38:46 PM
    Author     : dharm
--%>

<%@page import="java.util.UUID"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Customer.Model.Customer"%>
<%@page import="Customer.Database.CustomerAllData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Order.Model.Order"%>
<%@page import="Order.Database.GetOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/order_neworderbillstyle.css" type="text/css">
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    <body>
        <%
     

        
 
        int bill_id=(Integer)request.getAttribute("bill_id");
        String bill_no=request.getAttribute("bill_no").toString(); 
        String bill_date=request.getAttribute("bill_date").toString(); 
        
        Float actual_amount=(Float)request.getAttribute("bill_actualamount");
        Float advanced_amount=(Float)request.getAttribute("bill_advanced");
        Float due_amount=(Float)request.getAttribute("bill_dueamount");
        
        //fetching list of order for specific customer
        GetOrder getorder=new GetOrder();
        ArrayList < Order > orderlist=(ArrayList)getorder.getOrdersForBillDetails(bill_no);
        String customer_name="";
        String customer_contact="";
        String customer_username="";
        for(Order order:orderlist){ 
          
        CustomerAllData customeralldata=new CustomerAllData();
        Customer customer=customeralldata.getAllDataOfCustomer(order.getCustomer_email());
         customer_name=customer.getCustomer_fullname();
         customer_contact=customer.getCustomer_contact();
         customer_username=customer.getCustomer_username(); 
        }
        float total_remaining=0f;
        if(!orderlist.isEmpty()){%> 
      <div id="maindiv1">
        
         
        <h2>New Nawalpur Shirting Suiting And Tailoring</h2>
        <h3>Kawasoti-8,Indrachwok</h3>
        <p id="rightparagraph">
            PAN NO.:600448019<br>
            Contact:9844710625<br>
            Date:<%=bill_date %>
        </p>
         <p id="leftparagraph">
             Bill NO: <%=bill_no %><br>
             Customer Name: <%=customer_name %><br>
             Contact: <%=customer_contact %><br>
             Username: <%=customer_username %><br>
        </p>
        
         <h4>
        
        <div >
 
            <table id="billtable">
                        
                            <tr>
                                <th>Order ID</th>
                                <th>Amount</th>
                                <th>Cloth</th>
                                <th>Discount</th>
                                <th>Actual Amount</th>
                                <th>Advanced</th>
                                <th>Due</th>
                            </tr>
                        
                       
                            <%for(Order order:orderlist){
                                total_remaining=total_remaining+order.getOrder_remainingamount();
                            %> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=order.getOrder_id() %></td> 
                                    <td><%=order.getOrder_amount() %></td>
                                     <td><%=order.getOrder_clothamount() %></td>
                                    <td><%=order.getOrder_discount() %></td>
                                    <td><%=order.getOrder_totalamount() %></td>
                                    <td><%=order.getOrder_advance() %></td>
                                    <td><%=order.getOrder_remainingamount() %> </td>
                                <%}%> 
                             
                                
                               
                                </tr>
                                <tr>
                                     <td>Total:</td>
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                     <td>Rs.<%=actual_amount %></td>
                                     <td>Rs.<%=advanced_amount %></td>
                                     <td style="color:red;">Rs.<%=total_remaining %></td>
                                </tr>
                    </table>
                    <p id="bottomleftparagraph">
                        Note:<br>
                        1.Customer should come within 3 month to bring their order <br>
                        after delivery date. Otherwise we will not be responsible.<br>
                        2.Bill is compulsory to get order Items.

                    </p>
                    <p id="bottomrightparagraph">
                        
                        _________________________ <br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Signature<br>
                    </p>
                   
                                
        <%}%> 
    
   <%if(orderlist.isEmpty()){%>
                <h1 style="color: red; text-align: center;"> Ooops!Billing Details is Not Available!!!</h1>
    <%}%>
    </div>
    </div>
   <%if(!orderlist.isEmpty()){%>
    <button onclick="window.print()" class="btn success"/>Print Details</button> 
    <button style="margin-left:10px;" onclick="history.back()" class="btn danger" >Close</button>    
   <%}
    else{
   %>
      <button style="margin-left:48%;" onclick="history.back()" class="btn danger" >Close</button>    
   <%}%>

    </body>
</html>
