<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter voiture</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>

<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateTest"></jsp:include>

<form:form class="form-horizontal" method="POST" action="soumettreAjouterVoiture" modelAttribute="voitAjout" enctype="multipart/form-data">
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="modele">Modele: </form:label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" placeholder="Modele" path="modele"/>
    </div>
  </div>
  
   <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="nbPlaces">nombre de places: </form:label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" placeholder="nombre de places" path="nbPlaces"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="prix">Prix:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="Prix" path="prix"/>
    </div>
  </div>
  
   <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="voyage.id">id voyage:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="id voyage" path="voyage.id"/>
    </div>
  </div>
    
  <input type="file" name="file" style="margin:auto"/>
   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Ajouter voiture</button>
    </div>
  </div>
</form:form>
<h1 style="color: red">${msg}</h1>

</body>
</html>