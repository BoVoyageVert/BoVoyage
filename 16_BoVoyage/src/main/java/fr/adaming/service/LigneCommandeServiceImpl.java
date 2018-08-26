package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.LigneCommande;


@Service
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService{

	@Autowired
	ILigneCommandeDao lcDao;
	public void setlcDao(ILigneCommandeDao lcDao) {
		this.lcDao = lcDao;
	}
	
	@Override
	public int addLigneCommande(LigneCommande lc) {
		// TODO Auto-generated method stub
		return lcDao.addLigneCommande(lc);
	}

	@Override
	public int updateLigneCommande(LigneCommande lc) {
		// TODO Auto-generated method stub
		return lcDao.updateLigneCommande(lc);
	}

	@Override
	public int deleteLigneCommande(LigneCommande lc) {
		// TODO Auto-generated method stub
		return lcDao.deleteLigneCommande(lc);
	}

	@Override
	public LigneCommande getLigneCommandeById(LigneCommande lc) {
		// TODO Auto-generated method stub
		return lcDao.getLigneCommandeById(lc);
	}

	@Override
	public List<LigneCommande> getAllLigneCommande() {
		// TODO Auto-generated method stub
		return lcDao.getAllLigneCommande();
	}

}
