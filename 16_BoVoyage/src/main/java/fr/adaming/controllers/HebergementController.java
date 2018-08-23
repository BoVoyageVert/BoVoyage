package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hebergement;
import fr.adaming.service.IHebergementService;

/** 
 * 
 * @author Amandine
 * Classe Controller Hebergement
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
	
	/** 
	 * Méthode recupper la liste
	 */
	@RequestMapping(value="/listeHebergement", method=RequestMethod.GET)
	public ModelAndView afficherListeHebergement(){
	//recup liste de Service
		List<Hebergement> listeHebergement =hebergementService.getAllHebergement();
		return new ModelAndView("listeHebergement", "allHebergement", listeHebergement);
	}
	
	/** 
	 * Méthode ajouter un hebergement
	 */
	@RequestMapping(value = "/ajouterHebergement", method = RequestMethod.GET)
	public String afficherFormAjoutHebergement (Model model){
		model.addAttribute("hAjout", new Hebergement());
		return "ajouterHerbergement";
	}
	@RequestMapping(value = "/soumettreAjoutHebergement", method = RequestMethod.POST)
	public String soumettreAjouterHebergement (@ModelAttribute("hAjout") Hebergement hIn, RedirectAttributes rda){
		Hebergement verif =hebergementService.addHebergement(hIn);
		if(verif!=null){
			return "redirect:listeHebergement";
		}else{
			rda.addAttribute("msg", "L'ajout d'un nouvel hebergement a echoué!");
			return "redirect:ajouterHerbergement";
		}
	}
	
	

}
