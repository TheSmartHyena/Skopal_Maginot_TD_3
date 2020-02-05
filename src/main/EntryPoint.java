package main;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import static factory.ClientFactory.getClient;

import java.util.Iterator;
import java.util.List;

import controleur.ClientControleur;
import enumerations.persistance.EPersistance;
import factory.DaoFactory;
import modele.Client;
import vue.ClientVue;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
    
		System.out.println("");
		System.out.println("-------> III. Partie DAO : ");
		
    DaoFactory daos = DaoFactory.getDaoFactory(EPersistance.XML);
		//List<Client> clients = daos.getClientDao().getList();
    
    //System.out.println(clients.size());
    //Client testClient = getClient(PHYSIQUE, "JOYEUX", "LUCAS");
    
    // daos.getClientDao().read(2);
    List<Client> clients = daos.getClientDao().getList();
    
		for (Iterator iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			System.out.println(client.getNom() + " "  + client.getPrenom());
		}
    
    
    
	}

}
