<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All songs</h2>
<h3>Title : <c:out value="${lookify.title}"/> </h3>
<h3> Artist : <c:out value="${lookify.artist}"/> </h3>
<h3>Rating (1-10) :  <c:out value="${lookify.rating}"/> </h3>
</body>
</html>