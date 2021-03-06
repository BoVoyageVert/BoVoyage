<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter hebergemente</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
</head>
<body>

<!-- Insertion du templateAd (navbar) -->
<jsp:include page="${request.contextPath}/template/templateAd"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutHebergement" modelAttribute="hAjout"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="type">Type : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" placeholder="Type" path="type">
					<option>Chalet</option>
					<option>Appartement</option>
					<option>Cabane dans les arbres</option>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="disponibilite">Disponibilite : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Disponibilite"
					path="disponibilite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prix">Prix : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Prix en euros"
					path="prix" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="reduction">Reduction : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Reduction"
					path="reduction" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="lieux">Lieu : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="lieux" path="lieux" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="ville">Ville : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="ville" path="ville" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="codePostal">Code postal : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="codePostal"
					path="codePostal" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="menage">M�nage : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="M�nage"
					path="menage" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="numHebergement">Numero de l'hebergement : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="numHebergement"
					path="numHebergement" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="description">Description : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="description"
					path="description" />
			</div>
		</div>

		<input type="file" name="file" style="margin: auto" />


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess">Ajouter</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>



</body>
</html>