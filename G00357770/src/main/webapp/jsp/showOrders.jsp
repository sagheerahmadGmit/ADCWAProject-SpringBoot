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
		<c:forEach items="${orders}" var="order">
			<th>
				<h2>${order.oId}</h2>
			</th>

			<tr>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Product Id</th>
				<th>Description</th>
			</tr>
			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
	<a href="/addOrder.html">Add Order</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showCustomers.html">List Customers</a>
	<a href="/logout">Logout</a>

</body>
</html>