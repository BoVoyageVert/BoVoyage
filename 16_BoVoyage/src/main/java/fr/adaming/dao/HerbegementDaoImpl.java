	package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;

/**
 * 
 * @author Amandine Classe Dao Hebergement implement IHerbegementDao
 *
 */
@Repository
public class HerbegementDaoImpl implements IHerbergementDao {

	/**
	 * Déclaration de l'attribut SessionFactory
	 */
	@Autowired
	private SessionFactory sf;

	/**
	 * Setter pour l'ID
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hebergement> getAllHebergement() {
		Session s = sf.getCurrentSession();
		String req = "From Hebergement h";
		Query queryListHebergement=s.createQuery(req);
		List<Hebergement> listeHebergement =queryListHebergement.list();
		for(Hebergement h: listeHebergement){
			h.setImage("createQuery(req);base64"+Base64.encodeBase64String(h.getPhoto()));
		}
		return listeHebergement;
	}

	@Override
	public Hebergement getHebergementById(Hebergement h) {
		Session s = sf.getCurrentSession();
//		String req = "From Hebergement h where h.id_h=:pId";
//		Query query = s.createQuery(req);
//		query.setParameter("pId", h.getId());
//		return  (Hebergement) query.uniqueResult();
		Hebergement hOut= (Hebergement) s.get(Hebergement.class, h.getId());
		return hOut;
	}
	

	@Override
	public Hebergement getHebergementByType(Hebergement h) {
		Session s = sf.getCurrentSession();
		String req = "From Hebergement h where h.type=:ptype";
		Query query = s.createQuery(req);
		query.setParameter("ptype", h.getType());
		return  (Hebergement) query.uniqueResult();
	}

	
	@Override
	public Hebergement addHebergement(Hebergement h, Voyage v) {
		Session s=sf.getCurrentSession();
		s.save(h);
		return h;
	}

	@Override
	public int updateHebergement(Hebergement h) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(h);
//		String req = "Update Hebergement as he set he.type=:pType, he.disponibilite=:pDisponibilite, he.prix=:pPrix, he.reduction=:pReduction, he.lieux=:pLieux, he.ville=:pVille, he.codePostal=:pCodePostal, he.menage=:pMenage, he.numHebergement=:pNumHebergement, he.description=:pDescription, he.image=:pImage, Where he.id=:pId";
//		// recup le query
//		Query query = s.createQuery(req);
//
//		query.setParameter("pType", h.getType());
//		query.setParameter("pDisponibilite", h.isDisponibilite());
//		query.setParameter("pPrix", h.getPrix());
//		query.setParameter("pReduction", h.getReduction());
//		query.setParameter("pLieux", h.getLieux());
//		query.setParameter("pVille", h.getVille());
//		query.setParameter("pCodePostal", h.getCodePostal());
//		query.setParameter("pMenage", h.isMenage());
//		query.setParameter("pNumHebergement", h.getNumHebergement());
//		query.setParameter("pDescription", h.getDescription());
//		query.setParameter("pImage", h.getImage());
//		query.setParameter("pId", h.getId());
		if(s.get(Hebergement.class, h.getId())!=null){
			return 1;
		}else{

		return 0;
		}

	}

	@Override
	public int deleteHebergement(Hebergement h) {
		Session s = sf.getCurrentSession();
//		String req = "Delete From Hebergement h where h.id_h=:pId";
//		Query query = s.createQuery(req);
//		query.setParameter("pId", h.getId());
//		return query.executeUpdate();
		s.delete(h);
		if(s.get(Hebergement.class, h.getId())!=null){
			return 1;
		}else{

		return 0;
		}
	}

	@Override
	public Hebergement getHebergementByNum(Hebergement h) {
		Session s = sf.getCurrentSession();
		String req = "From Hebergement h where h.numHebergement=:pNum";
		Query query = s.createQuery(req);
		query.setParameter("pNum", h.getNumHebergement());
		return  (Hebergement) query.uniqueResult();
	}

}
