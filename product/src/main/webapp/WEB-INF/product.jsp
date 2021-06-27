<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
		<h1>Add Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="product">
			 <div class="form-group">
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input  class="form-control" path="name"/>
		    </div>
		     <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:input  class="form-control" path="description"/>
		    </div>
		    <div class="form-group">
		        <form:label path="price">Price</form:label>
		        <form:errors path="price"/>
		        <form:input  class="form-control" path="price"/>
		    </div>
		    <button>Submit</button>
		</form:form>
	</div>
</body>
</html>