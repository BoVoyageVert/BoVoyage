package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILoisirDao;
import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Loisir;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class LoisirServiceImpl implements ILoisirService{

	/**claire: association*/
	@Autowired
	private ILoisirDao loisirDao;
	private IVoyageDao voyageDao;
	
	/**claire: Getters et setters */
	public ILoisirDao getLoisirDao() {
		return loisirDao;
	}

	public void setLoisirDao(ILoisirDao loisirDao) {
		this.loisirDao = loisirDao;
	}

	
	@Override
	public List<Loisir> getAllLoisir() {
		return loisirDao.getAllLoisir();
	}

	@Override
	public Loisir getLoisirByCat(Loisir l) {
		return loisirDao.getLoisirByCat(l);
	}

	@Override
	public Loisir getLoisirById(Loisir l) {
		return loisirDao.getLoisirById(l);
	}

	@Override
	public Loisir addLoisir(Loisir l) {
		return loisirDao.addLoisir(l);
	}

	@Override
	public Loisir updateLoisir(Loisir l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loisir deleteLoisir(Loisir l) {
		// TODO Auto-generated method stub
		return null;
	}

}
