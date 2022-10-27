<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <title>Products Data</title> -->
<!-- <link rel="shortcut icon" href="images/product.jpg"/> -->
<jsp:include page="header.jsp"/>
</head>
<body>
	<%-- <ul>
		<h5>${listOfCustomers}</h5>
	</ul> --%>
	<c:if test="${not empty listOfProducts}">
		<h4 style="margin-left: 490px; margin-top: 30px">List of
			Products</h4>
		<div class="container">
			<%-- <caption>List of Customers</caption> --%>
			<table class="table table-success table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Product Name</th>
						<th scope="col">Model</th>
						<th scope="col">Price</th>
						<th scope="col">Quantity</th>
						<th scope="col">category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prodValue" items="${listOfProducts}">
						<tr>
							<td>${prodValue.productId}</td>
							<td>${prodValue.productName}</td>
							<td>${prodValue.modelNo}</td>
							<td><i class="fas fa-rupee-sign text-dark" style="font-size: 15px"></i> ${prodValue.price}</td>
							<td>${prodValue.quantity}</td>
							<%-- <c:forEach var="prodValue" items="${listValue.productDetails}">
								<c:set var="prods" scope="session" value="${prodValue.modelNo}" />
							</c:forEach> --%>
							<td>${prodValue.category}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>