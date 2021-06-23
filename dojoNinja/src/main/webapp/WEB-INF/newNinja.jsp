<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New Contact</h1>

	<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
		<div>
			<form:select path="dojo">
				<c:forEach items="${stu}" var="p">
					<form:option value="${ p.id }">${ p.name } </form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:label path="fname">First Name</form:label>
			<form:errors path="fname" />
			<form:input path="fname" />
		</div>
		<div>
			<form:label path="lname">Last Name</form:label>
			<form:errors path="lname" />
			<form:input path="lname" />
		</div>
		<div>
			<form:label path="age">Age</form:label>
			<form:errors path="age" />
			<form:input path="age"  type="number"/>
		</div>
		<button>Add Ninja</button>
</form:form>
</body>
</html>