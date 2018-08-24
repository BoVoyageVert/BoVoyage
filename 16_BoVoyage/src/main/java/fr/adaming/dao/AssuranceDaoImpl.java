package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
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
	public Assurance addAssurance(Assurance a) {

		/** Récupération de la session */
		Session s = sf.getCurrentSession();

		/** Ajout de l'assurance à la base */
		s.save(a);

		/** Récupération du résultat */
		return a;
	}

	/** Méthode permettant de mettre à jour les informations d'une assurance */
	@Override
	public Assurance updateAssurance(Assurance a) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// mettre à jour l'assurance
		s.saveOrUpdate(a);

		return a;
	}

	/** Méthode permettant de supprimer une assurance */
	@Override
	public Assurance deleteAssurance(Assurance a) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// supprimer l'assurance
		s.delete(a);

		return a;
	}

	/** Méthode permettant de récupérer une assurance par son ID */
	@Override
	public Assurance getAssuranceById(Assurance a) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// rédaction de la requête HQL
		String req = "FROM Assurance a WHERE a.id=:pId";

		// création du query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", a.getIdAssurance());

		// récupération de l'assurance trouvée
		return (Assurance) query.uniqueResult();
	}

	/** Méthode permettant de récupérer une assurance par son nom */
	@Override
	public Assurance getAssuranceByDossier(Assurance a) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// rédaction de la requête HQL
		String req = "FROM Assurance a WHERE a.numeroDossier=:pNum";

		// création du query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pNum", a.getNumeroDossier());

		// récupérer l'assurance trouvée
		return (Assurance) query.uniqueResult();
	}

	/** Méthode pour récupérer la liste de toutes les assurances */
	@SuppressWarnings("unchecked")
	@Override
	public List<Assurance> getAllAssurance() {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// rédaction de la requête HQL
		String req = "FROM Assurance a";

		// création du query
		Query query = s.createQuery(req);

		// récupération de la liste des assurances
		return query.list();
	}

}
