package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fr.adaming.model.Pack;
import fr.adaming.service.IPackService;

/**
 * @author Amandine Classe Controller pack
 */
@Controller
@RequestMapping("/pack")
public class PackController {
	/**
	 * Transformation association UML en Java
	 */
	@Autowired
	private IPackService packService;
	/**
	 * Setter pour ID
	 */
	
	public void setPackService(IPackService packService) {
		this.packService = packService;
		
	}
	
	public FileUpload getFile() {
		return file;
	}

	public void setFile(FileUpload file) {
		this.file = file;
	}

	private FileUpload file;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// web databinder sert à lier les params de la req aux objets java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	/**
	 * Methode pour recuperer les images et envoyer à la page jsp
	 */
	@RequestMapping(value="/getImage", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte [] recupImage(@RequestParam("pId") int id) throws IOException{
		Pack packImage= new Pack();
		packImage.setId(id);
		Pack pack=packService.getPacktById(packImage);
		if(pack.getPhoto()==null){
			return new byte [0];
		}else{
			return IOUtils.toByteArray(new ByteArrayInputStream(pack.getPhoto()));
		}
	}
	
	
	
	/**
	 * Amandine: Méthode recupper la liste des pack
	 */
	@RequestMapping(value = "/listePack", method = RequestMethod.GET)
	public ModelAndView afficherListePack() {
		// recup liste de Service
		List<Pack> listePack = packService.getAllPack();
		return new ModelAndView("listePack", "allPack", listePack);
	
	}
	
	/**
	 * Amandine : Méthode ajouter un pack
	 */
	@RequestMapping(value = "/ajouterPack", method = RequestMethod.GET)
	public String afficherFormAjoutPack(Model model) {
		model.addAttribute("pAjout", new Pack());
		return "ajouterPack";
	}

	@RequestMapping(value = "/soumettreAjoutPack", method = RequestMethod.POST)
	public String soumettreAjouterHebergement(@ModelAttribute("pAjout") Pack pIn,
			RedirectAttributes rda, MultipartFile file) throws IOException{
	if(file!=null){
		//transformation de l'image en tableau de byte
		pIn.setPhoto(file.getBytes());
	}
		
		
		Pack verif = packService.addPack(pIn);
		if (verif != null) {
			//transformer l'image en tableau de byte
			
			return "redirect:listePack";
		} else {
			rda.addAttribute("msg", "L'ajout d'un nouvel nouveau pack a echoué!");
			return "redirect:ajouterPack";
		}
	}
	
	
	/**
	 * Amandine : Méthode ajouter un pack
	 */
	@RequestMapping(value = "/ajouterPackClient", method = RequestMethod.GET)
	public String afficherFormAjoutPackClient(Model model) {
		model.addAttribute("pcAjout", new Pack());
		return "ajouterPackClient";
	}

	@RequestMapping(value = "/soumettreAjoutPackClient", method = RequestMethod.POST)
	public String soumettreAjouterPackClient(@ModelAttribute("pcAjout") Pack pIn,
			RedirectAttributes rda, MultipartFile file) throws IOException{
	if(file!=null){
		//transformation de l'image en tableau de byte
		pIn.setPhoto(file.getBytes());
	}
		
		
		Pack verif = packService.addPack(pIn);
		if (verif != null) {
			//transformer l'image en tableau de byte
			
			return "redirect:listePack";
		} else {
			rda.addAttribute("msg", "La selection du pack a echoué!");
			return "redirect:ajouterPackClient";
		}
	}
	
	
	/**
	 * Amandine: Méthode modifier un hebergement
	 */
	@RequestMapping(value = "/modifierPack", method = RequestMethod.GET)
	public String afficherFormModifierPack(Model model) {
		model.addAttribute("pModifier", new Pack());
		return "modifierPack";
	
}

	@RequestMapping(value = "/soumettreModifierPack", method = RequestMethod.POST)
	public String soumettreModifierHebergement(@ModelAttribute("pModifier") Pack pIn,
			RedirectAttributes rda, MultipartFile file) throws IOException{
		if(file!=null){
			//transformation de l'image en tableau de byte
			pIn.setPhoto(file.getBytes());
		}
		int verif = packService.updatePack(pIn);
		if (verif != 0) {
			return "redirect:listePack";
		} else {
			rda.addAttribute("msg", "La modification d'un nouveau pack a echoué!");
			return "redirect:modifierPack";
		}
	}
	
	/**
	 * Amandine : Méthode rechercher un pack par son nom
	 */
	@RequestMapping(value = "/rechercherPack", method = RequestMethod.GET)
	public ModelAndView afficheRecherchePackById() {
		return new ModelAndView("rechercherPack", "pRecherche", new Pack());
	}

	@RequestMapping(value = "/soumettreRechercherPack", method = RequestMethod.POST)
	public String soumettreRechFormPackById(ModelMap modele, RedirectAttributes rda, @ModelAttribute("pRech") Pack pIn, MultipartFile file) throws IOException {
		if(file!=null){
			//transformation de l'image en tableau de byte
			pIn.setPhoto(file.getBytes());
		}
		
		
		Pack verif = packService.getPacktById(pIn);

		if (verif != null) {
			modele.addAttribute("pRecherche", verif);
			return "rechercherPack";
		} else {
			rda.addAttribute("msg", "Le pack n'existe pas!");
			return "redirect:rechercherPack";
		}
	}
	
	
	/**
	 * Méthode supprimer un pack
	 */
	@RequestMapping(value = "/supprimerPack", method = RequestMethod.GET)
	public String afficheSupprimerPack(Model model) {
		model.addAttribute("pSupprimer", new Pack());
		return "supprimerPack";
	}
	@RequestMapping (value="/soumettreSupprimerPack", method=RequestMethod.POST)
	public String soumettreSupprimerHebergement(@ModelAttribute("pSupprimer") Pack pIn, RedirectAttributes rda){
		int verif = packService.deletePack(pIn);
		if (verif != 0){
			return "redirect:listePack";
		}else{
			rda.addAttribute("msg","La suppression du pack a échoué !");
			return "redirect:supprimerPack";}
		}		
	
	
	/**
	 * Amandine : Méthode page hebergement Admin
	 */
	@RequestMapping(value = "/listePackAdmin", method = RequestMethod.GET)
	public ModelAndView afficherListePackAdmin() {
		return new ModelAndView("listePackAdmin");
	}
	
}
