package test.java;




import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoadUnitTest {
	
	protected Setting testSetting;
	int setting1, setting3;
	String setting2, setting4;
	String loadFilePath;
	
	@Before
	public void setUp() throws Exception {
		setting1 = 17;
		setting2 = "TESTING";
		setting3 = 25;
		setting4 = "MORETEST";
		testSetting = new Setting(0, null, 0, null);
		loadFilePath = "testLoad.xml";
	}
	
	@Test
	public void testLoad() {
		//fail("Not yet implemented");
		
		testSetting.loadXML(loadFilePath);
		
		assertTrue(testSetting.getPIN() == setting1);
		assertTrue(testSetting.getprofilePicPath().equals(setting2));
		assertTrue(testSetting.getconfigureN() == setting3);
		assertTrue(testSetting.getserverURL().equals(setting4));
	}

}
