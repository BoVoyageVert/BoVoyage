package fr.adaming.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

/**
 * @author Amandine Classe Controller Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * Transformation association UML en Java
	 */
	private IAdminService adminService;
	/**
	 * Setter pour ID
	 */

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public IAdminService getAdminService() {
		return adminService;
	}
	
	/** Amandine : méthodeafficher page d'accueil Admin */
	@RequestMapping(value = "/accueilAdmin", method = RequestMethod.GET)
	public ModelAndView afficherAccueilAdmin() {
		return new ModelAndView("accueilAdmin");
	}

	/**
	 * Amandine : Méthode recupper la liste
	 */
	@RequestMapping(value = "/listeAdmin", method = RequestMethod.GET)
	public ModelAndView afficherListeAdmin() {
		// recup liste de Service
		List<Admin> listeAdmin= adminService.getAllAdmin();
		return new ModelAndView("listeAdmin", "allAdmin", listeAdmin);
	}
	
	
	/**
	 * Amandine : Méthode ajouter un admin
	 */
	@RequestMapping(value = "/ajouterAdmin", method = RequestMethod.GET)
	public String afficherFormAjoutAdmin(Model model) {
		model.addAttribute("adAjout", new Admin());
		return "ajouterAdmin";
	}

	@RequestMapping(value = "/soumettreAjoutAdmin", method = RequestMethod.POST)
	public String soumettreAjouterAdmin(@ModelAttribute("adAjout") Admin adIn,
			RedirectAttributes rda) {
		Admin verif = adminService.addAdmin(adIn);
		if (verif != null) {
			return "redirect:listeAdmin";
		} else {
			rda.addAttribute("msg", "L'ajout d'un nouvel admin a echoué!");
			return "redirect:ajouterAdmin";
		}
	}
	/**
	 * Amandine : Méthode security admin
	 */
	@RequestMapping(value = "/loginPageAdmin", method = RequestMethod.GET)
	public String afficheFormLogin() {
		return "loginPageAdmin";
	}

	// Methode appelée dans le cas ou l'acces et refusé
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String afficheDenied() {
		return "deniedPage";
	}

	// methode appelée dans le cas où l'authentification a echoué
	@RequestMapping(value = "/echec", method = RequestMethod.GET)
	public String afficheEchec(ModelMap modele) {
		modele.addAttribute("erreur", true);
		return "loginPage";
	}

	// methode appelée dans lors de la deconnexion
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String afficheLogout(Model model, HttpServletRequest req) {
		
		req.getSession().invalidate();
		model.addAttribute("msg", true);
		return "accueilClient";
	}
	
	
	
}
