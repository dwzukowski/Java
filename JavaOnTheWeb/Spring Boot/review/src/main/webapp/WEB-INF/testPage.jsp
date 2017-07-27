<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
</head>
<body>
        <h1>TestPage <c:out value="${currentUser.username}"></c:out></h1>
        <h3>Role: <c:out value="${currentUser.roles.get(0).name}"></c:out></h3>
<form:form method="POST" action="/test/test" modelAttribute="test">
    <form:label path="username">Name:
    <form:errors path="username"/>
    <form:input path="username"/></form:label>
    <form:label path="email">Email:
    <form:errors path="email"/>
    <form:input path="email"/></form:label>    
    <input type="submit" value="This is a Test"/>
</form:form>





<fmt:formatDate value="${currentUser.createdAt}" pattern = "MMM/dd/yyyy"/>
</body>
</html>