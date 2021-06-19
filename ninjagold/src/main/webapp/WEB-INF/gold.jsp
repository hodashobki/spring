<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>your gold <c:out value="${counter}"/></h1>
    <main>
        <div>
            <h2>Farm</h2>
            <p>Earnes 10-20 gold</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="gold" value="farm">
                <input type="submit" value="Find Gold">

            </form>
        </div>
        <div><h2>Cave</h2>
            <p>Earnes 5-10gold</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="gold" value="cave">
                <input type="submit" value="Find Gold" >

            </form></div>
        <div><h2>House</h2>
            <p>Earnes 2-5 gold</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="gold" value="house">
                <input type="submit" value="Find Gold">

            </form></div>
        <div><h2>Casino</h2>
            <p>Earnes/Loses 0-50 gold</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="gold" value="casino">
                <input type="submit" value="Find Gold">

            </form>
        </div>
    </main>
    <center>
    <div>
        <form action="/reset" method="POST">
            <input type="submit" value="Play again">
        </form>
    </div>
    <h3>Activity</h3>
    <div>
    <c:forEach items="${activity}" var="activity">
    <c:if test = "${fn:contains(activity, 'earned')}">
                     <p id="green">${activity}</p>
                 </c:if>
                 <c:if test = "${fn:contains(activity,'lost')}">
                     <p id="red">${activity}</p>
                 </c:if>
    </c:forEach>
    </div>
    
    
    
</center>
    
</body>
</html>