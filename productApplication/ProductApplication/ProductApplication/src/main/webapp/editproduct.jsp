<%@page import="com.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Product Details</h1>

<% Product product =(Product)request.getAttribute("existingproduct"); %>

<form action="editproduct">
<label>PId</label>
<input type="number" name="pid" value="<%= product.getPid()%>"><br><br>

<label>Pname</label>
<input type="text" name="pname" value="<%= product.getPname()%>"><br><br>

<label>PQty</label>
<input type="number" name="pqty" value="<%= product.getQty()%>"><br><br>

<label>Price</label>
<input type="text" name="price" value="<%= product.getPrice()%>"><br><br>

<input type="submit" value="Edit Product">
</form>

</body>
</html>