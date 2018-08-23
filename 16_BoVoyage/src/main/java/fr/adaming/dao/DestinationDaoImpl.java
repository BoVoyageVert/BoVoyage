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
	public Destination updateDestination(Destination d) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Effectuer les modifications */
		s.saveOrUpdate(d);

		return d;
	}

	@Override
	public Destination deleteDestination(Destination d) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Supprimer la destination */
		s.delete(d);

		return d;
	}

	@Override
	public Destination getDestinationById(Destination d) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Création de la requête HQL */
		String req = "FROM Destination d WHERE d.id=:pId";

		/** Création du query */
		Query query = s.createQuery(req);

		/** Passage des paramètres */
		query.setParameter("pId", d.getIdDestination());

		/** Récupération de la destination */
		return (Destination) query.uniqueResult();
	}

	@Override
	public Destination getDestinationByNom(Destination d) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Création de la requête HQL */
		String req = "FROM Destination d WHERE d.nomDestination=:pNom";

		/** Création du query */
		Query query = s.createQuery(req);

		/** Passage des paramètres */
		query.setParameter("pNom", d.getNomDestination());

		/** Récupération de la destination */
		return (Destination) query.uniqueResult();
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
