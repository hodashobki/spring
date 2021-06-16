<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>hello</h1>

<c:out value="${error}"/>
<h2>What is the code ?</h2>
	<form action="/secret" method="POST">
		<p><input type="text" name="secretBox"></p>
		<input type="submit" value="Try Code">
	</form>
</body>
</html>