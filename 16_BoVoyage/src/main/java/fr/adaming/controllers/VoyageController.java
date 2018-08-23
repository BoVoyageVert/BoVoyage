package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	
	
		/** steven : recup du formulaire d'ajout */
			@RequestMapping(value="/ajouterVoyage", method=RequestMethod.GET)
			public String afficherFormAddVoyage(Model modele){
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
	
	
	
	

}
