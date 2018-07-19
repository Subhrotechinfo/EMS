<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">


<head>
<title>Dashboard</title>
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
	<a class="navbar-brand" href="#"> <img
		src="<%-- ${pageContext.request.contextPath}/ --%>" alt="logo"
		width="40" height="40" class="rounded-circle">
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
	<div class="container col-sm-12 py-4"></div>

	<div class="container border border-success	px-5 py-5">
		<!-- Nav pills -->
		<div class="col-md-8">
			<ul class="nav nav-pills nav-tabs nav-justified">
				<li class="nav-item"><a class="nav-link active "
					data-toggle="pill" href="#empDetails">Employee Details</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/employee/showForm">New
						Employee </a></li>

			</ul>
		</div>


		<!-- Tab panes -->
		<div class="tab-content">
			<!-- Get Employees Pills -->
			<div id="empDetails" class="container tab-pane active">
				<br>

				<!-- Container for displaying the employees-->
				<h3 class="display-4">Basic Details Updation</h3>
				<!-- Emp table updater -->
				<div>
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Action</th>
								<th>Action</th>
								<th>Action</th>
								<th>Action</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="tempEmployee" items="${employees}">

									<!--  Create update link-->
									<c:url var="updateLink" value="/employee/showUpdateForm">
										<c:param name="employeeId" value="${tempEmployee.id}"></c:param>
									</c:url>

									<!--  Create delete link-->
									<c:url var="deleteLink" value="/employee/deleteEmployee">
										<c:param name="employeeDeleteId" value="${tempEmployee.id}"></c:param>
									</c:url>

									<!--  Create email link-->
									<c:url var="emailLink" value="/employee/email">
										<c:param name="employeeEmail" value="${tempEmployee.id}"></c:param>
									</c:url>

									<tr>
										<td>${tempEmployee.firstname}</td>
										<td>${tempEmployee.lastname}</td>
										<td>${tempEmployee.email}</td>
										<td><button type="button" class="btn btn-warning">
												<a href="${updateLink}"
													style="text-decoration: none; color: white;">Change</a>
											</button></td>
										<td><button type="button" class="btn btn-danger">
												<a href="${deleteLink}"
													onclick="if(!(confirm('Kindly Confirm to delete button'))) return false"
													style="text-decoration: none; color: white;">Delete</a>
											</button></td>
										<td><button type="button" class="btn btn-success">
												<a href="${emailLink}"
													style="text-decoration: none; color: white;">Email</a>
											</button></td>
										<td><button type="button" class="btn btn-light">
												<a
													href="${pageContext.request.contextPath}/view/pdf/${tempEmployee.id}"
													style="text-decoration: none; color: black;">PDF</a>
											</button></td>
										<td><button type="button" class="btn btn-info">
												<a
													href="${pageContext.request.contextPath}/view/excel/${tempEmployee.id}"
													style="text-decoration: none; color: white;">Excel-Attachment</a>
											</button></td>

									</tr>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- Tab Pill closing div -->

	</div>
	<!-- Div close for the nav pills -->


	<!-- footer section -->
	<!-- <div class="container col-sm-12   py-2" ></div> -->
	<div class=" container col-sm-10  bg-white text-center ">
		<!-- footer -->
		<footer>
		<p class="text-xs-center text-muted">Subhro Chatterjee &copy;
			Copyright 2018 - All rights reserved.</p>
		</footer>
	</div>

</body>
</html>

