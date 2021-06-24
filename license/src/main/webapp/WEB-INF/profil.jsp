<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	
		<h1>${person.firstName } ${person.lastName }</h1>
		<h4>License Number: ${person.license.number}</h4>
		<h4>State: ${person.license.state}</h4>
		<h4>Expiration Date: ${person.license.expirationDate}</h4>
	
</body>
</html>