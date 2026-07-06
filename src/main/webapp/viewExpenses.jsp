<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.expense.model.Expense"%>


<%
if(session.getAttribute("username")==null){

response.sendRedirect("login.jsp");

return;

}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>View Expenses</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<h2 class="text-center text-primary">

All Expenses

</h2>

<table class="table table-bordered table-hover">

<thead class="table-dark">

<tr>

<th>ID</th>
<th>Title</th>
<th>Amount</th>
<th>Category</th>
<th>Date</th>
<th>Edit</th>
<th>Delete</th>

</tr>

</thead>

<tbody>

<%

List<Expense> expenseList=(List<Expense>)request.getAttribute("expenseList");

if(expenseList!=null){

for(Expense expense:expenseList){

%>

<tr>

<td><%=expense.getId()%></td>

<td><%=expense.getTitle()%></td>

<td>₹ <%=expense.getAmount()%></td>

<td><%=expense.getCategory()%></td>

<td><%=expense.getExpenseDate()%></td>

<td>

<a href="EditExpenseServlet?id=<%=expense.getId()%>"
class="btn btn-warning btn-sm">

Edit

</a>

</td>

<td>

<a href="DeleteExpenseServlet?id=<%=expense.getId()%>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this expense?');">

Delete

</a>

</td>

</tr>

<%

}

}

%>

</tbody>

</table>

<a href="dashboard.jsp"
class="btn btn-primary">

Back to Dashboard

</a>

</div>

</body>

</html>