<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<title>Liste des destinations</title>
</head>
<body>

	<table class="table table-striped">
		<tr>
			<th style="text-align: center;">Nom</th>
			<th style="text-align: center;">Photo</th>
			<th style="text-align: center;">Description</th>
			<th style="text-align: center;">Prix</th>
			<th style="text-align: center;">Actions</th>
		</tr>

		<c:forEach var="d" items="${allDestination}">
			<tr>
				<td style="text-align: center;">${d.nomDestination}</td>
				<td><img
					src="${pageContext.request.contextPath}/destination/getImage?pId=${d.idDestination}"
					class="img-rounded"
					style="width: 200px; height: 200px; margin: auto;"></td>
				<td style="text-align: center;">${d.descriptionDesti}</td>
				<td style="text-align: center;">${d.prixDesti}</td>
				<td><a>Modifier</a></td>
				<td><a>Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>