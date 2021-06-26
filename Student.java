
package school.management.system;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Student extends Person implements Information, Serializable {
    private String rollnum;
	private int fee;
	String feeStatus;
	private double totalMarks;
	ArrayList<String> courses = new ArrayList<String>();
	ArrayList<Double> marks = new ArrayList<Double>();
	transient Scanner in = new Scanner(System.in);
	private int classname;

	// no argument Constructor.
	public Student() {
		super();
		getInformation();
	}


	// function to get Student's information
	public void getInformation() {
		System.out.println("Enter Student Roll number : ");
		rollnum = in.nextLine();
		Fee f = null;
		try {
			System.out.println("Enter class from grade 1 to 10 to check courses list:");
			classname = in.nextInt();
			in.nextLine();
			System.out.println("Enter paid if Student fee is paid else enter not paid.");
			feeStatus = in.nextLine();
			f = new Fee(classname);
			fee = f.totalFee();
		} catch (InputMismatchException mm) {
			System.out.println("Mismatch input please try again");
		}
		if (feeStatus.equalsIgnoreCase("paid")) {
			f.setFee(true);
		} else if (feeStatus.equalsIgnoreCase("not paid")) {
			f.setFee(false);
		}
		// called course constructor by its object by giving it grade.
		Course c = new Course(classname, f);
		// Called Courses class function to get course list of student.
		courses = c.courselist(classname);
	}


	// tOString for students all information
	@Override
	public String toString() {
		double total = 0;
		String res = "**********Students Information ****************";
res = res + ("\n" + super.toString() + "\nStudent Roll Number : " + rollnum + "\nStudent monthly fee : Rs. "+ fee + " Fee is " + feeStatus + "\nCourse wise marks");

		for (int i = 0; i < this.marks.size(); i++) {
			res = res + ("\n" + courses.get(i) + " : " + Double.toString(marks.get(i)) + " /75.0");
			total += 75;
		}

		res += "\nTotal marks : " + Double.toString(totalMarks) + " / " + total;
		return res;
	}


	// Getter Setter for all data feilds
	public ArrayList<String> getCourses() {
		return courses;
	}


	public void setCourses(ArrayList<String> c) {
		this.courses = c;
	}


	public String getStudentRollnumber() {
		return rollnum;
	}


	public void setStudentId(String rollnumber) {
		rollnum = rollnumber;
	}


	public Address getAdd() {
		return this.getAdd();
	}


	public int getFees() {
		return fee;
	}


	public void setMarks(ArrayList<Double> marks) {
		this.marks = marks;
	}


	public ArrayList<Double> getMarks() {
		return marks;
	}


	public double getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}


	public int getClassname() {
		return classname;
	}


	public void setClassname(int classname) {
		this.classname = classname;
	}
}



    

