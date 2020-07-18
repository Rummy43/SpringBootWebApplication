<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/submitUser" id="userForm" method="POST" modelAttribute="usersList">
		<span id="userMessage" class="text-info"></span>
		text: ${map.get('name')}
		<table id="userTable">
			<c:forEach items="${usersList.users}" var="user" varStatus="status">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>User Id</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
				<tr>
					<td><form:input readonly="true" path="users[${status.index}].firstName" value="${user.firstName}"/></td>
					<td><form:input path="users[${status.index}].lastName" value="${user.lastName}"/></td>
					<td><form:input readonly="true" path="users[${status.index}].id" value="${user.id}"/></td>
					<td><form:input readonly="true" path="users[${status.index}].address" value="${user.address}"/></td>
					<td><form:input readonly="true" path="users[${status.index}].phone" value="${user.phone}"/></td>
					<td><form:input readonly="true" path="users[${status.index}].email" value="${user.email}"/></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	
	<button class="btn btn-xs btn-primary" onclick="submitUser()">Submit</button>
	
</body>
</html>