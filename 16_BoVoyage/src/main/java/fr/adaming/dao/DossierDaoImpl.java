package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.DossierVoyage;
import fr.adaming.model.Voyage;

@Repository
public class DossierDaoImpl implements IDossierDao {

	/** Déclaration de l'attribut sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** Déclaration du setter pour l'injection dépendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/** Méthode permettant d'ajouter un dossier à la base */
	@Override
	public DossierVoyage addDossier(DossierVoyage dv) {

		// récupération de la session
		Session s = sf.getCurrentSession();

		// ajout du dossier à la base
		s.save(dv);

		return dv;
	}

	@Override
	public DossierVoyage updateDossier(DossierVoyage dv) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// modifier le dossier
		s.saveOrUpdate(dv);

		return dv;
	}

	@Override
	public DossierVoyage deleteDossier(DossierVoyage dv) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// supprimer le dossier
		s.delete(dv);

		return dv;
	}

	@Override
	public DossierVoyage getDossierById(DossierVoyage dv) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requête HQL
		String req = "FROM DossierVoyage dv WHERE dv.id=:pId";

		// création du query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", dv.getIdDossier());

		return (DossierVoyage) query.uniqueResult();
	}

	@Override
	public DossierVoyage getDossierByNum(DossierVoyage dv) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requête HQL
		String req = "FROM DossierVoyage dv WHERE dv.num=:pNum";

		// création du query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pNum", dv.getNumDossier());

		return (DossierVoyage) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DossierVoyage> getAllDossier(Voyage v, Client cl) {

		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requête HQL
		String req = "FROM DossierVoyage dv WHERE dv.client.id=:pIdC AND dv.voyage.id=:pIdV";

		// création du query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pIdC", cl.getIdClient());
		query.setParameter("pIdV", v.getId());

		return query.list();
	}

}
