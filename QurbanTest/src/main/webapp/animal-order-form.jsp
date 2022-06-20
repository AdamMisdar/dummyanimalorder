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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${animalOrder != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${animalOrder == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${animalOrder != null}">
            			Edit Animal Order
            		</c:if>
						<c:if test="${animalOrder == null}">
            			Add New Animal Order
            		</c:if>
					</h2>
				</caption>

				<c:if test="${animalOrder != null}">
					<input type="hidden" name="animalOrderID" value="<c:out value='${animalOrder.animalOrderID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Animal Type</label> <input type="text"
						value="<c:out value='${animalOrder.animalOrderType}' />" class="form-control"
						name="animalOrderType">
				</fieldset>

				<fieldset class="form-group">
					<label>Animal Price</label> <input type="number"
						value="<c:out value='${animalOrder.animalOrderPrice}' />" class="form-control"
						name="animalOrderPrice">
				</fieldset>

				<fieldset class="form-group">
					<label>Dependent Name</label> <input type="text"
						value="<c:out value='${animalOrder.dependentName}' />" class="form-control"
						name="dependentName">
				</fieldset>
				<fieldset class="form-group">
					<label>Supplier Name</label> <input type="text"
						value="<c:out value='${animalOrder.supplierName}' />" class="form-control"
						name="supplierName">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>