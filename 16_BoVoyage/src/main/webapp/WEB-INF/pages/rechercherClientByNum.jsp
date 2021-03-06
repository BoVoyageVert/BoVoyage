<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche du client par num�ro</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>

<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST" action="soumettreRechercherClientByNum" modelAttribute="clRechByNum">
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idClient">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" placeholder="Identifiant" path="idClient" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
		
	</form:form>

</body>
</html>