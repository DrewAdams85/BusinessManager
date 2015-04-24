/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.util.ArrayList;

public class Job {

	// *** declaring variables ***
	private String title, date;
	private double price, hours, pricePerHour, totalHours;
	private ArrayList<Job> jobsList = new ArrayList<>();

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

	// *** methods ***

	// getter
	public double getHours() {
		return hours;
	}
	
	public double getTotalHours() {
		return totalHours;
	}

	public double getPricePerHour() {
		return pricePerHour;
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

	public ArrayList<Job> getJobList() {
		return jobsList;
	}

	// setters

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
}
