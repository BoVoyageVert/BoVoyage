<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<title>Accueil admin</title>
</head>


<body>
<!-- Insertion du templateTest (navbar) -->
<!-- Insertion du templateTest (navbar) -->
<jsp:include page="${request.contextPath}/template/templateAd"></jsp:include>


<a style="color: red; text-align: center;" href="${pageContext.request.contextPath}/admin/seDeconnecter">Se Deconnecter</a>




<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/chamonix.jpg"
						style="width: 450px; height: 250px">
						
							
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Destination</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/destination/modifierDestination"/>">Modifier</a>
					| <a href="<c:url value="/destination/supprimerDestination"/>">Supprimer</a>
					| <a href="<c:url value="/destination/ajouterDestination"/>">Ajouter</a>
					| <a href="<c:url value="/destination/listeDestination"/>">Liste</a>
						</h3>

				</div>
			</div>
	
	</div>





	<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/hebergementcircle.jpg"
						style="width: 450px; height: 250px">
						
						
						
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Hebergement</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/hebergement/modifierHebergement?pId=${h.id}"/>">Modifier</a>
					| <a href="<c:url value="/hebergement/supprimerHebergement/${h.id}"/>">Supprimer</a>
					| <a href="<c:url value="/hebergement/ajouterHebergement/${h.id}"/>">Ajouter</a>
					| <a href="<c:url value="/hebergement/listeHebergement/${h.id}"/>">Liste</a>
						</h3>
					
			
				</div>
			</div>
	
	</div>





<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/raftingcircle.jpg"
						style="width: 450px; height: 250px">
						
							
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Loisirs</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/loisir/modifierLoisir"/>">Modifier</a>
					| <a href="<c:url value="/loisir/supprimerLoisir"/>">Supprimer</a>
					| <a href="<c:url value="/loisir/ajouterLoisir"/>">Ajouter</a>
					| <a href="<c:url value="/loisir/listeLoisir"/>">Liste</a>
						</h3>

				</div>
			</div>
	
	</div>



<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/voiture.jfif"
						style="width: 450px; height: 250px">
						
							
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Voitures</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/voiture/modifierVoiture"/>">Modifier</a>
					| <a href="<c:url value="/voiture/supprimerVoiture"/>">Supprimer</a>
					| <a href="<c:url value="/voiture/ajouterVoiture"/>">Ajouter</a>
					| <a href="<c:url value="/voiture/listeVoiture"/>">Liste</a>
						</h3>

				</div>
			</div>
	
	</div>




<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/tignes.jpg"
						style="width: 450px; height: 250px">
						
							
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Packs</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/pack/modifierPack"/>">Modifier</a>
					| <a href="<c:url value="/pack/supprimerPack"/>">Supprimer</a>
					| <a href="<c:url value="/pack/ajouterPack"/>">Ajouter</a>
					| <a href="<c:url value="/pack/listePack"/>">Liste</a>
						</h3>

				</div>
			</div>
	
	</div>




<div class="container" style="background-color: #F5F5DC;">
			<div class="media">
				<div class="media-left">
					<img class="media-object"
						src="../resources/img/assurance.jfif"
						style="width: 450px; height: 250px">
						
							
				</div>
				<div class="media-body">
					<h1 class="media-heading">
						<b>Assurances</b> <br />
						</h1>
						
						<h3>
						<a href="<c:url value="/assurance/modifierAssurance"/>">Modifier</a>
					| <a href="<c:url value="/assurance/supprimerAssurance"/>">Supprimer</a>
					| <a href="<c:url value="/assurance/ajouterAssurance"/>">Ajouter</a>
					| <a href="<c:url value="/assurance/listeAssurance"/>">Liste</a>
						</h3>

				</div>
			</div>
	
	</div>





</body>
</html>