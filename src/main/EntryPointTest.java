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

import database.TestDaoFactory;

public class EntryPointTest {

	public static void main(String[] args) throws Exception {
    
		System.out.println("");
		System.out.println("-------> III. Partie Test du DAO : ");
    
    TestDaoFactory testeur = new TestDaoFactory();
    testeur.testGetNombreClientsAvecMockito();
    testeur.testGetClientByIdAvecMockito();
		
	}
}
