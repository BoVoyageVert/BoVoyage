<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation d'un voyage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>
<h1 style="color:green;text-align:center">Réservation du voyage</h1>
	<form:form enctype="multipart/form-data" cssClass="form-horizontal" method="POST" action="soumettreReserverVoyage" modelAttribute="vReserv">
		
		
		
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
			<form:label cssClass="col-sm-2 control-label" path="nombrePlaces">Nombre de places</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="Nombre de places" path="nombrePlaces" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Continuer</button>
			</div>
		</div>
	</form:form>



</body>
</html>