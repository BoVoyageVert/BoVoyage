package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Destination;

/** jd : Déclaration de l'interface DestinationDao */

public interface IDestinationDao {

	public Destination addDestination(Destination d);

	public int updateDestination(Destination d);

	public int deleteDestination(Destination d);

	public Destination getDestinationById(Destination d);

	public Destination getDestinationByNom(Destination d);

	public List<Destination> getAllDestination();

}
