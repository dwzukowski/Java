<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Show Dojo</title>
</head>
<body>

<table style="width:30%">
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Age</th>
</tr>

<c:forEach items="${ninjas}" var="ninja" varStatus="loop">
<tr>
	<th><c:out value="${ninja.firstName}"/></th>
	<th><c:out value="${ninja.lastName}"/></th>
	<th><c:out value="${ninja.age}"/></th>
</tr>
</c:forEach>
</table>


</body>
</html>