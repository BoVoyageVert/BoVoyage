package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyage;


public interface IVoyageDao {
	
	public int addVoyage(Voyage v);
	public int updateVoyage(Voyage v);
	public int deleteVoyage(Voyage v);
	public Voyage getVoyageById(Voyage v);
	public List<Voyage> getAllVoyages();
	

}
