<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche du client par ID</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST" action="soumettreRechercherClientById" modelAttribute="clRechId">
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idClient">ID</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="Identifiant" path="idClient" />
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
		
		<th>Civilité</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Adresse</th>
		<th>Téléphone</th>
		<th>dateNaissance</th>
		<th>numCb</th>
		<th>numSequenciel</th>
		<th>mdp</th>
	</tr>
	
		<tr>
			
			<td>${clFind.civilite}</td>
			<td>${clFind.nom}</td>
			<td>${clFind.prenom}</td>
			<td>${clFind.adresse}</td>
			<td>${clFind.telephone}</td>
			<td><fmt:formatDate value="${clFind.dateNaissance}" pattern="dd/MM/yyyy" /></td>
			<td>${clFind.numCb}</td>
			<td>${clFind.numSequentiel}</td>
			<td>${clFind.mdp}</td>
			
		</tr>
	
	
	
</table>
	
	
	

</body>
</html>