<%-- 
    Document   : order_searchedbill
    Created on : Mar 16, 2021, 8:30:52 PM
    Author     : dharm
--%>

<%@page import="Order.Model.Bill"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.AllBillsList"%>
<%@page import="User.Database.GetProfilePicture"%>
<%@page import="User.Model.User"%>
<%@page import="User.Database.UserAllData"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/order_searchedbillstyle.css" type="text/css">
        
    </head>
    <body>

    
    <div id="table">
            <h1>List of Searched Bills</h1>   
                    <hr>
                    <br>
                    <h4>Note:Click on View to see updated Due amount.</h4>
                    <br>
          <%
            String bill_no=request.getAttribute("search_data").toString();
              
            //fetching list of bills
            AllBillsList allbilllist=new AllBillsList();
            List < Bill > billlist=allbilllist.selectSearchedBills(bill_no);
            if(!billlist.isEmpty()){%> 
            <table id="t01">
                        
                            <tr>
                                <th>Bill ID</th>
                                <th>Bill No.</th>
                                <th>Date</th>
                                <th>Actual Amount</th>
                                <th>Advanced</th>
                                <th>Due Amount(At First)</th>
                                <th>Action</th>
                            </tr>
                        
                       
                            <%for(Bill bill:billlist){%> 
                            <%-- Arranging data in tabular form --%> 
                                <tr> 
                                    <td><%=bill.getBill_id() %></td> 
                                    <td><%=bill.getBill_no() %></td>
                                    <td><%=bill.getBill_date() %></td>
                                    <td><%=bill.getBill_actualamount() %></td>
                                    <td><%=bill.getBill_advanced() %></td>
                                    <td style="color:red;"><b><%=bill.getBill_dueamount() %></b></td>
            
                                    <td>
                                     <form action="<%= request.getContextPath()%>/order_billdetailsservlet" id="beforebilldetailsform" method="post">
                                        <input type="hidden" name="bill_id_id"value="<%=bill.getBill_id() %>" >
                                        <input type="hidden" name="bill_no_id" value="<%=bill.getBill_no() %>">
                                        <input type="hidden" name="bill_date_id" value="<%=bill.getBill_date() %>">
                                        
                                        <input type="hidden" name="bill_actualamount_id" value="<%=bill.getBill_actualamount() %>">
                                        <input type="hidden" name="bill_advanced_id" value="<%=bill.getBill_advanced() %>">
                                        <input type="hidden" name="bill_due_id" value="<%=bill.getBill_dueamount() %>">
                                        
                                        <button  type="submit" class="btn warning">View </button>
                                     </form>                                
                                    </td>
                                       
                                <%}%> 

                                </tr>
                    </table>                 
        <%}%> 
    
    <%if(billlist.isEmpty()){%>
        <h1 style="color: red;"> List is Not Available !!!</h1>
    <%}%>
    <button id="closebutton" onclick="location.href='order_allbills.jsp'" type="button">Close</button>
    </body>
</html>
