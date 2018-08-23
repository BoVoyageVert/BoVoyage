package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHerbergementDao;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;

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
		return hebergementDao.getHebergementById(h);
	}

	@Override
	public Hebergement getHebergementByType(Hebergement h) {
		return hebergementDao.getHebergementByType(h);
	}

	@Override
	public Hebergement addHebergement(Hebergement h, Voyage v) {
		return hebergementDao.addHebergement(h, v);
	}

	@Override
	public int updateHebergement(Hebergement h) {
		return hebergementDao.updateHebergement(h);
	}

	@Override
	public int deleteHebergement(Hebergement h) {
		return hebergementDao.deleteHebergement(h);
	}

}
