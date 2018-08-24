package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{

	/**Association*/
	@Autowired
	private IVoitureDao voitDao;
	
	/**setter*/
	public void setVoitDao(IVoitureDao voitDao) {
		this.voitDao = voitDao;
	}

	
	@Override
	public List<Voiture> getAllVoitures() {
		return voitDao.getAllVoitures();
	}

	
	@Override
	public Voiture getVoitureById(Voiture voit) {
		return voitDao.getVoitureById(voit);
	}

	@Override
	public Voiture addVoiture(Voiture voit) {
		return voitDao.addVoiture(voit);
	}

	@Override
	public Voiture updateVoiture(Voiture voit) {
		return voitDao.updateVoiture(voit);
	}

	@Override
	public Voiture deleteVoiture(Voiture voit) {
		return voitDao.deleteVoiture(voit);
	}

}
