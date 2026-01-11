<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
</head>
<body>

<h1>User Login</h1>

<form action="userLogin" method="get">
    <label>Email :</label>
    <input type="text" name="uemail" required><br><br>

    <label>Password :</label>
    <input type="password" name="upass" required><br><br>

    <input type="submit" value="Login"><br><br>

    <a href="userregister.jsp">Create New User</a>
</form>

</body>
</html>
