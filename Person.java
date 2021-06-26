
package school.management.system;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Person implements Serializable {
    private String firstName;
	private String lastName;
	private String gender;
	private String contact;
	private Address address;
	transient Scanner input = new Scanner(System.in);

	// no argument Constructor.
	public Person() {
		try {
			System.out.print("Enter Firstname: ");
			firstName = input.nextLine();

			System.out.print("Enter Lastname: ");
			lastName = input.nextLine();

			System.out.print("Enter Gender: ");
			gender = input.nextLine();

			System.out.print("Enter contact: ");
			contact = input.nextLine();

			System.out.println("Enter Address: ");
			address = new Address();
		} catch (InputMismatchException ex) {
			System.out.println("Wrong Input!!!!!");
		}
	}


	// Constructor with arguments.
	public Person(String firstName, String lastName, String gender, String contact, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contact = contact;
		this.address = address;
	}


	// Getter Setter for all data feilds
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setAddress() {
		System.out.println("Enter House Number: ");
		address.setHouseNumber(input.nextLine());

		System.out.println("Enter Street Number: ");
		address.setStreetNumber(input.nextLine());

		System.out.println("Enter City: ");
		address.setHouseNumber(input.nextLine());
	}


	// Function to Display address
	public void displayAddress() {
		System.out.println(address.toString());
	}


	// toString for Person
	@Override
	public String toString() {
		return ("Name=" + firstName + " " + lastName + "\nGender=" + gender + "\nAddress=" + address.toString());
	}

}



    

