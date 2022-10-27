<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%-- <%@page import="java.util.Arrays"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%-- <%@ include file="home.jsp" %> --%>
<%@ page errorPage="customer_error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="images/customers.jpg"/>
<jsp:include page="header.jsp" />
</head>
<body>
	<%-- <ul>
		<h5>${listOfCustomers}</h5>
	</ul> --%>
	<%-- <h3>${param.message}</h3> --%>
	<c:if test="${empty customers }">
	<div class="container" style="margin-top: 20px;">
		<div class="alert alert-warning alert-dismissible fade show text-center"
			role="alert" style="border: 1px solid;">
			<i class="fas fa-exclamation-triangle"></i><strong> Failure!!</strong> NOT FOUND!!
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	</c:if>
	<c:if test="${not empty customers}">
		<h4 style="margin-left: 490px; margin-top: 30px">List of
			Customers</h4>
		<div class="container">
			<%-- <caption>List of Customers</caption> --%>
			<table class="table table-hover table-bordered text-center" style="background-color: #D6EEEE;">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Phone no.</th>
						<th scope="col">Email</th>
						<th scope="col">Product</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listValue" items="${customers}">
						<tr>
							<td>${listValue.customerId}</td>
							<td>${listValue.firstName}</td>
							<td>${listValue.lastName}</td>
							<td>${listValue.phoneNo}</td>
							<td>${listValue.email}</td>
							<%-- <c:forEach var="prodValue" items="${listValue.productDetails}">
								<c:set var="prods" scope="session" value="${prodValue.modelNo}" />
							</c:forEach> --%>
							<td><a href="/searchView/customer/${listValue.customerId}"><i
									class="fas fa-solid fa-eye text-success"
									style="font-size: 25px"></i></a></td>
							<td><a
								href="/delete/customer/${listValue.customerId}"><i
									class="fas fa-solid fa-trash text-danger"
									style="font-size: 25px"></i></a> &nbsp;&nbsp;&nbsp; <a
								href="/edit_customer/${listValue.customerId}"><i
									class="fas fa-edit text-dark" style="font-size: 25px"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>