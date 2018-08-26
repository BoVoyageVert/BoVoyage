<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer hebergement</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
</head>
<body>
<!-- Insertion du templateAd (navbar) -->
<jsp:include page="${request.contextPath}/template/templateAd"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreSupprimerHebergement" modelAttribute="hSupprimer">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">ID: </form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Supprimer</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>
</body>
</html>