<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<!--  Make this page for blog posting-->
<title>User Main Controller</title>
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
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-white">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="#"> <img
			src="${pageContext.request.contextPath}/WEB-INF/images/brand.jpg"
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
	<div class="container col-sm-12 py-4"></div>



	<div class="container border border-info px-5 py-5 bg-light"">
		<h2>Hello home</h2>
		<h3>User Dashboard Home</h3>

		<a href="${pageContext.request.contextPath}/employee/list">Dashboard</a><br>
		<br>
		<a href="${pageContext.request.contextPath}/employee/showForm">Saved</a>
		<br>
		<a href="${pageContext.request.contextPath}/employee/update">Update</a>
		<br>
		<a href="${pageContext.request.contextPath}/employee/delete">Delete</a>
		<br>
		<a href="${pageContext.request.contextPath}/employee/allEmail">SendEmailToAll</a>

	</div>

</body>
</html>