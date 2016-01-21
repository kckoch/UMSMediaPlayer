package cpsc3720.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator cal = new Calculator();
		assertEquals(5, cal.add(2, 3));
	}

}
