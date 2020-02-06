package controleur;

import java.util.List;

import interfaces.vue.IVueTestUnitaireCrud;
import modele.Client;
import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import interfaces.dao.IClientDao;
import database.XmlClientDao;
import static factory.ClientFactory.getClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUnitaireControleur {
  
  private IClientDao daoClient;

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
    
    boolean result = false;
    
		daoClient = mock(XmlClientDao.class);
		

		//assertNotNull(daoClient.getClientById("5"));    
    /*try{
      when(daoClient.getClientById("5")).thenReturn(getClient("5", MORALE, "JOYEUX", "STEPHANE", "42"));
		  assertEquals("5", daoClient.getClientById("5").getId());
      result = true;
    }catch(AssertionError e){
      result = false;
    }*/
      
    return result;
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
