package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	public void testGetTotalSecondsGood() 
	{
	int seconds = 
	Time.getTotalSeconds("05:05:05");
	assertTrue("The seconds were not calculated properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("10:00");});
	}

	@Test
	public void testGetTotalSecondsBoundary() 
	{
	int seconds = 
	Time.getTotalSeconds("23:59:59");
	assertTrue("The seconds were not calculated properly", seconds==86399);
	}
	
	@Test
	public void testGetTotalMinutesGood() 
	{
	int minutes = 
	Time.getTotalMinutes("05:05:05");
	assertTrue("The minutes were not calculated properly", minutes==5);
	}
	
	@Test
	public void testGetTotalMinutesBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalMinutes("10");});
	}
	
	@Test
	public void testGetTotalMinutesBoundary() 
	{
	int minutes = 
	Time.getTotalMinutes("23:59:59");
	assertTrue("The minutes were not calculated properly", minutes==59);
	}
	
	@Test
	public void testGetTotalHoursGood() 
	{
	int hours = 
	Time.getTotalHours("05:05:05");
	assertTrue("The hours were not calculated properly", hours==5);
	}
	
	@Test
	public void testGetTotalHoursBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalHours("");});
	}
	
	@Test
	public void testGetTotalHoursBoundary() 
	{
	int hours = 
	Time.getTotalHours("23:59:59");
	assertTrue("The hours were not calculated properly", hours==23);
	}
	
	@Test
	public void testGetSecondsGood() 
	{
	int seconds = 
	Time.getSeconds("05:05:05");
	assertTrue("The seconds were not calculated properly", seconds==5);
	}

	@Test
	public void testGetSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getSeconds("10:00");});
	}

	@Test
	public void testGetSecondsBoundary() 
	{
	int seconds = 
	Time.getSeconds("23:59:59");
	assertTrue("The seconds were not calculated properly", seconds==59);
	}
	

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly", 
	hours ==5);
	}

	@ParameterizedTest
	@ValueSource(strings = { "09:15:00", "23:15:15", "05:15:59" })
	void testGetTotalMinutes(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The minutes were not calculated properly", 
	minutes ==15);
	}
	

	@ParameterizedTest
	@ValueSource(strings = { "23:00:00", "05:15:00", "18:59:00" })
	void testGetSeconds(String candidate) {
	int seconds = Time.getSeconds(candidate);
	assertTrue("The seconds were not calculated properly", 
	seconds ==00);
	}

	@Test
	public void testGetMilliSecondsGood() 
	{
		int milliseconds = 
		Time.getMilliSeconds("10:59:59:005");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 5);
	}

	@Test
	public void testGetMilliSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getMilliSeconds("10:00:00");});
	}

	@Test
	public void testGetMilliSecondsBoundary() 
	{
	int milliseconds = 
	Time.getMilliSeconds("23:59:59:099");
	assertTrue("The milliseconds were not calculated properly", milliseconds== 99);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "23:00:00:007", "05:15:00:007", "18:59:00:007" })
	void testGetMilliSeconds(String candidate) {
	int seconds = Time.getMilliSeconds(candidate);
	assertTrue("The milliseconds were not calculated properly", 
	seconds ==007);
	}
}
