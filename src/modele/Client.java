package modele;

public class Client {

	private String id;
	private String nom;
	private String prenom;

	public Client(String id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getId() {
		return id;
	}

	public Client() {}
	
	public String getNom() {
		return nom;

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setId(String id) {
		this.id = id;
	}

}
