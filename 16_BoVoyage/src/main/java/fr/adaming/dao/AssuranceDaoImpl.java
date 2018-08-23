package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Assurance;

/** jd: Déclaration de la classe dao implémentant IAssuranceDao */

@Repository
public class AssuranceDaoImpl implements IAssuranceDao {

	/** jd: Déclaration du sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** jd: getter pour l'injection dépendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Assurance addDestination(Assurance a) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Ajout de l'assurance à la base */
		s.save(a);

		/** Récupération du résultat */
		return a;
	}

	@Override
	public Assurance updateDestination(Assurance a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance deleteDestination(Assurance a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance getDestinationById(Assurance a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance getDestinationByNom(Assurance a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Assurance> getAllDestination() {
		// TODO Auto-generated method stub
		return null;
	}

}
