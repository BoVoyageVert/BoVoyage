package fr.adaming.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	/** Transformation de l'association UML en Java */
	private IDossierDao dossierDao;

	/** Setter pour l'injection dépendance */
	@Autowired
	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}

	@Override
	public DossierVoyage addDossier(DossierVoyage dv, Voyage v, Client cl) {
		// lier les objets java
		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.addDossier(dv);
	}

	@Override
	public DossierVoyage updateDossier(DossierVoyage dv, Voyage v, Client cl) {

		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.updateDossier(dv);
	}

	@Override
	public DossierVoyage deleteDossier(DossierVoyage dv, Voyage v, Client cl) {

		dv.setVoyage(v);
		dv.setClient(cl);

		return dossierDao.deleteDossier(dv);
	}

	@Override
	public DossierVoyage getDossierById(DossierVoyage dv, Voyage v, Client cl) {
		dv.setVoyage(v);
		dv.setClient(cl);
		return dossierDao.getDossierById(dv);
	}

	@Override
	public DossierVoyage getDossierByNum(DossierVoyage dv, Voyage v, Client cl) {
		dv.setVoyage(v);
		dv.setClient(cl);
		return dossierDao.getDossierByNum(dv);
	}

	@Override
	public List<DossierVoyage> getAllDossier(Voyage v, Client cl) {
		return dossierDao.getAllDossier(v, cl);
	}

}
