package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;

/** 
 * 
 * @author Amandine
 * Interface Dao Hebergement
 *
 */

public interface IHerbergementDao {

	public List<Hebergement> getAllHebergement();

	public Hebergement getHebergementById(Hebergement h);

	public Hebergement getHebergementByType(Hebergement h);

	public Hebergement addHebergement(Hebergement h, Voyage v);

	public int updateHebergement(Hebergement h);

	public int deleteHebergement(Hebergement h);

}
