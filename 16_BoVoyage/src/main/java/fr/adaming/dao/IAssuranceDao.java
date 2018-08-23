package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Assurance;

/** jd: Déclaration de l'interface dao pour l'assurance */

public interface IAssuranceDao {

	public Assurance addDestination(Assurance a);

	public Assurance updateDestination(Assurance a);

	public Assurance deleteDestination(Assurance a);

	public Assurance getDestinationById(Assurance a);

	public Assurance getDestinationByNom(Assurance a);

	public List<Assurance> getAllDestination();

}
