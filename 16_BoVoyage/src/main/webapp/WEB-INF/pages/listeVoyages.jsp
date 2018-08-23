<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des voyages</title>
</head>
<body>
	
	<table class="table">
	<tr>
		
		<th>Date d'arrivée</th>
		<th>Date de départ</th>
		<th>Prix total</th>
		<th>Nombre de places</th>
		<th>Image</th>
	</tr>
	<c:forEach var="v" items="${allVoyages}">
	<tr>
		
		<td><fmt:formatDate value="${v.dateArrivee}" pattern="dd/MM/yyyy" /></td>
		<td><fmt:formatDate value="${v.dateDepart}" pattern="dd/MM/yyyy" /></td>
		<td>${v.prixTotal}</td>
		<td>${v.nombrePlaces}</td>
		<td>${v.image}</td>
		
	</tr>
	
	</c:forEach>
	
</table>
</body>
</html>