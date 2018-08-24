package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPackDao;
import fr.adaming.model.Pack;

/** 
 * @author Amandine
 * Classe Service Pack
 */

@Service
@Transactional
public class PackServiceImpl implements IPackService{
	
	/** 
	 * ID Pack DAO
	 */

	@Autowired
	private IPackDao packDao;
	/** 
	 * Setter Pour ID pack DAo
	 */
	
	public void setPackDao(IPackDao packDao) {
		this.packDao = packDao;
	}

	@Override
	public List<Pack> getAllPack() {
		return packDao.getAllPack();
	}

	@Override
	public Pack getPackByNom(Pack p) {
		return packDao.getPackByNom(p);
	}

	@Override
	public Pack getPacktById(Pack p) {
		return packDao.getPacktById(p);
	}

	@Override
	public Pack addPack(Pack p) {
		return packDao.addPack(p);
	}

	@Override
	public int updatePack(Pack p) {
		return packDao.updatePack(p);
	}

	@Override
	public int deletePack(Pack p) {
		return packDao.deletePack(p);
	}

}
