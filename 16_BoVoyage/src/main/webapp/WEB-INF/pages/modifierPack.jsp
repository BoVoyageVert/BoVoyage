<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<title>Modifier Pack</title>
</head>
<body>
<!-- Insertion du templateAd (navbar) -->
<jsp:include page="${request.contextPath}/template/templateAd"></jsp:include>

<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifierPack" modelAttribute="pModifier"  enctype="multipart/form-data">

<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">Id : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="nom" path="nom" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="description">Description : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="description"
					path="description" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateArrivee">Date d'arrivee : </form:label>
			<div class="col-sm-8">
				<form:input  type="date" cssClass="form-control"
					placeholder="date d'arrivee" path="dateArrivee" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateDepart">Date de depart : </form:label>
			<div class="col-sm-8">
				<form:input  type="date" cssClass="form-control"
					placeholder="Date de depart" path="dateDepart" />
			</div>
		</div>
		
				<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixTotal">Prix Total : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="Prix Total" path="prixTotal" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixPromo">Prix Promo : </form:label>
			<div class="col-sm-8">
				<form:input type="double" cssClass="form-control"
					placeholder="Prix promo" path="prixPromo" />
			</div>
		</div>
		

		
			<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nombrePlaces">Nombre de places : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="nombre de places" path="nombrePlaces" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="loisir1">Loisir 1 : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="loisir1" path="loisir1" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="loisir2">Loisir 2 : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="loisir2" path="loisir2" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="hebergement">Hebergement : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="hebergement" path="hebergement" />
			</div>
		</div>
		
			<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="destination">Destination : </form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="destination" path="destination" />
			</div>
		</div>

		
		
			<input type="file" name="file" style="margin: auto" />
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Modifier</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>





</body>
</html>