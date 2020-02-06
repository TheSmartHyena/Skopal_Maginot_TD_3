package interfaces.vue;

/* Test le Crud */
public interface IVueTestUnitaireCrud {

	/* Affiche le résultat du test sur le getList ==> Read */
	void afficherTestGetList();
  
  /* Affiche le client avec l'id: 5 ==> Read */
	void afficherTestGetClientById();
  
  /* Affiche le résultat du test sur le Create */
  void afficherTestCreateCient();
  
  /* Affiche le résultat du test sur le Update */
  void afficherTestUpdateClient();
  
  /* Affiche le résultat du test sur le Delete */
  void afficherTestDeleteClient();

}
