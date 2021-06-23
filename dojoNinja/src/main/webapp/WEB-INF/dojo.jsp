<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Dojo</title>
</head>
<body>

<h1>New Dojo</h1>

	<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
		<div>

			<form:label path="name">Dojo Name</form:label>
			<form:errors path="name" />
			<form:input class="form-control" path="name" />
		</div>
		
		<button>Add Dojo</button>

	</form:form>

</body>
</html>