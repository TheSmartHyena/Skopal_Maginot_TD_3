package interfaces.dao;

import modele.Client;

public interface IClientDao extends IDao<Client> {

	Client getClientById(int id);

}
