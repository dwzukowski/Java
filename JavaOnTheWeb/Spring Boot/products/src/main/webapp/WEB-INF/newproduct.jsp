<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" action="/products/new" modelAttribute="product">
    <form:label path="name">Product Name:
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    <form:label path="description">Description:
    <form:errors path="description"/>
    <form:input type="textfield" path="description"/></form:label>
    <form:label path="price">Price:
    <form:errors path="price"/>
    <form:input type="number" min="0.01" step="0.01" path="price"/></form:label>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>