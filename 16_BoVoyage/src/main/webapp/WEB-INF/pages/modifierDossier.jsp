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

<title>Modifier un dossier</title>
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifierDossier" modelAttribute="dossUpdate">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idDossier">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idDossier" />
			</div>
			<form:label for="inputNom" cssClass="col-sm-2 control-label"
				path="numDossier">Numéro de dossier</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputNom"
					placeholder="Numéro dossier" path="numDossier" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputDescription" cssClass="col-sm-2 control-label"
				path="statut">Statut</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control"
					id="inputDescritption" placeholder="ex : en cours" path="statut" />
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
		<div class="form-group">
			<form:label for="inputPrix" cssClass="col-sm-2 control-label"
				path="client.id">Client</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" id="inputPrix"
					placeholder="Client" path="client.id" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputPrix" cssClass="col-sm-2 control-label"
				path="admin.id">Admin</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" id="inputPrix"
					placeholder="Admin" path="admin.id" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Modifier</button>
	</form:form>


</body>
</html>