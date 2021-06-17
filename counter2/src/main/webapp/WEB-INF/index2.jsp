<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<h1>You have visited <a href="/">http://your_server</a><c:out value="${key}"/></h1>
<h3>Test another visit <a href="/">here</a></h3>
<h3>Test another visit <a href="/addtwo"> Visit Add Two Page</a></h3>

<h3>Destroy session <a href="/destroy"> destroy</a> </h3>

</body>
</html>