<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<!-- <h1>Hello...home page!!</h1> -->
	<div class="d-grid gap-2 col-6 mx-auto" style="margin-top: 100px;">
		<a href="/add_customer" class="btn btn-outline-success"><i class="fas fa-plus-circle" style="font-size: 20px"></i> Add New Customer</a> 
		<a href="/getAllView" class="btn btn-outline-info" role="button"><i class="fas fa-eye" style="font-size: 20px"></i> See All Customer</a>
	</div>

</body>
</html>