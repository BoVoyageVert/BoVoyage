package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;


public interface IClientDao {
	
	public int addClient(Client cl);
	public int updateClient(Client cl);
	public int deleteClient(Client cl);
	public Client getClientById(Client cl);
	public Client getClientByNum(Client cl);	
	public List<Client> getAllClients();

}