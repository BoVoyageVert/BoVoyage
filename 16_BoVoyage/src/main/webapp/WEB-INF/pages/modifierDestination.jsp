<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

<title>Modifier une destination</title>
</head>
<body>
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifierDestination" modelAttribute="dUpdate"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idDestination">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idDestination" />
			</div>
			<form:label for="inputNom" cssClass="col-sm-2 control-label"
				path="nomDestination">Nom</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputNom"
					placeholder="Nom" path="nomDestination" />
			</div>
			<label>Photo</label> <input type="file" name="file" />
		</div>
		<div class="form-group">
			<form:label for="inputDescription" cssClass="col-sm-2 control-label"
				path="descriptionDesti">Description</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control"
					id="inputDescritption" placeholder="Description"
					path="descriptionDesti" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputPrix" cssClass="col-sm-2 control-label"
				path="prixDesti">Prix</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" id="inputPrix"
					placeholder="Prix" path="prixDesti" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputPrix" cssClass="col-sm-2 control-label"
				path="voyage.id">Voyage</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" id="inputPrix"
					placeholder="Voyage" path="voyage.id" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Modifier</button>
	</form:form>


</body>
</html>