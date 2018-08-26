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
<title>liste des hebergements</title>
</head>
<body>

	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<c:forEach var="h" items="${allHebergement}">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="${pageContext.request.contextPath}/hebergement/getImage?pId=${h.id}"
						style="width: 450px; height: 250px">
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Type : ${h.type}</b> <br />
					</h1>
					<p>
						<b>Numéro du logement :</b> ${h.numHebergement}
					</p>
					<p>${h.description}</p>
					<p>
						<b>Adresse : </b>${h.lieux}</p>
					${h.codePostal}, ${h.ville}
					<h4>
						À partir de <s>${h.prix} €/nuit</s>
					</h4>
					<h4>
						<b>Promotion : ${h.reduction} €/nuit (-<fmt:formatNumber
								value="${1-(h.reduction/h.prix)}" type="PERCENT"
								minFractionDigits="0" minIntegerDigits="2" />)
						</b>
					</h4>
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>