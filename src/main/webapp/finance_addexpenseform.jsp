<%-- 
    Document   : finance_addexpenseform
    Created on : Feb 24, 2021, 2:07:21 PM
    Author     : dharm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="logo.jsp" /> 
<jsp:include page="userpageprotection.jsp" />  
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="CSS/finance_addexpensestyle.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/buttonscontrol.js"></script> 
        <title>Tailor Management System With Design Recommendation</title>
    </head>
    
        <h2>Add Expense Here!</h2>
        <form action="<%= request.getContextPath()%>/finance_addexpenseservlet" class="was-validated" id="expenseaddform" method="post">
                <div class="container">
                 
                    <label><b>Title:</b></label>
                    <input type="text" class="form-control"  placeholder="Enter expense title" name="expense_title_id" required  maxlength="50">
                  
                    <label><b>Amount:</b></label>
                    <input type="number" class="form-control" placeholder="Enter expense amount" name="expense_amount_id" required min="0">

                    <label><b>Description:</b></label>
                    <textarea class="form-control" placeholder="Enter description"  name="expense_description_id" required maxlength="500"></textarea>
                    <br>
                    
                  <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember" required> I agree on<a href="agreement.jsp">Terms & Conditions.</a> 
                    </label>
                  </div>
                    <input type="submit" id="addexpense" value="Add"></input>
              </form>
</html>
