<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            
        </tr>
    </thead>
    <tbody>
    
        <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
            <td><c:out value="${ninja.fname}"/></td>
            <td><c:out value="${ninja.lname}"/></td>
            <td><c:out value="${ninja.age}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>