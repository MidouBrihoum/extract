package xml_pack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

//helloo
public class GetOperation {
	File fXmlFile;
	Document doc;
	 List<Operation> operation;
	 List<Part> Lpart ;
	 
	GetOperation(File xml){
		this.fXmlFile=xml;
		GetOp();
		
	}
	void GetOp(){
				operation = new ArrayList<Operation>(); 

		  try {

				 fXmlFile = new File("IBC.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();

	
				
				NodeList operations = doc.getElementsByTagName("operation");

				for (int temp = 0; temp < operations.getLength(); temp++) {
					Node tempOp = operations.item(temp);
					if (tempOp.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) tempOp;
						
						String Opname;
						Opname= eElement.getAttribute("name");   //Nom de l'opération
						Node Opinput = eElement.getElementsByTagName("input").item(0);   //liste input de l'opération
						
						Element eElement2 = (Element) Opinput;
						String inputname =  eElement2.getAttribute("message");
																		
						Node inputMessage =getMessageFromName(inputname);
						List<Part> PartListe_inputMessage=getPartFromMessage(inputMessage);
						
						System.out.println("Operation: "+Opname);
						for (int i = 0; i < PartListe_inputMessage.size(); i++) {
							System.out.println("paramètre numéro "+(i+1)+":");
							System.out.println("partname: "+ PartListe_inputMessage.get(i).name);
							System.out.println("parttype: "+PartListe_inputMessage.get(i).type);
							System.out.println("*******");
						}
						System.out.println("---------------------------");																	
							}}
		  }catch (Exception e) {
						e.printStackTrace();
					    }		
				}

	
	
	Node getMessageFromName (String x){
		NodeList messages = doc.getElementsByTagName("message");
		
		for (int temp2 = 0; temp2 < messages.getLength(); temp2++) {
						
			Node tempmsg = messages.item(temp2);
			if (tempmsg.getNodeType() == Node.ELEMENT_NODE) {
				Element eElementmsg = (Element) tempmsg;
				String Msgname;
				Msgname= eElementmsg.getAttribute("name");
				
				if(Msgname.equals(x)){
				
		return tempmsg;
				}
	}}
		return null;
		}
	
	List<Part> getPartFromMessage(Node x){
		Lpart = new ArrayList<Part>();
		NodeList part = x.getChildNodes();
		for (int temp3 = 0; temp3 < part.getLength(); temp3++) {
			Node temppart = part.item(temp3);
			if (temppart.getNodeType() == Node.ELEMENT_NODE) {
				Element eElementpart = (Element) temppart;
				Lpart.add(new Part(eElementpart.getAttribute("name"),eElementpart.getAttribute("type")));
			}
		}
		return Lpart;
		
		
	}
	
	
		
	
  public static void main(String[] args) {
	  File ibc = new File("IBC.xml");
	  GetOperation x = new GetOperation(ibc);
		
//		x.print();
	  
}
}