<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un client</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<!-- Insertion du templateTest (navbar) -->
	<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<div class="container" style="background-color: #F5F5DC;">
		<form:form enctype="multipart/form-data" cssClass="form-horizontal"
			method="POST" action="soumettreInscription"
			modelAttribute="clInscrip">

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="civilite">Civilité</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre civilité" path="civilite" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="nom">Nom</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre nom" path="nom" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="prenom">Prenom</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre prénom" path="prenom" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="adresse">Adresse</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre adresse" path="adresse" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="telephone">Numéro de téléphone</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre téléphone" path="telephone" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="dateNaissance">Date de naissance</form:label>
				<div class="col-sm-10">
					<form:input type="date" cssClass="form-control"
						placeholder="Entrez votre date de naissance" path="dateNaissance" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="numCb">Numéro de carte bancaire</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez numéro de CB" path="numCb" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="numSequentiel">Numéro séquentiel</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre numéro séquentiel" path="numSequentiel" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="mail">Mail</form:label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control"
						placeholder="Entrez votre adresse mail" path="mail" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="mdp">Mot de passe</form:label>
				<div class="col-sm-10">
					<form:input type="password" cssClass="form-control"
						placeholder="Entrez votre mot de passe" path="mdp" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default"
						style="background-color: #90EE90;">Ajouter</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>