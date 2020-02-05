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
import modele.PersonneMorale;
import modele.PersonnePhysique;
import vue.ClientVue;

import java.lang.reflect.Method;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
    
		System.out.println("");
		System.out.println("-------> III. Partie DAO : ");
		
    DaoFactory daos = DaoFactory.getDaoFactory(EPersistance.XML);
    // List tout les clients
    
    /*List<Client> clients = daos.getClientDao().getList();
		for (Iterator iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			System.out.println(client.getId() + " " + client.getNom() + " "  + client.getPrenom());
      //System.out.println(client.getClass().getName());
      
      if(client instanceof PersonneMorale){
        System.out.println("Code insee: ");
        System.out.println(((PersonneMorale)client).getCodeInsee());
      }else if(client instanceof PersonnePhysique){
        System.out.println("Age: ");
        System.out.println(((PersonnePhysique)client).getAge());
      }
      
		}*/
    
    // GetById()
    
    /*Client client = daos.getClientDao().getClientById("5");
    if(client != null){
      System.out.println(client.getId() + " " + client.getNom() + " "  + client.getPrenom());
    }else{
      System.out.println("Null client");
    }*/
    
    // Create an element
    /*Client toCreate = factory.ClientFactory.getClient(PHYSIQUE, "Hector", "Poivrot");
        
    toCreate.setId("5");
    ((PersonnePhysique)toCreate).setAge(88);
    
    daos.getClientDao().create(toCreate);*/
    
    // delete
    /*
    Client toCreate = factory.ClientFactory.getClient(MORALE, "PouetPouet", "Mdr");
    toCreate.setId("68");
    ((PersonneMorale)toCreate).setCodeInsee("68000");
    daos.getClientDao().create(toCreate);
    
    Client toDelete = daos.getClientDao().getClientById("68");
    
    daos.getClientDao().delete(toDelete);*/

	}

}
