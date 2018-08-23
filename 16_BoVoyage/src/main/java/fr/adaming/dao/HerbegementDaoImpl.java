package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hebergement;

/**
 * 
 * @author Amandine Classe Dao Hebergement implement IHerbegementDao
 *
 */
@Repository
public class HerbegementDaoImpl implements IHerbergementDao {

	/**
	 * Déclaration de l'attribut SessionFactory
	 */
	@Autowired
	private SessionFactory sf;

	/**
	 * Setter pour l'ID
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hebergement> getAllHebergement() {
		Session s = sf.getCurrentSession();
		String req = "From hebergements h";
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Hebergement getHebergementById(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement getHebergementByType(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement addHebergement(Hebergement h) {
		Session s=sf.getCurrentSession();
		s.save(h);
		return null;
	}

	@Override
	public Hebergement updateHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement deleteHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

}
