<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>rechercher hebergement</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
	
</head>
<body>


	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRechercheHebergementU" modelAttribute="hRecherche">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID: </form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>



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

		
			<tr>
				<td>${hRechercher.type}</td>
				<td>${hRechercher.description}</td>
				<td>${hRechercher.prix}</td>
				<td>${hRechercher.reduction}</td>
				<td>${hRechercher.lieux}</td>
				<td>${hRechercher.ville}</td>
				<td>${hRechercher.codePostal}</td>
				<td>${hRechercher.disponibilité}</td>
				<td>${hRechercher.image}</td>
			</tr>
		
	</table>






</body>
</html>