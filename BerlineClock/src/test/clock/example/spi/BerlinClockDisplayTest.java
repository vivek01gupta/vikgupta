package test.clock.example.spi;

import org.junit.Assert;
import org.junit.Test;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;
import main.clock.example.spi.HourLampCalculator;
import main.clock.example.spi.Lamp;
import main.clock.example.spi.MinuteLampCalculator;
import main.clock.example.spi.SecondLampCalculator;

/**
 * Test class BerlinClockDisplay.
 *
 */
public class BerlinClockDisplayTest {

	private TimeCalculator calculator;
	private int hour;
	private int minute;
	private int second;
	private Lamp lamp;

	/**
	 * This test will display lamp for hour ,minute and second.
	 */
	@Test
	public void testDisplayClock() {
		hour = 13;
		minute = 17;
		second = 1;
		lamp = getLamp(hour, minute, second);

		calculator = new SecondLampCalculator(lamp);
		calculator.calculateLampRows();

		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_OFF,
				((SecondLampCalculator) calculator).getLampOnOrOff());

		calculator = new MinuteLampCalculator(lamp);
		calculator.calculateLampRows();

		Assert.assertEquals("YYROOOOOOOO", ((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());
		Assert.assertEquals("YYOO", ((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp());

		calculator = new HourLampCalculator(lamp);
		calculator.calculateLampRows();

		Assert.assertEquals("RROO", ((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());
		Assert.assertEquals("RRRO", ((HourLampCalculator) calculator).getDisplaySecondRowHourLamp());
	}

	private Lamp getLamp(int hour, int minute, int second) {
		return new Lamp(hour, minute, second);
	}
}
