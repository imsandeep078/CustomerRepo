<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Details</title>
<link rel="shortcut icon" href="images/edit.jpg"/>
<jsp:include page="header.jsp"/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
</head>
<body>
<h4 style="margin-left: 490px; margin-top: 30px">Edit
			Customer Details</h4>

<div class="container">
       <table class="table table-striped">
          <tbody>
             <tr>
                <td colspan="1">
                <form:form action="/save" method="post" class="well form-horizontal" modelAttribute="customer">
                      <fieldset>
                      <div class="form-group" style="display:none">
                            <form:label path="customerId" class="col-md-4 control-label">Customer Id</form:label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="far fa-id-badge"></i></span>
                               <form:input path="customerId" placeholder="Id" class="form-control" required="true" type="text"/></div>
                            </div>
                         </div>
                         <div class="form-group">
                            <form:label path="firstName" class="col-md-4 control-label">First Name</form:label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                               <form:input path="firstName" placeholder="First Name" class="form-control" required="true" type="text"/></div>
                            	<p><form:errors path="firstName" cssStyle="color: #ff0000;"/></p>
                            </div>
                         </div>
                         <div class="form-group">
                            <form:label path="lastName" class="col-md-4 control-label">Last Name</form:label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                               <form:input path="lastName" placeholder="Last Name" class="form-control" required="true" type="text"/></div>
                            	<p><form:errors path="lastName" cssStyle="color: #ff0000;"/></p>
                            </div>
                         </div>
                         <div class="form-group">
                            <form:label path="email" class="col-md-4 control-label">Email</form:label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                               <form:input path="email" placeholder="Email" class="form-control" required="true" type="email"/></div>
							   <p><form:errors path="email" cssStyle="color: #ff0000;"/></p>
                            </div>
                         </div>
                         <div class="form-group">
                            <form:label path="phoneNo" class="col-md-4 control-label">Phone Number</form:label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
                               <form:input path="phoneNo" placeholder="Phone Number" class="form-control" required="true" type="number"/></div>
                            	<p><form:errors path="phoneNo" cssStyle="color: #ff0000;"/></p>
                            </div>
                         </div>
                      </fieldset>
                      <div class="form-group text-centre" style="margin-left: 490px">
                           <div class="col-md-8 inputGroupContainer">
                             <form:button type="submit" class="btn btn-success btn-lg mb-1">Update</form:button>
                             <a class="btn btn-dark btn-lg mb-1" href="/getAllView" role="button">Cancel</a>
                           </div>
                      </div>
                  </form:form>
                </td>
             </tr>
          </tbody>
       </table>
    </div>

</body>
</html>