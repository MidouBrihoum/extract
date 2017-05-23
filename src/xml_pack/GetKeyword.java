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


public class GetKeyword {
	 File fXmlFile;	
	 List<String> Keyword;
	 
	 public List<String> getKeyword() {
			return Keyword;
		}
	 
	GetKeyword(File xml){
		this.fXmlFile=xml;
		getkey();
	}
	
	void getkey(){
		Keyword = new ArrayList<String>(); 

		  try {

				 fXmlFile = new File("IBC.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				
				Node Keywords = doc.getElementsByTagName("keywords").item(0);

				for (int temp = 0; temp < Keywords.getChildNodes().getLength(); temp++) {
					if (Keywords.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) Keywords;
				try{	Keyword.add(eElement.getElementsByTagName("Keyword").item(temp).getTextContent());} catch(Exception ex){}
					}
					
					 
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		  
		  }

	
	void print(){

		  for (int temp = 0; temp < Keyword.size(); temp++) {
			  try{
		  System.out.println(Keyword.get(temp).toString());} catch(Exception e){}
		  System.out.println("--------------");}
		  System.out.println("taille totale de la liste : "+ Keyword.size());
	}
		
	/*
  public static void main(String[] args) {
	  File ibc = new File("IBC.xml");
		GetKeyword x = new GetKeyword(ibc);
		
		//x.print();
	  
}*/
	
}