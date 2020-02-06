package vue;

import controleur.TestUnitaireControleur;
import interfaces.vue.IVueTestUnitaireCrud;

public class TestUnitaireCrudVue implements IVueTestUnitaireCrud {

	/* La vue connait son controleur */
	private TestUnitaireControleur controleur;

	@Override
	public void afficherTestGetList(){
    boolean result = controleur.testGetList();
    if(result){
      System.out.println("Test unitaire de la méthode: getList, de la classe: XmlCientDao: Réussi");
    }else{
      System.out.println("Test unitaire de la méthode: getList, de la classe: XmlCientDao: Echoué");
    }
  }
  
  @Override
	public void afficherTestGetClientById(){
    boolean result = controleur.testGetClientById();
    if(result){
      System.out.println("Test unitaire de la méthode: getById, de la classe: XmlCientDao: Réussi");
    }else{
      System.out.println("Test unitaire de la méthode: getById, de la classe: XmlCientDao: Echoué");
    }
  }
  
  @Override
  public void afficherTestCreateCient(){
    boolean result = controleur.testCreate();
    if(result){
      System.out.println("Test unitaire de la méthode: create, de la classe: XmlCientDao: Réussi");
    }else{
      System.out.println("Test unitaire de la méthode: create, de la classe: XmlCientDao: Echoué");
    }
  }
  
  @Override
  public void afficherTestUpdateClient(){
    boolean result = controleur.testUpdate();
    if(result){
      System.out.println("Test unitaire de la méthode: update, de la classe: XmlCientDao: Réussi");
    }else{
      System.out.println("Test unitaire de la méthode: update, de la classe: XmlCientDao: Echoué");
    }
  }
  
  @Override
  public void afficherTestDeleteClient(){
    boolean result = controleur.testDelete();
    if(result){
      System.out.println("Test unitaire de la méthode: delete, de la classe: XmlCientDao: Réussi");
    }else{
      System.out.println("Test unitaire de la méthode: delete, de la classe: XmlCientDao: Echoué");
    }
  }

	public TestUnitaireControleur getControleur() {
		return controleur;
	}

	public void setControleur(TestUnitaireControleur controleur) {
		this.controleur = controleur;
	}
  
  
}
