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
	public Assurance addAssurance(Assurance a) {
		return assuranceDao.addAssurance(a);
	}

	@Override
	public Assurance updateAssurance(Assurance a) {
		return assuranceDao.updateAssurance(a);
	}

	@Override
	public Assurance deleteAssurance(Assurance a) {
		return assuranceDao.deleteAssurance(a);
	}

	@Override
	public Assurance getAssuranceById(Assurance a) {
		return assuranceDao.getAssuranceById(a);
	}

	@Override
	public Assurance getAssuranceByDossier(Assurance a) {
		return assuranceDao.getAssuranceByDossier(a);
	}

	@Override
	public List<Assurance> getAllAssurance() {
		return assuranceDao.getAllAssurance();
	}

}
