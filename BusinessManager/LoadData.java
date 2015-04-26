/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadData {
	private static ArrayList<Client> clientList = new ArrayList<>();

	public static ArrayList<Client> loadClientData() {
		ArrayList<Client> clientList = new ArrayList<>();
		
		//comment out to switch back
		// String fileName = "/Users/Kent/Documents/GIT/BusinessManager/BusinessManager/ClientDatabase.txt";
		String fileName = "C:\\Users\\Drew\\Desktop\\Programming Projects\\BusinessManager\\BusinessManager\\ClientDatabase.txt";
		String fName, lName, address, city, state, zip, phone, discount;
		boolean seniorDiscount = false;

		InputFile file = new InputFile(fileName);

		while (!file.eof()) {
			fName = file.readWord();
			lName = file.readWord();
			address = file.readLine();
			city = file.readLine();
			state = file.readWord();
			zip = file.readWord();
			phone = file.readWord();

			discount = file.readWord();
			if (discount.equals("true"))
				seniorDiscount = true;
			else if (discount.equals("false"))
				seniorDiscount = false;

			clientList.add(new Client(fName, lName, address, city, state, zip,
					phone, seniorDiscount));
		}

		loadJobData(clientList);

		return clientList;
	}

	public static void loadJobData(ArrayList<Client> clientList) {
		int clientIndex;
		double price, hours;
		String title, date;
		
		//comment out to switch back
		String fileName = "C:\\Users\\Drew\\Desktop\\Programming Projects\\BusinessManager\\BusinessManager\\JobDatabase.txt";
		// String fileName = "/Users/Kent/Documents/GIT/BusinessManager/BusinessManager/JobDatabase.txt";

		InputFile file = new InputFile(fileName);

		while (!file.eof()) {
			clientIndex = file.readInt();
			title = file.readLine();
			date = file.readWord();
			price = file.readDouble();
			hours = file.readDouble();

			if (hours > 0)
				clientList.get(clientIndex).addJob(date, title, price, hours);
			else
				clientList.get(clientIndex).addJob(date, title, price);
		}
	}
}