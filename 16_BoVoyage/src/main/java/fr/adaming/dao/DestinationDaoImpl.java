package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Destination;

/**
 * jd : Déclaration de la classe DestinationDao qui implémente IDestinationDao
 */

@Repository
public class DestinationDaoImpl implements IDestinationDao {

	/** jd : Déclaration de l'attribut SessionFactory */
	@Autowired
	private SessionFactory sf;

	/** Déclaration du setter pour l'injection de dépendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/** jd : méthode permettant d'ajouter une destination dans la base */
	@Override
	public Destination addDestination(Destination d) {

		/** jd : Récupération de la session */
		Session s = sf.getCurrentSession();

		/** jd : Ajout de la destination dans la base */
		s.save(d);

		return d;
	}

	@Override
	public int updateDestination(Destination d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDestination(Destination d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Destination getDestinationById(Destination d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination getDestinationByNom(Destination d) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> getAllDestination() {

		/** jd : récupération de la session */
		Session s = sf.getCurrentSession();

		/** jd : création de la requête HQL */
		String req = "FROM Destination d";

		/** jd : création du query */
		Query query = s.createQuery(req);

		/** jd : récupération de la liste */
		return query.list();
	}

}
