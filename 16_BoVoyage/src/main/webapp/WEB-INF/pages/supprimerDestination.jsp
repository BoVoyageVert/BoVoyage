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

<title>Supprimer une destination</title>
</head>
<body>
<!-- Insertion du templateAd (navbar) -->
<jsp:include page="${request.contextPath}/template/templateAd"></jsp:include>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreDeleteDestination" modelAttribute="dDelete">
		<div class="form-group">
			<form:label for="inputEmail3" class="col-sm-2 control-label"
				path="idDestination">ID</form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEmail3"
					placeholder="ID" path="idDestination" />
			</div>
		</div>

		<button type="submit" class="btn btn-success">Supprimer</button>
	</form:form>

</body>
</html>