<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Event Planner</title>
</head>
	<body>
	<h1>Welcome, <c:out value="${user.fname}" /></h1>
	<p><a href="/logout">Logout </a>|</p>
	<hr>
		<div class="container">
			<form:form class="user-form" action="/update/${event.id}" method="put" modelAttribute="event">
				<h2>Your Event</h2>
			 	<div class="form-group">
			        <form:label path="name"> Name</form:label>
			        <form:errors path="name"/>
			        <form:input class="form-control" path="name" />
			    </div>
			    <div class="form-group">
			        <form:label path="date">Date</form:label>
			        <form:errors path="date"/>
			        <form:input  type="date" class="form-control" path="date" />
			    </div>
			    <div class="form-group">
			        <form:label path="location">Location</form:label>
			        <form:errors path="location"/>
			        <form:input class="form-control" path="location" />
			    </div>
			    <div class="form-group">
			        <form:label path="state">State</form:label>
			        <form:errors path="state"/>
					<form:select path="state">
					
						<option value="Je">Je</option>
						<option value="He">He</option>
						<option value="Ra">Ra</option>
						

					</form:select>
			    </div>
			    
			    <button>Update your Event</button>
			</form:form>
		</div>
	</body>
</html>