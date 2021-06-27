<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Category</title>

</head>
<body>
	<h1>${category.name }</h1>
	
	<hr>
		<div>
		<h3>Products:</h3>
		<c:forEach items="${category.products }" var="pro">
  		<h6>- ${pro.name}</h5>
		</c:forEach>
		</div>
		<hr>
		
		
		
		<form action="/category/${category.id}" method="post">
			<select name="product">
			        <c:forEach items="${product}" var="pr">

								<option value="${pr.id}">${pr.name}</option>
			        	
					</c:forEach>
		    </select>
		    <input type="submit" value="submit">
		</form>
		</div>
	</div>
  
  
 
</body>
</html>