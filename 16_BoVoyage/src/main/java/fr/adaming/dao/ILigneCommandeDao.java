package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeDao {
	public int addLigneCommande(LigneCommande lc);
	public int updateLigneCommande(LigneCommande lc);
	public int deleteLigneCommande(LigneCommande lc);
	public LigneCommande getLigneCommandeById(LigneCommande lc);
	public List<LigneCommande> getAllLigneCommande();
}



