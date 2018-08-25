package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** Amandine Classe Dao Admin
 */

@Repository
public class AdminDaoImpl {
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
	
	
}
