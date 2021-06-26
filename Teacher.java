
package school.management.system;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Teacher extends Person implements Information, Serializable {
    private int grade;
	private double salary;
	private int absentDays;
	private String isSalaryPaid;
	private Date hiringDate;
	transient Scanner input = new Scanner(System.in);


	// no argument Constructor.
	public Teacher() {
		super();
		absentDays = 0;
		isSalaryPaid = "unpaid";
		getInformation();
	}


	// Function to assign salary to Teacher
	private int assignSalary(int g) {
		return (g * 10_000);
	}


	// Function to calculation salary after deducting absent days
	public double calculateSalary() {
		if (absentDays > 5) {
			double deduction = ((2.0 / 100) * absentDays) * salary;
			salary -= deduction;
		}
		return salary;
	}


	// Function to get Teacher Information
	@Override
	public void getInformation() {
		try {
			System.out.print("Enter the Grade of Teacher from 1 to 6:");
			grade = input.nextInt();
			if (grade < 1 || grade > 6) {
				System.out.println("Wrong input! Enter grade again ");
				grade = input.nextInt();
			}
			salary = assignSalary(grade);

			System.out.println("Enter exact date of Hiring");
			System.out.print("Enter date from 1 to 31 :");
			int day = input.nextInt();
			System.out.print("\nEnter month from 1 to 12");
			int month = input.nextInt();
			System.out.print("\nEnter year in 20xx:");
			int year = input.nextInt();
			hiringDate = new Date(day, month, year);

		} catch (InputMismatchException ex) {
			System.out.println("Wrong Input!!!!!!");
		}
	}

// toString for Teacher
	@Override
	public String toString() {
		return (super.toString() + "\nSalary=" + salary + "\nAbsentent Days=" + absentDays + "\nSalary paid?"
				+ isSalaryPaid + "\nDate of Hiring=" + hiringDate.toString());
	}


	// Getter Setter for all datafeilds
	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getAbsentDays() {
		return absentDays;
	}


	public void setAbsentDays(int absentDays) {
		this.absentDays = absentDays;
	}


	public String getSalaryPaidStatus() {
		return isSalaryPaid;
	}


	public void setSalaryPaidStatus(String isSalaryPaid) {
		this.isSalaryPaid = isSalaryPaid;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	// Function to change and set Teacher's Hiring date
	public void changeHiringDate(Date d) {
		hiringDate.setDay(d.getDay());
		hiringDate.setMonth(d.getMonth());
		hiringDate.setYear(d.getYear());
		System.out.println("Now the hiring date is " + hiringDate.toString());
	}
}


    

