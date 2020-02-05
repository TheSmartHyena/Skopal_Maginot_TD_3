package xml;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import enumerations.client.ETypeClient;
import static factory.ClientFactory.getClient;
import factory.ClientFactory;
import modele.Client;
import modele.PersonneMorale;
import modele.PersonnePhysique;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlTools{
  
  private String myPath= "";
  private NodeList myNodeList;
  
  public XmlTools() throws IncorrectXmlToolsInstanciationException {
    // raise an error
    throw new IncorrectXmlToolsInstanciationException("Incorrect instanciation: path empty");         
  }

  public XmlTools(String path) {
      // This constructor has one parameter, name.
     myPath = path;
     
  }
  
  public void newPath(String newPath){
    close();
    myPath = newPath;
  }
  
  public void open(){
    System.out.println("Opening:" + myPath);
    
    try {
      
      File inputFile = new File(myPath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      myNodeList = doc.getElementsByTagName("client");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public List<Client> getList() throws WrongClientTypeException{
    
    List<Client> result = new ArrayList<>();
    
    for (int i=0; i < myNodeList.getLength(); i++) {
      Node node = myNodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element el = (Element) node;
        //System.out.println("Id personne: " + el.getAttribute("id"));
                                  
        String nom = el.getElementsByTagName("nom").item(0).getTextContent().trim();
        String prenom = el.getElementsByTagName("prenom").item(0).getTextContent().trim();
        String type = el.getElementsByTagName("type").item(0).getTextContent().trim();    
        String id = el.getAttribute("id").trim();
        
        if(type.equals("morale")){  
          try{
            Client client = getClient(ETypeClient.MORALE, nom, prenom);
            client.setId(id);
            
            String codeInsee = el.getElementsByTagName("codeInsee").item(0).getTextContent().trim();
            //client.setCodeInsee(codeInsee);
            
            result.add(client);
          }catch(Exception e){
            e.printStackTrace();
          }

        }else if(type.equals("physique")){
          try{            
            Client client = getClient(ETypeClient.PHYSIQUE, nom, prenom);   
            client.setId(id);
            
            String age = el.getElementsByTagName("age").item(0).getTextContent().trim();
            //client.setAge(Integer.parseInt(age));
            
            result.add(client);
          }catch(Exception e){
            e.printStackTrace();
          }
          
          
          //client.setAge(Integer.parseInt(age));
          
        }else{
          throw new WrongClientTypeException("Mauvais type de client dans le fichier xml.");
        }           
        
        //System.out.println(client.getClass().getName());
        //client.setId(id);
        
      }
      
    }
    
    return result;
    
  }
  
  public Client getClientById(){
    return null;
  }
  
  public void close(){
    
  }
  
 
}