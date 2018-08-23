package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fr.adaming.model.Loisir;
import fr.adaming.model.Voyage;
import fr.adaming.service.ILoisirService;

@Controller
@RequestMapping("/loisir")
public class LoisirController {
	
	/**claire: transformation de l'association uml en java*/
	@Autowired
	private ILoisirService loisirService;

	/**Getters et setters*/
	public ILoisirService getLoisirService() {
		return loisirService;
	}

	public void setLoisirService(ILoisirService loisirService) {
		this.loisirService = loisirService;
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	/** claire: Methodes */ 
	
	/** Afficher la liste */
	@RequestMapping(value = "/listeLoisir", method = RequestMethod.GET)
	public ModelAndView afficherListeLoisir() {
		
		/**Recuperer la liste */ 
		List<Loisir> loisirListe = loisirService.getAllLoisir();
		
		return new ModelAndView("listeLoisir", "allLoisirs", loisirListe);
	}

	/**claire: Ajouter un loisir */
	/**claire: methode get */
	@RequestMapping(value = "/ajouterLoisir", method = RequestMethod.GET)
	public ModelAndView afficherFormAddLoisir() {	
		return new ModelAndView ("ajouterLoisir", "lAjout", new Loisir());	
	}
	/**claire: methode post */
	@RequestMapping(value = "/soumettreAjouterLoisir", method = RequestMethod.POST)
	public String soumettreAjouterLoisir(Model model, @ModelAttribute("lAjout") Loisir lIn, RedirectAttributes rdl) {
		
		 /** Appel de la methode service */ 
		Loisir lOut = loisirService.addLoisir(lIn);
		
		if (lOut.getIdLoisir() != 0) {

			return "redirect:listeLoisir";

		} else {
			rdl.addAttribute("msg", "Impossible d'ajouter ce loisir");

			return "redirect:ajouterLoisir";
		}	
	}
	/** Rechercher un Loisir par sa categorie*/
	/**Methode get*/
	@RequestMapping(value = "/rechercherLoisir", method = RequestMethod.GET)
	public ModelAndView afficherRechercherLoisir() {
	
		return new ModelAndView("rechercherLoisir", "lRech", new Loisir());
	}
	/**Methode post*/
	@RequestMapping(value = "/soumettreRechLoisirByCat", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("lRech") Loisir l, RedirectAttributes rdl) {
		/** appel de la methode service pour Rechercher un Loisir*/
		Loisir loisirRech = loisirService.getLoisirByCat(l);

		if (loisirRech != null) {
			model.addAttribute("lFind", loisirRech );
			 return "rechercherLoisirByCat";

		} else {
			rdl.addAttribute("msg", "Recherche, impossible!");
			return "redirect:rechercherLoisir";
		}
		
	}
	

	
}
