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

	/** D�claration de l'attribut sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** D�claration du setter pour l'injection d�pendance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/** M�thode permettant d'ajouter un dossier � la base */
	@Override
	public DossierVoyage addDossier(DossierVoyage dv) {

		// r�cup�ration de la session
		Session s = sf.getCurrentSession();

		// ajout du dossier � la base
		s.save(dv);

		return dv;
	}

	@Override
	public DossierVoyage updateDossier(DossierVoyage dv) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// modifier le dossier
		s.saveOrUpdate(dv);

		return dv;
	}

	@Override
	public DossierVoyage deleteDossier(DossierVoyage dv) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// supprimer le dossier
		s.delete(dv);

		return dv;
	}

	@Override
	public DossierVoyage getDossierById(DossierVoyage dv) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// cr�ation de la requ�te HQL
		String req = "FROM DossierVoyage dv WHERE dv.id=:pId";

		// cr�ation du query
		Query query = s.createQuery(req);

		// passage des param�tres
		query.setParameter("pId", dv.getIdDossier());

		return (DossierVoyage) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DossierVoyage> getDossierByIdClient( Client cl) {

		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// cr�ation de la requ�te HQL
		String req = "FROM DossierVoyage dv WHERE dv.client.id=:pIdC";

		// cr�ation du query
		Query query = s.createQuery(req);

		// passage des param�tres
		query.setParameter("pIdC", cl.getIdClient());

		return query.list();
	}

	@Override
	public List<DossierVoyage> getAllDossier() {
		// r�cup�rer la session
				Session s = sf.getCurrentSession();

				// cr�ation de la requ�te HQL
				String req = "FROM DossierVoyage";

				// cr�ation du query
				Query query = s.createQuery(req);

				return query.list();
	}

}
