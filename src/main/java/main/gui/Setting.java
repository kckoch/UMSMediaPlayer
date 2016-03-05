package main.gui;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Setting {
	//private int PIN;
	//private String profilePicPath;
	private int configureN; //only admin can modify
	private String serverURL; //only admin can modify
	private ArrayList<User> users;
	
	public Setting(int _configureN, String _serverURL) {
		configureN = _configureN;
		serverURL = _serverURL;
		users = new ArrayList<User>();
		users.add(new User("admin", true, 9999, 0));
	}

	public int getconfigureN() {
		return configureN;
	}

	public void setconfigureN(int configureN) {
		this.configureN = configureN;
	}

	public String getserverURL() {
		return serverURL;
	}

	public void setserverURL(String serverURL) {
		this.serverURL = serverURL;
	}
	
	public void addUser(User newUser)
	{
		users.add(newUser);
	}
	

	// Inputs current save data from XML file (Load function)
	void loadXML(String inputFileName) {
		// Read in XML file (Load)
		try {
			// Designate input file
			File inputFile = new File(inputFileName);
			// Create parser
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Parse input file
			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();

			//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			Node nNode;
			Node nNode2;
			Element eElement;
			
			// Implement User-loading here.
			NodeList nList = doc.getElementsByTagName("user");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				nNode = nList.item(temp);
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					User newUser;
					
					eElement = (Element) nNode;

					newUser = new User(eElement.getAttribute("name"),
							Boolean.parseBoolean(eElement.getElementsByTagName("admin").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("PIN").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("filter").item(0).getTextContent()));

					NodeList nList2 = doc.getElementsByTagName("favoriteAlbumID");
					for (int temp2 = 0; temp2 < nList.getLength(); temp2++) {
						nNode2 = nList2.item(temp2);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							eElement = (Element) nNode;
//							newUser.addFavorites();
						}
						
					}
					
					users.add(newUser);
				}
			}
			

			nList = doc.getElementsByTagName("configureN");
			nNode = nList.item(0);
//			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
//			System.out.println(": " + eElement.getAttribute("val"));
			// Sets value of configureN from XML data
			this.setconfigureN(Integer.parseInt(eElement.getAttribute("val")));

			nList = doc.getElementsByTagName("serverURL");
			nNode = nList.item(0);
//			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
//			System.out.println(": " + eElement.getAttribute("val"));
			// Sets value of serverURL from XML data
			this.setserverURL(eElement.getAttribute("val"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Outputs current save data to XML file (Save function)
	void saveXML(String outputFileName) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root element (Settings)
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Settings");
			doc.appendChild(rootElement);
			
			Element elem;
			Attr attr;
			
			// Implement User-saving here.
			Element xmluser;
			for(User tempUser : users) {
				xmluser = doc.createElement("user");
				rootElement.appendChild(xmluser);
				attr = doc.createAttribute("name");
				attr.setValue("" + tempUser.getName());
				xmluser.setAttributeNode(attr);
				
				elem = doc.createElement("admin");
				elem.appendChild(doc.createTextNode("" + tempUser.getAdmin()));
				xmluser.appendChild(elem);
				elem = doc.createElement("PIN");
				elem.appendChild(doc.createTextNode("" + tempUser.getPIN()));
				xmluser.appendChild(elem);
				elem = doc.createElement("filter");
				elem.appendChild(doc.createTextNode("" + tempUser.getFilter()));
				xmluser.appendChild(elem);
				for(Integer tempID : tempUser.getFavoritesIDs())
				{
					elem = doc.createElement("favoriteAlbumID");
					elem.appendChild(doc.createTextNode("" + tempID));
					xmluser.appendChild(elem);
				}
			}
			
			// Configure N Element
			Element xmlconfigureN = doc.createElement("configureN");
			rootElement.appendChild(xmlconfigureN);
			// Attribute
			attr = doc.createAttribute("val");
			attr.setValue("" + this.getconfigureN());
			xmlconfigureN.setAttributeNode(attr);

			// Server URL Element
			Element xmlserverURL = doc.createElement("serverURL");
			rootElement.appendChild(xmlserverURL);
			// Attribute
			attr = doc.createAttribute("val");
			attr.setValue(this.getserverURL());
			xmlserverURL.setAttributeNode(attr);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputFileName));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
