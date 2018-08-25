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

<title>Rechercher un dossier</title>
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRechercherDossierId" modelAttribute="dossRech">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idDossier">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idDossier" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Rechercher</button>
	</form:form>

	<table class="table">
		<tr>
			<th>Numéro de dossier</th>
			<th>Statut</th>
			<th>Voyage</th>
			<th>Client</th>
			<th>Admin</th>
		</tr>

		<tr>
			<td>${dossFind.numDossier}</td>
			<td>${dossFind.statut}</td>
			<td>${dossFind.voyage.id}</td>
			<td>${dossFind.client.id}</td>
			<td>${dossFind.admin.id}</td>
		</tr>
	</table>



</body>
</html>