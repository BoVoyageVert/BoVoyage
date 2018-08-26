package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Destination;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Voyage;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/dossier")
public class DossierController {

	/** Transformation de l'association UML en Java */
	@Autowired
	private IDossierService dossierService;

	/** Setter pour l'injection d�pendance */
	public void setDossierService(IDossierService dossierService) {
		this.dossierService = dossierService;
	}

	/**
	 * >>>>>>>>>>>> FONCTIONNALITE DE RECUPERATION DE LA LISTE DE DOSSIERS
	 */
	@RequestMapping(value = "/listeDossier", method = RequestMethod.GET)
	public ModelAndView afficheListeDossier() {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		// Appel de la m�thode service pour r�cup�rer la liste des destinations

		List<DossierVoyage> listeDossier = dossierService.getDossierByIdClient(cl);

		return new ModelAndView("listeDossier", "allDossier", listeDossier);

	}

	/** >>>>>>>>>>>> FONCTIONNALITE D'AJOUT D'UN DOSSIER */
	/**
	 * 1. M�thode permettant d'afficher le formulaire d'ajout du dossier
	 */
	@RequestMapping(value = "/ajouterDossier", method = RequestMethod.GET)
	public String afficherFormAddDossier(Model modele) {
		modele.addAttribute("dossAjout", new DossierVoyage());
		return "ajouterDossier";
	}

	/**
	 * 2. M�thode permettant de soumettre le formulaire d'ajout du dossier
	 */
	@RequestMapping(value = "/soumettreAjouterDossier", method = RequestMethod.POST)
	public String soumettreAddDestination(@ModelAttribute("dossAjout") DossierVoyage dv, RedirectAttributes rda) {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		/** Appel de la m�thode service pour ajouter une destination */
		DossierVoyage dossOut = dossierService.addDossier(dv, v, cl);

		if (dossOut.getIdDossier() != 0) {
			return "redirect:listeDossier";
		} else {
			rda.addAttribute("msg", "Ce dossier n'a pas pu �tre ajout�, veuillez r�essayer !");
			return "redirect:ajouterDossier";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UN DOSSIER PAR SON ID
	 */
	@RequestMapping(value = "/rechercherDossierId", method = RequestMethod.GET)
	public ModelAndView afficherGetDossierById() {
		return new ModelAndView("rechercherDossierId", "dossRech", new DossierVoyage());
	}

	@RequestMapping(value = "/soumettreRechercherDossierId", method = RequestMethod.POST)
	public String soumettreGetDestinationById(ModelMap modele, @ModelAttribute(value = "dossRech") DossierVoyage dv,
			RedirectAttributes rda) {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		DossierVoyage dossOut = dossierService.getDossierById(dv, v, cl);

		if (dossOut != null) {
			modele.addAttribute("dossFind", dossOut);
			return "rechercherDossierId";
		} else {
			rda.addAttribute("msg", "Le dossier recherch� n'existe pas encore !");
			return "rechercherDossierId";
		}
	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE RECHERCHE D'UNE DESTINATION PAR
	 * SON NOM
	 */
	@RequestMapping(value = "/rechercherDossierNum", method = RequestMethod.GET)
	public ModelAndView afficherGetDossierByNum() {
		return new ModelAndView("rechercherDossierNum", "dossRech", new DossierVoyage());
	}

	@RequestMapping(value = "/soumettreRechercherDossierNum", method = RequestMethod.POST)
	public String soumettreGetDestinationByNom(ModelMap modele,
			@ModelAttribute(value = "dossRech") DossierVoyage dossRech, RedirectAttributes rda) {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		DossierVoyage dossOut = dossierService.getDossierById(dossRech, v, cl);

		if (dossOut != null) {
			modele.addAttribute("dossFind", dossOut);
			return "rechercherDossierNum";
		} else {
			rda.addAttribute("msg", "Le dossier recherch� n'existe pas encore !");
			return "rechercherDossierNum";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE MODIFICATION D'UN DOSSIER
	 */
	/**
	 * 1. M�thode permettant d'afficher le formulaire de modification du dossier
	 */
	@RequestMapping(value = "/modifierDossier", method = RequestMethod.GET)
	public String afficherFormUpdateDossier(Model modele) {
		modele.addAttribute("dossUpdate", new DossierVoyage());
		return "modifierDossier";
	}

	/**
	 * 2. M�thode permettant de soumettre le formulaire de modification du
	 * dossier
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreModifierDossier", method = RequestMethod.POST)
	public String soumettreUpdateDossier(@ModelAttribute("dossUpdate") DossierVoyage dossModif,
			RedirectAttributes rda) {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		/** Appel de la m�thode service pour ajouter une destination */
		DossierVoyage dossierModif = dossierService.updateDossier(dossModif, v, cl);

		if (dossierModif != null) {
			return "redirect:listeDossier";
		} else {
			rda.addAttribute("msg", "Ce dossier n'a pas pu �tre modifi�, veuillez r�essayer !");
			return "redirect:modifierDossier";
		}

	}

	/**
	 * >>>>>>>>>>>>>>>>>>>> FONCTIONNALITE DE SUPPRESSION D'UN DOSSIER
	 */
	@RequestMapping(value = "/supprimerDossier", method = RequestMethod.GET)
	public String afficherFormDeleteDossier(Model modele) {
		modele.addAttribute("dossDelete", new DossierVoyage());
		return "supprimerDossier";
	}

	/**
	 * 2. M�thode permettant de soumettre le formulaire de suppression du
	 * dossier
	 */
	@RequestMapping(value = "/soumettreDeleteDossier", method = RequestMethod.POST)
	public String soumettreDeleteDossier(@ModelAttribute("dossDelete") DossierVoyage dossSuppr,
			RedirectAttributes rda) {

		Voyage v = new Voyage();
		v.setId(v.getId());

		Client cl = new Client();
		cl.setIdClient(cl.getIdClient());

		/** Appel de la m�thode service pour ajouter une destination */
		DossierVoyage dossierSuppr = dossierService.deleteDossier(dossSuppr, v, cl);

		if (dossierSuppr != null) {
			return "redirect:listeDossier";
		} else {
			rda.addAttribute("msg", "Ce dossier n'a pas pu �tre supprim�, veuillez r�essayer !");
			return "redirect:supprimerDossier";
		}

	}

}
