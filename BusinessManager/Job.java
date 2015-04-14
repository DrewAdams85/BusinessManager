//Created by Kent Allen and Drew Adams - 4/01/2015
public class Job {
	
	// *** declaring variables ***
	private String title, date;
	private double price, hours;
	
	// *** constructors ***
	public Job(String date, String title, double price) {
      this.date = date;
		this.title = title;
		this.price = price;
	}
   
   public Job(String date, String title, double pricePerHour, double totalHours) {
      this.date = date;
      this.title = title;
      price = pricePerHour;
      hours = totalHours;
   }
	
	//  *** methods ***
	
	// getter
	public double getHours() {
		return hours;
	}
	
	public double getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}
   
   public String getDate() {
      return date;
   }
	
	// setters
	public void setHours(double hours) {
		this.hours = hours;
	}
}
