<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="common.jsp"></jsp:include>
<!-- <title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->

</head>
<body>
	<!-- <h1>Hello...home page!!</h1> -->
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><i
				class="fa fa-regular fa-globe"></i> CRM</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
					<li><a href="/home" class="nav-link px-2 text-primary"><i
							class="fa fa-fw fa-home"></i>Home</a></li>
					</li>


					<li class="nav-item">
					<li><a href="/getAllView" class="nav-link px-2 text-white"><i
							class="fa fa-regular fa-user"></i> Customers</a></li>
					</li>


					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true"><i
							class="fab fa-product-hunt"></i> Products</a></li>
				</ul>
			<c:if test="${search eq true }">
				<form method="get" action="/searchView" class="d-flex" style="padding-left: 150px;">
					<input type="text" name="lastName" class="form-control me-2" type="search" placeholder="Search with last name.."
						aria-label="Search"/>
					<button type="submit" class="btn btn-outline-success">Search</button>
				</form>
			</c:if>
				<div class="text-end" style="padding-left: 100px;">
					<button type="button" class="btn btn-outline-light me-2">Login</button>
					<button type="button" class="btn btn-warning">Sign-up</button>
				</div>
			</div>
		</div>
	</nav>

	<!-- Background image -->
	<!-- <div class="bg-image">
		<img src="images/deer.jpg" class="img-fluid" alt="Deer">
	</div> -->
	<!-- <div class="d-grid gap-2 col-6 mx-auto" style="margin-top: 100px;">
		<a href="/add_customer" class="btn btn-outline-success"><i class="fas fa-plus-circle" style="font-size: 20px"></i> Add New Customer</a> 
		<a href="/getAllView" class="btn btn-outline-info" role="button"><i class="fas fa-eye" style="font-size: 20px"></i> See All Customer</a>
	</div> -->
	<!-- Background image -->
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
		integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
		crossorigin="anonymous"></script> -->


	<!-- Option 1: Bootstrap Bundle with Popper -->
	<!-- <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script> -->

</body>
</html>