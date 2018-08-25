package fr.adaming.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{
	
	
	@Autowired
	IClientDao clDao;
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	@Override
	public int addClient(Client cl) {	
		return clDao.addClient(cl);
	}

	@Override
	public int updateClient(Client cl) {
		return clDao.updateClient(cl);
	}

	@Override
	public int deleteClient(Client cl) {
		return clDao.deleteClient(cl);
	}

	@Override
	public Client getClientById(Client cl) {
		return clDao.getClientById(cl);
	}

	@Override
	public Client getClientByNum(Client cl) {
		return clDao.getClientByNum(cl);
	}

	@Override
	public List<Client> getAllClients() {
		return clDao.getAllClients();
	}

}
