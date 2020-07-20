<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.msita.training.entity.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<html>
<head>
<title>Cart</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.css">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/carousel.css" rel="stylesheet">
<script src="js/home.js"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">Shop ABC</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>

	<main role="main"> 
		<div class="container">
			<div style="margin:10px 0;">
				<nav class="breadcrumb">
				  <a class="breadcrumb-item" href="index.html">Home</a>
				 <span class="breadcrumb-item active">Cart</span>
				</nav>
			</div>
        	<div class="row">
				<div class="col-sm-12 col-md-12 col-md-offset-1">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> Action</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="total" value="${0}"/>
							<c:forEach items="${lstProduct}" var="item">
								<tr>
									<td class="col-sm-8 col-md-6">
										<div class="media">
												<a class="thumbnail pull-left" href="#"style="padding-right: 15px;"> <img class="media-object" src="${item.image }" style="width: 72px; height: 72px;"> </a>
												<div class="media-body">
													<h4 class="media-heading"><a href="#">${item.name}</a></h4>
												
												</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1" style="text-align: center">
										<input type="quantity" class="form-control"  value="${item.quantity }">
									</td>
									<td class="col-sm-1 col-md-1 text-center"><strong>$${item.cost }</strong></td>
									<td class="col-sm-1 col-md-1">
									<button type="button" class="btn btn-danger">
										<span class="glyphicon glyphicon-remove"></span> Remove
									</button></td>
								</tr>
							</c:forEach>
							
								
							<tr>
								<td>   </td>
								<td>   </td>
								<td>   </td>
								<td>
								<button type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
								</button></td>
								<td>
								<button type="button" class="btn btn-success">
									Checkout <span class="glyphicon glyphicon-play"></span>
								</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
        </div>
	
	</main>
	
	<footer class="container">
		<p class="float-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			&copy; 2017-2018 Company, Inc. &middot; <a href="#">Privacy</a>
			&middot; <a href="#">Terms</a>
		</p>
	</footer> 
	<script src="bootstrap.min.js">  </script>
	<script src="productDetail.js">  </script>
</body>
</html>