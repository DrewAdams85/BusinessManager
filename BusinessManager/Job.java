//Created by Kent Allen and Drew Adams - 4/01/2015
public class Job {
	
	// *** declaring variables ***
	private String title;
	private double price, hours;
	private int numberOfWorkers;
	
	// *** constructor ***
	public Job(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	//  *** methods ***
	
	// getter
	public double getHours() {
		return fName;
	}
	
	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}
	
	public double getPrice() {
		return price;
	}

	public string getTitle() {
		return title;
	}
	
	// setters
	public void setHours(double hours) {
		this.hours = hours;
	}
	
	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}
		
}
