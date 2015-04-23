import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date dateobj = new Date();
	private static int menu = 0;
	private static ArrayList<Client> clientList;

	public static void mainMenu(Scanner input, ArrayList<Client> clientList) {
      this.clientList = clientList;
		do {
			System.out
					.println("Main Menu: \n" 
							+ " 1) Client Menu \n"
							+ " 2) Job Menu \n" 
							+ " 3) Print Invoice \n"
							+ " 0) Exit\n");
			System.out.print("Menu Option: ");
			menu = input.nextInt();
			input.nextLine();

			System.out.println();
			switch (menu) {
			case 1:
				clientMenu(input);
				System.out.println();
				break;
			case 2:
				jobMenu(input);
				System.out.println();
				break;
			case 3:
				printInvoice(input);
				System.out.println();
				break;
			case 4:
				System.out.println("Exit to main menu");
				break;
			case 0:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid selection");
			}
		} while (menu != 0);

		System.exit(0);
	}

	public static void clientMenu(Scanner input) {
		String fName, lName, address, city, state, zip, phone, selection;
		boolean seniorDiscount = false;
		do {
			System.out.println("Client Sub Menu: \n" 
					+ "1) Create Client \n"
					+ "2) Edit Client Info \n" 
					+ "3) View Client Info \n"
					+ "4) Main Menu\n" 
					+ "0) Exit");
			System.out.println();
			System.out.printf("Sub Menu Option: ");
			menu = input.nextInt();
			input.nextLine();

			System.out.println();
			switch (menu) {
			case 1:
				System.out.print("Clients First Name: ");
				fName = input.nextLine();
				System.out.print("Clients Last Name: ");
				lName = input.nextLine();
				System.out.print("Clients Address: ");
				address = input.nextLine();
				System.out.print("Clients City: ");
				city = input.nextLine();
				System.out.print("Clients State: ");
				state = input.nextLine();
				System.out.print("Clients Zip: ");
				zip = input.nextLine();
				System.out.print("Clients Phone Number: ");
				phone = input.nextLine();
				System.out.print("Does This Client Get A Senior Discoiunt?(y/n): ");
				selection = input.next();
				if (selection.equals("y"))
					seniorDiscount = true;

				clientList.add(new Client(fName, lName, address, city, state,
						zip, phone, seniorDiscount));

				System.out.println();
				break;
			case 2:
				editClientMenu(input);
				System.out.println();
				break;
			case 3:
				viewClientMenu(input);
				System.out.println();
				break;
			case 4:
				mainMenu(input);
				break;
			case 0:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid selection");
			}
		} while (menu != 0);
	}

	public static void editClientMenu(Scanner input) {
		int clientIndex;
		do {
			System.out.println("What client would you like to edit?");
			for (int i = 0; i < clientList.size(); i++) {
				System.out.printf("%d %s %s%n", i + 1, clientList.get(i)
						.getFName(), clientList.get(i).getLName());
			}
			System.out.println("0) Exit\n");
			System.out.print("Selection: ");
			menu = input.nextInt();
			input.nextLine();
			clientIndex = menu - 1;
			editClientSubMenu(input, clientIndex);

		} while (menu != 0);
	}

	public static void editClientSubMenu(Scanner input, int clientIndex) {
		String selection;
		do {
			System.out.println("What would you like to edit?");
			System.out.println("1) First Name");
			System.out.println("2) Last Name");
			System.out.println("3) Address");
			System.out.println("4) Phone Number");
			System.out.println("5) Senior Discount");
			System.out.println("6) Return to Client Menu");
			System.out.println("0) Exit");
			System.out.print("Sub Menu Option: ");

			menu = input.nextInt();
			input.nextLine();

			switch (menu) {
			case 1:
				System.out.print("Enter New First Name: ");
				clientList.get(clientIndex).setFName(input.nextLine());
				break;
			case 2:
				System.out.print("Enter New Last Name: ");
				clientList.get(clientIndex).setLName(input.nextLine());
				break;
			case 3:
				System.out.print("Enter New Address: ");
				clientList.get(clientIndex).setAddress(input.nextLine());
				System.out.println();
				System.out.print("Enter New City: ");
				clientList.get(clientIndex).setCity(input.nextLine());
				System.out.println();
				System.out.print("Enter New State: ");
				clientList.get(clientIndex).setState(input.nextLine());
				System.out.println();
				System.out.print("Enter New Zip: ");
				clientList.get(clientIndex).setZip(input.nextLine());
				System.out.println();
				break;
			case 4:
				System.out.print("Enter New Phone Number: ");
				clientList.get(clientIndex).setPhone(input.next());
				break;
			case 5:
				System.out
						.print("Does This Client Recieve A Senior Discount?(y/n): ");
				selection = input.next();

				if (selection.equals("y"))
					clientList.get(clientIndex).setSeniorDiscount(true);
				else
					clientList.get(clientIndex).setSeniorDiscount(false);
				break;
			case 6:
				clientMenu(input);
				break;
			case 0:
				System.out.println("Good Bye");
				break;
			default:
				System.out.println("Invalid Selection");
			}

		} while (menu != 0);
		System.exit(0);
	}

	public static void viewClientMenu(Scanner input) {
		int clientIndex;
		System.out.println("What client would you like to view?");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.printf("%d) %s %s%n", i + 1, clientList.get(i)
					.getFName(), clientList.get(i).getLName());
		}
		System.out.println("0) Return To Client Menu");
		menu = input.nextInt();
		input.nextLine();

		clientIndex = menu - 1;
		System.out.println();

		if (menu != 0) {
			printClientInfo(clientIndex);
			clientMenu(input);
		} else {
			clientMenu(input);
		}
	}

	public static void printClientInfo(int clientIndex) {
		System.out.println("Info for: "
				+ clientList.get(clientIndex).getFName() + " "
				+ clientList.get(clientIndex).getLName() + "\n" + "Address: "
				+ clientList.get(clientIndex).getAddress() + "\n" + "City: "
				+ clientList.get(clientIndex).getCity() + "\n" + "State: "
				+ clientList.get(clientIndex).getState() + "\n" + "Zip: "
				+ clientList.get(clientIndex).getZip() + "\n"
				+ "Phone Number: " + clientList.get(clientIndex).getPhone()
				+ "\n" + "Senior Discount: "
				+ clientList.get(clientIndex).getSeniorDiscount() + "\n");
	}

	public static void jobMenu(Scanner input) {
		do {
			System.out.println("Job Sub Menu: \n" 
					+ "1) Create Job \n"
					+ "2) Edit Job Info \n" 
					+ "3) View Job Info \n"
					+ "4) Main Menu \n" 
					+ "0) Exit");
			System.out.println();
			System.out.printf("Job Menu Option: ");
			menu = input.nextInt();
			input.nextLine();
			System.out.println();
			switch (menu) {
			case 1:
				createJobMenu(input, menu);
				System.out.println();
				break;
			case 2:
				editJobSubMenu(input, menu);
				break;
			case 3:
				viewClientJobMenu(input);
				break;
			case 4:
				System.out.println("Exit to Main Menu");
				System.out.println();
				mainMenu(input);
				break;
			case 0:
				System.out.println("Good Bye");
				break;
			default:
				System.out.printf("Invalid selection%n");
			}
		} while (menu != 0);
		System.out.println();
		System.exit(0);

	}

	public static void createJobMenu(Scanner input, int clientIndex) {
		String title, date, hours, selection;
		double price = 0, pricePerHour = 0, totalHours = 0;
		boolean hourlyJob = false;

		System.out.println("Add Job For Client: ");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.printf("%d) %s %s%n", i + 1, clientList.get(i)
					.getFName(), clientList.get(i).getLName());
		}
		System.out.println("0) Return To Job Menu");
		System.out.println();

		System.out.print("Menu Option: ");
		menu = input.nextInt();
		input.nextLine();
		clientIndex = menu - 1;

		do {
			if (menu != 0) {
				System.out.println();
				System.out.print("Enter A Title For The Job: ");
				title = input.nextLine();
				System.out.print("Enter Job Date: ");
				date = input.nextLine();
				System.out.print("Is It An Hourly Job(y/n): ");
				selection = input.next();
				if (selection.equals("y")) {
					hourlyJob = true;
					System.out.print("Enter Price Per Hour: ");
					pricePerHour = input.nextDouble();
					System.out.print("Enter Total Hours: ");
					totalHours = input.nextDouble();
					clientList.get(clientIndex).addJob(date, title,
							pricePerHour, totalHours);
				} else {
					System.out.print("Enter Price: ");
					price = input.nextDouble();
					clientList.get(clientIndex).addJob(date, title, price);
				}
				System.out.println();
			}

			System.out.printf(
					"Would You Like To Add Another Job For %s %s(y/n): ",
					clientList.get(clientIndex).getFName(),
					clientList.get(clientIndex).getLName());
			selection = input.next();
			input.nextLine();
			System.out.println();

			if (selection.equals("n")) {
				menu = 0;
			}
		} while (menu != 0);

		jobMenu(input);
	}

	public static void editJobSubMenu(Scanner input, int clientIndex) {
		String selection;

		System.out.println("Select Client to edit Job");
		for (int c = 0; c < clientList.size(); c++) {
			System.out.printf("%d) %s %s%n", c + 1, clientList.get(c)
					.getFName(), clientList.get(c).getLName());
		}
		
		System.out.println("0) Return To Job Menu");
		System.out.println();
		System.out.print("Menu Option: ");
		menu = input.nextInt();
		System.out.println();
		input.nextLine();
		clientIndex = menu - 1;

		System.out.println("Select the Job to edit");
		for (int j = 0; j < clientList.get(clientIndex).getJobList().size(); j++) {
			System.out.printf("%d %s %n", j + 1, clientList.get(clientIndex).getJobList().get(j).getTitle());
		}
		System.out.println("0) Return To Job Menu");
		menu = input.nextInt();
		input.nextLine();
		clientIndex = menu - 1;
		System.out.println();

		do {
			System.out.println("What would you like to edit?");
			System.out.println("1) Title");
			System.out.println("2) Date");
			System.out.println("3) Price");
			System.out.println("4) Hours");
			System.out.println("5) Set Job to charge hourly");
			System.out.println("6) Return to Job Menu");
			System.out.println("0) Exit");
			System.out.print("Sub Menu Option: ");

			menu = input.nextInt();
			input.nextLine();

			switch (menu) {
			case 1:
				System.out.print("Enter New Job Title: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setTitle(input.nextLine());
				break;
			case 2:
				System.out.print("Enter New Date: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setDate(input.nextLine());
				break;
			case 3:
				System.out.print("Enter New Price: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setPrice(input.nextDouble());
				break;
			case 4:
				System.out.print("Enter New Hours: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setHours(input.nextDouble());
				break;
			case 5:
				System.out.print("Change Job to charge hourly (y/n):");
				selection = input.next();

				if (selection.equals("y"))
					System.out.print("Enter Hours: ");
					clientList.get(clientIndex).getJobList().get(clientIndex).setTotalHours(input.nextDouble());
					System.out.print("Enter charge per hour: ");
					clientList.get(clientIndex).getJobList().get(clientIndex).setPricePerHour(input.nextDouble());
				break;
			case 6:
				jobMenu(input);
				break;
			case 0:
				System.out.println("Good Bye");
				break;
			default:
				System.out.println("Invalid Selection");
			}
		} while (menu != 0);
		System.exit(0);
	}

	public static void viewClientJobMenu(Scanner input) {
		int clientIndex;
		do {
			System.out.println("Select Client to view Job");
			for (int c = 0; c < clientList.size(); c++) {
				System.out.printf("%d) %s %s%n", c + 1, clientList.get(c)
						.getFName(), clientList.get(c).getLName());
			}

			System.out.println("0) Return To Job Menu");
			System.out.println();
			System.out.print("Menu Option: ");
			menu = input.nextInt();
			System.out.println();
			
			input.nextLine();
			clientIndex = menu - 1;

			System.out.println("Select the Job to view");
			for (int j = 0; j < clientList.get(clientIndex).getJobList().size(); j++) {
				System.out.printf("%d %s %n", j + 1, clientList.get(clientIndex).getJobList().get(j).getTitle());
			}
			System.out.println("0) Return To Job Menu");
			System.out.println();
			System.out.print("Menu Option: ");
			menu = input.nextInt();
			input.nextLine();
			System.out.println();
			
			clientIndex = menu - 1;
			System.out.println();

			if (menu != 0) {
				printClientJobInfo(clientIndex);
				jobMenu(input);
			} else {
				jobMenu(input);
			}
			System.out.println();

		} while (menu != 0);
		System.exit(0);
		
	}

	public static void printClientJobInfo(int clientIndex) {
		System.out.println("Title: "
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getTitle() 
				+ "\n" + "Date: " 
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getDate() 
				+ "\n" + "Hours: "
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getHours()
				+ "\n" + "Price: "
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getPrice()
				+ "\n" + "Price Per Hour: "
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getPricePerHour()
				+ "\n" + "Total Hours: "
				+ clientList.get(clientIndex).getJobList().get(clientIndex).getTotalHours());
		System.out.println();
	}
	
	public static void printInvoice(Scanner input) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		int clientIndex;

		System.out.println("Print Invoice For Client: ");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.printf("%d) %s %s%n", i + 1, clientList.get(i)
					.getFName(), clientList.get(i).getLName());
		}
		System.out.println("0) Main Menu\n");
		System.out.print("Menu Option: ");
		menu = input.nextInt();
		clientIndex = menu - 1;
		input.nextLine();
		System.out.println();

		if (menu == 0) {
			mainMenu(input);
		}

		Invoice.printInvoice(clientList.get(clientIndex),
				df.format(dateobj.getTime()));
	}
}
