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
<link rel="stylesheet" href="/css/main.css" />
<title>Languages App</title>
</head>
<body>
	<div class="container">
		<h1>New License</h1>
		<form action="/licenses/ne" method="post" modelAttribute="new">
		<div class="form-group">
			<select name="person">
			        <c:forEach items="${ persons }" var="pers">
						<option value="${pers.id}">${pers.firstName} ${pers.lastName}</option>
					</c:forEach>
		    </select>
		    </div>
		    <div class="form-group">
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <input class="form-control" name="state" path="state"/>
		    </div>
		    <div class="form-group">
		        <form:label path="exdate	">Expiration Date:</form:label>
		        <form:errors path="exdate"/>
		        <input class="form-control" type="date" name="expirationDate" path="exdate"/>
		    </div>
		    <input type="submit" value="Create"/>
		</form>
	</div>
</body>
</html>