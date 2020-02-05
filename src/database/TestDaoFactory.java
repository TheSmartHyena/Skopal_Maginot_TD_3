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

import database.mysql.MySqlClientDao;
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
		assertEquals(null, daoClient.getClientById(1));
	}

	@Test
	public void testGetClientByIdAvecMockito() throws Exception {
		daoClient = mock(MySqlClientDao.class);
		when(daoClient.getClientById(anyInt())).thenReturn(getClient(MORALE, "JOYEUX", "STEPHANE"));
		assertNotNull(daoClient.getClientById(1));
		assertEquals("JOYEUX", daoClient.getClientById(1).getNom());
		assertEquals("JOYEUX", daoClient.getClientById(15).getNom());
	}

	@Test
	public void testGetNombreClientsAvecMockito() throws Exception {
		List<Client> clients = createClients();
		daoClient = mock(MySqlClientDao.class);
		when(daoClient.getList()).thenReturn(clients);
		assertEquals(2, daoClient.getList().size());
	}

	private List<Client> createClients() throws Exception {
		List<Client> clients = new ArrayList<>();
		clients.add(ClientFactory.getClient(MORALE, "JOYEUX", "STEPHANE"));
		clients.add(ClientFactory.getClient(PHYSIQUE, "JOYEUX", "LUCAS"));
		return clients;
	}
}
