package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime theDayAfterNY = new DateTime(2018, 01, 01, 2, 30, 30);
		DateTime newYearsEve = new DateTime(2017, 12, 31, 22, 30, 30);
		
		DateTime negShiftedTimeZone = TimeZoneTranslator.shiftTimeZone(theDayAfterNY, -2, -6);
		DateTime posShiftedTimeZone = TimeZoneTranslator.shiftTimeZone(newYearsEve, 6, 10);
		
		assertEquals(newYearsEve.toString(), negShiftedTimeZone.toString());
		assertEquals(theDayAfterNY.toString(), posShiftedTimeZone.toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		Person partis = new Person("Christopher Valfridsson");
		Place somePlace = new Place("somePlace", 30.24856, 25.1651, 354.5);
		
		Event testEvent = new Event("testEvent",
				new DateTime(2018, 01, 01, 2, 30, 30), 
				new DateTime(2017, 12, 31, 7, 30, 30), 
				new HashSet<>(Arrays.asList(partis)), 
				somePlace);
		
		Event shiftedEvent = TimeZoneTranslator.shiftEventTimeZone(testEvent, TimeZone.GREENWICH_UTC, TimeZone.ALASKA );
		Event expected = new Event("testEvent",
				new DateTime(2017, 12, 31, 17, 30, 30),
				new DateTime(2017, 12, 30, 22, 30 ,30),
				new HashSet<>(Arrays.asList(partis)),
				somePlace);
		
		assertEquals(expected.getStartDate().toString(), shiftedEvent.getStartDate().toString());
		assertEquals(expected.getEndDate().toString(), shiftedEvent.getEndDate().toString());
		
	}

}
