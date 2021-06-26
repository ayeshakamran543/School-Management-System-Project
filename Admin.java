
package school.management.system;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Admin {
    private ArrayList<Person> list = new ArrayList<Person>();
	private Scanner in = new Scanner(System.in);
	private final String TEACHER_FILE = "teacher.dat";
	private int grade;

	public Admin() {
		grade = -1;
	}

//***********private methods for writing and reading teachers data to and from a file******************
	// method for writing into a file
	private void writeToTeacherFile(Person p) throws ClassNotFoundException, IOException {

		File f = new File(TEACHER_FILE);
		try (ObjectOutputStream output = !f.exists() ? new ObjectOutputStream(new FileOutputStream(f))
				: new ObjectOutputStream(new FileOutputStream(f, true)) {
					@Override
					public void writeStreamHeader() {
					}
				};) {
			output.writeObject(list.get(list.indexOf(p)));
		}
	}

	// In-case of any changing like removing a teacher this method deletes the
	// existing file and stores the new existing data
	private void updateStoredTeacherFile() throws ClassNotFoundException, FileNotFoundException, IOException {
		File f = new File(TEACHER_FILE);
		if (f.exists()) {
			f.delete();
			for (int i = 0; i < list.size(); i++) {
				writeToTeacherFile(list.get(i));
			}
		}

	}

	// this method is used to reload already stored data from the file
	private void reloadStoredTeacherFile() throws FileNotFoundException, ClassNotFoundException, IOException {
		File f = new File(TEACHER_FILE);
		if (f.exists()) {
			list.clear();
			try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
				Person p;
				try {
					while ((p = (Person) input.readObject()) != null) {
						list.add(p);
					}
				} catch (EOFException ex) {
					System.out.println("OLD DATA RELOADED!!");
				}
			}
		}
	}

	// this method updates hiring date of teacher and then updates file
	public void updateTeacherHiringDate() throws ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		int i = getTeacherPosition();
		if (i > -1) {
			System.out.println("Enter new date of Hiring");
			System.out.print("Enter date from 1 to 31 :");
			int day = in.nextInt();
			System.out.print("\nEnter month from 1 to 12");
			int month = in.nextInt();
			System.out.print("\nEnter year in 20xx");
			int year = in.nextInt();
			Date d = new Date(day, month, year);
			((Teacher) (list.get(i))).changeHiringDate(d);
			updateStoredTeacherFile();
		} else {
			System.out.println("no such record exists");
		}
	}

	// ******************methods for performing actions on teachers****************
	// method for hiring a new teacher
	public void hireNewTeacher() throws ClassNotFoundException, IOException {
		Teacher t = new Teacher();
		list.add(t);
		writeToTeacherFile(t);
	}

	// This method finds and returns the place where the teacher whose data needs to
	// be changed,or updated or viewed exists in an arraylist
	private int getTeacherPosition() throws ClassNotFoundException, IOException {
		System.out.println("enter first name:");
		String firstName = in.nextLine();
		System.out.println("enter last name:");
		String LastName = in.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (((list.get(i)).getFirstName().equalsIgnoreCase(firstName))
					&& ((list.get(i)).getLastName().equalsIgnoreCase(LastName))) {
				return i;
			}
		}
		return -1;
	}

	// this method removes the teacher and then updates the file
	public void removeTeacher() throws ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		int i = getTeacherPosition();
		if (i > -1) {
			list.remove(i);
			updateStoredTeacherFile();
		} else {
			System.out.println("Such a record doesn't exists!!!!!");
		}
	}

	// this method is used to change teacher salary status and then updates file
	public void updateTeacherSalaryStatus() throws FileNotFoundException, ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		int i = getTeacherPosition();
		if (i > -1) {
			System.out.println("Enter the status whether its paid or unpaid");
			String p = in.nextLine();
			while (true) {
				if (p.equalsIgnoreCase("paid") || p.equalsIgnoreCase("unpaid")) {
					break;
				}
				System.out.println("Wrong input! Enter status again");
				p = in.nextLine();
			}
			((Teacher) list.get(i)).setSalaryPaidStatus(p);
			System.out.println("The Salary status is " + ((Teacher) list.get(i)).getSalaryPaidStatus());
			updateStoredTeacherFile();
		} else {
			System.out.println("Such a record doesn't exists!!!!!");

		}
	}

	// this method is used to view or check the days teacher was absent
	public void checkTeacherAbsentDays() throws FileNotFoundException, ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		int i = getTeacherPosition();
		if (i > -1) {
			System.out.println("The teacher was absent for " + ((Teacher) list.get(i)).getAbsentDays() + " days");
		} else {
			System.out.println("Such a record doesn't exists!!!!!");
		}
	}

	// this method is used to calculate the salary of teacher based on absent days
	// and teacher's grade
	public void calculateSalary() throws FileNotFoundException, ClassNotFoundException, IOException {
		int i = getTeacherPosition();
		reloadStoredTeacherFile();
		if (i > -1) {
			System.out.println("Enter the Number of days the teacher was absent?");
			int absentDays = in.nextInt();
			((Teacher) (list.get(i))).setAbsentDays(absentDays);
			System.out.println("Assigning Salary according to Grade and Absent Days!!!");
			System.out.println("The teacher salary is Rs." + ((Teacher) list.get(i)).calculateSalary());
			updateStoredTeacherFile();
		} else {
			System.out.println("Such a record doesn't exists!!!!!");
		}
	}

	// this method is used to view a record of any specipic teacher
	public void viewTeacherRecord() throws FileNotFoundException, ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		int i = getTeacherPosition();
		if (i > -1) {
			System.out.println(list.get(i).toString());
		} else {
			System.out.println("Such a record doesn't exists!!!!!");
		}
	}

	// this method is used to view the records of all the teachers in the School
	public void viewAllTeachersRecord() throws FileNotFoundException, ClassNotFoundException, IOException {
		reloadStoredTeacherFile();
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ") " + list.get(i).toString()
					+ "\n___________________________________________________________");
		}
	}

	// ****************private methods for writing and reading Students data to and
	// from a file***************
	// private method to write data into the the file. The file is writing data into
	// the file chosen according to the grade user wants to make changes in
	private void updateStoredStudentFile() throws ClassNotFoundException, IOException {
		String file = getStudentFileName(grade);
		try (ObjectOutputStream studin = new ObjectOutputStream(new FileOutputStream(file));) {
			studin.writeObject(list);
			System.out.println("Data for students is stored!!!!!");
		}
	}

	// this private method reads the the data from the file according to grade the
	// user selected
	private void reloadStoredStudentFile()
			throws InvalidClassException, FileNotFoundException, ClassNotFoundException, IOException {
		if (grade == -1 || grade == 0) {
			System.out.print("Enter Class you are dealing with from grade 1 to grade 10.... ");
			grade = in.nextInt();
		}
		String file = getStudentFileName(grade);
		File f = new File(file);
		if (f.exists()) {
			try (ObjectInputStream studout = new ObjectInputStream(new FileInputStream(file));) {
				ArrayList<Person> temp = new ArrayList<Person>();
				temp = (ArrayList<Person>) studout.readObject();
				list = temp;
			}
		}

	}

	// This private method finds and returns the place where the student whose data
	// needs to
	// be updated or changed or viewed , exists in an arraylist
	private int getStudentPosition() throws ClassNotFoundException, IOException {
		reloadStoredStudentFile();
		in.nextLine();
		System.out.println("Enter Roll number of Student.");
		String rollnum = in.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if ((((Student) list.get(i)).getStudentRollnumber()).equalsIgnoreCase(rollnum)) {
				return i;
			}
		}
		return -1;
	}

	// this setter method is used to set the grade for the class whenever work is
	// being done for student
	private void setGrade(int grade) {
		this.grade = grade;
	}

	// this method is used to add a new student in selected grade
	public void addStudent() throws FileNotFoundException, ClassNotFoundException, EOFException, IOException {
		Student s = new Student();
		setGrade(s.getClassname());
		System.out.println(grade);
		reloadStoredStudentFile();
		list.add(s);
		updateStoredStudentFile();
	}

	// this private method is used to return the filename to and from where the user
	// would read and write date according to the selected grade
	private String getStudentFileName(int grade) {
		String fileName = "";
		switch (grade) {
		case 1:
			fileName = "Grade one Students.dat";
			break;
		case 2:
			fileName = "Grade two Students.dat";
			break;
		case 3:
			fileName = "Grade three Students.dat";
			break;
		case 4:
			fileName = "Grade four Students.dat";
			break;
		case 5:
			fileName = "Grade five Students.dat";
			break;
		case 6:
			fileName = "Grade six Students.dat";
			break;
		case 7:
			fileName = "Grade seven Students.dat";
			break;
		case 8:
			fileName = "Grade eight Students.dat";
			break;
		case 9:
			fileName = "Grade nine Students.dat";
			break;
		case 10:
			fileName = "Grade ten Students.dat";
			break;
		}
		return fileName;
	}

	// this method is used to view the whole list of students in a selected grade
	public void checkStudentsList() throws ClassNotFoundException, IOException {
		reloadStoredStudentFile();
		if (list.isEmpty()) {
			System.out.println("This class is empty");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

	// this method is used to remove the selected student from a particular grade
	public void removeStudent() throws Exception {
		reloadStoredStudentFile();
		int index = getStudentPosition();
		if (index > -1) {
			grade = ((Student) list.get(index)).getClassname();
			list.remove(index);
			updateStoredStudentFile();
		} else {
			System.out.println("Student not found.");
		}
	}

	// this method is used to update the marks of all the students in the entered
	// class
	public void updateMarks() throws ClassNotFoundException, IOException {
		reloadStoredStudentFile();
		int stud = getStudentPosition();
		if (stud > -1) {
			Student s = (Student) list.get(stud);
			System.out.println("Student name : " + s.getFirstName() + " " + s.getLastName() + "\nRoll number : "
					+ s.getStudentRollnumber());
			double mark;
			ArrayList<String> courses = new ArrayList<>();
			courses = s.getCourses();
			ArrayList<Double> marks = new ArrayList<>();
			for (int i = 0; i < courses.size(); i++) {
				System.out.print("Enter " + courses.get(i) + " marks out of 75 : ");
				while (true) {
					mark = in.nextDouble();
					if (mark <= 75) {
						break;
					}
					System.out.println("Wrong!! Marks are out of 75 Enter again : ");
				}
				marks.add(mark);
			}
			s.setMarks(marks);

			settotalMarks(s);
			updateStoredStudentFile();
		} else {
			System.out.println("Student not found");
		}
	}

	// this private method sets the total marks of a student sent according to the
	// updated marks
	private void settotalMarks(Student s) {
		ArrayList<Double> marks = s.getMarks();
		double TotalMarks = 0;
		for (int i = 0; i < marks.size(); i++) {
			TotalMarks += marks.get(i);
		}
		s.setTotalMarks(TotalMarks);
	}
}

    

