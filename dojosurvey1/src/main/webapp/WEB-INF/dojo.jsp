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
<h1>gggg</h1>

<form action="/process" method="POST">
    <p>Your Name: <input type="text" name="name" required> </p>
    <p>Dojo location: <select name="location" required>
    <option value="Jerusalem">Jerusalem</option>
    <option value="Hebron">Hebron</option>
    <option value="Ramallah">Ramallah</option>
   </select></p>
   <p>Favourite Language:<select name="lang" required>
    <option value="Python">Python</option>
    <option value="Java">Java</option>
    <option value="PHP">PHP</option>
  </select></p>
  <p>Comment (optional)</p> <p><textarea name="comment" id="" cols="30" rows="10"></textarea> </p>

<input type="submit" value="Try Code">

</form>
</body>
</html>