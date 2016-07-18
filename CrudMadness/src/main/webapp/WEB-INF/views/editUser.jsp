<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="/CrudMadness/views/mystyle.css">
</head>
<body>
<a href="/CrudMadness">Home</a> || <a href = "/CrudMadness/displayAll.html">Back</a>
<h2>Edit User</h2>
<form:form commandName="user" name="user">
		<form:errors path="*" cssClass="errorblock" element="div" />
		
		
		<label for="textinput1"><spring:message code="user.fName" />
		</label>
		<form:input path="fName" cssErrorClass="error" />
		<form:errors path="fName" cssClass="error" />
		<br />
		<label for="textinput2"><spring:message code="user.lName" />
		</label>
		<form:input path="lName" cssErrorClass="error" />
		<form:errors path="lName" cssClass="error" />
		<br />
		<label for="textinput3"><spring:message code="user.username" />
		</label>
		<form:input path="username" cssErrorClass="error" />
		<form:errors path="username" cssClass="error" />
		<br />
		<label for="textinput4"><spring:message code="user.gender" />
		</label>
		<form:radiobutton path="gender" value = "male" label = "male" cssErrorClass="error" checked="checked" />
		<form:radiobutton path="gender" value = "female" label = "female" cssErrorClass="error" />
		<form:errors path="gender" cssClass="error" />
		<br />
		<label for="textinput5"><spring:message code="user.age" /> </label>
		<form:input path="age" cssErrorClass="error" />
		<form:errors path="age" cssClass="error" />
		<br />
		<label for="textinput6"><spring:message code="user.email" />
		</label>
		<form:input path="email" cssErrorClass="error" />
		<form:errors path="email" cssClass="error" />
		<br />
		
		<input type="submit" class="btn" value="Enter User" />
	</form:form>
</body>
</html>