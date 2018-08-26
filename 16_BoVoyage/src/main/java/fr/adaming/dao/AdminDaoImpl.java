package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;



/** 
 * 
 * @author Amandine
 * Classe Dao Admin
 *
 */

@Repository
public class AdminDaoImpl implements IAdminDao{

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
	
	
	
	
	
	
	@Override
	public Admin addAdmin(Admin ad) {
		Session s=sf.getCurrentSession();
		s.save(ad);
		return ad;
	}






	@Override
	public List<Admin> getAllAdmin() {
		Session s = sf.getCurrentSession();
		String req = "From Admin ad";
		Query queryListAdministrator=s.createQuery(req);
		List<Admin> listeAdmin =queryListAdministrator.list();
		return listeAdmin;
	}
	
	
	
	
	
	


}
