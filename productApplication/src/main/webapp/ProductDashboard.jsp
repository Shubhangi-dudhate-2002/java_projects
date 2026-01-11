<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Product Application</h1>

<%  User user = (User) request.getAttribute("loggeduser"); %>

<span> Welcome<%= user.getName() %></span>
</body>
</html>