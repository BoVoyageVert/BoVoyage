package fr.adaming.service;

import java.util.List;

import fr.adaming.model.DossierVoyage;
import fr.adaming.model.LigneCommande;

public interface ILigneCommandeService {
	public int addLigneCommande(LigneCommande lc);
	public int updateLigneCommande(LigneCommande lc);
	public int deleteLigneCommande(LigneCommande lc);
	public LigneCommande getLigneCommandeById(LigneCommande lc);
	public List<LigneCommande> getAllLigneCommande();
	
	public List<LigneCommande> getLigneCommandeByDossier(DossierVoyage dossier);
}



