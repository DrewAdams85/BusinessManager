//Created by Kent Allen and Drew Adams - 4/01/2015
import java.util.ArrayList;

public class Client {
	
	// *** declaring variables ***
	private String fName, lName, address, phone;
   private ArrayList<Job> jobList = new ArrayList<>();
   private boolean seniorDiscount;

	// *** constructor ***
	public Client(String fName, String lName, String address, String phone, boolean seniorDiscount) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
      this.seniorDiscount = seniorDiscount;
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
   
   public boolean getSeniorDiscount() {
      return seniorDiscount;
   }
   
   public ArrayList<Job> getJobList() {
      return jobList;
   }

	// setters
   public void addJob(String date, String title, double price) {
      jobList.add(new Job(date, title, price));
   }
   
   public void addJob(String date, String title, double pricePerHour, double totalHours) {
      jobList.add(new Job(date, title, pricePerHour, totalHours));
   }
   
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
   
   public void setSeniorDiscount(boolean seniorDiscount) {
      this.seniorDiscount = seniorDiscount;
   }

}
