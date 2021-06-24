<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>

<h1>New Product</h1>

	<form:form action="/products/new" method="POST" modelAttribute="product">
		<div>

			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input class="form-control" path="name" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:input class="form-control" path="description"/>
		</div>
		<div>
			<form:label path="price">Price</form:label>
			<form:errors path="price" />
			<form:input class="form-control" path="price"/>
		</div>
	
		<button>Add Product</button>

	</form:form>

</body>
</html>