package test.clock.example.spi;

import org.junit.Assert;
import org.junit.Test;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;
import main.clock.example.spi.Lamp;
import main.clock.example.spi.SecondLampCalculator;

/**
 * This test class is for HourLampCalculator.
 *
 */
public class SecondLampCalculatorTest {

	private TimeCalculator calculator;
	private Lamp lamp;
	private int hour;
	private int minute;
	private int second;

	/**
	 * This test validate that for each 2 second yellow light will be ON
	 */
	@Test
	public void testCalculateLampRows_yellowLightBlinkOn() {
		second = 2;
		lamp = getLamp(hour, minute, second);
		calculator = getCalculator(lamp);
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_ON,
				((SecondLampCalculator) calculator).getLampOnOrOff());
	}

	/**
	 * This test validate that for each 2 second yellow light will be ON . if second
	 * is not divisible by 2 then light will be off.
	 * 
	 */
	@Test
	public void testCalculateLampRows_yellowLightBlinkOnOrOff() {
		// initially light is On
		lamp = getLamp(hour, minute, second);
		calculator = getCalculator(lamp);
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_ON,
				((SecondLampCalculator) calculator).getLampOnOrOff());

		// after on second light will be off
		second = 1;
		lamp = getLamp(0, 0, second);
		calculator = getCalculator(lamp);
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_OFF,
				((SecondLampCalculator) calculator).getLampOnOrOff());

		second = 3;
		lamp = getLamp(0, 0, second);
		calculator = getCalculator(lamp);
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_OFF,
				((SecondLampCalculator) calculator).getLampOnOrOff());

		second = 59;
		lamp = getLamp(hour, minute, second);
		calculator = getCalculator(lamp);
		calculator.calculateLampRows();
		Assert.assertEquals(ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_OFF,
				((SecondLampCalculator) calculator).getLampOnOrOff());
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
	 * Get SecondCalcualtor
	 * 
	 * @param lamp
	 * @return
	 */
	private TimeCalculator getCalculator(Lamp lamp) {
		return new SecondLampCalculator(lamp);
	}

}
