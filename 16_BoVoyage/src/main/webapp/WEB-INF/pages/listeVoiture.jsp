<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste voitures</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>Modele</th>
			<th>nombre de places</th>
			<th>Prix</th>
			<th>Image</th>
		</tr>

		<c:forEach var="voit" items="${allVoitures}">
			<tr>
				<td>${voit.modele}</td>
				<td>${voit.nbPlaces}</td>
				<td>${voit.prix}</td>
				<td><img
					src="${pageContext.request.contextPath}/voiture/getImageVoit?pIdVoiture=${voit.idVoiture}"
					style="width: 190px; height: 120px" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>