/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class JobMenu {
   private static int menu = 0;
   private static ArrayList<Client> clientList;
   
   
   public static void jobMenu(Scanner input, ArrayList<Client> list) {
      clientList = list;
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
				editJobClientMenu(input, menu);
				break;
			case 3:
				viewClientJobMenu(input);
				break;
			case 4:
				System.out.println("Exit to Main Menu");
				System.out.println();
				Menu.mainMenu(input);
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

		jobMenu(input, clientList);
	}

	public static void editJobClientMenu(Scanner input, int clientIndex) {
		do{
			System.out.println("Select Client's Job to edit");
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
			
			if (menu == 0)
				jobMenu(input, clientList);
				editJobSubMenu(input, clientIndex);
			
			} while (menu != 0);
		};
		
	public static void editJobSubMenu(Scanner input, int clientIndex){
		String selection;
		System.out.println("Select the Job to edit");
		for (int j = 0; j < clientList.get(clientIndex).getJobList().size(); j++) {
			System.out.printf("%d) %s %n", j + 1, clientList.get(clientIndex).getJobList().get(j).getTitle());
		}
		System.out.println("0) Return To Job Menu");
		System.out.println();
		System.out.print("Menu Option: ");
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
			System.out.println("0) Exit to Main Menu");
			
			System.out.println();
			System.out.print("Sub Menu Option: ");
			
			menu = input.nextInt();
			System.out.println();
			input.nextLine();

			switch (menu) {
			case 1:
				System.out.print("Enter New Job Title: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setTitle(input.nextLine());
				System.out.println();
				System.out.printf("Title has been changed to \"%s\".%n", clientList.get(clientIndex).getJobList().get(clientIndex).getTitle());
				System.out.println();
				break;
			case 2:
				System.out.print("Enter New Date: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setDate(input.nextLine());
				System.out.println();
				System.out.printf("Date has been changed to \"%s\".%n", clientList.get(clientIndex).getJobList().get(clientIndex).getDate());
				System.out.println();
				break;
			case 3:
				System.out.print("Enter New Price: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setPrice(input.nextDouble());
				System.out.println();
				System.out.printf("Price has been changed to \"$%.2f\".%n", clientList.get(clientIndex).getJobList().get(clientIndex).getPrice());
				System.out.println();
				break;
			case 4:
				System.out.print("Enter New Hours: ");
				clientList.get(clientIndex).getJobList().get(clientIndex).setHours(input.nextDouble());
				System.out.println();
				System.out.printf("Hours has been changed to \"%.2f\".%n", clientList.get(clientIndex).getJobList().get(clientIndex).getHours());
				System.out.println();
				break;
			case 5:
				System.out.print("Change Job to charge hourly (y/n):");
				selection = input.next();

				if (selection.equals("y"))
					System.out.print("Enter Hours: ");
					clientList.get(clientIndex).getJobList().get(clientIndex).setTotalHours(input.nextDouble());
					System.out.print("Enter charge per hour: ");
					clientList.get(clientIndex).getJobList().get(clientIndex).setPricePerHour(input.nextDouble());
					System.out.println();
					System.out.printf("Job has been changed to an hourly Job%n");
					System.out.println();
				break;
			case 6:
				jobMenu(input, clientList);
				System.out.println();
				break;
			case 0:
				System.out.println("Exit to Main Menu");
				System.out.println();
				Menu.mainMenu(input);
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
			clientIndex = menu-1;
			
			if (menu == 0)
				jobMenu(input, clientList);
			else
			viewClientJobSubMenu(input, clientIndex, clientIndex);
			
		} while (menu != 0);
	}
	
	public static void viewClientJobSubMenu(Scanner input, int jobIndex, int clientIndex){
		do {
			System.out.println("Select the Job to view");
			for (int j = 0; j < clientList.get(jobIndex).getJobList().size(); j++) {
				System.out.printf("%d %s %n", j + 1, clientList.get(jobIndex).getJobList().get(j).getTitle());
			}
			System.out.println("0) Return To Job Menu");
			System.out.println();
			System.out.print("Menu Option: ");
			menu = input.nextInt();
			input.nextLine();
			
			jobIndex = menu-1;
			System.out.println();

			if (menu != 0) {
				printClientJobInfo(jobIndex, clientIndex);
				viewClientJobMenu(input);
			} else {
				jobMenu(input, clientList);
			}
			System.out.println();
		} while (menu != 0);
		System.exit(0);
	}
   
  public static void printClientJobInfo(int jobIndex, int clientIndex) {
		System.out.printf("Title: %s%n", clientList.get(clientIndex).getJobList().get(jobIndex).getTitle()); 
		System.out.printf("Date: %s%n", clientList.get(clientIndex).getJobList().get(jobIndex).getDate());
		System.out.printf("Hours: %s%n", clientList.get(clientIndex).getJobList().get(jobIndex).getHours());
		System.out.printf("Price: $%.2f%n", clientList.get(clientIndex).getJobList().get(jobIndex).getPrice());
		System.out.printf("Price Per Hour: $%.2f%n", clientList.get(clientIndex).getJobList().get(jobIndex).getPricePerHour());
		System.out.printf("Total Hours: %s%n", clientList.get(clientIndex).getJobList().get(jobIndex).getTotalHours());
		System.out.println();
	} 
}