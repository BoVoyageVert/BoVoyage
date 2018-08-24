<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher loisir</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
	<form:form class="form-horizontal" method="POST"
		action="soumettreRechLoisirByNom" modelAttribute="lRech"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom: </form:label>
			<div class="col-sm-5">
				<form:input type="text" cssClass="form-control"
					placeholder="nom" path="nom" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Rechercher
					par nom</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red">${msg}</h1>

	<table class="table table-bordered">
		<tr>
			<th>Categorie</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Réduction</th>
			<th>Photo</th>
		</tr>
		
		<tr>
			<td>${lFind.categorie}</td>
			<td>${lFind.nom}</td>
			<td>${lFind.description}</td>
			<td>${lFind.prix}</td>
			<td>${lFind.reduction}</td>
			<td><img
				src="${pageContext.request.contextPath}/loisir/getImage?pIdLoisir=${lFind.idLoisir}"
				style="width: 150px; height: 120px" /></td>
		</tr>

	</table>


</body>
</html>