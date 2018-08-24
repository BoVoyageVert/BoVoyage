package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

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
import fr.adaming.model.Loisir;
import fr.adaming.service.ILoisirService;

@Controller
@RequestMapping("/loisir")
public class LoisirController {

	/** claire: transformation de l'association uml en java */
	@Autowired
	private ILoisirService loisirService;

	/** Getters et setters */
	public ILoisirService getLoisirService() {
		return loisirService;
	}

	public void setLoisirService(ILoisirService loisirService) {
		this.loisirService = loisirService;
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
	@RequestMapping(value = "/listeLoisir", method = RequestMethod.GET)
	public ModelAndView afficherListeLoisir() {

		/** Recuperer la liste */
		List<Loisir> loisirListe = loisirService.getAllLoisir();

		return new ModelAndView("listeLoisir", "allLoisirs", loisirListe);
	}

	// recuperer l'image
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pIdLoisir") int id) throws IOException {
		Loisir loisirImage = new Loisir();
		loisirImage.setIdLoisir(id);
		Loisir loisir = loisirService.getLoisirById(loisirImage);

		if (loisir.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(loisir.getPhoto()));
		}

	}

	// claire: Ajouter un loisir
	// claire: methode get
	@RequestMapping(value = "/ajouterLoisir", method = RequestMethod.GET)
	public ModelAndView afficherFormAddLoisir() {
		return new ModelAndView("ajouterLoisir", "lAjout", new Loisir());
	}

	// claire: methode post
	@RequestMapping(value = "/soumettreAjouterLoisir", method = RequestMethod.POST)
	public String soumettreAjouterLoisir(Model model, @ModelAttribute("lAjout") Loisir lIn, RedirectAttributes rdl,
			MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			lIn.setPhoto(file.getBytes());
		}

		// Appel de la methode service
		Loisir lOut = loisirService.addLoisir(lIn);

		if (lOut.getIdLoisir() != 0) {

			return "redirect:listeLoisir";

		} else {
			rdl.addAttribute("msg", "Impossible d'ajouter ce loisir");

			return "redirect:ajouterLoisir";
		}
	}

	// Rechercher un Loisir par sa categorie
	// Methode get
	@RequestMapping(value = "/rechercherLoisir", method = RequestMethod.GET)
	public ModelAndView afficherRechercherLoisir() {

		return new ModelAndView("rechercherLoisir", "lRech", new Loisir());
	}

	// Methode post
	@RequestMapping(value = "/soumettreRechLoisirByNom", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute(value = "lRech") Loisir l, RedirectAttributes rdl,
			MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			l.setPhoto(file.getBytes());
		}

		// appel de la methode service pour Rechercher un Loisir
		Loisir loisirRech = loisirService.getLoisirByNom(l);

		if (loisirRech != null) {
			model.addAttribute("lFind", loisirRech);
			return "rechercherLoisir";

		} else {
			rdl.addAttribute("msg", "Recherche, impossible!");
			return "redirect:rechercherLoisir";
		}

	}

	// modifier un Loisir
	@RequestMapping(value = "/modifierLoisir", method = RequestMethod.GET)
	public ModelAndView afficherModifierLoisir() {

		return new ModelAndView("modifierLoisir", "lModif", new Loisir());

	}

	@RequestMapping(value = "/soumettreModifLoisir", method = RequestMethod.POST)
	public String soumettreFormModif(Model model, @ModelAttribute("lModif") Loisir l, RedirectAttributes rdl,
			MultipartFile file) throws IOException {

		if (file != null) {
			// Transformation de l'image en tableau de byte
			l.setPhoto(file.getBytes());
		}

		/** appel de la methode service pour modifier un loisir */
		Loisir lModif = loisirService.updateLoisir(l);

		if (lModif.getIdLoisir() != 0) {
			return "redirect:listeLoisir";
		} else {
			rdl.addAttribute("msg", "Modification impossible!");

			return "redirect:modifierLoisir";
		}
	}

	// supprimer un Loisir
	@RequestMapping(value = "/supprimerLoisir", method = RequestMethod.GET)
	public ModelAndView afficherSupprimerLoisir() {

		return new ModelAndView("supprimerLoisir", "lSup", new Loisir());

	}

	@RequestMapping(value = "/soumettresupprimerLoisir", method = RequestMethod.POST)
	public String soumettreSupLoisir(Model model, @ModelAttribute("lSup") Loisir l, RedirectAttributes rdl) {
		/** appel de la methode service pour supprimer un loisir */
		Loisir lSup = loisirService.deleteLoisir(l);

		if (lSup.getIdLoisir() != 0) {
			return "redirect:listeLoisir";
		} else {
			rdl.addAttribute("msg", "Suppression impossible!");

			return "redirect:supprimerLoisir";
		}
	}

}
