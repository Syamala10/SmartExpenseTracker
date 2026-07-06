<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


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

<title>Add Expense</title>

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
➕ Add Expense
</h2>

<hr>

<form action="${pageContext.request.contextPath}/AddExpenseServlet" method="post">

<div class="mb-3">
<label>Expense Title</label>
<input type="text" name="title" class="form-control" required>
</div>

<div class="mb-3">
<label>Amount</label>
<input type="number" step="0.01" name="amount" class="form-control" required>
</div>

<div class="mb-3">
<label>Category</label>
<select name="category" class="form-control">
    <option>Food</option>
    <option>Travel</option>
    <option>Shopping</option>
    <option>Bills</option>
    <option>Health</option>
    <option>Others</option>
</select>
</div>

<div class="mb-3">
<label>Expense Date</label>
<input type="date" name="expenseDate" class="form-control" required>
</div>

<button class="btn btn-success w-100">
Save Expense
</button>

</form>

<br>

<a href="dashboard.jsp" class="btn btn-secondary w-100">
Back to Dashboard
</a>

</div>

</body>
</html>