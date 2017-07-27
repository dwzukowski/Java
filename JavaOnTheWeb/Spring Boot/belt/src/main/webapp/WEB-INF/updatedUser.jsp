<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>

<h3>Edit User</h3>
<form:form method="POST" action="/admin/edit/${user.id}" modelAttribute="user">
    <form:label path="username">Name:
    <form:errors path="username"/>
    <form:input path="username"/></form:label>
	<form:label path="due">Due Date:
    <form:input  type="number" min="1" max="31" step="1" path="due"/></form:label>
   	<form:label path="pack">Package:</form:label>
    <form:select path="pack">
	<c:forEach items="${availablePacks}" var="packs" varStatus="loop">
		<option value="${packs.id}">${packs.name} (${packs.price})</option>
	</c:forEach>
	</form:select>
    <input type="submit" value="Save Changes"/>
</form:form>
<a href="/admin">Back</a>



</body>
</html>