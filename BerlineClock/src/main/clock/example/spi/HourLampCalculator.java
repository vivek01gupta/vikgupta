package main.clock.example.spi;

import java.util.Arrays;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;

/**
 * This class will calculate lamp for Hour and display accordingly.
 *
 */
public class HourLampCalculator implements TimeCalculator {

	private Lamp lamp;
	private String displayFirstRowHourLamp;
	private String displaySecondRowHourLamp;

	public HourLampCalculator(Lamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void calculateLampRows() {
		int hour = lamp.getHour();
		calculateFirstRowForHour(hour);
		calculateSecondRowForHour(hour);

	}

	/**
	 * This method will calculate lamp for first row for hour.
	 * 
	 * @param hour
	 */
	private void calculateFirstRowForHour(int hour) {
		int firstRowLamp = hour / ITimeUnitConstants.MULTIPLE_OF_FIVE;
		char[] ch = new char[ITimeUnitConstants.LAMP_IN_ROW_FOUR];
		Arrays.fill(ch, ITimeUnitConstants.LIGHTS_OFF);
		for (int i = 0; i < firstRowLamp; i++) {
			ch[i] = ITimeUnitConstants.RED_LIGHT;
		}
		setDisplayFirstRowHourLamp(new String(ch));
	}

	/**
	 * This method will calculate lamp for second row for hour.
	 * 
	 * @param hour
	 */
	private void calculateSecondRowForHour(int hour) {
		int firstRowLamp = hour % ITimeUnitConstants.MULTIPLE_OF_FIVE;
		char[] ch = new char[ITimeUnitConstants.LAMP_IN_ROW_FOUR];
		Arrays.fill(ch, ITimeUnitConstants.LIGHTS_OFF);
		for (int i = 0; i < firstRowLamp; i++) {
			ch[i] = ITimeUnitConstants.RED_LIGHT;
		}
		setDisplaySecondRowHourLamp(new String(ch));
	}

	/**
	 * @return the displayFirstRowHourLamp
	 */
	public String getDisplayFirstRowHourLamp() {
		return displayFirstRowHourLamp;
	}

	/**
	 * @param displayFirstRowHourLamp
	 *            the displayFirstRowHourLamp to set
	 */
	public void setDisplayFirstRowHourLamp(String displayFirstRowHourLamp) {
		this.displayFirstRowHourLamp = displayFirstRowHourLamp;
	}

	/**
	 * @return the displaySecondRowHourLamp
	 */
	public String getDisplaySecondRowHourLamp() {
		return displaySecondRowHourLamp;
	}

	/**
	 * @param displaySecondRowHourLamp
	 *            the displaySecondRowHourLamp to set
	 */
	public void setDisplaySecondRowHourLamp(String displaySecondRowHourLamp) {
		this.displaySecondRowHourLamp = displaySecondRowHourLamp;
	}

}
