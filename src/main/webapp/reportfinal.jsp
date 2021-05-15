<%-- 
    Document   : reportfinal
    Created on : Apr 25, 2021, 2:08:41 PM
    Author     : dharm
--%>


<%@page import="Order.Database.SalesCalculator"%>
<%@page import="Finance.Database.ExpenseCalculator"%>
<%@page import="Finance.Database.SalaryCalculator"%>
<%@page import="Finance.Database.GetExpenseFigure"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Order.Database.GetSalesFigure"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<jsp:include page="userandadminpagepeotection.jsp" />
<jsp:include page="logo.jsp" />

<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tailor Management System With Design Recommendation</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Scripts/pagerefresh.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/universalsidebarstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/userfinalreportstyle.css" type="text/css">
        <link rel="stylesheet" href="CSS/sidebarprofilestyle.css" type="text/css">
        
    </head>
    <body>

     <%
        //getting dates
        String start_date=request.getAttribute("start_date").toString();
        String end_date=request.getAttribute("end_date").toString();

        //get sales Figure
        GetSalesFigure getsalesfigure=new  GetSalesFigure();
        List<Map<Object, Object>> saleslist=getsalesfigure.getSalesFigure(start_date,end_date);

        //get Expense Figure
        GetExpenseFigure getexpensefigure=new GetExpenseFigure();
        List<Map<Object, Object>> expenselist=getexpensefigure.getExpenseFigure(start_date,end_date);
        
        //getting paid salary
        SalaryCalculator salarycalculator =new SalaryCalculator ();
        Float paidsalary=salarycalculator.sumTotalSalary(start_date, end_date);
        
       
        //get TotalExpense
        ExpenseCalculator expensecalculator=new ExpenseCalculator();
        Float totalexpense=expensecalculator.sumTotalExpense(start_date, end_date);
        
        //get Total Sales
        SalesCalculator salescalculator=new SalesCalculator();
        Float totalsales=salescalculator.sumTotalSales(start_date, end_date);
        
        
        //getting net profit
        Float profit= totalsales-(paidsalary+totalexpense);
        
        
        Gson gsonObj = new Gson();

        String dataPointssales = null;
        String dataPointsexpense = null;

        
        dataPointssales = gsonObj.toJson(saleslist);
        dataPointsexpense = gsonObj.toJson(expenselist);
        
     %>
     
     <h2>Report</h2>
     <h4>Analysis from <%=start_date %> to <%=end_date %>.</h4>

     <div class="row">
        <div class="column">
          <div class="card">
            <h2>Total Sales </h2>
            <h2 class="value">Rs.<%=totalsales %></h2>
            
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Total Expenses</h2>
            <h2 class="value">Rs.<%=totalexpense %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Total Paid Salary</h2>
            <h2 class="value">Rs.<%=paidsalary %></h2>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h2>Net Profit</h2>
            <h2 class="value">Rs.<%=profit %></h2>
          </div>
        </div>
     </div>
     
   
     <div id="chartContainersales"></div>
     <div id="chartContainerexpense"></div>
     <button id="closebutton" onclick="history.back()" type="button">Close</button>
     <script type="text/javascript">
        window.onload = function() { 
     
        <% if(dataPointssales != null) { %>
        var chartsales = new CanvasJS.Chart("chartContainersales", {
                animationEnabled: true,
                animationDuration: 5000,
                backgroundColor:"#f1f1f1",
                exportEnabled: true,
                theme: "light1",
                title: {
                        text: "Sales Figure",
                        fontColor: "green",
                        fontWeight: "bold",
                        fontFamily: "Geneva"
                },
                axisY:{
		title: "Amount",
		prefix: "Rs.",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
                    }
                },
                axisX:{
		title: "Date",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
                
               
                },
                data: [{
                        type: "line", //change type to bar, line, area, pie, etc
                        xValueType: "dateTime",
                        color: "green",
                        dataPoints: <%out.print(dataPointssales);%>
                }]
        });
        chartsales.render();
        <% } %> 

        <% if(dataPointsexpense != null) { %>
        var chartexpense = new CanvasJS.Chart("chartContainerexpense", {
                animationEnabled: true,
                animationDuration: 5000,
                backgroundColor:"#f1f1f1",
                exportEnabled: true,
                theme: "light1",
                title: {
                        text: "Expenses Figure",
                        fontColor: "red",
                        fontWeight: "bold",
                        fontFamily: "Geneva"
                },
                axisY:{
		title: "Amount",
		prefix: "Rs.",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
                    }
                
                },
                axisX:{
		title: "Date",
                crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
                
               
                },
                data: [{
                        type: "area", //change type to bar, line, area, pie, etc
                        xValueType: "dateTime",
                        color: "orange",
                        dataPoints: <%out.print(dataPointsexpense);%>
                }]
        });
        chartexpense.render();
        <% } %> 
        };
      </script>
     <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
</html>
