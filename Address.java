
package school.management.system;
import java.util.*;
import java.io.Serializable;
public class Address implements Serializable{
    private String houseNumber;
	private String streetNumber;
	private String city;
	transient Scanner input = new Scanner(System.in);

	//no argument Constructor.
	public Address() {
		try {
			System.out.println("Enter house number: ");
			houseNumber = input.nextLine();

			System.out.println("Enter street number: ");
			streetNumber = input.nextLine();

			System.out.println("Enter city: ");
			city = input.nextLine();
		} catch (InputMismatchException ex) {
			System.out.println("Wrongly entered!!!!!");
		}
	}
	

	//Constructor with Argument.(COPY CONSTRUCTOR)
	public Address(Address address) {
		this.houseNumber = address.houseNumber;
		this.streetNumber = address.streetNumber;
		this.city = address.city;
	}


	//Constructor with Argument.
	public Address(String houseNumber, String streetNumber, String city) {
		this.houseNumber = houseNumber;
		this.streetNumber = streetNumber;
		this.city = city;
	}

	
	//Getter Setter for all data feilds
	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}


	//toString for Address
	@Override
	public String toString() {
		return ("Address: House#" + houseNumber + " st#" + streetNumber + " " + city);
	}
}

    
    

