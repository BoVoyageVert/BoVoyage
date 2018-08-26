<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste voitures</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>

	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<c:forEach var="voit" items="${allVoitures}">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="${pageContext.request.contextPath}/voiture/getImageVoit?pIdVoiture=${voit.idVoiture}"
						style="width: 450px; height: 250px">
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Modèle : ${voit.modele}</b>
					</h1>
					<p>${voit.nbPlaces}places</p>
					<h4>${voit.prix}€/jour</h4>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- FOOTER -->
	<footer>
		<p class="pull-right">
			<a href="#">Revenir en haut de page</a>
		</p>
		<p>
			&copy; 2018 BoVoyage, Inc. &middot; <a href="#">Privacy</a> &middot;
			<a href="#">Terms</a>
		</p>
	</footer>

</body>
</html>