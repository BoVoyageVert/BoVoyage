<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>
	<form:form enctype="multipart/form-data" cssClass="form-horizontal" method="POST" action="soumettreAjouterClient" modelAttribute="clAjout">
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
		
	
	
	
	
	
	
	</form:form>


</body>
</html>