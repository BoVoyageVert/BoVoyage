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
<title>Liste des assurances</title>
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<table class="table table-striped">
		<tr>
			<th>Assurance annulation</th>
			<th>Assurance complémentaire</th>
			<th>Numéro de dossier</th>
			<th>Voyage</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="a" items="${allAssurance}">
			<tr>
				<td>${a.assuranceAnnulation}</td>
				<td>${a.assuranceComplementaire}</td>
				<td>${a.numeroDossier}</td>
				<td>${a.voyage.id}</td>
				<td><a>Modifier</a></td>
				<td><a>Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>