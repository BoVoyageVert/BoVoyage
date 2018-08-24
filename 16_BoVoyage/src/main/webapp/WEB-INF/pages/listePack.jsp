<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootrap.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>liste des hebergements</title>
</head>
<body>


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
				<td>${p.nom}</td>
				<td>${p.description}</td>
				<td>${p.dateArrivee}</td>
				<td>${p.dateDepart}</td>
				<td>${p.prixTotal}</td>
				<td>${p.prixPromo}</td>
				<td>${p.nombrePlaces}</td>
				<td>${p.loisir1}</td>
				<td>${p.loisir2}</td>
				<td>${p.hebergement}</td>
				<td>${p.destination}</td>
				<td>${p.image}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>