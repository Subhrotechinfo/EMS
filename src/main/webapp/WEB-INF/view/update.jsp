<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<title>Update</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<style>
</style>
</head>


<body>
	<nav class="navbar navbar-expand-sm bg-white"> <!-- Brand/logo -->
	<a class="navbar-brand" href="#"> <img src="images/brand.jpg"
		alt="logo" width="40" height="40" class="rounded-circle">
	</a>

	<ul class="navbar-nav justify-content-end"
		style="padding-left: 1110px;">
		<li class="nav-item">
			<!-- <a class="nav-link" href="#" style="color: #009900;">Sign Out</a> -->
			<!--  Logout Button --> <form:form
				action="${pageContext.request.contextPath}/logout" method="POST">
				<button type="submit" class="button btn btn-dark">Logout</button>
			</form:form>
		</li>
	</ul>
	</nav>

	<div class="container border border-success	px-5 py-5 bg-light">
		<h3>Updated Data</h3>
		<form:form action="saveEmployee" modelAttribute="updatecustomer"
			method="POST">
			<!--  Associate the date with customer id-->
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastname" /></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><button type="submit" class="button btn btn-dark">Update</button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>

</body>

</html>