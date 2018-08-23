package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Voyage;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	IClientService clService;
	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	
	/** steven : recup de la liste des voyages */
	@RequestMapping(value="/listeClients", method=RequestMethod.GET)
	public ModelAndView afficherListeClients(){
		// recup la liste de service
		List<Client> listeClients = clService.getAllClients();
		return new ModelAndView("listeClients", "allClients", listeClients);
	}
	
	
	/** steven : recup du formulaire d'ajout */
	@RequestMapping(value="/ajouterClient", method=RequestMethod.GET)
	public String afficherFormAjouterClient(Model modele){
			modele.addAttribute("clAjout", new Voyage());
			return "ajouterClient";
	}
	/** steven : soumission de l'ajout */
	@RequestMapping (value="/soumettreAjouterClient", method=RequestMethod.POST)
	public String soumettreAjouterClient(@ModelAttribute("clAjout") Client clIn, RedirectAttributes rda){
		int verif = clService.addClient(clIn);
		if (verif != 0){
			return "redirect:listeClients";
		}else{
			rda.addAttribute("msg","L'ajout du client a échoué !");
			return "redirect:ajouterClient";}
		}	

}
