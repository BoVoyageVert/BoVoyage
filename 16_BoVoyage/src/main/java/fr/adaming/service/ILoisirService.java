package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Loisir;

public interface ILoisirService {
	
	/**claire: Methode pour liste des loisirs*/
	public List<Loisir> getAllLoisir();	
	
	/**claire: Methode pour rechercher des loisirs par cat*/
	public List<Loisir> getLoisirByCat(Loisir l);
	
	/**claire: Methode pour rechercher des loisirs par id*/
	public Loisir getLoisirById(Loisir l);
	
	/**claire: Methode pour ajouter un loisir*/
	public Loisir addLoisir(Loisir l);
	
	/**claire: Methode pour modifier un loisir*/
	public Loisir updateLoisir(Loisir l);
	
	/**claire: Methode pour supprimer un loisir*/
	public Loisir deleteLoisir(Loisir l);
	

}
