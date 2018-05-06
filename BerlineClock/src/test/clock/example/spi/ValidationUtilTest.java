package test.clock.example.spi;

import org.junit.Assert;
import org.junit.Test;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.spi.Lamp;
import main.clock.example.spi.ValidationUtil;

/**
 * validate the time unit
 *
 */
public class ValidationUtilTest {

	private int hour;
	private int minute;
	private int second;

	/**
	 * This test validate that if user enter hour more than 24 it will throw
	 * exception.
	 */
	@Test
	public void testValidate_hourIsGreaterThan24() {
		try {
			hour = 25;
			ValidationUtil.validate(getLamp(hour, minute, second));
			Assert.fail("Exception must be thrown");
		} catch (Exception e) {
			Assert.assertEquals(ITimeUnitConstants.HOUR_MUST_BE_LESS_THAN_24, e.getMessage());
		}
	}

	/**
	 * This test validate that if user enter minute more than 59 it will throw
	 * exception.
	 */
	@Test
	public void testValidate_minuteIsGreaterThan59() {
		try {
			minute = 61;
			ValidationUtil.validate(getLamp(hour, minute, second));
			Assert.fail("Exception must be thrown");
		} catch (Exception e) {
			Assert.assertEquals(ITimeUnitConstants.MINUTE_AND_SECOND_MUST_BE_LESS_THAN_60, e.getMessage());
		}
	}

	/**
	 * This test validate that if user enter second more than 59 it will throw
	 * exception.
	 */
	@Test
	public void testValidate_secondIsGreaterThan59() {
		try {
			second = 61;
			ValidationUtil.validate(getLamp(hour, minute, second));
			Assert.fail("Exception must be thrown");
		} catch (Exception e) {
			Assert.assertEquals(ITimeUnitConstants.MINUTE_AND_SECOND_MUST_BE_LESS_THAN_60, e.getMessage());
		}
	}

	/**
	 * This test validate that if user enter minute or second more than 59 it will
	 * throw exception.
	 */
	@Test
	public void testValidate_secondIsGreaterThan59AndMinuteLessThan59() {
		try {
			minute = 40;
			second = 61;
			ValidationUtil.validate(getLamp(hour, minute, second));
			Assert.fail("Exception must be thrown");
		} catch (Exception e) {
			Assert.assertEquals(ITimeUnitConstants.MINUTE_AND_SECOND_MUST_BE_LESS_THAN_60, e.getMessage());
		}
	}

	/**
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	private Lamp getLamp(int hour, int minute, int second) {
		return new Lamp(hour, minute, second);
	}
}
