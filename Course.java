
package school.management.system;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Course implements Serializable {
    private int classname;
	private int subject;
	ArrayList<String> courses = new ArrayList<String>();
	// Fee class object to get feeStatus.
	Fee f;
	Scanner in = new Scanner(System.in);

	// Constructor with only Fee class object to get fee Status
	Course(Fee f) {
		System.out.println("Enter class from 1 to 10 grade in which you are applying for courses information :");
		classname = in.nextInt();
		this.classname = classname;
		this.f = f;

	}


	// Constructor with only Fee class object to get fee Status and with Student's grade.
	Course(int classname, Fee f) {
		this.classname = classname;
		this.f = f;
	}


	// Function to get couses of a particular class
	public ArrayList<String> courselist(int classname) {

		// Checks if fee is paid and shows courses list.
		if (f.getFee()) {

			/* Shows courses with respect to grade. Grade 1-8 have 6 subjects Grade 9/10
			 * have 7 subjects and have choice between 2 major science subjects
			 */

			ArrayList<String> res = new ArrayList<String>();
			if (classname >= 1 && classname <= 8) {
				res.add("English");
				res.add("Urdu");
				res.add("Science");
				res.add("Maths");
				res.add("Pakistan Studies");
				res.add("Islamiat");
				System.out.println("Your courses are ");
				System.out.println("1. English \n2. Urdu \n3. Maths \n4. Science \n5. Pakistan Studies \n6. Islamiat");
				return res;

			}
         else if (classname > 8 && classname <= 10) {
System.out.println("Select which science subject you want to choose : \n1. Biology  \n2.Computer Science    \nChoose 1 or 2 ");
				
subject = in.nextInt();
				switch (subject) {
				case 1: {
					res.add("English");
					res.add("Urdu");
					res.add("Science");
					res.add("Maths");
					res.add("Pakistan Studies");
					res.add("Islamiat");
					res.add("Biology");
					System.out.println("Your courses are ");
					System.out.println("1. English \n2. Urdu \n3. Maths \n4. Science \n5. Pakistan Studies \n6. Islamiat \n7.Biology");
					return res;

				}
				case 2: {
					res.add("English");
					res.add("Urdu");
					res.add("Science");
					res.add("Maths");
					res.add("Pakistan Studies");
					res.add("Islamiat");
					res.add("Computer Science");
					System.out.println("Your courses are ");
					System.out.println(
							"1. English \n2. Urdu \n3. Maths \n4. Science \n5. Pakistan Studies \n6. Islamiat \n7. Computer Science");
					return res;
				}
				default: {
					System.out.println("No option like that is avalible");
					break;
				}
				}
			}
			return res;
		}

		// If fee is not paid you cannot see courses list.
		else {
			System.out.println("Fee must be paid for enrollment ");
			return null;
		}
	}

}


    

