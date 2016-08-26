<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hero</title>
</head>
<body>

	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Hero</h1>
			<p>All the Heroes in our Universe!</p>
		</div>
	</div>
	</section>

	<section class="container">
	<div class="row">
		<div>
			<a href=" <spring:url value="/" /> ">Go Home</a>
		</div>
		<div>
			<a href=" <spring:url value="/addnewhero" /> ">A a Hero</a>
		</div>
	</div>
	</section>

	<section class="container">
	<h2>Heroes</h2>
	<div class="row">
		<c:forEach items="${heroesList}" var="hero">
			<div class="col-am-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Hero #: ${ hero.heroId }</h3>
						<p>First Name: ${ hero.firstName }</p>
						<p>Last Name: ${ hero.lastName }</p>
						<p>Alias: ${ hero.alias }
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</section>

</body>
</html>