package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILoisirDao;
import fr.adaming.model.Loisir;

@Service
@Transactional
public class LoisirServiceImpl implements ILoisirService{

	/**claire: association*/
	@Autowired
	private ILoisirDao loisirDao;
	
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
	public List<Loisir> getLoisirByCat(Loisir l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loisir getLoisirById(Loisir l) {
		// TODO Auto-generated method stub
		return null;
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
