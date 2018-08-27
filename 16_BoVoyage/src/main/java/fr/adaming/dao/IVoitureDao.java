package fr.adaming.dao;

import java.util.List;
import fr.adaming.model.Voiture;

public interface IVoitureDao {
	
	/**claire: Methode pour liste des voitures*/
	public List<Voiture> getAllVoitures();	
	
	/**claire: Methode pour rechercher des voitures par id*/
	public Voiture getVoitureById(Voiture voit);
	
	/**claire: Methode pour ajouter une voiture*/
	public Voiture addVoiture(Voiture voit);
	
	/**claire: Methode pour modifier une voiture*/
	public Voiture updateVoiture(Voiture voit);
	
	/**claire: Methode pour supprimer une voiture*/
	public Voiture deleteVoiture(Voiture voit);
	
	public Voiture getVoitureByModele(Voiture voit);
	

}
