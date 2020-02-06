package factory;

import enumerations.client.ETypeClient;
import modele.Client;
import modele.PersonneMorale;
import modele.PersonnePhysique;

public class ClientFactory {

	private ClientFactory() {
		// le constructeur est privé .. on ne peut pas instancier la classe.

	}

	public static Client getClient(String id, ETypeClient typeClient, String nom, String prenom, String mystere) throws Exception {
		switch (typeClient) {
		case MORALE:
			return createPersonneMorale(id, nom, prenom, mystere);
		case PHYSIQUE:
			return createPersonnePhysique(id, nom, prenom, Integer.parseInt(mystere));
		default:
			throw new Exception("Type de client Inconnu");
		}

	}

	private static Client createPersonneMorale(String id, String nom, String prenom, String codeInsee) {
		PersonneMorale client = new PersonneMorale();
		client.setNom(nom);
		client.setPrenom(prenom);
    client.setId(id);
    client.setCodeInsee(codeInsee);
		return client;
	}

	private static Client createPersonnePhysique(String id, String nom, String prenom, int age) {
		PersonnePhysique client = new PersonnePhysique();
		client.setNom(nom);
		client.setPrenom(prenom);
    client.setAge(age);
    client.setId(id);
		return client;
	}

}
