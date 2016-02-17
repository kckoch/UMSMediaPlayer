import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	public static void main(String[] args) {
		// Empty Setting to store values in
		Setting theSetting = new Setting(0, null, 0, null);

		// Load testing
		theSetting.loadXML("file.xml");
		if (theSetting.getPIN() == 7)
			System.out.println("1 Correct");
		if (theSetting.getprofilePicPath().equals("pathname"))
			System.out.println("2 Correct");
		if (theSetting.getconfigureN() == 11)
			System.out.println("3 Correct");
		if (theSetting.getserverURL().equals("stuff"))
			System.out.println("4 Correct");


		// Save testing
		theSetting = new Setting(8, "test1", 9, "test2");
		theSetting.saveXML("file.xml");
		
		try {
			File inputFile = new File("file.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("PIN");
			Element eElement = (Element) nList.item(0);
			if(Integer.parseInt(eElement.getAttribute("val")) == 8)
				System.out.println("1 Correct");
			nList = doc.getElementsByTagName("profilePicPath");
			eElement = (Element) nList.item(0);
			if(eElement.getAttribute("val").equals("test1"))
				System.out.println("2 Correct");
			nList = doc.getElementsByTagName("configureN");
			eElement = (Element) nList.item(0);
			if(Integer.parseInt(eElement.getAttribute("val")) == 9)
				System.out.println("3 Correct");
			nList = doc.getElementsByTagName("serverURL");
			eElement = (Element) nList.item(0);
			if(eElement.getAttribute("val").equals("test2"))
				System.out.println("4 Correct");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
