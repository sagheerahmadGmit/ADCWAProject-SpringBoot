<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>Products</h1>
	<table>
		<tr>
			<th>Product Id</th>
			<th>Description</th>
			<th>Stock in Quantity</th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.pId}</td>
				<td>${product.pDesc}</td>
				<td>${product.qtyInStock}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>

</body>
</html>