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
		<th>Numéro de l'hebergement</th>
			<th>Type</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Réduction</th>
			<th>Lieu</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Disponibilité</th>
			<th>image</th>
			
			
		</tr>

		<c:forEach var="h" items="${allHebergement}">
			<tr>
				<td>${h.type}</td>
				<td>${h.description}</td>
				<td>${h.prix}</td>
				<td>${h.reduction}</td>
				<td>${h.lieux}</td>
				<td>${h.ville}</td>
				<td>${h.codePostal}</td>
				<td>${h.disponibilite}</td>
				<td><img src="${pageContext.request.contextPath}/hebergement/getImage?pId=${h.id}" style="width: 200px; height: 200px"/></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>