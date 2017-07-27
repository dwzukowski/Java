<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
    <form id="logoutForm" method="POST" action="/logout" style="float:right">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>


<h1>Customers</h1>
<table style="width:25%">
<tr>
	<th>Name</th>
	<th>Next Due Date</th>
	<th>Amount Due</th>
	<th>Package Type</th>
</tr>
	<c:forEach items="${allCustomers}" var="customer" varStatus="loop">
<tr>
	<td><a href="/admin/edit/${customer.id}"><c:out value="${customer.username}"></c:out></a></td>
	<td><c:out value="${customer.due}"></c:out></td>
	<td><c:out value="${customer.pack.price}"></c:out></td>
	<td><c:out value="${customer.pack.name}"></c:out></td>
</tr>
	</c:forEach>
</table>
<br>
<h1>Packages</h1>
<table style="width:32%">
<tr>
	<th>Package Name</th>
	<th>Package Price</th>
	<th>Available</th>
	<th>Number of Users</th>
	<th>Action</th>
</tr>
	<c:forEach items="${allPacks}" var="pack" varStatus="loop">
<tr>
	<td><c:out value="${pack.name}"></c:out></td>
	<td><c:out value="${pack.price}"></c:out></td>
	<td><c:out value="${pack.available}"></c:out></td>
	<td><c:out value="${pack.users.size()}"></c:out></td>
	<td><a href="/admin/activatePack/${pack.name}">Activate</a> | <a href="/admin/deactivatePack/${pack.name}">Deactivate</a> | <a href="/admin/destroyPack/${pack.name}">Delete</a></td>
</tr>
	</c:forEach>
</table>
<div style="border:1px solid black; width:200px">
<h3>Create a Package</h3>
<form:form method="POST" action="/admin/createPack" modelAttribute="pack">
    <form:label path="name">Name:
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    <form:label path="price">Name:
    <form:errors path="price"/>
    <form:input type="number" min="0.01" step="0.01" path="price"/></form:label>
    <input type="submit" value="Create new Package"/>
</form:form>
</div>
</body>
</html>