<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">

<title>Languages App</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<div class="container">
		<h1>Welcome to Languages Dot Com!</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ languages }" var="lang">
				<tr>
					<td><a href="/language/${lang.id }">${ lang.name }</a></td>
					<td>${ lang.creator }</td>
					<td>${ lang.version }</td>
					<td>
						<a class="btn btn-primary" href="/language/edit/${lang.id}">Edit</a>
						<form id="delete-form" action="/language/${lang.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="btn btn-danger" type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="container">
		<h1>New Language</h1>
		<form action="/languages" method="post" modelAttribute="language">
		    <div class="form-group">
		        <form:label path="name">Language Name</form:label>
		        <form:errors path="name"/>
		        <input class="form-control" name="name" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <input class="form-control" name="creator" path="creator"/>
		    </div>
			<div class="form-group">
		        <form:label path="version">Current Version</form:label>
		        <form:errors path="Version"/>
		        <input class="form-control" name="version" path="version"/>
		    </div>
		    <input type="submit" value="Submit"/>
		</form>
	</div> 
	</div>
</body>
</html>