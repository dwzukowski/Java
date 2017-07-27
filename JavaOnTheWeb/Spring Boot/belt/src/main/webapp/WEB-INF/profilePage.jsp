<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
    <form id="logoutForm" method="POST" action="/logout" style="float:right">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	<h1>User Profile for <c:out value="${currentUser.username}"></c:out></h1>
	<ul>
	<li>Current Package: <c:out value="${currentUser.pack.name}"></c:out></li>
	<li>Next Due Date:</li>
	<li>Amount Due: <c:out value="${currentUser.pack.price}"></c:out></li>
	<li>User Since: <fmt:formatDate value="${currentUser.createdAt}" pattern = "MMMM dd, yyyy"/></li>
	</ul>
</body>
</html>