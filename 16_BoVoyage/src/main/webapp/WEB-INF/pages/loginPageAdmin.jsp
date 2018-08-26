<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page login Admin</title>
</head>
<body>

	<form action="j_spring_security_check" method="post">
		Login: <input type="text" name="j_username" /> <br /> Mot de passe: <input
			type="text" name="j_password" /> <br /> <input type="submit"
			value="Se connecter" />
	</form>
	
	<c:if test="${not empty erreur}">

		<h1 style="color: red; text-align: center">Le login ou le mot de
			passe est erron�(s)!</h1>
	</c:if>
	
	<c:if test="${not empty msg}">
		<h1 style="color: red; text-align: center">Vous etes deconnect�!</h1>
	</c:if>

</body>
</html>