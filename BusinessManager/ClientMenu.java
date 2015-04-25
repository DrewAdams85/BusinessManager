/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class ClientMenu {
	private static int menu = 0;
	private static ArrayList<Client> clientList;

	public static void clientMenu(Scanner input, ArrayList<Client> list) {
		clientList = list;
		String fName, lName, address, city, state, zip, phone, selection;
		boolean seniorDiscount = false;
		do {
			System.out.println("Client Sub Menu: \n" + "1) Create Client \n"
					+ "2) Edit Client Info \n" + "3) View Client Info \n"
					+ "4) Main Menu\n" + "0) Exit");
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
				System.out
						.print("Does This Client Get A Senior Discoiunt?(y/n): ");
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
				Menu.mainMenu(input);
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

	public static void editClientMenu(Scanner input) {
		int clientIndex;
		do {
			System.out.println("What client would you like to edit?");
			for (int i = 0; i < clientList.size(); i++) {
				System.out.printf("%d %s %s%n", i + 1, clientList.get(i)
						.getFName(), clientList.get(i).getLName());
			}
			System.out.println("0) Client Menu\n");
			System.out.print("Selection: ");
			menu = input.nextInt();
			input.nextLine();
			clientIndex = menu - 1;

			if (menu == 0)
				clientMenu(input, clientList);

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
				clientMenu(input, clientList);
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
		String selection;
		System.out.println("What client would you like to view?");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.printf("%d) %s %s%n", i + 1, clientList.get(i)
					.getFName(), clientList.get(i).getLName());
		}
		System.out.println("0) Return To Client Menu");
		System.out.print("Selection: ");
		menu = input.nextInt();
		input.nextLine();

		clientIndex = menu - 1;
		System.out.println();

		if (menu != 0) {
			printClientInfo(clientIndex);
			System.out.print("Would You Like To View Another Client?(y/n): ");
			selection = input.nextLine();
			System.out.println();

			if (selection.equals("y"))
				viewClientMenu(input);

			clientMenu(input, clientList);
		} else {
			clientMenu(input, clientList);
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
}