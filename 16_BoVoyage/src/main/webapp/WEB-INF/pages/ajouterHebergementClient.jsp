<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootrap.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>liste des hebergements</title>
</head>
<body>

<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

<h1>Voici la liste des hebergements disponibles</h1>

<table class="table table-bordered">
		<tr>
		<th>Numéro de l'hebergement</th>
			<th>Type</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Réduction</th>
			<th>Lieu</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Disponibilité</th>
			<th>image</th>
			
			
		</tr>

		<c:forEach var="h" items="${allHebergement}">
			<tr>
				<td>${h.type}</td>
				<td>${h.description}</td>
				<td>${h.prix}</td>
				<td>${h.reduction}</td>
				<td>${h.lieux}</td>
				<td>${h.ville}</td>
				<td>${h.codePostal}</td>
				<td>${h.disponibilite}</td>
				<td><img src="${pageContext.request.contextPath}/hebergement/getImage?pId=${h.id}" style="width: 200px; height: 200px"/></td>
			</tr>
		</c:forEach>
	</table>

<h1>Veuillez selectionner l'hébergement de votre choix</h1>

<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutHebergementClient" modelAttribute="hcAjout" enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="Type">Type : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" placeholder="Type" path="type">
				<option>Chalet</option>
 				 <option>Appartement</option>
  				<option>Cabane dans les arbres</option>
				</form:select>
			</div>
		</div>
		
		
			<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="menage">Menage : </form:label>
			<div class="col-sm-8">
				<form:select cssClass="form-control"
					placeholder="menage" path="menage">
				<option>Oui</option>
 				 <option>Non</option>
				</form:select>
			</div>
		</div>
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sucess">Selectionner</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>






</body>
</html>