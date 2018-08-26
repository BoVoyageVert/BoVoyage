<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootrap.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>Réserver un loisir</title>
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>
<h1 style="color:green;text-align:center">Réservation des loisirs</h1>

<table class="table table-bordered">
		<tr>
		<th>Categorie</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Réduction</th>
			<th>Photo</th>						
		</tr>

		<c:forEach var="l" items="${allLoisir}">
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

<h1>Veuillez selectionner le loisir de votre choix</h1>
	
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreReserverLoisir" modelAttribute="lReserv" enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom du loisir : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" path="nom">
					<c:forEach var="l" items="${allLoisir}">
						<option>${l.nom}</option>
 				 	</c:forEach>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
		<!-- petite magouille qui passe inaperçue -->
			<form:label cssClass="col-sm-2 control-label" path="idLoisir">Quantité</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="Quantité" path="idLoisir" />
			</div>
		</div>
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess">Selectionner</button>
			</div>
		</div>
	</form:form>
	
	<h3><a href="${pageContext.request.contextPath}/panier/panier">Continuer</a></h3>


	<h1 style="color: red; text-align: center">${msg}</h1>






</body>
</html>