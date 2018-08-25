<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

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
	<c:forEach var="cl" items="${allClients}">
		<tr>
			
			<td>${cl.civilite}</td>
			<td>${cl.nom}</td>
			<td>${cl.prenom}</td>
			<td>${cl.adresse}</td>
			<td>${cl.telephone}</td>
			<td><fmt:formatDate value="${cl.dateNaissance}" pattern="dd/MM/yyyy" /></td>
			<td>${cl.numCb}</td>
			<td>${cl.numSequentiel}</td>
			<td>${cl.mdp}</td>
			
		</tr>
	
	</c:forEach>
	
</table>


</body>
</html>