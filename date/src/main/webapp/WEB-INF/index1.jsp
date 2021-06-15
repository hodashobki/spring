<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Time</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app1.js"></script>
</head>
<body>
<center>
<h1 style="color:green"><c:out value="${thetime}"/></h1>
</center>
</body>
</html>