package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hebergement;
/** 
 * 
 * @author Amandine
 * Interface Service Hebergement
 *
 */
public interface IHebergementService {

	public List<Hebergement> getAllHebergement();

	public Hebergement getHebergementById(Hebergement h);

	public Hebergement getHebergementByType(Hebergement h);

	public Hebergement addHebergement(Hebergement h);

	public Hebergement updateHebergement(Hebergement h);

	public Hebergement deleteHebergement(Hebergement h);
	
}
