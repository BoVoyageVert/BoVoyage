package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.service.IDestinationService;

/** jd : D�claration du Controller pour la classe Destination */

@Controller /** jd : annotation pour d�finir la classe comme un Controller */
@RequestMapping("/destination") /**
								 * jd : annotation pour cr�er la correspondance
								 * entre la classe de traitement et l'URI de la
								 * requ�te
								 */
public class DestinationController {

	/** jd : Transformation de l'association UML en Java */
	@Autowired
	private IDestinationService destinationService;

	/** jd : d�claration du setter pour l'injection d�pendance */
	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}

	/**
	 * >>>>>>>>>>>> FONCTIONNALITE DE RECUPERATION DE LA LISTE DE DESTINATION
	 */
	@RequestMapping(value = "/listeDestination", method = RequestMethod.GET)
	public ModelAndView afficheListeDestination() {

		/**
		 * Appel de la m�thode service pour r�cup�rer la liste des destinations
		 */
		List<Destination> listeDestination = destinationService.getAllDestination();

		return new ModelAndView("listeDestination", "allDestination", listeDestination);

	}

	/** >>>>>>>>>>>> FONCTIONNALITE D'AJOUT D'UNE DESTINATION */
	/**
	 * 1. M�thode permettant d'afficher le formulaire d'ajout de la destination
	 */
	@RequestMapping(value = "/ajouterDestination", method = RequestMethod.GET)
	public String afficherFormAddDestination(Model modele) {
		modele.addAttribute("dAjout", new Destination());
		return "ajouterDestination";
	}

	/**
	 * 2. M�thode permettant de soumettre le formulaire d'ajout de la
	 * destination
	 */
	@RequestMapping(value = "/soumettreAjouterDestination", method = RequestMethod.POST)
	public String soumettreAddDestination(@ModelAttribute("dAjout") Destination destIn, RedirectAttributes rda) {

		/** Appel de la m�thode service pour ajouter une destination */
		Destination destOut = destinationService.addDestination(destIn);

		if (destOut.getId() != 0) {
			return "redirect:listeDestination";
		} else {
			rda.addAttribute("msg", "Cette destination n'a pas pu �tre ajout�e, veuillez r�essayer !");
			return "redirect:ajouterDestination";
		}

	}

	/** >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE DESTINATION */
	@RequestMapping(value = "/rechercherDestination", method = RequestMethod.GET)
	public ModelAndView afficherGetDestinationById() {
		return new ModelAndView("rechercherDestinationId", "dRech", new Destination());
	}

	@RequestMapping(value = "/soumettreRechercherDestination", method = RequestMethod.POST)
	public String soumettreGetDestinationById(ModelMap modele, @ModelAttribute(value = "dRech") Destination dRech,
			RedirectAttributes rda) {

		Destination destiOut = destinationService.getDestinationById(dRech);

		if (destiOut != null) {
			modele.addAttribute("dFind", destiOut);
			return "rechercherDestinationId";
		} else {
			rda.addAttribute("msg", "La destination recherch�e n'existe pas encore !");
			return "rechercherDestinationId";
		}

	}

}
