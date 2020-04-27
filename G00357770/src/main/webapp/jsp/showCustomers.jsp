<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
	<h1>Customers</h1>

	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId} ${customer.cName}</h2>
	</c:forEach>

	<br>
	<a href="/index.html">Home</a>

</body>
</html>