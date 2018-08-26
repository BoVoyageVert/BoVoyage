package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

/** 
 * 
 * @author Amandine
 * Classe Service Admin
 *
 */

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	/** 
	 * ID Admin DAO
	 */

	@Autowired
	private IAdminDao adminDao;
	/** 
	 * Setter ID Admin DAO
	 */
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	/** 
	 * redéfinition des methodes IAdminDao
	 */
	@Override
	public Admin addAdmin(Admin ad) {
		return adminDao.addAdmin(ad);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

}
