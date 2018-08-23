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
	public int updateDestination(Destination d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDestination(Destination d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Destination getDestinationById(Destination d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination getDestinationByNom(Destination d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> getAllDestination() {
		return destinationDao.getAllDestination();
	}

}
