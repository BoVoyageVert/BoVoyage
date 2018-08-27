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
<title>Réserver une voiture</title>
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>
	<h1 style="color: green; text-align: center">Réservation d'une voiture de location</h1>

	<table class="table table-bordered">
		<tr>
			<th>Photo</th>
			<th>Modèle</th>
			<th>Nombre de places</th>
			<th>Prix</th>
		</tr>

		<c:forEach var="voit" items="${allVoiture}">
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/voiture/getImage?pIdVoiture=${voit.idVoiture}"
					style="width: 150px; height: 120px" /></td>
				<td>${voit.modele}</td>
				<td>${voit.nbPlaces}</td>
				<td>${voit.prix}</td>
			</tr>
		</c:forEach>
	</table>

	<h1>Veuillez selectionner la voiture de votre choix</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreReserverVoiture" modelAttribute="voitReserv"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="modele">Modèle de la voiture : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" path="modele">
					<c:forEach var="voit" items="${allVoiture}">
						<option>${voit.modele}</option>
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
	
	
	
	<form:form cssClass="form-horizontal"
			method="POST" action="soumettrePasserVoiture">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default"
						style="background-color: #90EE90;">Passer à l'étape suivante</button>
				</div>
			</div>
		</form:form>

	


	<h1 style="color: red; text-align: center">${msg}</h1>






</body>
</html>