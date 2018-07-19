<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">


<head>
<title>Confirm Page</title>
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
	<h2>Employee Deleted</h2>

	<br>
	<a href="${pageContext.request.contextPath}/employee/list">Dashboard</a>

</body>
</html>





