package main.clock.example.spi;

public class Lamp {

	int hour;
	int minute;
	int second;

	Lamp() {

	}

	public Lamp(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;

	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
