<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h1>Teams</h1>
			<p>Our Teams!</p>
		</div>
	</div>
	</section>

	<section class="container">
	<div class="row">
		<div>
			<a href=" <spring:url value="/" /> ">Go Home</a>
		</div>
	</div>
	</section>

	<section class="container">
	<h2>Teams</h2>
	<b>Team Name: </b>${team.teamName }<br/>
	<b>Universe Name: </b>${universe.locationName }
	</section>

</body>
</html>