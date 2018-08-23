package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageService {
	
	public int addVoyage(Voyage v);
	public int updateVoyage(Voyage v);
	public int deleteVoyage(Voyage v);
	public Voyage getVoyageById(Voyage v);
	public List<Voyage> getAllVoyages();

}
