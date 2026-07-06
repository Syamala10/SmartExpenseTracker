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

<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{

background:#eef2f7;

font-family:Arial;

}

.dashboard{

width:700px;

margin:50px auto;

background:white;

padding:35px;

border-radius:15px;

box-shadow:0px 0px 15px rgba(0,0,0,.2);

}

.btn{

padding:12px;

font-size:18px;

}

</style>

</head>

<body>

<div class="dashboard">

<h2 class="text-center text-primary">

💰 Smart Expense Tracker

</h2>

<hr>

<h5 class="text-center">

Welcome,

<%=session.getAttribute("username")%>

</h5>

<br>

<div class="d-grid gap-3">

<a href="addExpense.jsp"

class="btn btn-primary">

➕ Add Expense

</a>

<a href="ViewExpenseServlet"

class="btn btn-success">

📋 View Expenses

</a>

<a href="LogoutServlet"

class="btn btn-danger">

🚪 Logout

</a>

</div>

</div>

</body>

</html>