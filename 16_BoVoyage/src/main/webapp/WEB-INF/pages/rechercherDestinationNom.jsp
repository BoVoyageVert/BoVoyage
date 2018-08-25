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
		action="soumettreRechercherDestinationNom" modelAttribute="dRech"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="nomDestination">Nom</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="Nom" path="nomDestination" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Rechercher</button>
	</form:form>

	<table class="table">
		<tr>
			<th>Nom</th>
			<th>Photo</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Voyage</th>
		</tr>

		<tr>
			<td>${dFind.nomDestination}</td>
			<td><img
				src="${pageContext.request.contextPath}/destination/getImage?pId=${dFind.idDestination}"
				class="img-rounded" style="width: 200px; height: 200px"></td>
			<td>${dFind.descriptionDesti}</td>
			<td>${dFind.prixDesti}</td>
			<td>${dFind.voyage.id}</td>
		</tr>
	</table>



</body>
</html>