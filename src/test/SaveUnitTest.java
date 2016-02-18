package test;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SaveUnitTest {
	
	protected Setting testSetting, checkSetting;
	int setting1, setting3;
	String setting2, setting4;
	String saveFilePath;
	
	@Before
	public void setUp() throws Exception {
		setting1 = 17;
		setting2 = "TESTING";
		setting3 = 25;
		setting4 = "MORETEST";
		testSetting = new Setting(setting1, setting2, setting3, setting4);
		checkSetting = new Setting(0, null, 0, null);
		saveFilePath = "testSave.xml";
	}
	
	@Test
	public void testSave() {
		//fail("Not yet implemented");
		
		testSetting.saveXML(saveFilePath);
		
		checkSetting.loadXML(saveFilePath);
		
		assert(checkSetting.getPIN() == setting1);
		assert(checkSetting.getprofilePicPath().equals(setting2));
		assert(checkSetting.getconfigureN() == setting3);
		assert(checkSetting.getprofilePicPath().equals(setting4));
		/*
		try {
			File inputFile = new File(saveFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("PIN");
			Element eElement = (Element) nList.item(0);
			assert(Integer.parseInt(eElement.getAttribute("val")) == setting1);
			
			nList = doc.getElementsByTagName("profilePicPath");
			eElement = (Element) nList.item(0);
			assert(eElement.getAttribute("val").equals(setting2));
			
			nList = doc.getElementsByTagName("configureN");
			eElement = (Element) nList.item(0);
			assert(Integer.parseInt(eElement.getAttribute("val")) == setting3);
			
			nList = doc.getElementsByTagName("serverURL");
			eElement = (Element) nList.item(0);
			assert(eElement.getAttribute("val").equals(setting4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	

}
