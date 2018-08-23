package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao{

	@Autowired
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	@Override
	public int addVoyage(Voyage v) {
		Session s = sf.getCurrentSession();
		s.save(v);
		if (s.get(Voyage.class, v.getId()) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateVoyage(Voyage v) {
		
		
		return 0;
	}

	@Override
	public int deleteVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Voyage getVoyageById(Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> getAllVoyages() {
		Session s = sf.getCurrentSession();
		String req = "FROM Voyage";
		org.hibernate.Query queryListVoyages = s.createQuery(req);
		List<Voyage> listeVoyages = queryListVoyages.list();

		for (Voyage v : listeVoyages) {
			v.setImage("data:image/png);base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeVoyages;
	}
	
	

}
