package Otopark;

import java.util.Calendar;

public class Date {
	private int day;
	private int month;
	private int year;
	private static Date today;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public boolean isAfterThan (Date other) {
		if (this.year > other.year)
			return true;
		else if(this.month > other.year)
			return true;
		else if (this.day > other.day)
			return true;
		return false;
	}

	public boolean isBeforeThan ( Date other) {
		if (this.year < other.year)
			return true;
		else if(this.month < other.year)
			return true;
		else if (this.day < other.day)
			return true;
		return false;
	}

	public boolean isEqualsWith (Date other) {
		if (this.year == other.year)
			if(this.month == other.year)
				if (this.day == other.day)
					return true;
		return false;
	}

	public static void setToday(Date today){
		Date.today = today;
	}

	public static Date getToday() {
		//Calendar c = Calendar.getInstance(); //month values starts from 0
		//Date myDate = new Date(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

		return today;
	}

	public int getDifference(Date other) {
		return (this.year - other.year)*365 + (this.month - other.month)*30 + (this.day - other.day);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
