package controleur;

import java.util.List;

import interfaces.vue.IVueTestUnitaireCrud;
import modele.Client;

public class TestUnitaireControleur {

	// Le contrôleur connait sa vue :
	private IVueTestUnitaireCrud vue;

	/* Le controleur connait sa vue */
	public TestUnitaireControleur(IVueTestUnitaireCrud vue) {
		this.vue = vue;
	}

	public IVueTestUnitaireCrud getVue() {
		return vue;
	}
  
  public boolean testGetList(){
    return true;
  }
  
  public boolean testGetClientById(){
    return true;
  }
  
  public boolean testCreate(){
    return true;
  }
  
  public boolean testUpdate(){
    return true;
  }
  
  public boolean testDelete(){
    return true;
  }
  
}
