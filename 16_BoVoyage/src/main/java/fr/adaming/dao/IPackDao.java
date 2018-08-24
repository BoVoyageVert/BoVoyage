package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Pack;


/** 
 * 
 * @author Amandine
 * Interface Dao Pack
 *
 */

public interface IPackDao {
	
	public List<Pack> getAllPack();

	public Pack getPackByNom(Pack p);

	public Pack getPacktById(Pack p);

	public Pack addPack(Pack p);

	public int updatePack(Pack p);

	public int deletePack(Pack p);
	
	
}
