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


public class GetOperation {
	
//	File fXmlFile;
	List<Operation> operationList;
	
	Element GlobalElement;
	 public List<Operation> getOperationList() {
		return operationList;
	}
	 
	List<Part> Lpart ;
	 
	GetOperation(Element e){
		this.GlobalElement=e;
		GetOp();
		
	}
	
	
	
	
	
	public void GetOp(){
				
		operationList = new ArrayList<Operation>(); 

		  try {

		//	Document	IBCdoc = getDocumentFromXmlFileName ("IBC.xml"); // retourne document depuis le nom du fichier XML
	
				
		//	GlobalElement = IBCdoc.getDocumentElement(); 
				NodeList operations = GlobalElement.getElementsByTagName("operation"); // Liste des operations

				
				
				
				for (int temp = 0; temp < operations.getLength(); temp++) { // loop pour chaque operation
					Node tempOp = operations.item(temp); 
					if (tempOp.getNodeType() == Node.ELEMENT_NODE) {
						
						Element OperationElement = (Element) tempOp; // element operaiton
						
						
						String Opname= OperationElement.getAttribute("name");   //Nom de l'operation
						
						List<Part> PartListe_InputMessage = GetIN_OutFromOperation("input",OperationElement,GlobalElement); //retrouver la liste PART input
						List<Part> PartListe_OutputMessage = GetIN_OutFromOperation("output",OperationElement,GlobalElement);//retrouver la liste PART input
						List<Part> PartListe_Preconditions = GetPre_PostConditionFromOperation ("Precondition" ,OperationElement);//retrouver la liste des préconditions depuis l'operation
						List<Part> PartListe_Postconditions = GetPre_PostConditionFromOperation ("Postcondition" ,OperationElement);//retrouver la liste des PostConditions depuis l'operation

						operationList.add(new Operation(Opname, PartListe_InputMessage, PartListe_OutputMessage, PartListe_Preconditions, PartListe_Postconditions));
							
							}}
			
		  }catch (Exception e) {
						e.printStackTrace();
					    }
				
				}

	
	//------------------ les fonctions ------------------------
	
	
	
	
	
	
	
	//-----------------------------------------
	Node getMessageFromName (String x ,Element y){
		NodeList messages = y.getElementsByTagName("message");
		
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
	

	//----------------------------------
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
	
	List<Part> GetIN_OutFromOperation (String x ,Element e, Element y  ) {
		
		Node Opinput = e.getElementsByTagName(x).item(0);   // input de l'operation
		
		Element eElement2 = (Element) Opinput;                            // element input de l'opreation
		String inputname =  eElement2.getAttribute("message"); // retrouver le nom du message qu'utilise l'input
														
		Node inputMessage =getMessageFromName(inputname,y);  // retrouver le node du message depuis son nom
		
		List<Part> PartListe_Message=getPartFromMessage(inputMessage); // une liste pour retourner les paramétre des mesage ( dans un objet part)
		return(PartListe_Message);
	}
	
	//--------------------------------------------------
	
	
	
	
List<Part> GetPre_PostConditionFromOperation (String x ,Element e) {
	
	
		Node ConditionsNode = e.getElementsByTagName("conditions").item(0); // retrouver la balise Condition
		
	return(getPartFromCondition(ConditionsNode,x ))	;
		
	}
	
	//-------------------------------------

List<Part> getPartFromCondition(Node x,String s ){
	
	
	Lpart = new ArrayList<Part>();
	Element Conditions = (Element) x; // element Condition depuis le noeud conditions
	

	NodeList part = Conditions.getElementsByTagName(s);
	
	for (int temp3 = 0; temp3 < part.getLength(); temp3++) {
		Node temppart = part.item(temp3);
		if (temppart.getNodeType() == Node.ELEMENT_NODE) {
			Element eElementpart = (Element) temppart;
			Lpart.add(new Part(eElementpart.getAttribute("name"),eElementpart.getTextContent()));
		}
	}
	return Lpart;
	
	
}
	

//------------------ test print ---------------
	
//------------------fin  test print -----------------	
	

	
	
	
	
	
	
	
	
	
	
	
		
	
  public static void main(String[] args) {


  }
}