package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class VoyageServiceImpl implements IVoyageService{
	
	@Autowired
	IVoyageDao vDao;
	public void setvDao(IVoyageDao vDao) {
		this.vDao = vDao;
	}

	@Override
	public int addVoyage(Voyage v) {
		return vDao.addVoyage(v);
	}

	@Override
	public int updateVoyage(Voyage v) {
		return vDao.updateVoyage(v);
	}

	@Override
	public int deleteVoyage(Voyage v) {
		return vDao.deleteVoyage(v);
	}

	@Override
	public Voyage getVoyageById(Voyage v) {
		// TODO Auto-generated method stub
		return vDao.getVoyageById(v);
	}

	@Override
	public List<Voyage> getAllVoyages() {
		return vDao.getAllVoyages();
	}

}
