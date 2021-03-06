

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
		
		assertTrue(checkSetting.getPIN() == setting1);
		assertTrue(checkSetting.getprofilePicPath().equals(setting2));
		assertTrue(checkSetting.getconfigureN() == setting3);
		assertTrue(checkSetting.getserverURL().equals(setting4));

	}
	
	

}
