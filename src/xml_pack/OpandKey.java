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
import java.io.File;

public class OpandKey {
	List<Operation> operationList;

public OpandKey() {
		test();

		
		for (int i = 0; i < operationList.size(); i++) {

			System.out.println("parametre numero "+(i+1)+":");


<<<<<<< HEAD
GetOperation Operations;
GetKeyword Keywords;
String filename;

public OpandKey(GetOperation operations, GetKeyword keywords,String filename) {
	super();
	File ibc = new File(filename);
	Operations = operations;
	Keywords = keywords;
}

void 
=======
			System.out.println("partname: "+ operationList.get(i).opname);
			
			System.out.println("*******");
		}
		System.out.println("---------------------------");
	}


void test(){
	
	
	File ibc = new File("IBC.xml");
	Document	IBCdoc = getDocumentFromXmlFileName (ibc); // retourne document depuis le nom du fichier XML
	
	Element GlobalElement = IBCdoc.getDocumentElement(); // retourne element globale du docment
	
	GetOperation Operations = new GetOperation(GlobalElement);
	operationList = Operations.getOperationList();
	
}


public Document getDocumentFromXmlFileName (File f)
{

	Document doc=null;

	try {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(f);
		doc.getDocumentElement().normalize();
		
	} catch(Exception e ){
		
	}
	
	return doc;
	
	
>>>>>>> b7fcc4c3a94000b9a657ea21b4fd8c8200ca2ffd
}

public static void main(String [] args){
	new OpandKey();
}
}


