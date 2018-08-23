package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Destination;

/** jd : Déclaration de l'interface DestinationService */

public interface IDestinationService {

	public Destination addDestination(Destination d);

	public Destination updateDestination(Destination d);

	public Destination deleteDestination(Destination d);

	public Destination getDestinationById(Destination d);

	public Destination getDestinationByNom(Destination d);

	public List<Destination> getAllDestination();

}
