<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste Loisirs</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
</head>
<body>
<table class="table table-bordered">
		<tr>
		<th>Categorie</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Réduction</th>
			<th>Photo</th>						
		</tr>

		<c:forEach var="l" items="${allLoisirs}">
			<tr>
				<td>${l.categorie}</td>
				<td>${l.nom}</td>
				<td>${l.description}</td>
				<td>${l.prix}</td>
				<td>${l.reduction}</td>
				<td><img src="${pageContext.request.contextPath}/loisir/getImage?pIdLoisir=${l.idLoisir}" style="width:150px; height: 120px"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>