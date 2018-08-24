package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Assurance;
import fr.adaming.model.Voyage;

/** jd: Déclaration de l'interface service pour l'assurance */

public interface IAssuranceService {

	public Assurance addAssurance(Assurance a);

	public Assurance updateAssurance(Assurance a);

	public Assurance deleteAssurance(Assurance a);

	public Assurance getAssuranceById(Assurance a);

	public Assurance getAssuranceByDossier(Assurance a);

	public List<Assurance> getAllAssurance();

}
