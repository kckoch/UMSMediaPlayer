package main.model;

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
//		users.add(new User("admin", true, 9999, 0));
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
	
	public User getUser(int n)
	{
		return users.get(n);
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
// Loads in XML save data
	public void loadXML(String inputFileName) {
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

			NodeList nList;
			Node nNode;
			Node nNode1;
			Node nNode2;
			Element eElement;
			Element eElement1;
			Element eElement2;
			
			// Implement User-loading here.
			NodeList nUsers;
			NodeList nAlbums;
			NodeList nTracks;
//			Album tempAlbum;
//			Track tempTrack;
			//ArrayList<Album> favAlbums;
			ArrayList<Track> favTracks;
			User newUser;
			Album newAlbum;
//			Track newTrack;
			nUsers = doc.getElementsByTagName("user");
			for (int temp = 0; temp < nUsers.getLength(); temp++) {
				nNode = nUsers.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;

					newUser = new User(eElement.getAttribute("name"),
							Boolean.parseBoolean(eElement.getElementsByTagName("admin").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("PIN").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("filter").item(0).getTextContent()));
					newUser.setIcon(eElement.getElementsByTagName("icon").item(0).getTextContent());

					nAlbums = eElement.getElementsByTagName("album");
					for (int temp1 = 0; temp1 < nAlbums.getLength(); temp1++) {
						nNode1 = nAlbums.item(temp1);
						if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
							eElement1 = (Element) nNode1;
							
							favTracks = new ArrayList<Track>();
							nTracks = eElement1.getElementsByTagName("track");
							for (int temp2 = 0; temp2 < nTracks.getLength(); temp2++) {
								nNode2 = nTracks.item(temp2);
								if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
									eElement2 = (Element) nNode2;
									//Track(long duration, String trackTitle, String trackURL, String newArtist)
									favTracks.add(new Track(Long.parseLong(eElement2.getElementsByTagName("totalTime").item(0).getTextContent()),
											eElement2.getAttribute("name"),
											eElement2.getElementsByTagName("mediaURL").item(0).getTextContent(),
											eElement2.getElementsByTagName("artist").item(0).getTextContent()));
								}
							}
							newAlbum = new Album(eElement1.getAttribute("name"),
									favTracks,
									eElement1.getElementsByTagName("mediaURL").item(0).getTextContent());
							newUser.addFavorite(newAlbum);
						}
					}
					users.add(newUser);
				}
			}
			

			nList = doc.getElementsByTagName("configureN");
			nNode = nList.item(0);
			eElement = (Element) nNode;
			// Sets value of configureN from XML data
			this.setconfigureN(Integer.parseInt(eElement.getAttribute("val")));

			nList = doc.getElementsByTagName("serverURL");
			nNode = nList.item(0);
			eElement = (Element) nNode;
			// Sets value of serverURL from XML data
			this.setserverURL(eElement.getAttribute("val"));
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println("File loaded!");
	}

// Outputs XML save data
	public void saveXML(String outputFileName) {
		// Output XML file (Save)
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
			Element xmlalbum;
			Element xmltrack;
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
				elem = doc.createElement("icon");
				elem.appendChild(doc.createTextNode("" + tempUser.getIcon()));
				xmluser.appendChild(elem);
				for(Album tempAlbum : tempUser.getFavorites())
				{
					xmlalbum = doc.createElement("album");
					xmluser.appendChild(xmlalbum);
					attr = doc.createAttribute("name");
					attr.setValue("" + tempAlbum.getName());
					xmlalbum.setAttributeNode(attr);
					
					for(Track tempTrack : tempAlbum.getTracks())
					{
						xmltrack = doc.createElement("track");
						xmlalbum.appendChild(xmltrack);
						attr = doc.createAttribute("name");
						attr.setValue("" + tempTrack.getTitle());
						xmltrack.setAttributeNode(attr);
						
						elem = doc.createElement("totalTime");
						elem.appendChild(doc.createTextNode("" + tempTrack.getTotalTime()));
						xmltrack.appendChild(elem);
						elem = doc.createElement("mediaURL");
						elem.appendChild(doc.createTextNode("" + tempTrack.getMediaURL()));
						xmltrack.appendChild(elem);
						elem = doc.createElement("artist");
						elem.appendChild(doc.createTextNode("" + tempTrack.getArtist()));
						xmltrack.appendChild(elem);
					}
					elem = doc.createElement("mediaURL");
					elem.appendChild(doc.createTextNode("" + tempAlbum.getMediaURL()));
					xmlalbum.appendChild(elem);
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

//			System.out.println("File saved!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
