package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;
import fr.adaming.service.IHebergementService;

/**
 * 
 * @author Amandine Classe Controller Hebergement
 *
 */
@Controller
@RequestMapping("/hebergement")
public class HebergementController {

	/**
	 * Transformation association UML en Java
	 */
	@Autowired
	private IHebergementService hebergementService;

	/**
	 * Setter pour ID
	 */

	public void setHebergementService(IHebergementService hebergementService) {
		this.hebergementService = hebergementService;
	}

	private Voyage voyage;

	/**
	 * Amandine: Méthode recupper la liste
	 */
	@RequestMapping(value = "/listeHebergement", method = RequestMethod.GET)
	public ModelAndView afficherListeHebergement() {
		// recup liste de Service
		List<Hebergement> listeHebergement = hebergementService.getAllHebergement();
		return new ModelAndView("listeHebergement", "allHebergement", listeHebergement);
	}

	/**
	 * Amandine : Méthode ajouter un hebergement
	 */
	@RequestMapping(value = "/ajouterHebergement", method = RequestMethod.GET)
	public String afficherFormAjoutHebergement(Model model) {
		model.addAttribute("hAjout", new Hebergement());
		return "ajouterHebergement";
	}

	@RequestMapping(value = "/soumettreAjoutHebergement", method = RequestMethod.POST)
	public String soumettreAjouterHebergement(@ModelAttribute("hAjout") Hebergement hIn, Voyage vIn,
			RedirectAttributes rda) {
		Hebergement verif = hebergementService.addHebergement(hIn, vIn);
		if (verif != null) {
			return "redirect:listeHebergement";
		} else {
			rda.addAttribute("msg", "L'ajout d'un nouvel hebergement a echoué!");
			return "redirect:ajouterHebergement";
		}
	}

	
	/**
	 * Amandine: Méthode modifier un hebergement
	 */
	@RequestMapping(value = "/modifierHebergement", method = RequestMethod.GET)
	public String afficherFormModifierHebergement(Model model) {
		model.addAttribute("hModifier", new Hebergement());
		return "modifierHebergement";
	
}

	@RequestMapping(value = "/soumettreModifierHebergement", method = RequestMethod.POST)
	public String soumettreModifierHebergement(@ModelAttribute("hModifier") Hebergement hIn,
			RedirectAttributes rda) {
		int verif = hebergementService.updateHebergement(hIn);
		if (verif != 0) {
			return "redirect:listeHebergement";
		} else {
			rda.addAttribute("msg", "La modification d'un nouvel hebergement a echoué!");
			return "redirect:modifierHebergement";
		}
	}
	
	/**
	 * Amandine : Méthode rechercher un hebergement
	 */
	@RequestMapping(value = "/rechercherHebergementU", method = RequestMethod.GET)
	public ModelAndView afficheRechercheHebergementById() {
		return new ModelAndView("rechercherHebergement", "hRecherche", new Hebergement());
	}

	@RequestMapping(value = "/soumettreRechercheHebergementU", method = RequestMethod.POST)
	public String soumettreRechFormHebergementById(ModelMap modele, RedirectAttributes rda, @ModelAttribute("hRech") Hebergement hIn) {
		Hebergement verif = hebergementService.getHebergementById(hIn);

		if (verif != null) {
			modele.addAttribute("hRecherche", verif);
			return "rechercherHebergement";
		} else {
			rda.addAttribute("msg", "L'hebergement n'existe pas!");
			return "redirect:rechercherHebergement";
		}
	}
	
	
	
	
	/**
	 * Méthode supprimer un hebergement
	 */
	@RequestMapping(value = "/supprimerHebergement", method = RequestMethod.GET)
	public String afficheSupprimerHebergement(Model model) {
		model.addAttribute("hSupprimer", new Hebergement());
		return "supprimerHebergement";
	}
	@RequestMapping (value="/soumettreSupprimerHebergement", method=RequestMethod.POST)
	public String soumettreSupprimerHebergement(@ModelAttribute("hSupprimer") Hebergement hIn, RedirectAttributes rda){
		int verif = hebergementService.deleteHebergement(hIn);
		if (verif != 0){
			return "redirect:listeHebergement";
		}else{
			rda.addAttribute("msg","La suppression de l'hébergement a échoué !");
			return "redirect:supprimerHebergement";}
		}			

	
}
