<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Ninja</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
    <form:select path="dojo">
	<c:forEach items="${dojos}" var="dojo" varStatus="loop">
		<option value="${dojo.getId()}">${dojo.getName()}</option>
	</c:forEach>
	</form:select>
    <form:label path="firstName">First Name
    <form:errors path="firstName"/>
    <form:input path="firstName"/></form:label>
    <form:label path="lastName">Last Name
    <form:errors path="lastName"/>
    <form:input path="lastName"/></form:label>
    <form:label path="age">Age
    <form:errors path="age"/>
    <form:input type="number" min="1" path="age"/></form:label>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>