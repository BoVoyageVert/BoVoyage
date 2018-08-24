package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fr.adaming.model.Hebergement;
import fr.adaming.model.Pack;
import fr.adaming.model.Voyage;
import fr.adaming.service.IHebergementService;

/**
 * 
 * @author Amandine Classe Controller Hebergement
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

	private Voyage voyage;

	public FileUpload getFile() {
		return file;
	}

	public void setFile(FileUpload file) {
		this.file = file;
	}

	private FileUpload file;
	
	
	/**
	 * Amandine : Methode pour recuperer les images et envoyer à la page jsp
	 */
	@RequestMapping(value="/getImage", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte [] recupImage(@RequestParam("pId") int id) throws IOException{
		Hebergement hebergementImage= new Hebergement();
		hebergementImage.setId(id);
		Hebergement hebergement=hebergementService.getHebergementById(hebergementImage);
		if(hebergement.getPhoto()==null){
			return new byte [0];
		}else{
			return IOUtils.toByteArray(new ByteArrayInputStream(hebergement.getPhoto()));
		}
	}
	
	/**
	 * Amandine: Méthode recupper la liste
	 */
	@RequestMapping(value = "/listeHebergement", method = RequestMethod.GET)
	public ModelAndView afficherListeHebergement() {
		// recup liste de Service
		List<Hebergement> listeHebergement = hebergementService.getAllHebergement();
		return new ModelAndView("listeHebergement", "allHebergement", listeHebergement);
	}

	/**
	 * Amandine : Méthode ajouter un hebergement
	 */
	@RequestMapping(value = "/ajouterHebergement", method = RequestMethod.GET)
	public String afficherFormAjoutHebergement(Model model) {
		model.addAttribute("hAjout", new Hebergement());
		return "ajouterHebergement";
	}

	@RequestMapping(value = "/soumettreAjoutHebergement", method = RequestMethod.POST)
	public String soumettreAjouterHebergement(@ModelAttribute("hAjout") Hebergement hIn, Voyage vIn,
			RedirectAttributes rda, MultipartFile file) throws IOException{
		if(file!=null){
			//transformation de l'image en tableau de byte
			hIn.setPhoto(file.getBytes());
		}
				
		
		Hebergement verif = hebergementService.addHebergement(hIn, vIn);
		if (verif != null) {
			return "redirect:listeHebergement";
		} else {
			rda.addAttribute("msg", "L'ajout d'un nouvel hebergement a echoué!");
			return "redirect:ajouterHebergement";
		}
	}

	
	/**
	 * Amandine: Méthode modifier un hebergement
	 */
	@RequestMapping(value = "/modifierHebergement", method = RequestMethod.GET)
	public String afficherFormModifierHebergement(Model model) {
		model.addAttribute("hModifier", new Hebergement());
		return "modifierHebergement";
	
}

	@RequestMapping(value = "/soumettreModifierHebergement", method = RequestMethod.POST)
	public String soumettreModifierHebergement(@ModelAttribute("hModifier") Hebergement hIn,
			RedirectAttributes rda, MultipartFile file) throws IOException {
		if(file!=null){
			//transformation de l'image en tableau de byte
			hIn.setPhoto(file.getBytes());
		}
		
		int verif = hebergementService.updateHebergement(hIn);
		if (verif != 0) {
			return "redirect:listeHebergement";
		} else {
			rda.addAttribute("msg", "La modification d'un nouvel hebergement a echoué!");
			return "redirect:modifierHebergement";
		}
	}
	
	/**
	 * Amandine : Méthode rechercher un hebergement
	 */
	@RequestMapping(value = "/rechercherHebergementU", method = RequestMethod.GET)
	public ModelAndView afficheRechercheHebergementById() {
		return new ModelAndView("rechercherHebergement", "hRecherche", new Hebergement());
	}

	@RequestMapping(value = "/soumettreRechercheHebergementU", method = RequestMethod.POST)
	public String soumettreRechFormHebergementById(ModelMap modele, RedirectAttributes rda, @ModelAttribute("hRech") Hebergement hIn, MultipartFile file) throws IOException {
		
		if(file!=null){
			//transformation de l'image en tableau de byte
			hIn.setPhoto(file.getBytes());
		}
		
		Hebergement verif = hebergementService.getHebergementById(hIn);
		if (verif != null) {
			modele.addAttribute("hRecherche", verif);
			return "rechercherHebergement";
		} else {
			rda.addAttribute("msg", "L'hebergement n'existe pas!");
			return "redirect:rechercherHebergement";
		}
	}
	

	
	/**
	 * Méthode supprimer un hebergement
	 */
	@RequestMapping(value = "/supprimerHebergement", method = RequestMethod.GET)
	public String afficheSupprimerHebergement(Model model) {
		model.addAttribute("hSupprimer", new Hebergement());
		return "supprimerHebergement";
	}
	@RequestMapping (value="/soumettreSupprimerHebergement", method=RequestMethod.POST)
	public String soumettreSupprimerHebergement(@ModelAttribute("hSupprimer") Hebergement hIn, RedirectAttributes rda){
		int verif = hebergementService.deleteHebergement(hIn);
		if (verif != 0){
			return "redirect:listeHebergement";
		}else{
			rda.addAttribute("msg","La suppression de l'hébergement a échoué !");
			return "redirect:supprimerHebergement";}
		}			

	
}
