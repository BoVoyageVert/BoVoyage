package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.service.IDestinationService;

/** jd : Déclaration du Controller pour la classe Destination */

@Controller /** jd : annotation pour définir la classe comme un Controller */
@RequestMapping("/destination") /**
								 * jd : annotation pour créer la correspondance
								 * entre la classe de traitement et l'URI de la
								 * requête
								 */
public class DestinationController {

	private FileUpload file;

	/** jd : Transformation de l'association UML en Java */
	@Autowired
	private IDestinationService destinationService;

	/** jd : déclaration du setter pour l'injection dépendance */
	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}

	/**
	 * >>>>>>>>>>>> FONCTIONNALITE DE RECUPERATION DE LA LISTE DE DESTINATION
	 */
	@RequestMapping(value = "/listeDestination", method = RequestMethod.GET)
	public ModelAndView afficheListeDestination() {

		// Appel de la méthode service pour récupérer la liste des destinations

		List<Destination> listeDestination = destinationService.getAllDestination();

		return new ModelAndView("listeDestination", "allDestination", listeDestination);

	}

	/** Méthode permettant de récupérer l'image */
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImage(@RequestParam("pId") int id) throws IOException {

		Destination des = new Destination();
		des.setIdDestination(id);

		Destination destination = destinationService.getDestinationById(des);

		if (destination.getPhotoDesti() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(destination.getPhotoDesti()));
		}
	}

	/** >>>>>>>>>>>> FONCTIONNALITE D'AJOUT D'UNE DESTINATION */
	/**
	 * 1. Méthode permettant d'afficher le formulaire d'ajout de la destination
	 */
	@RequestMapping(value = "/ajouterDestination", method = RequestMethod.GET)
	public String afficherFormAddDestination(Model modele) {
		modele.addAttribute("dAjout", new Destination());
		return "ajouterDestination";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire d'ajout de la
	 * destination
	 */
	@RequestMapping(value = "/soumettreAjouterDestination", method = RequestMethod.POST)
	public String soumettreAddDestination(@ModelAttribute("dAjout") Destination destIn, MultipartFile file,
			RedirectAttributes rda) throws IOException {

		if (file != null) {
			// transformation de l'image en tableau de byte
			destIn.setPhotoDesti(file.getBytes());
		}

		/** Appel de la méthode service pour ajouter une destination */
		Destination destOut = destinationService.addDestination(destIn);

		if (destOut.getId() != 0) {
			return "redirect:listeDestination";
		} else {
			rda.addAttribute("msg", "Cette destination n'a pas pu être ajoutée, veuillez réessayer !");
			return "redirect:ajouterDestination";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE DESTINATION PAR
	 * SON ID
	 */
	@RequestMapping(value = "/rechercherDestinationId", method = RequestMethod.GET)
	public ModelAndView afficherGetDestinationById() {
		return new ModelAndView("rechercherDestinationId", "dRech", new Destination());
	}

	@RequestMapping(value = "/soumettreRechercherDestinationId", method = RequestMethod.POST)
	public String soumettreGetDestinationById(ModelMap modele, @ModelAttribute(value = "dRech") Destination dRech,
			RedirectAttributes rda, MultipartFile file) throws IOException {

		if (file != null) {
			// transformation de l'image en tableau de byte
			dRech.setPhotoDesti(file.getBytes());
		}

		Destination destiOut = destinationService.getDestinationById(dRech);

		if (destiOut != null) {
			modele.addAttribute("dFind", destiOut);
			return "rechercherDestinationId";
		} else {
			rda.addAttribute("msg", "La destination recherchée n'existe pas encore !");
			return "rechercherDestinationId";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE DESTINATION PAR
	 * SON NOM
	 */
	@RequestMapping(value = "/rechercherDestinationNom", method = RequestMethod.GET)
	public ModelAndView afficherGetDestinationByNom() {
		return new ModelAndView("rechercherDestinationNom", "dRech", new Destination());
	}

	@RequestMapping(value = "/soumettreRechercherDestinationNom", method = RequestMethod.POST)
	public String soumettreGetDestinationByNom(ModelMap modele, @ModelAttribute(value = "dRech") Destination dRech,
			RedirectAttributes rda, MultipartFile file) throws IOException {

		if (file != null) {
			// transformation de l'image en tableau de byte
			dRech.setPhotoDesti(file.getBytes());
		}

		Destination destiOut = destinationService.getDestinationByNom(dRech);

		if (destiOut != null) {
			modele.addAttribute("dFind", destiOut);
			return "rechercherDestinationNom";
		} else {
			rda.addAttribute("msg", "La destination recherchée n'existe pas encore !");
			return "rechercherDestinationNom";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE MODIFICATION D'UNE DESTINATION
	 */
	/**
	 * 1. Méthode permettant d'afficher le formulaire de modification de la
	 * destination
	 */
	@RequestMapping(value = "/modifierDestination", method = RequestMethod.GET)
	public String afficherFormUpdateDestination(Model modele) {
		modele.addAttribute("dUpdate", new Destination());
		return "modifierDestination";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire de modification de la
	 * destination
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreModifierDestination", method = RequestMethod.POST)
	public String soumettreUpdateDestination(@ModelAttribute("dUpdate") Destination destModif, RedirectAttributes rda,
			MultipartFile file) throws IOException {

		if (file != null) {
			// transformation de l'image en tableau de byte
			destModif.setPhotoDesti(file.getBytes());
		}

		/** Appel de la méthode service pour ajouter une destination */
		Destination destiModif = destinationService.updateDestination(destModif);

		if (destiModif != null) {
			return "redirect:listeDestination";
		} else {
			rda.addAttribute("msg", "Cette destination n'a pas pu être modifiée, veuillez réessayer !");
			return "redirect:modifierDestination";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE SUPPRESSION D'UNE DESTINATION
	 */
	@RequestMapping(value = "/supprimerDestination", method = RequestMethod.GET)
	public String afficherFormDeleteDestination(Model modele) {
		modele.addAttribute("dDelete", new Destination());
		return "supprimerDestination";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire de suppression de la
	 * destination
	 */
	@RequestMapping(value = "/soumettreDeleteDestination", method = RequestMethod.POST)
	public String soumettreDeleteDestination(@ModelAttribute("dDelete") Destination destSuppr, RedirectAttributes rda) {

		/** Appel de la méthode service pour ajouter une destination */
		Destination destiSuppr = destinationService.deleteDestination(destSuppr);

		if (destiSuppr != null) {
			return "redirect:listeDestination";
		} else {
			rda.addAttribute("msg", "Cette destination n'a pas pu être supprimée, veuillez réessayer !");
			return "redirect:supprimerDestination";
		}

	}
}
