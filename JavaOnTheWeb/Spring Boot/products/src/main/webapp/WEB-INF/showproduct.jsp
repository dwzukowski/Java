<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Given Product, select from list of categories</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1> Product: <c:out value="${product.name}"/></h1>
<form:form method="POST" action="/ProductCategory/${product.id}" modelAttribute="product">
    <form:select path="categories">
	<c:forEach items="${allcategories}" var="category" varStatus="loop">
		<option value="${category.getId()}">${category.getName()}</option>
	</c:forEach>
	</form:select>
    <input type="submit" value="add"/>
</form:form>
</body>
</html>