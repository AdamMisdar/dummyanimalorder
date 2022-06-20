<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Animal Orders</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Animal Orders Section </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Animal Order List</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Animal Orders</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Animal Order</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Animal Type</th>
						<th>Animal Price</th>
						<th>Dependent Name</th>
						<th>Supplier Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="animalOrder" items="${listAnimalOrder}">
					

						<tr>
							<td><c:out value="${animalOrder.animalOrderID}" /></td>
							<td><c:out value="${animalOrder.animalOrderType}" /></td>
							<td><c:out value="${animalOrder.animalOrderPrice}" /></td>
							<td><c:out value="${animalOrder.dependentName}" /></td>
							<td>
							<c:if test="${animalOrder.supplierName == null}">
								<c:out value="No Supplier" />
							</c:if>	
							<c:if test="${animalOrder.supplierName != null}">
								<c:out value="${animalOrder.supplierName}" />
							</c:if></td>		

							<td><a href="edit?animalOrderID=<c:out value='${animalOrder.animalOrderID}' />">Add/Edit Supplier</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?animalOrderID=<c:out value='${animalOrder.animalOrderID}' />">Delete this part</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>