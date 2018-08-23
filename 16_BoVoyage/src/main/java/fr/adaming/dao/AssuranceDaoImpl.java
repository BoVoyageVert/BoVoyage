package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Assurance;

/** jd: D�claration de la classe dao impl�mentant IAssuranceDao */

@Repository
public class AssuranceDaoImpl implements IAssuranceDao {

	/** jd: D�claration du sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** jd: getter pour l'injection d�pendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Assurance addDestination(Assurance a) {

		/** R�cup�ration de la session */
		Session s = sf.getCurrentSession();

		/** Ajout de l'assurance � la base */
		s.save(a);

		/** R�cup�ration du r�sultat */
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
