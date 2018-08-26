package fr.adaming.controllers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import fr.adaming.model.Hebergement;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Loisir;
import fr.adaming.model.Voiture;
import fr.adaming.model.Voyage;
import fr.adaming.service.IHebergementService;
import fr.adaming.service.ILoisirService;
import fr.adaming.service.IVoitureService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	
	
	/**
	 * la ligne de commande
	 */
	private LigneCommande ligneCommande;
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	/**
	 * Transfo de l'association
	 */
	@Autowired
	IVoitureService vService;
	public void setvService(IVoitureService vService) {
		this.vService = vService;
	}

	@Autowired
	IHebergementService hService;
	public IHebergementService gethService() {
		return hService;
	}
	
	
	@Autowired
	ILoisirService lService;
	public void setlService(ILoisirService lService) {
		this.lService = lService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// web databinder sert � lier les params de la req aux objets java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	/** steven : recup du formulaire de la r�servation du voyage */
	@RequestMapping(value = "/reserverVoyage", method = RequestMethod.GET)
	public String afficherFormAjouterClient(Model modele) {
		modele.addAttribute("vReserv", new Voyage());
		return "reserverVoyage";
	}
	
	/** steven : soumission de la r�servation du voyage */
	@RequestMapping(value = "/soumettreReserverVoyage", method = RequestMethod.POST)
	public String soumettreReserverVoyage(@ModelAttribute("vReserv") Voyage vIn, RedirectAttributes rda, HttpServletRequest req) {
	/** mettre le voyage r�serv� dans la session*/
		if (vIn != null) {
		req.getSession().setAttribute("voyage", vIn);
			return "redirect:reserverHebergement";
		} else {
			rda.addAttribute("msg", "Vous devez reserver un voyage !");
			return "redirect:reserverVoyage";
		}
	}
	
	/** steven : recup du formulaire de la r�servation de l'h�bergement */
	@RequestMapping(value = "/reserverHebergement", method = RequestMethod.GET)
	public String afficherFormReserverHebergement(Model modele) {
		modele.addAttribute("hReserv", new Hebergement());
		modele.addAttribute("allHeberg", hService.getAllHebergement());
		modele.addAttribute("lcHeberg", new LigneCommande());
		return "reserverHebergement";
	}
	
	/** steven : soumission de la r�servation de l'h�bergement */
	@RequestMapping(value = "/soumettreReserverHebergement", method = RequestMethod.POST)
	public String soumettreReserverHebergement(@ModelAttribute("hReserv") Hebergement hIn, @ModelAttribute("lcHeberg") LigneCommande lcIn, RedirectAttributes rda, HttpServletRequest req) {
	
		if (hIn != null && lcIn != null) { 
			
			/**
			 * r�cup�rer l'h�bergement � partir du num
			 */
			hIn = hService.getHebergementByNum(hIn);
			
			/**
			 * remplir la ligne de commande
			 */
			
			lcIn.setTypePrestation("H�bergement");
			lcIn.setDesignation(hService.getHebergementById(hIn).getType());
			
			Voyage voy = (Voyage) req.getSession().getAttribute("voyage");
			Date date1 = voy.getDateArrivee();
			Date date2 = voy.getDateDepart();
			int jours1=(int) (date1.getTime()/(1000*60*60*24));
			int jours2=(int) (date2.getTime()/(1000*60*60*24));
			int jours = jours2-jours1;
			System.out.println("la diff�rence est : "+jours);
			
			lcIn.setQuantite(jours);
			lcIn.setPrixNormal(hService.getHebergementById(hIn).getPrix()*jours);
			lcIn.setPrixPromotion(hService.getHebergementById(hIn).getReduction()*jours);
			
			/**
			 * rajouter la ligne de commande au panier
			 */
			List<LigneCommande> liste = (List<LigneCommande>) req.getSession().getAttribute("panier");
			if(liste != null){
				liste.add(lcIn);
			}else{
				liste = new ArrayList<LigneCommande>();
				liste.add(lcIn);
			}
			req.getSession().setAttribute("panier", liste);
			
			return "redirect:reserverLoisir";
		} else {
			rda.addAttribute("msg", "Vous devez reserver un h�bergement !");
			return "redirect:reserverHebergement";
		}
	}
	
	/** steven : recup du formulaire de la r�servation des loisirs */
	@RequestMapping(value = "/reserverLoisir", method = RequestMethod.GET)
	public String afficherFormReserverLoisir(Model modele) {
		modele.addAttribute("lReserv", new Loisir());
		modele.addAttribute("allLoisir", lService.getAllLoisir());
		modele.addAttribute("lcLoisir", new LigneCommande());
		return "reserverLoisir";
	}
	
	/** steven : soumission de la r�servation du loisir */
	@RequestMapping(value = "/soumettreReserverLoisir", method = RequestMethod.POST)
	public String soumettreReserverLoisir(@ModelAttribute("lReserv") Loisir lIn, @ModelAttribute("lcLoisir") LigneCommande lcIn, RedirectAttributes rda, HttpServletRequest req) {
		if (lIn != null) { 
			// petite magouille qui passe inaper�ue
			lcIn.setQuantite(lIn.getIdLoisir());
			/**
			 * r�cup�rer le loisir � partir du nom
			 */
			lIn = lService.getLoisirByNom(lIn);
			
			/**
			 * remplir la ligne de commande
			 */
			
			lcIn.setTypePrestation("Loisir");
			lcIn.setDesignation(lService.getLoisirById(lIn).getNom());
			
			lcIn.setPrixNormal(lService.getLoisirById(lIn).getPrix()*lcIn.getQuantite());
			lcIn.setPrixPromotion(lService.getLoisirById(lIn).getReduction()*lcIn.getQuantite());
			
			/**
			 * rajouter la ligne de commande au panier
			 */
			List<LigneCommande> liste = (List<LigneCommande>) req.getSession().getAttribute("panier");
			if(liste != null){
				liste.add(lcIn);
			}else{
				liste = new ArrayList<LigneCommande>();
				liste.add(lcIn);
			}
			req.getSession().setAttribute("panier", liste);
		}
		return "redirect:reserverLoisir";
	}
	
	
	
	
	
	
	
	
	
	
}
