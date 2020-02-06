package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import static enumerations.persistance.EPersistance.MEMORY;
import static factory.ClientFactory.getClient;
import static factory.DaoFactory.getDaoFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import database.MemoryClientDao;
import factory.ClientFactory;
import factory.DaoFactory;
import interfaces.dao.IClientDao;
import modele.Client;

public class TestDaoFactory {

	private DaoFactory dao;
	private IClientDao daoClient;

	@Before
	public void setUp() throws Exception {
		// Sans mockito :
		dao = getDaoFactory(MEMORY);
		daoClient = dao.getClientDao();
	}

	@Test
	public void testGetNombreClientsSansMockito() {
		assertEquals(3, daoClient.getList().size());
	}

	@Test
	public void testGetClientByIdSansMockito() {
		assertEquals(null, daoClient.getClientById("1"));
	}

	@Test
	public void testGetClientByIdAvecMockito() throws Exception {
    System.out.println("Je passe par: testGetClientByIdAvecMockito");
		daoClient = mock(MemoryClientDao.class);
		when(daoClient.getClientById("drg")).thenReturn(getClient("1", MORALE, "JOYEUX", "STEPHANE", "42"));
    
		assertNotNull(daoClient.getClientById("1"));
    
		assertEquals("JOYEUX", daoClient.getClientById("1").getNom());
		assertEquals("JOYEUX", daoClient.getClientById("3630").getNom());
	}

	@Test
	public void testGetNombreClientsAvecMockito() throws Exception {
    
    System.out.println("Je passe par ici");
		List<Client> clients = createClients();
		daoClient = mock(MemoryClientDao.class);
		when(daoClient.getList()).thenReturn(clients);
		assertEquals(2, daoClient.getList().size());
    
    //System.out.println(daoClient.getList().size());
	}

	private List<Client> createClients() throws Exception {
		List<Client> clients = new ArrayList<>();
		clients.add(ClientFactory.getClient("1", MORALE, "JOYEUX", "STEPHANE", "42"));
		clients.add(ClientFactory.getClient("2", MORALE, "JOYEUX", "STEPHANE", "10"));
		return clients;
	}
}
