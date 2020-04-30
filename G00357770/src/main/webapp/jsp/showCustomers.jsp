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
	<h1>List of Customers</h1>
	<table>
		<c:forEach items="${customers}" var="customer">
			<th>
				<h2>${customer.cId}${customer.cName}</h2>
				<h2>${customer.cName}'sOrders</h2>
			</th>

			<tr>
				<th>Order Id</th>
				<th>Quantity</th>
				<th>Product Id</th>
				<th>Description</th>
			</tr>

			<c:forEach items="${customer.orders}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
	<a href="/addCustomer.html">Add Customer</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/logout">Logout</a>

</body>
</html>