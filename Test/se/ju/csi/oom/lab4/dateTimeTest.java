package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class dateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime testOb = new DateTime(2018, 10, 03, 11,34, 00);
		assertEquals("2018-10-03 11:34", testOb.toString());
	}

	@Test
	public void testDateTimeString() {
		DateTime testOb = new DateTime("2018-10-03 11:34:00");
		assertEquals("2018-10-03 11:34:00", testOb.toString());
	}

}
