<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to User Login</h1>

<form action="userlogin" method="get">
<label>Email</label>
<input type="text" name="uemail"><br><br>

<label>Password</label>
<input type="password" name="upass"><br><br>

<input type="submit" value="Login"> <br><br>

<a href="userregister.jsp">Create New User</a>

</form>
</body>
</html>