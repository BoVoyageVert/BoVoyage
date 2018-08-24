<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifiaction du client</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
	<form:form cssClass="form-horizontal" method="POST" action="soumettreModifierVoyage" modelAttribute="vModif">
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idClient">ID</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" placeholder="Identifiant" path="idClient" />
			</div>
		</div>
	
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="civilite">Civilité : </form:label>
			<form class="col-sm-10">
				<form:radiobutton path="civilite" value="M." /> Monsieur<br> 
				<form:radiobutton path="civilite" value="Mme" /> Madame<br> 
			</form>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez votre nom" path="nom" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prenom">Prenom</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez votre prénom" path="prenom" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse">Adresse</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez votre adresse" path="adresse" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="telephone">Numéro de téléphone</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez votre téléphone" path="telephone" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateNaissance">Date de naissance</form:label>
			<div class="col-sm-10">
				<form:input type="date" cssClass="form-control" placeholder="Entrez votre date de naissance" path="dateNaissance" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="numCb">Numéro de carte bancaire</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez numéro de CB" path="numCb" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="numSequentiel">Numéro séquentiel</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Entrez votre numéro séquentiel" path="numSequentiel" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mdp">Mot de passe</form:label>
			<div class="col-sm-10">
				<form:input type="password" cssClass="form-control" placeholder="Entrez votre mot de passe" path="mdp" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	
	
	</form:form>

</body>
</html>