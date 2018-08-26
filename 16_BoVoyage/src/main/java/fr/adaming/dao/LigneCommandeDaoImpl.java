package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Voyage;

@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
	@Autowired
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public int addLigneCommande(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		s.save(lc);
		if (s.get(LigneCommande.class, lc.getId()) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateLigneCommande(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(lc);
		if (s.get(LigneCommande.class, lc.getId()) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int deleteLigneCommande(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		s.delete(lc);
		if (s.get(LigneCommande.class, lc.getId()) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public LigneCommande getLigneCommandeById(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		LigneCommande lcOut = (LigneCommande) s.get(LigneCommande.class, lc.getId());
		return lcOut;
	}

	@Override
	public List<LigneCommande> getAllLigneCommande() {
		Session s = sf.getCurrentSession();
		String req = "FROM LigneCommande";
		org.hibernate.Query queryListLigneCommande = s.createQuery(req);
		List<LigneCommande> listeLigneCommande = queryListLigneCommande.list();

		

		return listeLigneCommande;
	}

}
