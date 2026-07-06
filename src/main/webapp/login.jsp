<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Expense Tracker</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f4f7fc;
}

.login-box{
    width:450px;
    margin:80px auto;
    padding:30px;
    background:white;
    border-radius:15px;
    box-shadow:0px 0px 15px rgba(0,0,0,.2);
}

</style>

</head>

<body>

<div class="login-box">

<h2 class="text-center text-primary">
💰 Smart Expense Tracker
</h2>

<hr>

<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

<div class="mb-3">

<label>Username</label>

<input
type="text"
name="username"
class="form-control"
required>

</div>

<div class="mb-3">

<label>Password</label>

<input
type="password"
name="password"
class="form-control"
required>

</div>

<div class="d-grid">

<button type="submit" class="btn btn-primary">
Login
</button>

</div>

</form>

</div>

</body>

</html>