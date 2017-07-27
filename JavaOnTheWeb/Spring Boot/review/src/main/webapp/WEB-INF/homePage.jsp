<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
        <h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>
        <h3>Role: <c:out value="${currentUser.roles.get(0).name}"></c:out></h3>
        <h3>Id: <c:out value="${currentUser.id}"></c:out></h3>
        <h3>Rings: <c:out value="${currentUser.getRings().size()}"></c:out></h3>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>

	<a href="/admin/createRing">Ring Creator</a>
	
<h3>Pick Up a Ring</h3>
<form:form method="POST" action="/home/findRing" modelAttribute="ring">
    <form:select path="name">
	<c:forEach items="${Allrings}" var="ring" varStatus="loop">
		<option value="${ring.id}">${ring.name}</option>
	</c:forEach>
	</form:select>
    <input type="submit" value="Bind Yourself In Darkness"/>
</form:form>
<br>
<table style="width:25%">
<tr>
	<th>Rings You Have Found</th>
	<th>Action</th>
</tr>
	<c:forEach items="${currentUser.getRings()}" var="foundRing" varStatus="loop">
<tr>
	<td><c:out value="${foundRing.name}"></c:out></td>
	<td><a href="/loseRing/${foundRing.id}">Drop</a></td>
</tr>
	</c:forEach>
</table>



</body>
</html>