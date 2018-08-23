package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAssuranceDao;
import fr.adaming.model.Assurance;
import fr.adaming.model.Voyage;

/** jd: Déclaration de la classe service implémentant IAssuranceService */

@Service
@Transactional
public class AssuranceServiceImpl implements IAssuranceService {

	/** jd: Transformation de l'association UML en Java */
	private IAssuranceDao assuranceDao;

	/** Getter pour l'injection dépendance */
	@Autowired
	public void setAssuranceDao(IAssuranceDao assuranceDao) {
		this.assuranceDao = assuranceDao;
	}

	@Override
	public Assurance addDestination(Assurance a, Voyage v) {
		/** Lier les objets assurance et voyage */
		a.setVoyage(v);
		return assuranceDao.addDestination(a);
	}

	@Override
	public Assurance updateDestination(Assurance a, Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance deleteDestination(Assurance a, Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance getDestinationById(Assurance a, Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance getDestinationByNom(Assurance a, Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Assurance> getAllDestination(Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

}
