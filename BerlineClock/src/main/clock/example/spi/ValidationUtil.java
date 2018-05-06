package main.clock.example.spi;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.exception.TimeException;

/**
 * This class will validate the time.
 *
 */
public class ValidationUtil {

	/**
	 * Validate the time i.e hour ,must be less than or equal 24<br>
	 * and minute and second must be less than 60.<br>
	 * 
	 * @param lamp
	 * @throws TimeException
	 */
	public static void validate(Lamp lamp) throws TimeException {
		if (lamp.getHour() >= 24) {
			throw new TimeException(ITimeUnitConstants.HOUR_MUST_BE_LESS_THAN_24);
		}
		if (lamp.getMinute() > 59 || lamp.getSecond() > 59) {
			throw new TimeException(ITimeUnitConstants.MINUTE_AND_SECOND_MUST_BE_LESS_THAN_60);
		}
	}

}
