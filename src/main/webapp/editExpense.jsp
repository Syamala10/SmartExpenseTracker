<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.expense.model.Expense"%>

<%
Expense expense=(Expense)request.getAttribute("expense");
%>


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

<title>Edit Expense</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#eef2f7;
}

.card{
width:550px;
margin:40px auto;
padding:30px;
border-radius:15px;
box-shadow:0px 0px 15px rgba(0,0,0,.2);
}

</style>

</head>

<body>

<div class="card">

<h2 class="text-center text-primary">

✏️ Update Expense

</h2>

<hr>

<form action="UpdateExpenseServlet" method="post">

<input type="hidden" name="id" value="<%=expense.getId()%>">

<div class="mb-3">

<label>Title</label>

<input type="text"
name="title"
class="form-control"
value="<%=expense.getTitle()%>"
required>

</div>

<div class="mb-3">

<label>Amount</label>

<input type="number"
step="0.01"
name="amount"
class="form-control"
value="<%=expense.getAmount()%>"
required>

</div>

<div class="mb-3">

<label>Category</label>

<input type="text"
name="category"
class="form-control"
value="<%=expense.getCategory()%>"
required>

</div>

<div class="mb-3">

<label>Date</label>

<input type="date"
name="expenseDate"
class="form-control"
value="<%=expense.getExpenseDate()%>"
required>

</div>

<button class="btn btn-success w-100">

Update Expense

</button>

</form>

<br>

<a href="ViewExpenseServlet"
class="btn btn-secondary w-100">

Back

</a>

</div>

</body>

</html>