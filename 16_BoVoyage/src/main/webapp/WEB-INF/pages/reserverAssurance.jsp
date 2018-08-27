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
<title>Réserver une assurance</title>
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>
	<h1 style="color: green; text-align: center">Réservation d'une assurance</h1>

	<table class="table table-bordered">
		<tr>
			<th>N° choix</th>
			<th>Assurance annulation</th>
			<th>Assurance complémentaire</th>
			<th>Prix</th>
		</tr>

		<c:forEach var="a" items="${allAssurance}">
			<tr>
				<td>${a.idAssurance}</td>
				<td>${a.assuranceAnnulation}</td>
				<td>${a.assuranceComplementaire}</td>
				<td>${a.prix}</td>
			</tr>
		</c:forEach>
	</table>

	<h1>Veuillez selectionner l'assurance de votre choix</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreReserverAssurance" modelAttribute="aReserv"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idAssurance">Choix de l'assurance n° : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" path="idAssurance">
					<c:forEach var="a" items="${allAssurance}">
						<option>${a.idAssurance}</option>
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
	
	
		
		
		<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<h3>
						<a href="${pageContext.request.contextPath}/panier/panier">Visualiser la réservation</a>
					</h3>
				</div>
			</div>
	
	


	<h1 style="color: red; text-align: center">${msg}</h1>






</body>
</html>