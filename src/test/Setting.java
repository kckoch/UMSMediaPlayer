package test;
import java.io.File;

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

	int PIN, configureN;
	String profilePicPath, serverURL;

	Setting(int _PIN, String _profilePicPath, int _configureN, String _serverURL) {
		this.PIN = _PIN;
		this.profilePicPath = _profilePicPath;
		this.configureN = _configureN;
		this.serverURL = _serverURL;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int PIN) {
		this.PIN = PIN;
	}

	public String getprofilePicPath() {
		return profilePicPath;
	}

	public void setprofilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
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

			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("PIN");
			Node nNode = nList.item(0);
//			System.out.print("\n" + nNode.getNodeName());
			Element eElement = (Element) nNode;
//			System.out.println(": " + eElement.getAttribute("val"));
			// Sets value of PIN from XML data
			this.setPIN(Integer.parseInt(eElement.getAttribute("val")));

			nList = doc.getElementsByTagName("profilePicPath");
			nNode = nList.item(0);
//			System.out.print("\n" + nNode.getNodeName());
			eElement = (Element) nNode;
//			System.out.println(": " + eElement.getAttribute("val"));
			// Sets value of profilePicPath from XML data
			this.setprofilePicPath(eElement.getAttribute("val"));

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

	void saveXML(String outputFileName) {
		// Output XML file (Save)
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root element (Settings)
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Settings");
			doc.appendChild(rootElement);

			// PIN Element
			Element uno = doc.createElement("PIN");
			rootElement.appendChild(uno);
			// Attribute
			Attr attr1 = doc.createAttribute("val");
			attr1.setValue("" + this.getPIN());
			uno.setAttributeNode(attr1);

			// Profile Pic ID Element
			Element dos = doc.createElement("profilePicPath");
			rootElement.appendChild(dos);
			// Attribute
			Attr attr2 = doc.createAttribute("val");
			attr2.setValue(this.getprofilePicPath());
			dos.setAttributeNode(attr2);

			// Configure N Element
			Element tres = doc.createElement("configureN");
			rootElement.appendChild(tres);
			// Attribute
			Attr attr3 = doc.createAttribute("val");
			attr3.setValue("" + this.getconfigureN());
			tres.setAttributeNode(attr3);

			// Server URL Element
			Element cuatro = doc.createElement("serverURL");
			rootElement.appendChild(cuatro);
			// Attribute
			Attr attr4 = doc.createAttribute("val");
			attr4.setValue(this.getserverURL());
			cuatro.setAttributeNode(attr4);

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
