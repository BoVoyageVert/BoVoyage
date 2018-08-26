<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>liste des packs</title>
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<c:forEach var="p" items="${allPack}">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="${pageContext.request.contextPath}/pack/getImage?pId=${p.id}"
						style="width: 450px; height: 250px">
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>${p.nom}</b> <br />
					</h1>
					<p>
						<b>Description :</b> ${p.description}
					</p>
					<p>
						<b>Les dates : </b>
						<fmt:formatDate value="${p.dateDepart}" pattern="dd/MM/yyyy" />
						au
						<fmt:formatDate value="${p.dateArrivee}" pattern="dd/MM/yyyy" />
					</p>
					<p>
						<b>Destination : </b>${p.destination}
					</p>
					<p>
						<b>Pour ${p.nombrePlaces} personnes.</b>
					</p>
					<p>
						<b>Prestations comprises : </b>${p.loisir1}, ${p.loisir2},
						${p.hebergement}
					</p>
					<h4>
						À partir de <s>${p.prixTotal} €/personne</s>
					</h4>
					<h4>
						<b>Prix : ${p.prixPromo} €/personne (-<fmt:formatNumber
								value="${1-(p.prixPromo/p.prixTotal)}" type="PERCENT"
								minFractionDigits="0" minIntegerDigits="1" />)
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