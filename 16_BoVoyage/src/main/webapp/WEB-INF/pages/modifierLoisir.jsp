<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier loisir</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
</head>
<body>
<form:form class="form-horizontal" method="POST" action="soumettreModifLoisir" modelAttribute="lModif">

<div class="form-group">
    <form:label  cssClass="col-sm-2 control-label" path="idLoisir">ID: </form:label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" placeholder="Id loisir" path="idLoisir"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label  cssClass="col-sm-2 control-label" path="categorie">Categorie: </form:label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" placeholder="Categorie" path="categorie"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="nom">Nom: </form:label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" placeholder="Nom" path="nom"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="description">Description:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="Description" path="description"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="prix">Prix:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="Prix" path="prix"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="reduction">Reduction:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="Reduction" path="reduction"/>
    </div>
  </div>
  
   <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="voyage.id">id voyage:</form:label>
    <div class="col-sm-5">
      <form:input cssClass="form-control" placeholder="id voyage" path="voyage.id"/>
    </div>
  </div>
    
  <div class="form-group">
    <form:label cssClass="col-sm-2 control-label" path="image">Image:</form:label>
    <div class="col-sm-5">
      <form:input type="file" cssClass="form-control" placeholder="Image" path="image"/>
    </div>
  </div>
   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Modifier loisir</button>
    </div>
  </div>
</form:form>
<h1 style="color: red">${msg}</h1>

</body>
</html>