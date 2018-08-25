package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import fr.adaming.model.Voiture;
import fr.adaming.service.IVoitureService;

@Controller
@RequestMapping("/voiture")
public class VoitureController {

	/**
	 * Transformation de l'association UML en java
	 */
	@Autowired
	private IVoitureService voitService;

	/**
	 * Getters pour recuperer la voiture de la classe service
	 * 
	 * @return
	 */
	public IVoitureService getVoitService() {
		return voitService;
	}

	/**
	 * 
	 * @param voitService
	 */
	public void setVoitService(IVoitureService voitService) {
		this.voitService = voitService;
	}

	private FileUpload file;

	// Getter et setter pour file
	/**
	 * @return the file
	 */
	public FileUpload getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(FileUpload file) {
		this.file = file;
	}

	// claire: Methodes

	// Afficher la liste
	@RequestMapping(value = "/listeVoiture", method = RequestMethod.GET)
	public ModelAndView afficherListeVoiture() {

		// Recuperer la liste des voitures
		List<Voiture> listeVoit = voitService.getAllVoitures();

		return new ModelAndView("listeVoiture", "allVoitures", listeVoit);
	}

	// recuperer l'image
	@RequestMapping(value = "/getImageVoit", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pIdVoiture") int id) throws IOException {
		Voiture voitImage = new Voiture();
		voitImage.setIdVoiture(id);
		Voiture voiture = voitService.getVoitureById(voitImage);

		if (voiture.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(voiture.getPhoto()));
		}

	}

	// ajouter une voiture
	@RequestMapping(value = "/ajouterVoiture", method = RequestMethod.GET)
	public ModelAndView afficherFormAddVoiture() {
		return new ModelAndView("ajouterVoiture", "voitAjout", new Voiture());
	}

	@RequestMapping(value = "/soumettreAjouterVoiture", method = RequestMethod.POST)
	public String soumettreAjouterVoiture(Model model, @ModelAttribute("voitAjout") Voiture voitIn,
			RedirectAttributes rdv, MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			voitIn.setPhoto(file.getBytes());
		}

		// Appel de la methode service
		Voiture voitOut = voitService.addVoiture(voitIn);

		if (voitOut.getIdVoiture() != 0) {
			return "redirect:listeVoiture";

		} else {
			rdv.addAttribute("msg", "Impossible d'ajouter une voiture");
			return "redirect:ajouterVoiture";
		}
	}

	// Rechercher une voiture par son id
	@RequestMapping(value = "/rechercherVoiture", method = RequestMethod.GET)
	public ModelAndView afficherRechercherVoiture() {

		return new ModelAndView("rechercherVoiture", "voitRech", new Voiture());
	}

	/** Methode post */
	@RequestMapping(value = "/soumettreRechVoiture", method = RequestMethod.POST)
	public String soumettreRechVoiture(Model model, @ModelAttribute("voitRech") Voiture voit, RedirectAttributes rdv,
			MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			voit.setPhoto(file.getBytes());
		}
		// appel de la methode service pour Rechercher une voiture
		Voiture voitureRech = voitService.getVoitureById(voit);

		if (voitureRech != null) {
			model.addAttribute("voitFind", voitureRech);
			return "rechercherVoiture";

		} else {
			rdv.addAttribute("msg", "Recherche, impossible!");
			return "redirect:rechercherVoiture";
		}

	}

	// modifier une voiture
	@RequestMapping(value = "/modifierVoiture", method = RequestMethod.GET)
	public ModelAndView afficherModifVoiture() {
		return new ModelAndView("modifierVoiture", "voitModif", new Voiture());
	}

	@RequestMapping(value = "/soumettreModifVoiture", method = RequestMethod.POST)
	public String soumettreModifVoiture(Model model, @ModelAttribute("voitModif") Voiture voit, RedirectAttributes rdv,
			MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			voit.setPhoto(file.getBytes());
		}
		// appel de la methode service pour modifier une voiture
		Voiture voitureModif = voitService.updateVoiture(voit);

		if (voitureModif != null) {
			return "redirect:listeVoiture";
		} else {
			rdv.addAttribute("msg", "Modification impossible!");

			return "redirect:modifierVoiture";
		}
	}

	// Supprimer une voiture
	@RequestMapping(value = "/supprimerVoiture", method = RequestMethod.GET)
	public ModelAndView afficherSupVoiture() {
		return new ModelAndView("supprimerVoiture", "voitSup", new Voiture());
	}

	@RequestMapping(value = "/soumettreSupVoiture", method = RequestMethod.POST)
	public String soumettreSupVoiture(ModelMap model, @ModelAttribute("voitSup") Voiture voit, RedirectAttributes rdv) {
		// appel de la methode service pour modifier une voiture
		Voiture voitureSup = voitService.deleteVoiture(voit);

		if (voitureSup != null) {
			return "redirect:listeVoiture";
		} else {
			rdv.addAttribute("msg", "Suppression impossible!");

			return "redirect:supprimerVoiture";
		}

	}

	// methode pour recuperer le template
	@RequestMapping(method = RequestMethod.GET, value = "templateTest")
	public String newItem(Model model) {
		return "shared/template/templateTest";
	}
}
