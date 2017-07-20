<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1> Category: <c:out value="${cat.name}"/></h1>
<form:form method="POST" action="/categoryProduct/${cat.id}" modelAttribute="category">
    <form:select path="products">
	<c:forEach items="${allproducts}" var="product" varStatus="loop">
		<option value="${product.getId()}">${product.getName()}</option>
	</c:forEach>
	</form:select>
    <input type="submit" value="add"/>
</form:form>
</body>
</html>