<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron text-center">
		<h1>My First Bootstrap Page</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h3>Column 1</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Product page</h3>
				<form:form method="post" action="/btn" modelAttribute="product">
     	Id: <form:input path="id" type="number" class="form-control" />
     	Name: <form:input path="name" type="text" name="name"
						class="form-control" />
					<div>
						<form:errors style="color:red" path="name" />
					</div>
     	Price: <form:input path="price" type="number" name="price"
						class="form-control" />
					<div>
						<form:errors style="color:red" path="price" />
					</div>
					<br />
					<input type="submit" name="add" value="Add" class="btn btn-success" />
					<input type="submit" name="update" value="Update"
						class="btn btn-warning" />
					<input type="submit" name="delete" value="Delete"
						class="btn btn-danger" />

				</form:form>
			</div>
			<div class="col-sm-4">
				<h3>Column 3</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th></th>
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach var="p" items="${products }">
						<tr>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>${p.price }</td>
							<td><img src="data:image/jpg;base64,${p.pic1 }" width="80" />
							</td>
							<td><a href="/select?id=${p.id }">Select</a></td>
							<td>
								<a href="/showUpload?id=${p.id }">Upload Image</a>							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-2"></div>
	</div>
</body>
</html>