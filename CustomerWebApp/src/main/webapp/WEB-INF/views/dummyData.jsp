<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello..Dummy Api Data!!</h1>
<div align="center">
    <h2>Dummy Data</h2>
    <!-- <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/new">New Customer</a></h3> -->
    <table border="1" cellpadding="5">
        <tr>
            <th>UserID</th>
            <th>ID</th>
            <th>Title</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${dummydata}" var="dummy">
        <tr>
            <td>${dummy.userId}</td>
            <td>${dummy.id}</td>
            <td>${dummy.title}</td>
            <td>${dummy.completed}</td>
            <%-- <td>
                <a href="/edit?id=${dummy.userId}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete?id=${dummy.userId}">Delete</a>
            </td> --%>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>