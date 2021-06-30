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
		<h1>Here are some events in your State</h1>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${evIn }" var="v">
				<tr>
				   <td><a href="/events/${v.id}"> ${ v.name }</a>  </td>
                    <td><fm:formatDate value="${ v.date }" pattern="MMM dd,yyyy"/>
					<td>${ v.location}</td>
					<td>${v.host.fname}</td>
					<td>
					 <c:choose>
    <c:when test="${v.host.id==user.id}">
    <a href="/delete/${v.id}"> Delete</a>  |<a href="/events/${v.id}/edit"> Update</a>
    </c:when>

    <c:otherwise>
    <c:choose>
    <c:when test="${v.users.contains(user)}">
    
    Join :<a href="/unjoin/${v.id}">Join</a>
    </c:when>
    <c:otherwise>
     <a href="/join/${v.id}">Join</a>
    
     </c:otherwise> 
     </c:choose>
    
    </c:otherwise> 
    </c:choose>
					  
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*
	<div class="container">
	<h1>Here are some events in other States</h1>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ evn }" var="e">
				<tr>
				   <td><a href="/events/${e.id}"> ${ e.name }</a>  </td>
                    <td><fm:formatDate value="${ e.date }" pattern="MMM dd,yyyy"/>
					<td>${ e.location}</td>
					<td>${e.host.fname}</td>
					<td>
					 <c:choose>
    <c:when test="${e.host.id==user.id}">
    <a href="/delete/${e.id}"> Delete</a>  |<a href="/events/${e.id}/edit"> Update</a>
    </c:when>

    <c:otherwise>
    <c:choose>
    <c:when test="${e.users.contains(user)}">
    
    Join :<a href="/unjoin/${e.id}">Join</a>
    </c:when>
    <c:otherwise>
     <a href="/join/${e.id}">Join</a>
    
     </c:otherwise> 
     </c:choose>
    
    </c:otherwise> 
    </c:choose>
					  
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	+++++++++*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*+
	<hr>
	<div class="container">
			<form:form class="user-form" action="/events/new" method="post" modelAttribute="event">
			<form:hidden value = "${user.id} " path="host" />
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
			    
			    <button>Create your Event</button>
			</form:form>
		</div>
	
	
	</body>
</html>