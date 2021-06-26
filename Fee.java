
package school.management.system;
import java.io.Serializable;
import java.util.Scanner;
public class Fee implements Serializable {
    private int totalfee = 1000;
	private int classname;
	private boolean fee = false;
	transient Scanner in = new Scanner(System.in);

	// Argumented Constructor
	public Fee(int classname) {
		this.classname = classname;
	}


	// Function to show total fee w.r.t class.
	public int totalFee() {
		return totalfee * classname;
	}


	// Checks fee Status of a student
	public boolean feeStatus() {
		System.out.println("Enter paid if fee is paid else enter not paid ");
		String ans;
		ans = in.nextLine();
		if (ans.equalsIgnoreCase("yes"))
			return true;
		else if (ans.equalsIgnoreCase("no"))
			return false;
		else {
			System.out.println("Invalid answer");
			return feeStatus();
		}
	}


	// Getter and setters for datafields
	public int getTotalfee() {
		return totalfee;
	}


	public boolean getFee() {
		return fee;
	}


	public void setFee(boolean fee) {
		this.fee = fee;
	}
}


    

