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
<h1>Submitted Information</h1>
<h3>Name :<c:out value="${name}"/></h3>
<h3>Dojo Location : <c:out value="${location}"/> </h3>
<h3>Favorite Language :<c:out value="${lang}"/></h3>
<h3>Comment:<c:out value="${comment}"/></h3>

</body>
</html>