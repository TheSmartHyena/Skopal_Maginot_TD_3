package main;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import static factory.ClientFactory.getClient;

import java.util.Iterator;
import java.util.List;

import enumerations.persistance.EPersistance;
import factory.DaoFactory;
import modele.Client;
import modele.PersonneMorale;
import modele.PersonnePhysique;
import controleur.TestUnitaireControleur;
import vue.TestUnitaireCrudVue;
import interfaces.vue.IVueTestUnitaireCrud;

import java.lang.reflect.Method;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
       
    System.out.println("");
		System.out.println("-------> I. Test unitaires CRUD : ");
    
    TestUnitaireCrudVue vueTestUnitaire = new TestUnitaireCrudVue();
    TestUnitaireControleur controleurTestUnitaire = new TestUnitaireControleur(vueTestUnitaire);
    vueTestUnitaire.setControleur(controleurTestUnitaire);
    
    vueTestUnitaire.afficherTestGetList();
    vueTestUnitaire.afficherTestGetClientById();
    vueTestUnitaire.afficherTestCreateCient();
    vueTestUnitaire.afficherTestUpdateClient();
    vueTestUnitaire.afficherTestDeleteClient();
   
    System.out.println("");
		System.out.println("-------> II. Travail demandé : ");
    
    DaoFactory daosA = DaoFactory.getDaoFactory(EPersistance.XML);
    Client clientA = daosA.getClientDao().getClientById("5");
    
    DaoFactory daosB = DaoFactory.getDaoFactory(EPersistance.MEMORY);
    Client clientB = daosB.getClientDao().getClientById("5");
    
    System.out.println("Id: " + clientA.getId() + " Nom: " + clientA.getNom() + " Prénom: " + clientA.getPrenom());
    System.out.println("Id: " + clientB.getId() + " Nom: " + clientB.getNom() + " Prénom: " + clientB.getPrenom());
    
    
    
	}

}
