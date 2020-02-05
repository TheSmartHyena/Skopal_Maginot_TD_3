package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;

import java.util.ArrayList;
import java.util.List;

import factory.ClientFactory;
import interfaces.dao.IClientDao;
import modele.Client;
import xml.XmlTools;

public class XmlClientDao implements IClientDao {

  private static XmlClientDao instance;
  private XmlTools myXmlTools;
  
  private XmlClientDao() {
    
    try{
      myXmlTools = new XmlTools("src/database/xml/xmlDatabase.xml");
    }catch(Exception e){
      System.out.println(e);
    }

  }

  public static XmlClientDao getInstance() {
    System.out.println("XmlClientDao !");
    if (instance == null) {
      instance = new XmlClientDao();
    }
    return instance;
  }

  @Override
  public void create(Client toCreate) {
    // TODO Auto-generated method stub
    try{
      myXmlTools.open();
      boolean result = myXmlTools.createClient(toCreate);

    }catch(Exception e){
      System.out.println(e);
    }

  }

  @Override
  public void update(Client objet) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Client objet) {
    // TODO Auto-generated method stub

  }
  
  @Override
  public Client read() {
    // TODO Auto-generated method stub

    return null;
  }

  @Override
  public List<Client> getList() {
    
    List<Client> result = null;
    
    try{
      
      myXmlTools.open();
      result = myXmlTools.getList();
      
    }catch(Exception e){
      System.out.println(e);
    }
    
    return result;
  }

  @Override
  public Client getClientById(String id){
    
    Client result = null; 
    
    try{
      
      myXmlTools.open();
      result = myXmlTools.getClientById(id);
      
    }catch(Exception e){
      System.out.println(e);
    }
    
    return result;
    
  }
  
}
