<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" type="text/css" href="/views/mystyle.css">
</head>
<body>
	<h2>User List</h2>
	
	<c:if test="${not empty users}">

		<ul>
			<c:forEach var="user" items="${users}">
				<li>${user.fName} ${user.lName}  - ${user.username} - ${user.age} years old - email: ${user.email} - <a href="/CrudMadness/deleteUser.html?id=${user.id}">Delete</a> || <a href="/CrudMadness/editUser.html?id=${user.id}">Edit</a> </li>
			</c:forEach>
		</ul>

	</c:if>
	
	<a href="/CrudMadness">Home</a> || <a href="/CrudMadness/addUser.html">Add a User</a>
</body>
</html>