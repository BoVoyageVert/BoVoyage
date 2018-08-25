<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un voyage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<form:form enctype="multipart/form-data" cssClass="form-horizontal" method="POST" action="soumettreModifierVoyage" modelAttribute="vModif">
	
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="identifiant" path="id" />
			</div>
		</div>
	
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateArrivee">Date d'arrivée</form:label>
			<div class="col-sm-10">
				<form:input type="date" cssClass="form-control" placeholder="Date d'arrivée" path="dateArrivee" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateDepart">Date de départ</form:label>
			<div class="col-sm-10">
				<form:input type="date" cssClass="form-control" placeholder="date de depart" path="dateDepart" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixTotal">Prix total</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Prix total" path="prixTotal" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nombrePlaces">Nombre de places</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="Nombre de places" path="nombrePlaces" />
			</div>
		</div>
		
		
		<input type="file" name="file">


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>



</body>
</html>