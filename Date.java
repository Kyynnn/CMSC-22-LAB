public class Date {
	private int month;
	private int day;
	private int year;

	public boolean isLeapYear() { //determines if a year is a leap year
		if ((year % 4 == 0 && year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}

	public Date(int year, int month, int day) {
		setDate(year, month, day);
	}

	public Date() {
		this.month = 1;
		this.day = 1;
		this.year = 1000;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		if (year < 1000 || year > 9999) {
			throw new IllegalArgumentException("Invalid year!");
		}
		this.year = year;
	}

	public void	setMonth(int month) {
		if (month > 12 || month < 1) {
			throw new IllegalArgumentException("Invalid month!");
		}
		this.month = month;
	}

	public void setDay(int day) {
		if (isLeapYear() == false && month == 2 && day > 28) {
			throw new IllegalArgumentException("Not a leap year!");
		} else if (((month == 4 || month == 6 || month == 9 || month == 11 ) && day > 30) || (day > 31) || (day < 1)) {
			throw new IllegalArgumentException("Month, day, and year combination not possible!");
		}
		this.day = day;
	}

	public String toString() {
		return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
	}

	public void setDate(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
}