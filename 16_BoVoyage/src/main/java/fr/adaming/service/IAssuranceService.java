package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Assurance;
import fr.adaming.model.Voyage;

/** jd: Déclaration de l'interface service pour l'assurance */

public interface IAssuranceService {

	public Assurance addDestination(Assurance a, Voyage v);

	public Assurance updateDestination(Assurance a, Voyage v);

	public Assurance deleteDestination(Assurance a, Voyage v);

	public Assurance getDestinationById(Assurance a, Voyage v);

	public Assurance getDestinationByNom(Assurance a, Voyage v);

	public List<Assurance> getAllDestination(Voyage v);

}
