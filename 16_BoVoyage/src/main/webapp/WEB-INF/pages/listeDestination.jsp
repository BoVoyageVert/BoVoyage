<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<title>Liste des destinations</title>
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<c:forEach var="d" items="${allDestination}">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="${pageContext.request.contextPath}/destination/getImage?pId=${d.idDestination}"
						style="width: 350px; height: 250px">
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>${d.nomDestination}</b>
					</h1>
					<p>${d.descriptionDesti}</p>
					<h4>À partir de ${d.prixDesti} €/personne</h4>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>