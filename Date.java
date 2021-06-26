
package school.management.system;
import java.io.Serializable;
public class Date implements Serializable {
    private int day;
	private int month;
	private int year;
	
	
	//no argument constructor
	public Date() {
		day = 1;
		month = 1;
		year = 2020;
	}

	
	// copy constructor
	public Date(Date d) 
	{
		day = d.day;
		month = d.month;
		year = d.year;
	}
	

	//Argumented Constructor.
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}


	//Getter Setter for all data feilds
	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
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

	//toString method for Date class
	@Override
	public String toString() {
		return("Date of Hiring:" + day + "/" + month + "/" + year);
	}
    
}
