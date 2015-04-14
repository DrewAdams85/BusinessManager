//Created by Kent Allen and Drew Adams - 4/01/2015
public class Client {
	
	// *** declaring variables ***
	private String fName, lName, address, phone;

	// *** constructor ***
	public Client(String fName, String lName, String address, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
	}

	// *** methods ***

	// getters
	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getFName() {
		return fName;
	}

	public String getLName() {
		return lName;
	}

	// setters
	public void setFName(String fName) {
		this.fName = fName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
