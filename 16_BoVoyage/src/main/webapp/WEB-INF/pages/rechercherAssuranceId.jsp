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

<title>Rechercher une destination</title>
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRechercherAssuranceId" modelAttribute="aRech">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idAssurance">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idAssurance" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Rechercher</button>
	</form:form>

	<table class="table">
		<tr>
			<th>Assurance annulation</th>
			<th>Assurance complémentaire</th>
			<th>Numéro de dossier</th>
			<th>Voyage</th>
		</tr>

		<tr>
			<td>${aFind.assuranceAnnulation}</td>
			<td>${aFind.assuranceComplementaire}</td>
			<td>${aFind.numeroDossier}</td>
			<td>${aFind.voyage.id}</td>
		</tr>
	</table>



</body>
</html>