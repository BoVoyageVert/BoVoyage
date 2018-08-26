package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Voyage;

/** jd: d�claration de l'interface dao pour Dossier */

public interface IDossierDao {

	public DossierVoyage addDossier(DossierVoyage dv);

	public DossierVoyage updateDossier(DossierVoyage dv);

	public DossierVoyage deleteDossier(DossierVoyage dv);

	public DossierVoyage getDossierById(DossierVoyage dv);

	public List<DossierVoyage> getDossierByIdClient(Client cl);
	
	public List<DossierVoyage> getAllDossier();

}
