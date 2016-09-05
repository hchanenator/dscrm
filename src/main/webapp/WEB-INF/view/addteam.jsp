<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<p>Add a Hero</p>
		</div>
	</div>
	</section>

	<section class="container">
	<h2>Heroes</h2>
	<div class="jumbotron">
		<form:form modelAttribute="newHero" class="form-horizontal">
			<fieldset>
				<legend>Add a new Hero!</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName">First
						Name: </label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="firstName" path="firstName" type="text"
								class="form:input-large" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="lastName">Last
						Name: </label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="lastName" path="lastName" type="text"
								class="form:input-large" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="alterEgo">Alias:
					</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="alterEgo" path="alias" type="text"
								class="form:input-large" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add">
					</div>
				</div>

			</fieldset>
		</form:form>
	</div>
	</section>

</body>
</html>