<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>rechercher hebergement</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
	
</head>
<body>

<h1>Rechercher un pack par son nom</h1>
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRecherchePack" modelAttribute="pRecherche">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID: </form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>



<table class="table table-bordered">
		<tr>
		<th>Nom du pack</th>
			<th>Description</th>
			<th>Date d'arrivée</th>
			<th>Date de départ</th>
			<th>Prix du pack</th>
			<th>Prix promo</th>
			<th>Nombre de places</th>
			<th>Loisir 1</th>
			<th>Loisir 2</th>
			<th>Hebergement</th>
			<th>Destination</th>
			<th>Image</th>
			
			
		</tr>

		<c:forEach var="p" items="${allPack}">
			<tr>
				<td>${pRech.nom}</td>
				<td>${pRech.description}</td>
				<td>${pRech.dateArrivee}</td>
				<td>${pRech.dateDepart}</td>
				<td>${pRech.prixTotal}</td>
				<td>${pRech.prixPromo}</td>
				<td>${pRech.nombrePlaces}</td>
				<td>${pRech.loisir1}</td>
				<td>${pRech.loisir2}</td>
				<td>${pRech.hebergement}</td>
				<td>${pRech.destination}</td>
				<td>${pRech.image}</td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>