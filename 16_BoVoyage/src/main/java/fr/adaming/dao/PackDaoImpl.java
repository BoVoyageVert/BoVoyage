package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hebergement;
import fr.adaming.model.Pack;



/** 
 * @author Amandine
 * Classe Dao Pack
 */

@Repository
public class PackDaoImpl implements IPackDao{
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
	public List<Pack> getAllPack() {
		Session s = sf.getCurrentSession();
		String req = "From Pack p";
		Query queryListPack=s.createQuery(req);
		List<Pack> listePack =queryListPack.list();
		for(Pack p: listePack){
			p.setImage("createQuery(req);base64"+Base64.encodeBase64String(p.getPhoto()));
		}
		return listePack;
	}

	@Override
	public Pack getPackByNom(Pack p) {
		Session s = sf.getCurrentSession();
		Pack pOut=(Pack) s.get(Pack.class, p.getNom());
		return pOut;
	}

	@Override
	public Pack getPacktById(Pack p) {
		Session s = sf.getCurrentSession();
		Pack pOut=(Pack) s.get(Pack.class, p.getId());
		return pOut;
	}

	@Override
	public Pack addPack(Pack p) {
		Session s=sf.getCurrentSession();
		s.save(p);
		return p;
	}

	@Override
	public int updatePack(Pack p) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(p);
		if(s.get(Hebergement.class, p.getId())!=null){
			return 1;
		}else{

		return 0;
		}

	}

	@Override
	public int deletePack(Pack p) {
		Session s = sf.getCurrentSession();
		s.delete(p);
		if(s.get(Hebergement.class, p.getId())!=null){
			return 1;
		}else{

		return 0;
		}
	}

	
	
	
	
}
