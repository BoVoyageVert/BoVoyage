package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@Autowired
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public int addClient(Client cl) {
		
		Session s = sf.getCurrentSession();
		s.save(cl);
		if (s.get(Client.class, cl.getIdClient()) != null){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public int updateClient(Client cl) {
		
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(cl);
		if (s.get(Client.class, cl.getIdClient()) != null) {
			return 1;
		} else {
			return 0;
		}
		
	
	}

	@Override
	public int deleteClient(Client cl) {
		Session s = sf.getCurrentSession();
		
		s.delete(cl);
		if ( s.get(Client.class, cl.getIdClient()) == null){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public Client getClientById(Client cl) {
		Session s = sf.getCurrentSession();
		
		
		return (Client) s.get(Client.class, cl.getIdClient());
	}

	@Override
	public Client getClientByNum(Client cl) {
		Session s = sf.getCurrentSession();
		return (Client) s.get(Client.class, cl.getNom());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		Session s = sf.getCurrentSession();
		String req = "FROM Client";
		Query query = s.createQuery(req);
		
		return query.list();
	}
	
	

}
