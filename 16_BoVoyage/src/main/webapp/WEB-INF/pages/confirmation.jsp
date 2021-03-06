<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un client</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<h3 style="color: green">
			Félicitations, vous venez de commander votre voyage du
			<fmt:formatDate value="${voyage.dateDepart}" pattern="dd/MM/yyyy" />
			au
			<fmt:formatDate value="${voyage.dateArrivee}" pattern="dd/MM/yyyy" />
			pour ${voyage.nombrePlaces} personnes.
		</h3>
		<br />
		<h4>Votre demande est en cours de validation par un
			administrateur. Vous serez averti par mail lors de l'acceptation.</h4>
		<p style="font-weight: bold">Inclu dans votre commande :</p>

		<table class="table">
			<tr>
				<th>Type de prestation</th>
				<th>Designation</th>
				<th>Nombre</th>
				<th>Prix</th>
			</tr>
			<c:forEach var="lc" items="${allLigneCommande}">
				<tr>
					<td>${lc.typePrestation}</td>
					<td>${lc.designation}</td>
					<td>${lc.quantite}</td>
					<td>${lc.prixPromotion}€</td>


				</tr>

			</c:forEach>

		</table>

		<h3>
			Prix total : <b>${prixTotalPromo}€</b>
		</h3>
		<hr />
		<h4>Merci pour votre confiance, nous espérons vous revoir bientôt
			sur notre site.</h4>

	</div>
	<form:form cssClass="form-horizontal" method="POST" action="terminer">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess"
					style="background-color: #90EE90;">Terminer</button>
			</div>
		</div>
	</form:form>



</body>
</html>