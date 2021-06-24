<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Category</title>

</head>
<body>
	<h1>${category.name }</h1>
	
	
		<div>
		<h3>Products:</h3>
		<c:forEach items="${ category.products }" var="category">
  		<h6>- ${category.name}</h6>
		</c:forEach>
		
		
		
		<div>
		<form action="/categories/${category.id}" method="post">
			<select name="product">
			        <c:forEach items="${ products }" var="pro">

				<option value="${pro.id}">${pro.name}</option>
			        	
			</c:forEach>
		    </select>
		    <input type="submit" value="submit">
		</form>
		</div>
	</div>
  
  
 
</body>
</html>