package main.clock.example.api;

public interface ITimeUnitConstants {

	char LIGHTS_OFF = 'O';
	char RED_LIGHT = 'R';
	char YELLOW_LIGHT = 'Y';
	int MULTIPLE_OF_FIVE = 5;

	int LAMP_IN_ROW_FOUR = 4;
	int LAMP_IN_FIRST_ROW_MINUTE = 11;

	String TIME_IN_SECOND_YELLOW_LIGHT_OFF = "O";
	String TIME_IN_SECOND_YELLOW_LIGHT_ON = "Y";

	String HOUR_MUST_BE_LESS_THAN_24 = "Hour must be less than 24";
	String MINUTE_AND_SECOND_MUST_BE_LESS_THAN_60 = "Minute and Second must be less than 59";

}
