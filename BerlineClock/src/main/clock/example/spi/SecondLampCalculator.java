package main.clock.example.spi;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;

/**
 * This class will calculate lamp for second and display accordingly.
 *
 */
public class SecondLampCalculator implements TimeCalculator {

	Lamp lamp;
	String lampOnOrOff;

	public SecondLampCalculator(Lamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void calculateLampRows() {
		String lampOnOrOFF = ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_OFF;
		if (lamp != null && lamp.getSecond() % 2 == 0) {
			lampOnOrOFF = ITimeUnitConstants.TIME_IN_SECOND_YELLOW_LIGHT_ON;
		}
		setLampOnOrOff(lampOnOrOFF);
	}

	/**
	 * @return lampOnOrOff
	 */
	public String getLampOnOrOff() {
		return lampOnOrOff;
	}

	/**
	 * @param lampOnOrOff
	 *            the lampOnOrOff to set
	 */
	public void setLampOnOrOff(String lampOnOrOff) {
		this.lampOnOrOff = lampOnOrOff;
	}

}
