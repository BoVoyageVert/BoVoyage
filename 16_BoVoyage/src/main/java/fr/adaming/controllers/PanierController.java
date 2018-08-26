package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.IClientService;


@Controller
@RequestMapping("/panier")
public class PanierController {
	
	@Autowired
	private IClientService clService;
	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	int prixTotalNormal = 0;
	public int getPrixTotalNormal() {
		return prixTotalNormal;
	}
	public void setPrixTotalNormal(int prixTotalNormal) {
		this.prixTotalNormal = prixTotalNormal;
	}
	
	int prixTotalPromo = 0;
	public int getPrixTotalPromo() {
		return prixTotalPromo;
	}
	public void setPrixTotalPromo(int prixTotalPromo) {
		this.prixTotalPromo = prixTotalPromo;
	}

	/**
	 * le panier
	 */
	private List<LigneCommande> panier;
	public List<LigneCommande> getPanier() {
		return panier;
	}
	public void setPanier(List<LigneCommande> panier) {
		this.panier = panier;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// web databinder sert � lier les params de la req aux objets java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	
	/** steven : recup de la liste des lignes de commande */
		@RequestMapping(value="/panier", method=RequestMethod.GET)
		public String afficherPanier(HttpServletRequest req, Model modele){
			panier = (List<LigneCommande>) req.getSession().getAttribute("panier");
			prixTotalNormal = 0;
			for (LigneCommande lc : panier){
				prixTotalNormal += lc.getPrixNormal();
			}
			prixTotalPromo = 0;
			for (LigneCommande lc : panier){
				prixTotalPromo += lc.getPrixPromotion();
			}
			modele.addAttribute("allLigneCommande", panier);
			modele.addAttribute("prixTotalNormal", prixTotalNormal);
			modele.addAttribute("prixTotalPromo", prixTotalPromo);
			return "panier";
		}
		
		/** steven : demande de commande */
		@RequestMapping(value = "/soumettrePanier", method = RequestMethod.POST)
		public String soumettrePanier() {
		
				return "redirect:inscription";
			
		}
		
		
		/** steven : recup du formulaire de l'inscription */
		@RequestMapping(value = "/inscription", method = RequestMethod.GET)
		public String afficherFormInscription(Model modele) {
			modele.addAttribute("clInscrip", new Client());
			return "inscription";
		}
		
		/** steven : soumission de l'inscription */
		@RequestMapping(value = "/soumettreInscription", method = RequestMethod.POST)
		public String soumettreInscription(@ModelAttribute("clInscrip") Client clIn, RedirectAttributes rda, HttpServletRequest req) {
		/** enregistrer le client inscrit dans la base de données */
			if (clIn != null) {
				req.getSession().setAttribute("client", clIn);
				clService.addClient(clIn);
				return "redirect:confirmation";
			} else {
				rda.addAttribute("msg", "Vous devez vous inscrire !");
				return "redirect:inscription";
			}
		}
		
		/** steven : recup du formulaire de la page de confirmation */
		@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
		public String afficherFormConfirmation(Model modele, HttpServletRequest req) {
			panier = (List<LigneCommande>) req.getSession().getAttribute("panier");
			prixTotalPromo = 0;
			for (LigneCommande lc : panier){
				prixTotalPromo += lc.getPrixPromotion();
			}
			modele.addAttribute("allLigneCommande", panier);
			modele.addAttribute("prixTotalPromo", prixTotalPromo);
			return "confirmation";
		}
		
		
		
}
