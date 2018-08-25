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
<title>Selectionner un pack</title>
</head>
<body>

<h1>Voici la liste des packs disponibles</h1>
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

		<c:forEach var="p" items="${allPack}">
			<tr>
				<td>${p.nom}</td>
				<td>${p.description}</td>
				<td>${p.dateArrivee}</td>
				<td>${p.dateDepart}</td>
				<td>${p.prixTotal}</td>
				<td>${p.prixPromo}</td>
				<td>${p.nombrePlaces}</td>
				<td>${p.loisir1}</td>
				<td>${p.loisir2}</td>
				<td>${p.hebergement}</td>
				<td>${p.destination}</td>
				<td><img src="${pageContext.request.contextPath}/pack/getImage?pId=${p.id}"/></td>
			</tr>
		</c:forEach>
	</table>


<h1>Veuillez selectionner le pack de votre choix</h1>

<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutPackClient" modelAttribute="pcAjout" enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom : </form:label>
			<div class="col-sm-10">
				<form:select cssClass="form-control" placeholder="selectionner" path="nom" >
				<option>${p.nom}</option>
				</form:select>
			</div>
		</div>
		
		
			<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nombrePlaces">Nombre de places : </form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control"
					placeholder="nombre de places" path="nombrePlaces" />
			</div>
		</div>
		
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Selectionner ce pack</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>




</body>
</html>