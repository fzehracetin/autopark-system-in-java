package Otopark;

import java.util.Calendar;

public class Time {
	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getDifference( Time other) {
		int newHour=0,newMin=0;

		newHour = other.hour-this.hour;
		newMin = other.minute-this.minute;


		if(other.hour <= this.hour){
			newHour =(24-this.hour) + other.hour;
		}

		if(other.minute<this.minute){
			newMin = (60 - this.minute) + other.minute;
			newHour--;
		}


		return Math.abs(   newHour*60 + newMin   );
	}

	public static Time getTime() {
		Calendar c = Calendar.getInstance();
		Time time = new Time (c.get(Calendar.HOUR), c.get(Calendar.MINUTE));
		return time;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + "]";
	}



}
