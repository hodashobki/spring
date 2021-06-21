<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css" />
<title>Languages App</title>
</head>
<body>
	<div class="container">
		<h1>Edit Language</h1>
		<form action="/language/edit/${ language.id}" method="post"
			modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<label>Language Name</label>
				<input class="form-control" name="name"/>
			</div>
			<div class="form-group">
				<label>Creator</label>
				<input class="form-control" name="creator" />
			</div>
			<div class="form-group">
				<label>Current Version</label>
				<input class="form-control" name="version"/>
			</div>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>