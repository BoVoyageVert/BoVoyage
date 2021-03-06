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

<title>Ajout de dossier de voyage</title>
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjouterDossier" modelAttribute="dossAjout">
		<div class="form-group">
			<form:label for="inputNom" cssClass="col-sm-2 control-label"
				path="numDossier">Num�ro de dossier</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputNom"
					placeholder="Num�ro" path="numDossier" />
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
				<form:input type="text" cssClass="form-control" id="inputPrix"
					placeholder="Voyage" path="voyage.id" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputClient" cssClass="col-sm-2 control-label"
				path="client.idClient">Client</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputClient"
					placeholder="Client" path="client.idClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputPrix" cssClass="col-sm-2 control-label"
				path="admin.id">Admin</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputPrix"
					placeholder="Admin" path="admin.id" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form:form>





</body>
</html>