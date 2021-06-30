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
	<p><a href="/logout">Logout </a>|</p>
	<h1><c:out value="${event.name}" /></h1>
	<p>Date : <fm:formatDate value="${ event.date }" pattern="MMM dd,yyyy"/></p>
	<p>Location: <c:out value="${event.location}-${event.state}" /></p>
	<p>People Attending: <c:out value="${event.users.size()}" /></p>
	<p>Host: <c:out value="${event.host.fname} ${event.host.lname}" /></p>
	<hr>
	<div class="container">
		<h3>People Attending</h3>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Location</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${event.users}" var="user">
				<tr>
					<td>${user.fname} ${user.lname}</td>
					<td>${ user.location}, ${ user.state}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
	<h1>Messages for the event</h1>
	<c:forEach items="${event.comments}" var="com">
	
	<p>${user.fname}-${com.message}</p>
	</c:forEach>
	</div>
	<hr>
	
		<div class="container">
			<form:form class="user-form" action="/events/${event.id}/createComment/new" method="post" modelAttribute="comment">
			
				<h2>Add Message</h2>
			 	<div class="form-group">
			        <form:label path="message">Add message</form:label>
			        <form:errors path="message"/>
			        <form:input class="form-control" path="message" />
			    </div>
			   
			    
			    <button>Your Message?</button>
			</form:form>
		</div>
	</body>
</html>