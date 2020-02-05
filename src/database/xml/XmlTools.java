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
import java.util.Iterator;
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTools{
  
  private String myPath= "";
  private NodeList myNodeList;
  private Document myDoc; 
  
  public XmlTools() throws IncorrectXmlToolsInstanciationException {
    // raise an error
    throw new IncorrectXmlToolsInstanciationException("Incorrect instanciation: path empty");         
  }

  public XmlTools(String path) {
      // This constructor has one parameter, name.
     myPath = path;
     
  }
  
    public XmlTools(NodeList nodelist) {
      // This constructor has one parameter, name.
     myNodeList = nodelist;
     
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
      myDoc = doc;
      
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
            ((PersonneMorale)client).setCodeInsee(codeInsee);
            
            result.add(client);
          }catch(Exception e){
            e.printStackTrace();
          }

        }else if(type.equals("physique")){
          try{            
            Client client = getClient(ETypeClient.PHYSIQUE, nom, prenom);   
            client.setId(id);
            
            String age = el.getElementsByTagName("age").item(0).getTextContent().trim();
            ((PersonnePhysique)client).setAge(Integer.parseInt(age));
            
            result.add(client);
          }catch(Exception e){
            e.printStackTrace();
          }
                 
        }else{
          throw new WrongClientTypeException("Mauvais type de client dans le fichier xml.");
        }           
             
      }
      
    }
    
    return result;
    
  }
  
  public Client getClientById(String id){
    
    Client result = null;
    List<Client> clients = null;
    
    try{
      clients = this.getList();
    }catch(Exception e){
      e.printStackTrace();
    }
      
    for (Iterator iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
            
      if(client.getId().equals(id)){
        result = client;
        break;
      }
      
    }
    
    return result;
    
  }
  
  public boolean createClient(Client toCreate){
    
    boolean result = false;
    
    try{
      
      // Get root
      Node clients = myDoc.getFirstChild();
      
      // On y ajoute un élement client vide
      Element client = myDoc.createElement("client");
      clients.appendChild(client);
      
      // On ajoute un id à notre élement vierge
      Attr attr = myDoc.createAttribute("id");
      attr.setValue(toCreate.getId());  
      client.setAttributeNode(attr);
      
      // On ajoute les 4 éléments en fonction du type de client envoyé
      client.appendChild(createElement("nom", toCreate.getNom()));
      client.appendChild(createElement("prenom", toCreate.getPrenom()));
            
      if(toCreate instanceof PersonnePhysique){
        client.appendChild(createElement("age", String.valueOf( ((PersonnePhysique)toCreate).getAge())) );
        client.appendChild(createElement("type", "physique"));
      }else if(toCreate instanceof PersonneMorale){
        client.appendChild(createElement("codeInsee", ((PersonneMorale)toCreate).getCodeInsee()));
        client.appendChild(createElement("prenom", "morale"));
      }
      
      // Write the new file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(myDoc);
      StreamResult streamResult = new StreamResult(new File(myPath));
      transformer.transform(source, streamResult);
      
      result = true;
      
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return result;
    
  }
  
  private Element createElement(String name, String value){
    
    Element result = myDoc.createElement(name);
    result.appendChild(myDoc.createTextNode(value));
    
    return result;
    
  }
  
  public void close(){
    // useless because of the garbage collector and no stream
  }
  
}