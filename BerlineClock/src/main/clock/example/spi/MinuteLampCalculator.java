package main.clock.example.spi;

import java.util.Arrays;

import main.clock.example.api.ITimeUnitConstants;
import main.clock.example.api.TimeCalculator;

/**
 * This class will calculate lamp for minute and display accordingly.
 *
 */
public class MinuteLampCalculator implements TimeCalculator {

	private Lamp lamp;
	private String displayFirstRowMinuteLamp;
	private String displaySecondRowMinuteLamp;

	public MinuteLampCalculator(Lamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void calculateLampRows() {
		int minute = lamp.getMinute();
		calculateFirstRowForMinute(minute);
		calculateSecondRowForMinute(minute);
	}

	/**
	 * This method will calculate lamp for first row for minute.
	 * 
	 * @param hour
	 */
	private void calculateFirstRowForMinute(int minute) {
		int firstRowLamp = minute / ITimeUnitConstants.MULTIPLE_OF_FIVE;
		char[] ch = new char[ITimeUnitConstants.LAMP_IN_FIRST_ROW_MINUTE];
		Arrays.fill(ch, ITimeUnitConstants.LIGHTS_OFF);
		for (int i = 0; i < firstRowLamp; i++) {
			if ((i + 1) % 3 == 0) {
				ch[i] = ITimeUnitConstants.RED_LIGHT;
			} else {
				ch[i] = ITimeUnitConstants.YELLOW_LIGHT;
			}
		}
		setDisplayFirstRowMinuteLamp(new String(ch));
	}

	/**
	 * This method will calculate lamp for second row for minute.
	 * 
	 * @param hour
	 */
	private void calculateSecondRowForMinute(int minute) {
		int secondRowLamp = minute % ITimeUnitConstants.MULTIPLE_OF_FIVE;
		char[] ch = new char[ITimeUnitConstants.LAMP_IN_ROW_FOUR];
		Arrays.fill(ch, ITimeUnitConstants.LIGHTS_OFF);
		for (int i = 0; i < secondRowLamp; i++) {
			ch[i] = ITimeUnitConstants.YELLOW_LIGHT;
		}
		setDisplaySecondRowMinuteLamp(new String(ch));
	}

	/**
	 * @return
	 */
	public String getDisplayFirstRowMinuteLamp() {
		return displayFirstRowMinuteLamp;
	}

	/**
	 * @param displayFirstRowMinuteLamp
	 */
	public void setDisplayFirstRowMinuteLamp(String displayFirstRowMinuteLamp) {
		this.displayFirstRowMinuteLamp = displayFirstRowMinuteLamp;
	}

	/**
	 * @return
	 */
	public String getDisplaySecondRowMinuteLamp() {
		return displaySecondRowMinuteLamp;
	}

	/**
	 * @param displaySecondRowMinuteLamp
	 */
	public void setDisplaySecondRowMinuteLamp(String displaySecondRowMinuteLamp) {
		this.displaySecondRowMinuteLamp = displaySecondRowMinuteLamp;
	}

}
