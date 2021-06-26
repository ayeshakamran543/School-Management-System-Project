
package school.management.system;
import java.util.*;
import java.io.*;
public class Runner {
    public static void main(String[] args)
			throws InvalidClassException, FileNotFoundException, IOException, ClassNotFoundException, Exception {
		Scanner input = new Scanner(System.in);

		int i = 1;
		int j = 1;
		String l;
		String f;
		while (i == 1) {
			System.out.println("*******************MENU******************* ");
			System.out.println("Enter 1 to add teacher \nEnter 2 to remove teacher"
					+ "\nEnter 3 to update salary paid status \nEnter 4 to check the days teacher were absent \nEnter 5 to update teacher hiring date"
					+ "\nEnter 6 to calculate the teacher salary"
					+ "\nEnter 7 to view a teacher record \nEnter 8 to view record of all teachers in the School \nEnter 9 to Add Student \nEnter 10 to remove Student"
					+ "\nEnter 11 to check any class student list \nEnter 12 to update student marks");
			System.out.println("******************************************* \n");
			int choice;
			choice = input.nextInt();
			System.out.println("Your Choice is " + choice);
			Admin a = new Admin();
			String s;
			s = input.nextLine();

			switch (choice) {

			case 1:
				a.hireNewTeacher();
				break;

			case 2:
				a.removeTeacher();
				break;

			case 3:
				a.updateTeacherSalaryStatus();
				break;

			case 4:
				a.checkTeacherAbsentDays();
				break;

			case 5:
				a.updateTeacherHiringDate();
				break;

			case 6:
				a.calculateSalary();
				break;

			case 7:
				a.viewTeacherRecord();
				break;

			case 8:
				System.out.println("___________________________________________________________");
				System.out.println("The record of whole faculty is....................");
				System.out.println("___________________________________________________________");
				a.viewAllTeachersRecord();

				break;

			case 9:
				a.addStudent();
				break;

			case 10:
				a.removeStudent();
				break;

			case 11:
				a.checkStudentsList();
				break;

			case 12:
				a.updateMarks();
				break;
			}

			System.out.println("\n*******Enter 1 to continue and 0 tro exit*******");
			i = input.nextInt();
			s = input.nextLine();
		}
	}
}

    

