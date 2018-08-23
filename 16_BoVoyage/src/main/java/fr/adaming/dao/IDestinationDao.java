package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Destination;

/** jd : Déclaration de l'interface DestinationDao */

public interface IDestinationDao {

	public Destination addDestination(Destination d);

	public Destination updateDestination(Destination d);

	public Destination deleteDestination(Destination d);

	public Destination getDestinationById(Destination d);

	public Destination getDestinationByNom(Destination d);

	public List<Destination> getAllDestination();

}
