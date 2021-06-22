<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify Dashboard</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="/song/new">Add new</a>
    <a href="/search/topten">Top ten</a>
    <div class="search-container">
      <form action="/search">
        <input type="text" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i>Search</button>
      </form>
    </div>
  </div>
    

<table id="customers">
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lookify}" var="lookify">
        <tr>
        
            <td><a href="/song/${lookify.id}">${lookify.title}</a></td>
            <td><c:out value="${lookify.rating}"/></td>
            <td><a href="/delete/${lookify.id}">Delete</a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>