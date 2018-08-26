package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Admin;
/** 
 * 
 * @author Amandine
 * Interface Service Admin
 *
 */
public interface IAdminService {

public Admin addAdmin (Admin ad);
	
	public List<Admin> getAllAdmin ();
	
}
