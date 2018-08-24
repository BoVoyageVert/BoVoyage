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
<title>rechercher voiture</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>
	<form:form class="form-horizontal" method="POST"
		action="soumettreRechVoiture" modelAttribute="voitRech" enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idVoiture">Id voiture: </form:label>
			<div class="col-sm-5">
				<form:input type="text" cssClass="form-control" placeholder="idVoiture"
					path="idVoiture" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Rechercher par id
					</button>
			</div>
		</div>
	</form:form>
	
	<h1 style="color: red">${msg}</h1>
	
	<table class="table table-bordered">
		<tr>
			<th>Modele</th>
			<th>nombre de places</th>
			<th>Prix</th>
			<th>Image</th>
		</tr>

			<tr>
				<td>${voitFind.modele}</td>
				<td>${voitFind.nbPlaces}</td>
				<td>${voitFind.prix}</td>
				<td><img
				src="${pageContext.request.contextPath}/voiture/getImageVoit?pIdVoiture=${voitFind.idVoiture}"
				style="width: 190px; height: 120px" /></td>
			</tr>

	</table>
</body>
</html>