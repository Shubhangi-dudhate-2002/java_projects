<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New User Registration</h1>

<form action="newuserregister" method="post">
<label>Id</label>
<input type="number" name="uid"><br><br>

<label>Name</label>
<input type="text" name="uname"><br><br>

<label>Email</label>
<input type="text" name="uemail"><br><br>

<label>Address</label>
<input type="text" name="uaddre"><br><br>

<label>Password</label>
<input type="password" name="upass"><br><br>

<input type="submit" value="New User"> <br><br>

<a href="userlogin.jsp">Already have an account?</a>
</form>
</body>
</html>