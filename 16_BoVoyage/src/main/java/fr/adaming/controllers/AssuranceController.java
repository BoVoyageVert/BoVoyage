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

import fr.adaming.model.Assurance;
import fr.adaming.model.Destination;
import fr.adaming.service.IAssuranceService;

/** jd : Déclaration du Controller pour la classe Assurance */

@Controller /** jd : annotation pour définir la classe comme un Controller */
@RequestMapping("/assurance") /**
								 * jd : annotation pour créer la correspondance
								 * entre la classe de traitement et l'URI de la
								 * requête
								 */
public class AssuranceController {

	/** jd: Transformation de l'association UML en Java */
	@Autowired
	private IAssuranceService assuranceService;

	/** jd: Setter pour l'injection dépendance */
	public void setAssuranceService(IAssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}

	/**
	 * >>>>>>>>>>>> FONCTIONNALITE DE RECUPERATION DE LA LISTE DES ASSURANCES
	 */
	@RequestMapping(value = "/listeAssurance", method = RequestMethod.GET)
	public ModelAndView afficheListeAssurance() {

		// Appel de la méthode service pour récupérer la liste des destinations

		List<Assurance> listeAssurance = assuranceService.getAllAssurance();

		return new ModelAndView("listeAssurance", "allAssurance", listeAssurance);

	}

	/** >>>>>>>>>>>> FONCTIONNALITE D'AJOUT D'UNE ASSURANCE */
	/**
	 * 1. Méthode permettant d'afficher le formulaire d'ajout de l'assurance
	 */
	@RequestMapping(value = "/ajouterAssurance", method = RequestMethod.GET)
	public String afficherFormAddAssurance(Model modele) {
		modele.addAttribute("aAjout", new Assurance());
		return "ajouterAssurance";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire d'ajout de l'assurance
	 */
	@RequestMapping(value = "/soumettreAjouterAssurance", method = RequestMethod.POST)
	public String soumettreAddAssurance(@ModelAttribute("aAjout") Assurance assurIn, RedirectAttributes rda) {

		/** Appel de la méthode service pour ajouter une destination */
		Assurance assurOut = assuranceService.addAssurance(assurIn);

		if (assurOut.getIdAssurance() != 0) {
			return "redirect:listeAssurance";
		} else {
			rda.addAttribute("msg", "Cette assurance n'a pas pu être ajoutée, veuillez réessayer !");
			return "redirect:ajouterAssurance";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE ASSURANCE PAR SON
	 * ID
	 */
	@RequestMapping(value = "/rechercherAssuranceId", method = RequestMethod.GET)
	public ModelAndView afficherGetAssuranceById() {
		return new ModelAndView("rechercherAssuranceId", "aRech", new Assurance());
	}

	@RequestMapping(value = "/soumettreRechercherAssuranceId", method = RequestMethod.POST)
	public String soumettreGetAssuranceById(ModelMap modele, @ModelAttribute(value = "aRech") Assurance aRech,
			RedirectAttributes rda) {

		// Appel de la méthode service pour rechercher une assurance par son id
		Assurance assurOut = assuranceService.getAssuranceById(aRech);

		if (assurOut != null) {
			modele.addAttribute("aFind", assurOut);
			return "rechercherAssuranceId";
		} else {
			rda.addAttribute("msg", "L'assurance recherchée n'existe pas encore !");
			return "rechercherAssuranceId";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE ASSURANCE PAR SON
	 * DOSSIER
	 */
	@RequestMapping(value = "/rechercherAssuranceDossier", method = RequestMethod.GET)
	public ModelAndView afficherGetAssuranceByDossier() {
		return new ModelAndView("rechercherAssuranceDossier", "aRech", new Assurance());
	}

	@RequestMapping(value = "/soumettreRechercherAssuranceDossier", method = RequestMethod.POST)
	public String soumettreGetAssuranceByDossier(ModelMap modele, @ModelAttribute(value = "aRech") Assurance aRech,
			RedirectAttributes rda) {

		// Appel de la méthode service pour chercher une assurance par son
		// dossier
		Assurance assurOut = assuranceService.getAssuranceByDossier(aRech);

		if (assurOut != null) {
			modele.addAttribute("aFind", assurOut);
			return "rechercherAssuranceDossier";
		} else {
			rda.addAttribute("msg", "L'assurance recherchée n'existe pas encore !");
			return "rechercherAssuranceDossier";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE MODIFICATION D'UNE ASSURANCE
	 */
	/**
	 * 1. Méthode permettant d'afficher le formulaire de modification de
	 * l'assurance
	 */
	@RequestMapping(value = "/modifierAssurance", method = RequestMethod.GET)
	public String afficherFormUpdateAssurance(Model modele) {
		modele.addAttribute("aUpdate", new Assurance());
		return "modifierAssurance";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire de modification de
	 * l'assurance
	 */
	@RequestMapping(value = "/soumettreModifierAssurance", method = RequestMethod.POST)
	public String soumettreUpdateAssurance(@ModelAttribute("aUpdate") Assurance assurModif, RedirectAttributes rda) {

		// Appel de la méthode service pour modifier une assurance
		Assurance assurOut = assuranceService.updateAssurance(assurModif);

		if (assurOut != null) {
			return "redirect:listeAssurance";
		} else {
			rda.addAttribute("msg", "Cette assurance n'a pas pu être modifiée, veuillez réessayer !");
			return "redirect:modifierAssurance";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE SUPPRESSION D'UNE ASSURANCE
	 */
	/**
	 * 1. Méthode permettant d'afficher le formulaire de suppression de
	 * l'assurance
	 */
	@RequestMapping(value = "/supprimerAssurance", method = RequestMethod.GET)
	public String afficherFormDeleteAssurance(Model modele) {
		modele.addAttribute("aDelete", new Assurance());
		return "supprimerAssurance";
	}

	/**
	 * 2. Méthode permettant de soumettre le formulaire de suppression de
	 * l'assurance
	 */
	@RequestMapping(value = "/soumettreDeleteAssurance", method = RequestMethod.POST)
	public String soumettreDeleteAssurance(@ModelAttribute("aDelete") Assurance assurSuppr, RedirectAttributes rda) {

		/** Appel de la méthode service pour ajouter une destination */
		Assurance assurOut = assuranceService.deleteAssurance(assurSuppr);

		if (assurOut != null) {
			return "redirect:listeAssurance";
		} else {
			rda.addAttribute("msg", "Cette assurance n'a pas pu être supprimée, veuillez réessayer !");
			return "redirect:supprimerAssurance";
		}

	}
	
	//methode pour recuperer le template 
		@RequestMapping(method = RequestMethod.GET, value = "templateTest")
		public String newItem(Model model) {
		    return "shared/template/templateTest";
		}

}
