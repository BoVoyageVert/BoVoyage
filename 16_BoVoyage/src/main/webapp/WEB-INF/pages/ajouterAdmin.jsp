<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un admin</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
</head>
<body>

<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutAdmin" modelAttribute="adAjout">

		<
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="votre nom"
					path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prenom">Prenom : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="votre prenom" path="prenom" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="identifiant">Identifiant : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="Ridentifiant" path="identifiant" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="motDePasse">Mot de passe : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="motDePasse" path="motDePasse" />
			</div>
		</div>
		
	
		
	
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess">Ajouter</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>



</body>
</html>