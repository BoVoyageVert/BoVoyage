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

<title>Modifier une assurance</title>
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifierAssurance" modelAttribute="aUpdate">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idAssurance">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idAssurance" />
			</div>
			<form:label for="inputNom" cssClass="col-sm-2 control-label"
				path="assuranceAnnulation">Assurance annulation</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputNom"
					placeholder="true ou false" path="assuranceAnnulation" />
			</div>
			<form:label for="inputNom" cssClass="col-sm-2 control-label"
				path="assuranceAnnulation">Assurance complémentaire</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputNom"
					placeholder="true ou false" path="assuranceComplementaire" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputDescription" cssClass="col-sm-2 control-label"
				path="numeroDossier">Numéro Dossier</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control"
					id="inputDescritption" placeholder="numéro dossier"
					path="numeroDossier" />
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