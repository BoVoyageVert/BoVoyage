<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootrap.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>R�server un h�bergement</title>
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>
	<h1 style="color: green; text-align: center">R�servation de
		l'h�bergement</h1>

	<table class="table table-bordered">
		<tr>
			<th>Num�ro de l'hebergement</th>
			<th>Type</th>
			<th>Description</th>
			<th>Prix</th>
			<th>R�duction</th>
			<th>Lieu</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Disponibilit�</th>
			<th>image</th>

		</tr>

		<c:forEach var="h" items="${allHeberg}">
			<tr>
				<td>${h.numHebergement}</td>
				<td>${h.type}</td>
				<td>${h.description}</td>
				<td>${h.prix}</td>
				<td>${h.reduction}</td>
				<td>${h.lieux}</td>
				<td>${h.ville}</td>
				<td>${h.codePostal}</td>
				<td>${h.disponibilite}</td>
				<td><img
					src="${pageContext.request.contextPath}/hebergement/getImage?pId=${h.id}"
					style="width: 150px; height: 150px" /></td>

			</tr>
		</c:forEach>
	</table>

	<h1>Veuillez selectionner l'h�bergement de votre choix</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreReserverHebergement" modelAttribute="hReserv"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="numHebergement">Num�ro d'h�bergement : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" path="numHebergement">
					<c:forEach var="h" items="${allHeberg}">
						<option>${h.numHebergement}</option>
					</c:forEach>
				</form:select>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess"
					style="background-color: #90EE90;">Selectionner</button>
			</div>
		</div>
	</form:form>


	<h1 style="color: red; text-align: center">${msg}</h1>






</body>
</html>