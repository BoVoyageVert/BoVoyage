package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Assurance;

/** jd: Déclaration de l'interface dao pour l'assurance */

public interface IAssuranceDao {

	public Assurance addAssurance(Assurance a);

	public Assurance updateAssurance(Assurance a);

	public Assurance deleteAssurance(Assurance a);

	public Assurance getAssuranceById(Assurance a);

	public Assurance getAssuranceByDossier(Assurance a);

	public List<Assurance> getAllAssurance();

}
