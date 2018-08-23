package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteClient(Client cl) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Client getClientById(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientByNum(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clDao.getAllClients();
	}

}
