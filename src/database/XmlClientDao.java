package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;

import java.util.ArrayList;
import java.util.List;

import factory.ClientFactory;
import interfaces.dao.IClientDao;
import modele.Client;

public class XmlClientDao implements IClientDao {

	private static XmlClientDao instance;

	private XmlClientDao() {

	}

	public static XmlClientDao getInstance() {
		System.out.println("XmlClientDao !");
		if (instance == null) {
			instance = new XmlClientDao();
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
			clients.add(ClientFactory.getClient(MORALE, "JOYEUX", "STEPHANE"));
			clients.add(ClientFactory.getClient(PHYSIQUE, "JOYEUX", "LUCAS"));
			clients.add(ClientFactory.getClient(PHYSIQUE, "JOYEUX", "JULIE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getClientById(int id) {
		return null;
	}

}
