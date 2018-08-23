package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/voyage")
public class VoyageController {
	
	/** steven : transformation de l'association */
	@Autowired
	IVoyageService vService;
	public void setvService(IVoyageService vService) {
		this.vService = vService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// web databinder sert à lier les params de la req aux objets java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	/** steven : recup de la liste des voyages */
		@RequestMapping(value="/listeVoyages", method=RequestMethod.GET)
		public ModelAndView afficherListeVoyages(){
			// recup la liste de service
			List<Voyage> listeVoyages = vService.getAllVoyages();
			return new ModelAndView("listeVoyages", "allVoyages", listeVoyages);
		}
	
	
	
		/** steven : recup du formulaire de modification */
			@RequestMapping(value="/modifierVoyage", method=RequestMethod.GET)
			public String afficherFormModifierVoyage(Model modele){
					modele.addAttribute("vModif", new Voyage());
					return "modifierVoyage";
			}
			/** steven : soumission de la modification */
			@RequestMapping (value="/soumettreModifierVoyage", method=RequestMethod.POST)
			public String soumettreModifierVoyage(@ModelAttribute("vModif") Voyage vIn, RedirectAttributes rda){
				int verif = vService.updateVoyage(vIn);
				if (verif != 0){
					return "redirect:listeVoyages";
				}else{
					rda.addAttribute("msg","La modification du voyage a échoué !");
					return "redirect:modifierVoyage";}
				}
			/** steven : recup du formulaire d'ajout */
			@RequestMapping(value="/ajouterVoyage", method=RequestMethod.GET)
			public String afficherFormAjouterVoyage(Model modele){
					modele.addAttribute("vAjout", new Voyage());
					return "ajouterVoyage";
			}
			/** steven : soumission de l'ajout */
			@RequestMapping (value="/soumettreAjouterVoyage", method=RequestMethod.POST)
			public String soumettreAjouterVoyage(@ModelAttribute("vAjout") Voyage vIn, RedirectAttributes rda){
				int verif = vService.addVoyage(vIn);
				if (verif != 0){
					return "redirect:listeVoyages";
				}else{
					rda.addAttribute("msg","L'ajout du voyage a échoué !");
					return "redirect:ajouterVoyage";}
				}			
			
			/** steven : recup du formulaire de suppression */
			@RequestMapping(value="/supprimerVoyage", method=RequestMethod.GET)
			public String afficherFormSupprimerVoyage(Model modele){
					modele.addAttribute("vSuppr", new Voyage());
					return "supprimerVoyage";
			}
			/** steven : soumission de la suppression */
			@RequestMapping (value="/soumettreSupprimerVoyage", method=RequestMethod.POST)
			public String soumettreSupprimerVoyage(@ModelAttribute("vSuppr") Voyage vIn, RedirectAttributes rda){
				int verif = vService.deleteVoyage(vIn);
				if (verif != 0){
					return "redirect:listeVoyages";
				}else{
					rda.addAttribute("msg","La suppression du voyage a échoué !");
					return "redirect:supprimerVoyage";}
				}			
			
			/** steven : recup du formulaire de recherche */
			@RequestMapping(value="/rechercherVoyage", method=RequestMethod.GET)
			public String afficherFormRechercherVoyage(Model modele){
					modele.addAttribute("vRech", new Voyage());
					return "rechercherVoyage";
			}
			/** steven : soumission de la recherche */
			@RequestMapping (value="/soumettreRechercherVoyage", method=RequestMethod.POST)
			public String soumettreRechercherVoyage(@ModelAttribute("vRech") Voyage vIn, RedirectAttributes rda){
				Voyage vOut = vService.getVoyageById(vIn);
				if (vOut != null){
					return "redirect:listeVoyages";
				}else{
					rda.addAttribute("msg","La recherche du voyage a échoué !");
					return "redirect:rechercherVoyage";}
				}		
			
	
	
	
	

}
