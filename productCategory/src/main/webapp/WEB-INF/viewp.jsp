<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Products</title>

</head>
<body>
	<h1>${product.name }</h1>
	
	
		<div>
		<h3>Categories:</h3>
		<c:forEach items="${ product.categories }" var="category">
  		<h6>- ${category.name}</h6>
		</c:forEach>
		</div>
		
		
		
		<form action="/products/${product.id}" method="post">
			<select name="category">
			        <c:forEach items="${ categories }" var="cate">

								<option value="${cate.id}">${cate.name}</option>
			        	
					</c:forEach>
		    </select>
		    <input type="submit" value="submit">
		</form>
		</div>
	</div>
  
  
 
</body>
</html>