package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Loisir;

@Repository
public class LoisirDaoImpl implements ILoisirDao{

	/** claire: declaration de l'attribut sessionFactory */
	@Autowired
	private SessionFactory sf;

	/** claire: setter pour injection de dependance */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<Loisir> getAllLoisir() {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** claire: Req */
		String req = "FROM Loisir";
		
		/**claire: Query */
		Query queryListe = s.createQuery(req);
		
		List<Loisir> listeLoisir = queryListe.list();
		
		/**claire: transformation photo*/
		for (Loisir l  : listeLoisir) {
			l.setImage("data:image/png);base64," + Base64.encodeBase64String(l.getPhoto()));
		}

		return listeLoisir;
	}


	@Override
	public Loisir getLoisirByNom(Loisir l) {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** claire: Req */
		String req = "FROM Loisir l WHERE l.nom=:pNom ";
		
		/**claire: Query */
		Query query = s.createQuery(req);
		
		/**Passage des params*/
		query.setParameter("pNom", l.getNom());
		
		return (Loisir) query.uniqueResult();
	}

	@Override
	public Loisir getLoisirById(Loisir l) {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** claire: Req */
		String req = "FROM Loisir l WHERE l.idLoisir=:pIdLoisir ";
		
		/**claire: Query */
		Query query = s.createQuery(req);
		
		/**Passage des params*/
		query.setParameter("pIdLoisir", l.getIdLoisir());
		
		return (Loisir) query.uniqueResult();
	}

	@Override
	public Loisir addLoisir(Loisir l) {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** methode save*/
		s.save(l);
		
		return l;
	}

	@Override
	public Loisir updateLoisir(Loisir l) {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** methode save or update*/
		s.saveOrUpdate(l);
			
		return l;
	}

	@Override
	public Loisir deleteLoisir(Loisir l) {
		/** claire: Recuperer la session*/
		Session s = sf.getCurrentSession();
		
		/** methode delete*/
		s.delete(l);
			
		return l;
		
	}

}
