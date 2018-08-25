<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<title>Liste des dossiers</title>
</head>
<body>

	<table class="table table-striped">
		<tr>
			<th style="text-align: center;">Numéro de dossier</th>
			<th style="text-align: center;">Statut</th>
			<th style="text-align: center;">Voyage</th>
			<th style="text-align: center;">Client</th>
			<th style="text-align: center;">Admin</th>
			<th style="text-align: center;">Actions</th>
		</tr>

		<c:forEach var="doss" items="${allDossier}">
			<tr>
				<td style="text-align: center;">${doss.numDossier}</td>
				<td style="text-align: center;">${doss.statut}</td>
				<td style="text-align: center;">${doss.voyage.id}</td>
				<td style="text-align: center;">${doss.client.id}</td>
				<td style="text-align: center;">${doss.admin.id}</td>
				<td><a>Modifier</a></td>
				<td><a>Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>