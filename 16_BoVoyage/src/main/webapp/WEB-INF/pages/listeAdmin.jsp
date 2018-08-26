<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootrap.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>liste des admins</title>
</head>
<body>


<table class="table table-bordered">
		<tr>
		<th>Nom</th>
			<th>Prenom</th>
			<th>Statut</th>
			
			
			
		</tr>

		<c:forEach var="ad" items="${allAdmin}">
			<tr>
				<td>${ad.nom}</td>
				<td>${ad.prenom}</td>
				<td>${ad.active}</td>
			</tr>
		</c:forEach>
	</table>





</body>
</html>