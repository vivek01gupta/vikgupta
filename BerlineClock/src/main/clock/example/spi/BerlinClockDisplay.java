package main.clock.example.spi;

import java.util.Scanner;

import main.clock.example.api.TimeCalculator;
import main.clock.example.exception.TimeException;

public class BerlinClockDisplay {
	public static void main(String[] args) throws TimeException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter hour unit less than 24\n");
		int hour = sc.nextInt();

		System.out.println("Please enter minute unit\n");
		int minute = sc.nextInt();

		System.out.println("Please enter second unit\n");
		int second = sc.nextInt();

		sc.close();
		Lamp lamp = new Lamp(hour, minute, second);

		try {
			ValidationUtil.validate(lamp);
			TimeCalculator calculator = new SecondLampCalculator(lamp);
			calculator.calculateLampRows();

			System.out.println("*****Lamp For Seconds: First Row************");
			System.out.println(((SecondLampCalculator) calculator).getLampOnOrOff());

			calculator = new MinuteLampCalculator(lamp);
			calculator.calculateLampRows();

			System.out.println("*****Lamp For Minute : First Row************");
			System.out.println(((MinuteLampCalculator) calculator).getDisplayFirstRowMinuteLamp());

			System.out.println("*****Lamp For  Minute: Second Row  ************");
			System.out.println(((MinuteLampCalculator) calculator).getDisplaySecondRowMinuteLamp());

			calculator = new HourLampCalculator(lamp);
			calculator.calculateLampRows();

			System.out.println("*****Lamp For Hour: First Row  ************");
			System.out.println(((HourLampCalculator) calculator).getDisplayFirstRowHourLamp());

			System.out.println("*****Lamp For Hour :Second Row ************");
			System.out.println(((HourLampCalculator) calculator).getDisplaySecondRowHourLamp());
		} catch (Exception ex) {
			System.out.println("Try Again!" + ex.getMessage());
		}

	}

}
