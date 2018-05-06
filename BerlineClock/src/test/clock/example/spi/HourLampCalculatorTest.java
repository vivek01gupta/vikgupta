package test.clock.example.spi;

import org.junit.Assert;
import org.junit.Test;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;
import main.clock.example.spi.HourLampCalculator;
import main.clock.example.spi.Lamp;

/**
 * This test class is for HourLampCalculator.
 *
 */
public class HourLampCalculatorTest {

	private TimeCalculator calculator;
	private int hour;
	private int minute;
	private int second;

	/**
	 * This test validate that for hour there are 4 lamps in first row.
	 */
	@Test
	public void testCalculateLampRows_firstRowForHour_length() {
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.LAMP_IN_ROW_FOUR,
				((HourLampCalculator) calculator).getDisplayFirstRowHourLamp().length());
	}

	/**
	 * This test validate that for hour there are 4 lamps in second row.
	 */
	@Test
	public void testCalculateLampRows_secondRowForHour_length() {
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.LAMP_IN_ROW_FOUR,
				((HourLampCalculator) calculator).getDisplaySecondRowHourLamp().length());
	}

	/**
	 * This test validate that for each 5 hour lamp's light should be Red in first
	 * row.
	 */
	@Test
	public void testCalculateLampRows_firstRowForHour_shouldLightRedForEveryFiveHour() {
		hour = 7;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("ROOO", ((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());

		hour = 13;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RROO", ((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());

		hour = 23;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RRRR", ((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());

		hour = 24;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RRRR", ((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());
	}

	/**
	 * This test validate that for each 1 hour lamp's light should be Red in second
	 * row.
	 */
	@Test
	public void testCalculateLampRows_secondRowForHour_shouldLightRedForEveryOneHour() {
		hour = 7;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RROO", ((HourLampCalculator) calculator).getDisplaySecondRowHourLamp());

		hour = 23;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RRRO", ((HourLampCalculator) calculator).getDisplaySecondRowHourLamp());

		hour = 24;
		calculator = getCalculator(getLamp(hour, minute, second));
		calculator.calculateLampRows();
		Assert.assertEquals("RRRR", ((HourLampCalculator) calculator).getDisplaySecondRowHourLamp());
	}

	/**
	 * setup for lamp object.
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
	 * Get HourLampCalculator
	 * 
	 * @param lamp
	 * @return
	 */
	private TimeCalculator getCalculator(Lamp lamp) {
		return new HourLampCalculator(lamp);
	}

}
