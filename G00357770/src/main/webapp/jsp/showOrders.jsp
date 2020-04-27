<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>List of Orders</h1>
	<table>
		<tr>
			<th>Quantity</th>
			<th>Order Date</th>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Product Id</th>
			<th>Description</th>
		</tr>

		<c:forEach items="${orders}" var="order">
		<h2>${order.oId}</h2>
			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust}</td>
				<td>${order.prod}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>

</body>
</html>