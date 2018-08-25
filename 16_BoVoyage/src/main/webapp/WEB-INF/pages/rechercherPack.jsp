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

<h1>Rechercher un pack par son id</h1>
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRechercherPack" modelAttribute="pRecherche" enctype="multipart/form-data">


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
		<th>Nom du pack</th>
			<th>Description</th>
			<th>Date d'arrivée</th>
			<th>Date de départ</th>
			<th>Prix du pack</th>
			<th>Prix promo</th>
			<th>Nombre de places</th>
			<th>Loisir 1</th>
			<th>Loisir 2</th>
			<th>Hebergement</th>
			<th>Destination</th>
			<th>Image</th>
			
			
		</tr>

		
			<tr>
				<td>${pRecherche.nom}</td>
				<td>${pRecherche.description}</td>
				<td>${pRecherche.dateArrivee}</td>
				<td>${pRecherche.dateDepart}</td>
				<td>${pRecherche.prixTotal}</td>
				<td>${pRecherche.prixPromo}</td>
				<td>${pRecherche.nombrePlaces}</td>
				<td>${pRecherche.loisir1}</td>
				<td>${pRecherche.loisir2}</td>
				<td>${pRecherche.hebergement}</td>
				<td>${pRecherche.destination}</td>
				<td><img src="${pageContext.request.contextPath}/pack/getImage?pId=${pRecherche.id}" style="width: 200px; height: 200px" ></td>
			</tr>
	
	</table>




</body>
</html>