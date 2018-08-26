<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fct" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<c:forEach var="l" items="${allLoisirs}">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="${pageContext.request.contextPath}/loisir/getImage?pIdLoisir=${l.idLoisir}"
						style="width: 350px; height: 250px">
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>${l.categorie}</b>
					</h1>
					<p>${l.nom}</p>
					<p>${l.description}</p>
					<p>
						Prix de départ :<s> ${l.prix} €/personne</s>
					</p>
					<h4>
						<b>Promotion : ${l.reduction} €/personne (-<fmt:formatNumber
								value="${1-(l.reduction/l.prix)}" type="PERCENT"
								minFractionDigits="0" minIntegerDigits="2" />)
						</b>
					</h4>
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