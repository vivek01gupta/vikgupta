package test.clock.example.spi;

import org.junit.Assert;
import org.junit.Test;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;
import main.clock.example.spi.Lamp;
import main.clock.example.spi.MinuteLampCalculator;

/**
 * This test class is for MinuteLampCalculator.
 *
 */
public class MinuteLampCalculatorTest {

	private TimeCalculator calculator;
	private int hour;
	private int minute;
	private int second;

	/**
	 * This test validate that for minute there are 11 lamps in first row.
	 */
	@Test
	public void testCalculateLampRows_firstRowForMinute_length() {
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.LAMP_IN_FIRST_ROW_MINUTE,
				((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp().length());
	}

	/**
	 * This test validate that for minute there are 11 lamps in second row.
	 */
	@Test
	public void testCalculateLampRows_secondRowForMinute_length() {
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.LAMP_IN_ROW_FOUR,
				((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp().length());
	}

	/**
	 * This test validate that for minute there will be Yellow light for each 5
	 * minute in first row.
	 */
	@Test
	public void testCalculateLampRows_firstRowForMinute_shouldLightYelloForEveryFiveHour_exceptQuarter() {
		minute = 10;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYOOOOOOOOO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

		minute = 25;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYRYYOOOOOO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

		minute = 55;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYRYYRYYRYY", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

	}

	/**
	 * This test validate that for minute there will be Red light for 1st ,2nd and
	 * 3rd quarter.
	 * 
	 */
	@Test
	public void testCalculateLampRows_firstRowForMinute_shouldLightRedForEveryQuarter() {
		minute = 15;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYROOOOOOOO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

		minute = 30;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYRYYROOOOO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

		minute = 45;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYRYYRYYROO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

	}

	/**
	 * This test validate that for minute there will be Yellow light for each 1
	 * minute in second row.
	 */
	@Test
	public void testCalculateLampRows_secondRowForMinute_shouldLightYellowForEveryOneMinute() {
		minute = 12;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYOO", ((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp());

		minute = 17;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYOO", ((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp());

		minute = 59;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("YYYY", ((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp());
	}

	/**
	 * setup for lamp object
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	private Lamp getLamp(int hour, int minute, int second) {
		return new Lamp(hour, minute, second);
	}

	/**
	 * Get MinuteCalculator
	 * 
	 * @param lamp
	 * @return
	 */
	private TimeCalculator getCalculator(Lamp lamp) {
		return new MinuteLampCalculator(lamp);
	}

}
