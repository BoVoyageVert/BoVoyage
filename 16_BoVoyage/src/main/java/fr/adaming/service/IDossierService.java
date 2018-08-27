package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;

public interface IDossierService {

	public DossierVoyage addDossier(DossierVoyage dv, Voyage v, Client cl);

	public DossierVoyage updateDossier(DossierVoyage dv, Voyage v, Client cl);

	public DossierVoyage deleteDossier(DossierVoyage dv, Voyage v, Client cl);

	public DossierVoyage getDossierById(DossierVoyage dv, Voyage v, Client cl);

	public List<DossierVoyage> getDossierByIdClient(Client cl);
	
	public List<DossierVoyage> getAllDossier();

	void sendMail(DossierVoyage dv, Voyage v, Hebergement h);
	
	

}
