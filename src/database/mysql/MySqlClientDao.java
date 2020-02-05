package database.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.dao.IClientDao;
import modele.Client;

public class MySqlClientDao implements IClientDao {

	private static MySqlClientDao instance;
	private Connection connection;

	private MySqlClientDao() {
		connection = ConnectionMySql.getConnection();
	}

	public static MySqlClientDao getInstance() {
		if (instance == null) {
			instance = new MySqlClientDao();
		}
		return instance;
	}

	@Override
	public void create(Client objet) {

	}

	@Override
	public void update(Client objet) {

	}

	@Override
	public void delete(Client objet) {

	}

	@Override
	public Client read() {

		return null;
	}

	@Override
	public List<Client> getList() {
		List<Client> clients = new ArrayList<>();
		PreparedStatement requete = null;
		try {
			requete = connection.prepareStatement("select * from client");
		} catch (SQLException e) {
			System.out.println("erreur " + e.getMessage());
		}
		try {
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				clients.add(new Client(res.getString("id"), res.getString("nom"), res.getString("prenom")));
			}
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();

		} catch (SQLException e) {
			System.out.println("erreur 2 " + e.getMessage());
		}

		return clients;
	}

	@Override
	public Client getClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
