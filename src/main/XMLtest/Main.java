
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.*;
import java.io.*;
import org.w3c.dom.*;


@SuppressWarnings("unused")
public class Main
{
	public static void main(String[] args)
	{		
		Settings theSettings = new Settings(0, 0, 0, null);

		try {
			File inputFile = new File("file.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("PIN");
			Node nNode = nList.item(0);
			System.out.print("\n" + nNode.getNodeName());
			Element eElement = (Element) nNode;
			System.out.println(": " + eElement.getAttribute("val"));
			
			nList = doc.getElementsByTagName("profilePicID");
			nNode = nList.item(0);
			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
			System.out.println(": " + eElement.getAttribute("val"));
			
			nList = doc.getElementsByTagName("configureN");
			nNode = nList.item(0);
			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
			System.out.println(": " + eElement.getAttribute("val"));
			
			nList = doc.getElementsByTagName("serverURL");
			nNode = nList.item(0);
			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
			System.out.println(": " + eElement.getAttribute("val"));
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Settings");
			doc.appendChild(rootElement);

			// Element
			Element uno = doc.createElement("PIN");
			rootElement.appendChild(uno);
			// Attribute
			Attr attr1 = doc.createAttribute("val");
			attr1.setValue("" + theSettings.getPIN());
			uno.setAttributeNode(attr1);

			// Element
			Element dos = doc.createElement("profilePicID");
			rootElement.appendChild(dos);
			// Attribute
			Attr attr2 = doc.createAttribute("val");
			attr2.setValue("" + theSettings.getprofilePicID());
			dos.setAttributeNode(attr2);

			// Element
			Element tres = doc.createElement("configureN");
			rootElement.appendChild(tres);
			// Attribute
			Attr attr3 = doc.createAttribute("val");
			attr3.setValue("" + theSettings.getconfigureN());
			tres.setAttributeNode(attr3);

			// Element
			Element cuatro = doc.createElement("serverURL");
			rootElement.appendChild(cuatro);
			// Attribute
			Attr attr4 = doc.createAttribute("val");
			attr4.setValue(theSettings.getserverURL());
			cuatro.setAttributeNode(attr4);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("file.xml"));
			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
