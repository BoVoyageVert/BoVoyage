<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche d'un voyage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<form:form cssClass="form-horizontal" method="POST" action="soumettreRechercherVoyage" modelAttribute="vRech">
	
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="identifiant" path="id" />
			</div>
		</div>
	
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>
	
	<h1 style="color:red">${msg}</h1>
	
	<table class="table">
	<tr>
		
		<th>Date d'arrivée</th>
		<th>Date de départ</th>
		<th>Prix total</th>
		<th>Nombre de places</th>
		<th>Image</th>
	</tr>
	
		<tr>
			
			<td><fmt:formatDate value="${vFind.dateArrivee}" pattern="dd/MM/yyyy" /></td>
			<td><fmt:formatDate value="${vFind.dateDepart}" pattern="dd/MM/yyyy" /></td>
			<td>${vFind.prixTotal}</td>
			<td>${vFind.nombrePlaces}</td>
			<td><img src="${pageContext.request.contextPath}/voyage/getPhoto?pId=${vFind.id}" style="width:150px;height:150px" /></td>
			
		</tr>
	
	
	
</table>



</body>
</html>