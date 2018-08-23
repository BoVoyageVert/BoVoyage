package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.model.Destination;

/**
 * jd : D�claration de la classe DestinationDao qui impl�mente IDestinationDao
 */

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService {

	/** Transformation de l'association UML en Java */
	private IDestinationDao destinationDao;

	/** D�claration du setter pour l'injection d�pendance */
	@Autowired
	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}

	/** M�thode service permettant d'ajouter une destination */
	@Override
	public Destination addDestination(Destination d) {
		return destinationDao.addDestination(d);
	}

	@Override
	public Destination updateDestination(Destination d) {
		return destinationDao.updateDestination(d);
	}

	@Override
	public Destination deleteDestination(Destination d) {
		return destinationDao.deleteDestination(d);
	}

	@Override
	public Destination getDestinationById(Destination d) {
		return destinationDao.getDestinationById(d);
	}

	@Override
	public Destination getDestinationByNom(Destination d) {
		return destinationDao.getDestinationByNom(d);
	}

	@Override
	public List<Destination> getAllDestination() {
		return destinationDao.getAllDestination();
	}

}
