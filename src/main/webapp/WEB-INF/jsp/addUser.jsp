<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/addUser.js"></script>
	<form:form action="/addUser" id="addUserForm" method="POST"
		modelAttribute="user">
		<span id="addUserMessage" class="text-info"></span>
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" value="" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" value="" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" value="" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone" value="" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" value="" /></td>
			</tr>
		</table>
	</form:form>

	<button class="btn btn-xs btn-primary" onclick="addUser()">Submit</button>
</body>
</html>