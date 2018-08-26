<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<link href='custom.css' rel='stylesheet' type='text/css'>

<title>Marmotte Vacances</title>

<!-- Bootstrap core CSS -->
<link href="../resources/css/bootstrap.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Custom styles for this template -->
<link href="../carousel.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="accueilClient"><img
							src="../resources/img/logo.png" style="width: 65px; height: 30px">
						</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a
								href="${pageContext.request.contextPath}/destination/listeDestination"><i
									class="fa fa-plane" aria-hidden="true"></i> Destinations</a></li>
							<li><a
								href="${pageContext.request.contextPath}/hebergement/listeHebergement"><i
									class="fa fa-bed" aria-hidden="true"></i> Hébergements</a></li>
							<li><a
								href="${pageContext.request.contextPath}/loisir/listeLoisir"><i
									class="fa fa-map-o" aria-hidden="true"></i> Loisirs</a></li>
							<li><a
								href="${pageContext.request.contextPath}/voiture/listeVoiture"><i
									class="fa fa-car" aria-hidden="true"></i> Voitures</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pack/listePack"><i
									class="fa fa-suitcase" aria-hidden="true"></i> Nos Packs</a></li>
							<li><a
								href="${pageContext.request.contextPath}/login/client"><i
									class="fa fa-user-o" aria-hidden="true"></i> Mon compte</a></li>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>

	<!-- Jumbotron for reservation trip -->
	<div class="container" style="background-color: olive; height: 240px">
		<div>
			<img src="../resources/img/logo.png"
				style="margin-top: 15px; margin-left: 75px"> <a
				href="${pageContext.request.contextPath}/pack/listePack"><img
				src="../resources/img/promotions-vacances-ete-montagne-30-v1.jpg"
				style="float: right; margin-right: 30px; margin-top: 15px;"></a>
		</div>
		<br /> <a class="btn btn-primary btn-lg"
			href="${pageContext.request.contextPath}/reservation/reserverVoyage"
			role="button" style="background-color: #90EE90; margin-left: 115px">Réserver
			votre voyage</a>
	</div>
	<br />
	<br />
	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle" src="../resources/img/destinationcircle.jpg"
					alt="Generic placeholder image" width="170" height="170">
				<h2 style="color: #90EE90">
					<b>Découvrez nos destinations dans les montagnes françaises</b>
				</h2>
				<p>Seul ? En couple ? En famille ? Entre amis ? Découvrez nos
					plus belles destinations dans les montagnes françaises.</p>
				<p>
					<a class="btn btn-default"
						href="${pageContext.request.contextPath}/destination/listeDestination"
						role="button" style="background-color: #F5F5DC">Voir les
						détails &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="../resources/img/hebergementcircle.jpg"
					alt="Generic placeholder image" width="170" height="170">
				<h2 style="color: #90EE90">
					<b>Nos hébergements</b>
				</h2>
				<p>Trouvez l'hébergement qu'il vous faut parmi notre sélection
					des plus beaux chalets.</p>
				<p>
					<a class="btn btn-default"
						href="${pageContext.request.contextPath}/hebergement/listeHebergement"
						role="button" style="background-color: #F5F5DC">Voir les
						détails &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="../resources/img/raftingcircle.jpg"
					alt="Generic placeholder image" width="170" height="170">
				<h2 style="color: #90EE90">
					<b>Nos loisirs</b>
				</h2>
				<p>Besoin de repos ? À la recherche de sensations fortes ? Vous
					trouverez tout ce qu'il vous faut dans notre sélection.</p>
				<p>
					<a class="btn btn-default"
						href="${pageContext.request.contextPath}/loisir/listeLoisir"
						role="button" style="background-color: #F5F5DC">Voir les
						détails &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->


		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">
		<h1 style="color: #90EE90">Nos destinations vedettes</h1>
		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					<b>Chamonix. </b><span class="text-muted">Le luxe pour toute
						la famille.</span>
				</h2>
				<p class="lead">Chamonix se situe dans la partie occidentale et
					septentrionale des Alpes, à 15 km de la Suisse par le Col des
					Montets et à 15 km de l'Italie par le tunnel du Mont Blanc. La
					vallée de Chamonix est dominée par le Mont Blanc, le plus haut
					sommet d'Europe occidentale avec ses 4810,45 mètres et propose de
					nombreux points de vue incroyables grâce aux remontées mécaniques
					et aux sentiers pédestres.</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					data-src="holder.min.js/500x500/auto"
					alt="Generic placeholder image" src="../resources/img/chamonix.jpg"
					class="img-rounded">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 col-md-push-5">
				<h2 class="featurette-heading">
					<b>Tignes. </b> <span class="text-muted">Voyez par vous
						même.</span>
				</h2>
				<p class="lead">Au cœur de la Savoie, dans les Alpes du Nord, la
					station de ski Tignes vous accueille hiver comme été. Du 25 juin au
					7 août 2016, vous pouvez skier sur les 20 km de pistes du glacier
					entre 3456 et 3000 mètres, pratiquer le ski de fond ou encore
					bronzer sur la terrasse du Panoramic. Durant l'été, la station
					propose aussi d'autres activités comme de la randonnée pédestre, du
					Bike Park, de l'acroland, du parapente, de l'équitation ou du
					rafting.</p>
			</div>
			<div class="col-md-5 col-md-pull-7">
				<img class="featurette-image img-responsive center-block"
					data-src="holder.min.js/500x500/auto"
					alt="Generic placeholder image" src="../resources/img/tignes.jpg"
					class="img-rounded">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					<b>Samoëns. </b> <span class="text-muted">Idéale pour les
						familles.</span>
				</h2>
				<p class="lead">En été comme en hiver, c'est une destination
					idéale pour les familles. Située en Haute Savoie et profitant du
					domaine du Grand Massif, Samoëns est une station particulièrement
					adaptée pour accueillir dans les meilleures conditions les
					familles. Elle dispose de nombreuses infrastructures pour les
					enfants comme la halte-garderie Les Loupiots et le centre de
					loisirs la Marmotte. Il existe aussi la structure « Famille plus »
					qui aidera les famille à organiser au mieux leurs vacances avec
					leurs enfants. Elles reçoivent un accueil personnalisé et des
					animations adaptés à tous les âges.</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					data-src="holder.min.js/500x500/auto"
					alt="Generic placeholder image" src="../resources/img/samoens.jpg"
					class="img-rounded">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->

		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/iCc5eqqF2mE" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen="true"></iframe>
		<p style="text-align: inherit;">
		<h2 style="color: #90EE90">Marre de cette situtation ? Marmotte
			Vacances est fait pour vous !</h2>
		<br /> <br /> <br />


		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Revenir en haut de page</a>
			</p>
			<p>
				&copy; 2018 BoVoyage, Inc. &middot; <a href="#">Privacy</a> &middot;
				<a href="#">Terms</a>
			</p>
		</footer>
	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="../assets/js/vendor/jquery-3.3.1.js"></script>
	<script src="../../resources/js/bootstrap.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>