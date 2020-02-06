package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;

import java.util.ArrayList;
import java.util.List;

import factory.ClientFactory;
import interfaces.dao.IClientDao;
import modele.Client;

public class MemoryClientDao implements IClientDao {

	private static MemoryClientDao instance;

	private MemoryClientDao() {

	}

	public static MemoryClientDao getInstance() {
		if (instance == null) {
			instance = new MemoryClientDao();
		}
		return instance;
	}

	@Override
	public void create(Client objet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Client objet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client objet) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getList() {
		List<Client> clients = new ArrayList<>();
		try {
      
			clients.add(ClientFactory.getClient("1", MORALE, "JOYEUX", "STEPHANE", "42"));
			clients.add(ClientFactory.getClient("2", PHYSIQUE, "JOYEUX", "LUCAS", "10"));
			clients.add(ClientFactory.getClient("3", PHYSIQUE, "JOYEUX", "JULIE", "10"));
      clients.add(ClientFactory.getClient("5", PHYSIQUE, "Noel", "Père", "300"));
      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getClientById(String id) {
      
    Client result = null; 
    List<Client> clients = this.getList();
    for (int i=0; i < clients.size(); i++) {
      Client client = clients.get(i);

      if(client.getId().equals(id)){
        result = client;
        break;
      }
      
    }
    return result;
	}
  
}
