package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Destination;

/**
 * jd : D�claration de la classe DestinationDao qui impl�mente IDestinationDao
 */

@Repository
public class DestinationDaoImpl implements IDestinationDao {

	/** jd : D�claration de l'attribut SessionFactory */
	@Autowired
	private SessionFactory sf;

	/** D�claration du setter pour l'injection de d�pendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/** jd : m�thode permettant d'ajouter une destination dans la base */
	@Override
	public Destination addDestination(Destination d) {

		/** jd : R�cup�ration de la session */
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

		/** jd : r�cup�ration de la session */
		Session s = sf.getCurrentSession();

		/** jd : cr�ation de la requ�te HQL */
		String req = "FROM Destination d";

		/** jd : cr�ation du query */
		Query query = s.createQuery(req);

		/** jd : r�cup�ration de la liste */
		return query.list();
	}

}
