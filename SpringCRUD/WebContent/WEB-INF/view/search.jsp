<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<body>
<table border="1px solid black">
<tr>
	<th>Id</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>Action</th>
</tr>

<c:forEach items="${searchlist}" var="i">
<tr>
	<td>${i.id}</td>
	<td>${i.firstname}</td>
	<td>${i.lastname}</td>
	<td colspan="2"><a href="delete.html?id=${i.id}">Delete</a>&nbsp;&nbsp;<a href="edit.html?id=${i.id}">Edit</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>