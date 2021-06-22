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
<h1>hello</h1>
<c:forEach items="${lookify}" var="lookify">
<p><c:out value="${lookify.title} -${lookify.artist}"/> </p>
 </c:forEach>
</body>
</html>