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

<title>Ajout d'assurances</title>
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjouterAssurance" modelAttribute="aAjout">
		<div class="form-group">
			<form:label for="inputDossier" cssClass="col-sm-2 control-label"
				path="assuranceAnnulation">Assurance annulation</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputDossier"
					placeholder="true ou false" path="assuranceAnnulation" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputDossier" cssClass="col-sm-2 control-label"
				path="assuranceComplementaire">Assurance complémentaire</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputDossier"
					placeholder="true ou  false" path="assuranceComplementaire" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputDossier" cssClass="col-sm-2 control-label"
				path="numeroDossier">Numéro de dossier</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputDossier"
					placeholder="Description" path="numeroDossier" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="inputDossier" cssClass="col-sm-2 control-label"
				path="voyage.id">Voyage</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="inputVoyage"
					placeholder="Voyage" path="voyage.id" />
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form:form>





</body>
</html>