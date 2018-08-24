package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
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
	public Assurance addAssurance(Assurance a) {

		/** R�cup�ration de la session */
		Session s = sf.getCurrentSession();

		/** Ajout de l'assurance � la base */
		s.save(a);

		/** R�cup�ration du r�sultat */
		return a;
	}

	/** M�thode permettant de mettre � jour les informations d'une assurance */
	@Override
	public Assurance updateAssurance(Assurance a) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// mettre � jour l'assurance
		s.saveOrUpdate(a);

		return a;
	}

	/** M�thode permettant de supprimer une assurance */
	@Override
	public Assurance deleteAssurance(Assurance a) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// supprimer l'assurance
		s.delete(a);

		return a;
	}

	/** M�thode permettant de r�cup�rer une assurance par son ID */
	@Override
	public Assurance getAssuranceById(Assurance a) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// r�daction de la requ�te HQL
		String req = "FROM Assurance a WHERE a.id=:pId";

		// cr�ation du query
		Query query = s.createQuery(req);

		// passage des param�tres
		query.setParameter("pId", a.getIdAssurance());

		// r�cup�ration de l'assurance trouv�e
		return (Assurance) query.uniqueResult();
	}

	/** M�thode permettant de r�cup�rer une assurance par son nom */
	@Override
	public Assurance getAssuranceByDossier(Assurance a) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// r�daction de la requ�te HQL
		String req = "FROM Assurance a WHERE a.numeroDossier=:pNum";

		// cr�ation du query
		Query query = s.createQuery(req);

		// passage des param�tres
		query.setParameter("pNum", a.getNumeroDossier());

		// r�cup�rer l'assurance trouv�e
		return (Assurance) query.uniqueResult();
	}

	/** M�thode pour r�cup�rer la liste de toutes les assurances */
	@SuppressWarnings("unchecked")
	@Override
	public List<Assurance> getAllAssurance() {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// r�daction de la requ�te HQL
		String req = "FROM Assurance a";

		// cr�ation du query
		Query query = s.createQuery(req);

		// r�cup�ration de la liste des assurances
		return query.list();
	}

}
