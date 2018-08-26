<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<h3 style="color: green">
			Votre sélection de voyage du
			<fmt:formatDate value="${voyage.dateArrivee}" pattern="dd/MM/yyyy" />
			au
			<fmt:formatDate value="${voyage.dateDepart}" pattern="dd/MM/yyyy" />
			pour ${voyage.nombrePlaces} personnes.
		</h3>
		<br />
		<p style="font-weight: bold">Les prestations que vous avez
			sélectionnés sont les suivantes :</p>

		<table class="table">
			<tr>
				<th>Type de prestation</th>
				<th>Designation</th>
				<th>Nombre</th>
				<th>Prix normal</th>
				<th>Prix en promotion</th>
			</tr>
			<c:forEach var="lc" items="${allLigneCommande}">
				<tr>
					<td>${lc.typePrestation}</td>
					<td>${lc.designation}</td>
					<td>${lc.quantite}</td>
					<td>${lc.prixNormal}€</td>
					<td>${lc.prixPromotion}€</td>
					<%-- 			<td><c:if test="${lc.prixNormal}!=${lc.prixPromotion}">${lc.prixPromotion}</c:if></td> --%>


				</tr>

			</c:forEach>

		</table>

		<h3>
			Prix total : <b>${prixTotalPromo}€</b> au lieu de <s>${prixTotalNormal}€</s>
			!
		</h3>


		<form:form enctype="multipart/form-data" cssClass="form-horizontal"
			method="POST" action="soumettrePanier" modelAttribute="clInscrip">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default"
						style="background-color: #90EE90;">Commander</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>