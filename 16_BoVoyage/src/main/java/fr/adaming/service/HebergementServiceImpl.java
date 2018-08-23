package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHerbergementDao;
import fr.adaming.model.Hebergement;

/** 
 * 
 * @author Amandine
 * Classe Service Hebergement
 *
 */

@Service
@Transactional//ouvre transaction avant et farme après
public class HebergementServiceImpl implements IHebergementService{
	
	/** 
	 * ID Hebergement DAO
	 */

	@Autowired
	private IHerbergementDao hebergementDao;
	/** 
	 * Setter ID Hebergement DAO
	 */
	public void setHebergementDao(IHerbergementDao hebergementDao) {
		this.hebergementDao = hebergementDao;
	}
	
	/** 
	 * redéfinition des methodes IHerbergement Dao
	 */
	
	@Override
	public List<Hebergement> getAllHebergement() {
		return hebergementDao.getAllHebergement();
	}

	

	@Override
	public Hebergement getHebergementById(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement getHebergementByType(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement addHebergement(Hebergement h) {
		return hebergementDao.addHebergement(h);
	}

	@Override
	public Hebergement updateHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hebergement deleteHebergement(Hebergement h) {
		// TODO Auto-generated method stub
		return null;
	}

}
