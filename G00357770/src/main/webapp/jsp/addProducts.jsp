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
	<form:form modelAttribute="product">
		<h1>Add New Product</h1>
		<table>
			<tr>
				<td>Product Description:</td>
				<!-- the path has to be the same name as in the model -->
				<td><form:input path="pDesc"></form:input></td>
				<td><form:errors path="pDesc"></form:errors></td>
			</tr>
			<tr>
				<td>Quantity in Stock:</td>
				<td><form:input path="qtyInStock"></form:input></td>
				<td><form:errors path="qtyInStock"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
	<a href="/showProducts.html">List Products</a>

</body>
</html>