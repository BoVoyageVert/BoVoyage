package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Voiture;

@Repository
public class VoitureDaoImpl implements IVoitureDao {

	/** claire: declaration de l'attribut sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** claire: setter pour injection de dependance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Voiture> getAllVoitures() {
		// recuperer la session
		Session s = sf.getCurrentSession();

		// req HQL
		String req = "FROM Voiture";

		// claire: Query
		Query queryListe = s.createQuery(req);

		List<Voiture> listeVoiture = queryListe.list();


		return listeVoiture;

	}

	@Override
	public Voiture getVoitureById(Voiture voit) {
		// recuperer la session
		Session s = sf.getCurrentSession();

		// req HQL
		String req = "FROM Voiture voit WHERE voit.idVoiture=:pIdVoiture";

		// Query
		Query query = s.createQuery(req);

		// recuperer les parametres
		query.setParameter("pIdVoiture", voit.getIdVoiture());

		return (Voiture) query.uniqueResult();
	}

	@Override
	public Voiture addVoiture(Voiture voit) {
		// recuperer la session
		Session s = sf.getCurrentSession();

		//methode save
		s.save(voit);
		
		return voit;
	}

	@Override
	public Voiture updateVoiture(Voiture voit) {
		// recuperer la session
		Session s = sf.getCurrentSession();
		
		//methode save or update
		s.saveOrUpdate(voit);

		return voit;
	}

	@Override
	public Voiture deleteVoiture(Voiture voit) {
		// recuperer la session
		Session s = sf.getCurrentSession();
				
		//methode save or update
		s.delete(voit);
		
		return voit;
	}

}
