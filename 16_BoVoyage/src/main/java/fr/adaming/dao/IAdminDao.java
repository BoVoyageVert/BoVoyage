package fr.adaming.dao;
/** 
 * 
 * @author Amandine
 * Interface Dao Admin
 *
 */

import java.util.List;

import fr.adaming.model.Admin;

public interface IAdminDao {

	public Admin addAdmin (Admin ad);
	
	public List<Admin> getAllAdmin ();
}
