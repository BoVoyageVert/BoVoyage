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

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	IClientService clService;
	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// web databinder sert à lier les params de la req aux objets java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
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
			modele.addAttribute("clAjout", new Client());
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
	
	/** steven : recup du formulaire de modification */
	@RequestMapping(value="/modifierClient", method=RequestMethod.GET)
	public String afficherFormModifierClient(Model modele){
		modele.addAttribute("clModif", new  Client() );
		return "modifierClient";
	}
	/** steven : soumission de la modification */
	@RequestMapping(value="/soumettreModifierClient", method=RequestMethod.POST)
	public String soumettreModifierClient(@ModelAttribute("clModif") Client clIn, RedirectAttributes rda){
		int verif = clService.updateClient(clIn);
		if(verif != 0){
			return "redirect:listeClients";
		}else {
			rda.addAttribute("msg", "La modification du client a échoué");
			return "redirect:modifClient";
		}
	}
	/** steven : recup du formulaire de suppression */
	@RequestMapping(value="/supprimerClient", method=RequestMethod.GET)
	public String afficherFormSupprimerClient(Model modele){
		modele.addAttribute("clSuppr",new Client());
		return "supprimerClient";
	}
	/** steven : soumission de la suppression */
	@RequestMapping(value="/soumettreSupprimerClient", method=RequestMethod.POST)
	public String soumettreSupprimerClient(@ModelAttribute(value="clSuppr") Client clIn, RedirectAttributes rda){
		int verif = clService.deleteClient(clIn);
		if(verif != 0){
			return "redirect:listeClients";
		}else{
			return "redirect:supprimerClient";
		}
	}
	/** steven : recup du formulaire de recherche par ID */
	@RequestMapping(value="/rechercherClientById", method=RequestMethod.GET)
	public String afficherFormRechercherClientById(Model modele){
		modele.addAttribute("clRechById",new Client());
		return "rechercherClientById";
	}
	/** steven : soumission de la recherche par ID */
	@RequestMapping(value="/soumettreRechercherClientById", method=RequestMethod.POST)
	public String soumettreRechercherClientById(@ModelAttribute(value="clRechById") Client clIn, RedirectAttributes rda){
		Client clOut = clService.getClientById(clIn);
		if (clOut != null){
			return "redirect:listeClients";
		}else {
			return "redirect:rechercherClientById";
		}
	}
	/** steven : recup du formulaire de recherche par num */
	@RequestMapping(value="/rechercherClientByNum", method= RequestMethod.GET)
	public String afficherFormRechercherClientByNum(Model modele){
		
		modele.addAttribute("clRechByNum", new Client());
		return "rechercherClientByNum";
	}
	
	/** steven : soumission de la recherche par num */
	@RequestMapping(value="/soumettreRechercherClientByNum", method=RequestMethod.POST)
	public String soumettreRechercherClientByNum(@ModelAttribute(value="clRechByNum") Client clIn, RedirectAttributes rda){
		Client clOut = clService.getClientByNum(clIn);
		if (clOut != null){
			return "redirect:listeClients";
		}else{
			return "redirect:rechercherClientByNum";
		}
	}
	
	
	

}
