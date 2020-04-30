<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>

	<!-- This is where the model-attribute is used from the controller -->
	<form:form modelAttribute="customer">
		<h1>Add New Customer</h1>
		<table>
			<tr>
				<td>Customer Name:</td>
				<!-- the path has to be the same name as in the model -->
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showOrders.html">List Orders</a>

</body>
</html>